package com.mycompany.app;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.mycompany.test.utils.TestUtils;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class StringMatchGUITest extends TestCase {

	static StringMatchGUI stringMatchGUI = new StringMatchGUI();

	public void testSubmit() throws Exception {
		String text = "hello hello bye";
		String subtext = "hello";
		String expectedResult = "0 6";

		assertNotNull(stringMatchGUI); // Instantiated?

		// set text
		JTextField inputTextText = (JTextField) TestUtils.getChildNamed(stringMatchGUI, "textText");
		assertNotNull(inputTextText); // Component found?
		inputTextText.setText(text);
		inputTextText.postActionEvent(); // Type in a test message + ENTER

		// set subtext
		JTextField inputTextSubtext = (JTextField) TestUtils.getChildNamed(stringMatchGUI, "textSubtext");
		assertNotNull(inputTextSubtext); // Component found?
		inputTextSubtext.setText(subtext);
		inputTextSubtext.postActionEvent(); // Type in a test message + ENTER

		// submit
		JButton inputButtonSubmit = (JButton) TestUtils.getChildNamed(stringMatchGUI, "buttonSubmit");
		assertNotNull(inputButtonSubmit); // Component found?
		inputButtonSubmit.doClick(); // Type in a test message + ENTER

		// read result
		JTextField inputTextResult = (JTextField) TestUtils.getChildNamed(stringMatchGUI, "textResult");
		assertNotNull(inputTextSubtext); // Component found?
		String result = inputTextResult.getText();

		assertEquals(expectedResult, result);

	}

}
