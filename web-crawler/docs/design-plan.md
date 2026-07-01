## Requirements

First, the classic requirements are:
- Be Polite: Respect implicit and explicit politeness considerations, such as only crawling allowed pages. This also means respecting `robots.txt`, but there is also implicit politeness where even without specifications the crawler tries to avoid hitting sites too often.
- Be Robust: Be immune to spider traps and other malicious behavior from web servers
- Be scalable: designed to increase the crawl rate by adding more machines
	- Performance/efficiency: permit full use of available processing and network resources
	- Be capable of distributed operation: designed to run on multiple distributed machines
- Fetch pages of “higher quality” first
- Continuous operation: Continue fetching fresh copies of a previously fetched page
- Extensible: Adapt to new data formats, protocols


## Rough Outline.
in order to do this I'll implement a coordinator (singleton) with several worker nodes (factory based) that will handle the actual per site crawling. By designing it in this way from the beginning it would be much easier to pivot to full distribution. The coordinator can also be responsible for issuing jobs to the workers, allowing continuous operation based on expiration.

I'll enter the seed domains as a csv at runtime so they can be changed easily, this will give the initial frontier so that no additional data will be needed. In order to ensure politeness I'll handle sites on a per domain name system. How this will work is every time a worker sees a domain it is unsure of (not currently in memory), it will strip the domain of the path and ask the coordinator for an allocation. The coordinator will check the source of truth (postgres db) whether it is present, already allocated, and the time that site was last hit. if everything looks good then it can be sent back to the worker's queue to perform the fetching and processing. if there's ever downtime I'll have a worker ask for domains that are past the TTL, though I am not particularly worried about timeliness due to the intended source content. The idea is to loosely follow the mercator scheme

The higher quality first constraint will be trickier, I'll probably start by sorting on domain with the theory that more expensive (.com, .org) are less likely to be spam though it will need returning to.

Extensibility for now will be handled by a roughly SOLID based architecture since it is early days.
