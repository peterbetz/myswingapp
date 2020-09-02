/*
 * This class provides string utilities methods such as searches, etc.
 */
package com.mycompany.utils;

public class StringUtil {

	/**
	 * Finds a substring within string and returns the result a string of indexes. Possible improvements are to return the indexes as an array.
	 * @param text text to be searched
	 * @param subtext subtext to search on
	 * @return a string with all the index positions within the text or empty string if no match found or text & subtext is null/empty. Indexes are space concatenated.
	 */
	public static String findSubString(String text, String subtext) {

		String result = "";
		String unprocessedStr = new String(text);
		int foundCount = 0;
		int milage = 0;
		
		// text or subtext never match so return empty. We could throw an error as well if we deem this to be an error (subject to specs).
		if (text == null || text.equals("") || subtext == null || subtext.equals("")) {
			return result;
		}
		
		while (unprocessedStr.length() >= subtext.length()) {
			int position = unprocessedStr.indexOf(subtext);
			// whenever we find a match we continue to search within the unprocessedStr remainder
			if (position != -1) {
				milage = milage + position + (foundCount * subtext.length());
				result = result + " " + milage;
				foundCount = ++foundCount;
				unprocessedStr = unprocessedStr.substring(position + subtext.length());				
			} else {
				// no further matches found within unprocessedStr
				break;
			}

		}
		
		return result.trim();
		
	}
	
	/**
	 * Ignoring case finds a substring within string and returns the result as string.  Possible improvements are to return the indexes as an array.
	 * @param text text to be searched
	 * @param subtext subtext to search on
	 * @return a string with all the index positions within the text or empty string if no match found or text & subtext is null/empty. Indexes are space concatenated.
	 */
	public static String findSubStringIgnoreCase(String text, String subtext) {
		return findSubString(text.toUpperCase(), subtext.toUpperCase());
	}
	
}
