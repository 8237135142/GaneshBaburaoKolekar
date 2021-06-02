package com.spring.SpringCore;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ShapeCollection {
	private List<String> shapeOfList;
	private Set<String> shapeOfSet;
	private Map<String, String> shapeOfMap;
	private Properties shapeOfProperties;

	public void setShapeOfList(List<String> shapeOfList) {
		this.shapeOfList = shapeOfList;
	}

	public void setShapeOfSet(Set<String> shapeOfSet) {
		this.shapeOfSet = shapeOfSet;
	}

	public void setShapeOfMap(Map<String, String> shapeOfMap) {
		this.shapeOfMap = shapeOfMap;
	}

	public void setShapeOfProperties(Properties shapeOfProperties) {
		this.shapeOfProperties = shapeOfProperties;
	}

	public String toString() {
		return "List Elements :" + shapeOfList + "\nSet Elements :" + shapeOfSet + "" + "\nMap Elements :" + shapeOfMap
				+ "\nProperty Elements :" + shapeOfProperties;

	}

}

