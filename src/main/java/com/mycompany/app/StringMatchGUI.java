package com.mycompany.app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.mycompany.utils.StringUtil;

/**
 * This program demonstrates substrings matching using JPanel in Swing. This class can be directly executed. 
 * Possible improvements are logging.
 * @author Peter Betz
 */
public class StringMatchGUI extends JFrame {
	
	private JLabel labelText = new JLabel("Enter text: ");
	private JLabel labelSubtext = new JLabel("Enter subtext: ");
	private JLabel labelResult = new JLabel("Found at indexes");
	private JTextField textText = new JTextField(20);
	private JTextField textSubtext = new JTextField(20);
	private JTextField textResult = new JTextField(20);
	private JButton buttonSubmit = new JButton("Submit");
	
	public StringMatchGUI() {
		super("String Match GUI");
		
		// create a new panel with GridBagLayout manager
		JPanel newPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		// add components to the panel
		constraints.gridx = 0;
		constraints.gridy = 0;		
		newPanel.add(labelText, constraints);

		constraints.gridx = 1;
		newPanel.add(textText, constraints);
		textText.setName("textText");
		
		constraints.gridx = 0;
		constraints.gridy = 1;		
		newPanel.add(labelSubtext, constraints);
		
		constraints.gridx = 1;
		newPanel.add(textSubtext, constraints);
		textSubtext.setName("textSubtext");
		
		constraints.gridx = 0;
		constraints.gridy = 2;		
		newPanel.add(labelResult, constraints);
		
		constraints.gridx = 1;
		newPanel.add(textResult, constraints);		
		textResult.setName("textResult");
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(buttonSubmit, constraints);
		buttonSubmit.setName("buttonSubmit");
		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String result = StringUtil.findSubStringIgnoreCase(textText.getText(), textSubtext.getText());
				result = result.equals("") ? "No match found. Try again" : result;  				textResult.setText(result);
				
			}
		});
		
		
		// set border for the panel	
		newPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Task Panel"));
		
		// add the panel to this frame
		add(newPanel);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// allows the direct running of the class
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new StringMatchGUI().setVisible(true);
			}
		});
	}
}