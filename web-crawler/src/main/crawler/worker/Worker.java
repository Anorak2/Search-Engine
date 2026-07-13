// Worker Node
// Description: Scrapes web pages assigned by the coordinator and returns the relevant/reduced information
// Inputs: Config values
// Outputs: PageInformation class
//
// Authors: Adam Berry
// Created On: 2026-6-1

package crawler.worker;

import crawler.Config;
import crawler.core.PageInformation;

import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Safelist;
import org.jsoup.select.Elements;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("worker")
public class Worker implements ApplicationRunner{
	private Cleaner cleaner = new Cleaner(Safelist.basic());
	private Set<String> stopWordList;
	public boolean running;

	@Override
	public void run(ApplicationArguments args) throws Exception{
		this.running = true;
		this.stopWordList = Set.of(
				"", "I", "a", "about", "an", "are", "as", "at", "be", "by",
				"com", "de", "en", "for", "from", "how", "in", "is", "it",
				"la", "of", "on", "or", "that", "the", "this", "to", "was",
				"what", "when", "where", "who", "will", "with", "und", "www"
				);

		while(this.running){
			parse_page("https://www.google.com/");
			parse_page("https://www.java.com/en/");
			break;
		}
	}


	private PageInformation parse_page(String input_url) throws Exception{
		PageInformation pageInfo = new PageInformation();
		pageInfo.linkSet = new HashSet<>();
		Set<String> rawTermSet = new HashSet<>();


		Document dirtyDoc = Jsoup.connect(input_url).get();
		Document doc = this.cleaner.clean(dirtyDoc);
		if(doc == null){
			throw new Error("Could not connect to the website");
		}
		pageInfo.title = doc.title();

		// Parse out all in text links
		Elements links = doc.getElementsByTag("a");
		for (Element link : links) {
			String linkHref = link.attr("href");
			pageInfo.linkSet.add(linkHref);

			String linkText = link.text();
			rawTermSet.add(linkText);
		}

		Elements buttons = doc.getElementsByTag("button");
		for (Element button : buttons) {
			String linkHref = button.attr("href");
			pageInfo.linkSet.add(linkHref);

			String buttonText = button.text();
			rawTermSet.add(buttonText);
		}

		Elements paragraphs = doc.getElementsByTag("p");
		for (Element paragraph : paragraphs) {
			String paragraphText = paragraph.text();
			rawTermSet.add(paragraphText);
		}
		pageInfo.termSet = cleanWordSet(rawTermSet);

		return pageInfo;
	}

	private Set<String> cleanWordSet(Set<String> uncleanSet){
		Set<String> cleanSet = new HashSet<>();
		for (String str : uncleanSet){
			// Remove everything that isn't a number, letter, or space
			// I made certain exceptions for [#, @, %, $] since they are most likely to contain meaningful context
			// Also removes all double spaces
			str = str.replaceAll("[^A-Za-z0-9 #@%$]+|\\s{2,}", "");
			str = str.toLowerCase();
			String[] splitted = str.split("\\s+");
			for(String s : splitted){
				cleanSet.add(s);
			}
		}
		// Remove the most common stopwords
		// This is an older way of doing things but for my model it should be better
		cleanSet.removeAll(stopWordList);

		return cleanSet;
	}
}
