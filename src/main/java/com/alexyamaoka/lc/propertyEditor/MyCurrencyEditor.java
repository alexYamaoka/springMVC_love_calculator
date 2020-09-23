package com.alexyamaoka.lc.propertyEditor;

import java.beans.PropertyEditorSupport;

public class MyCurrencyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(text.toUpperCase());
	}
}
