package com.alexyamaoka.lc.propertyEditor;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("inside custom property editor: name property editor");
		// convert name to upper case
		String myConvertedStringValue = text.toUpperCase();
		
		setValue(myConvertedStringValue);
	}
}
