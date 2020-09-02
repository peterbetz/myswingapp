package com.mycompany.test.utils;

import java.awt.Component;
import java.awt.Container;

public class TestUtils {

	/**
	 * Get a child swing component by name.
	 * 
	 * @param parent
	 *            parent swing component
	 * @param name
	 *            component within
	 * @return swing component
	 */
	public static Component getChildNamed(Component parent, String name) {

		if (name.equals(parent.getName())) {
			return parent;
		}

		if (parent instanceof Container) {
			Component[] children = ((Container) parent).getComponents();

			for (int i = 0; i < children.length; ++i) {
				Component child = getChildNamed(children[i], name);
				if (child != null) {
					return child;
				}
			}
		}

		return null;
	}

}