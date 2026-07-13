// PageInformation
// Description: Encapsulates the information pulled from a web page
// Inputs:
// Outputs:
//
// Author: Adam Berry
// Created On: 2026-7-13

package crawler.core;

import java.util.Set;

public class PageInformation {
	// Intended as a simple way to encapsulate data for transport between functions
	public String title;

	public Set<String> termSet;
	public Set<String> linkSet;
}
