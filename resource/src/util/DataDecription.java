package com.rose4j.util;

import java.io.Serializable;

public class DataDecription implements Serializable{
private String caption;
private String xAxisName;
private String yAxisName;
private String numberPrefix;
public DataDecription(String caption, String xAxisName, String yAxisName,
		String numberPrefix) {
	super();
	this.caption = caption;
	this.xAxisName = xAxisName;
	this.yAxisName = yAxisName;
	this.numberPrefix = numberPrefix;
}
public String getCaption() {
	return caption;
}
public void setCaption(String caption) {
	this.caption = caption;
}
public String getxAxisName() {
	return xAxisName;
}
public void setxAxisName(String xAxisName) {
	this.xAxisName = xAxisName;
}
public String getyAxisName() {
	return yAxisName;
}
public void setyAxisName(String yAxisName) {
	this.yAxisName = yAxisName;
}
public String getNumberPrefix() {
	return numberPrefix;
}
public void setNumberPrefix(String numberPrefix) {
	this.numberPrefix = numberPrefix;
}

}
