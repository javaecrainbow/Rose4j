package com.rose4j.util;

import java.io.Serializable;

public class ShowData implements Serializable{
	private String label;
	private String value;
	
	public ShowData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowData(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
