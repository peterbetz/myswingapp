package com.mycompany.utils;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase {

	public void testFindSubString() {
		String result = null;
		
		// normal text
		result = StringUtil.findSubString("hello hello other", "hello");
		assertEquals("0 6", result);

		// case sensitive
		result = StringUtil.findSubString("hello Hello other", "hello");
		assertEquals("0", result);
		
		// empty strings
		result = StringUtil.findSubString("", "hello");
		assertEquals("", result);
		
		result = StringUtil.findSubString("hello Hello other", "");
		assertEquals("", result);
		
	}

	public void testFindSubStringIgnoreCase() {
		String result = null;
		
		// normal text
		result = StringUtil.findSubStringIgnoreCase("hello hello other", "hello");
		assertEquals("0 6", result);		
		
		// mixed cases
		result = StringUtil.findSubStringIgnoreCase("hello Hello other", "hello");
		assertEquals("0 6", result);
	}

}
