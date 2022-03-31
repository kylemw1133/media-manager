package util;

import java.util.Scanner;

public class TypedAttribute {
	String name;
	int dataType;
	
	public TypedAttribute(String n, int t) {
		name = n;
		dataType = t;
	}
	
	public Object promptForValue(Scanner s) {
		return 0;
	}
	
	public String toString() {
		return "(" + this.name + ", " + this.dataType + ")";
	}
	
	public boolean equals(TypedAttribute a) {
		return this.name == a.name && this.dataType == a.dataType;
	}
}
