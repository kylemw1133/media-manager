package util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class TypedAttribute {
	public String name;
	public int dataType;
	public Object value;

	private static final DateFormat dateFormat = DateFormat.getInstance();

	public TypedAttribute(String n, int t) {
		name = n;
		dataType = t;
		value = null;
	}

	public void promptForValue(Scanner s) {
		System.out.print("Provide a value for " + this.name + ": ");

		switch (this.dataType) {
		case Types.INTEGER:
			value = Integer.parseInt(s.nextLine());
			break;
		case Types.FLOAT:
		case Types.DOUBLE:
		case Types.REAL:
			value = Double.parseDouble(s.nextLine());
			break;
		case Types.DATE:
			value = Date.valueOf(s.nextLine());
			break;
		case Types.VARCHAR:
			value = s.nextLine();
			break;
		}
	}

	public void fillInStmt(PreparedStatement s, int valuePos) throws SQLException {
		switch (this.dataType) {
		case Types.INTEGER:
			s.setInt(valuePos, (int) this.value);
			break;
		case Types.FLOAT:
		case Types.DOUBLE:
		case Types.REAL:
			s.setDouble(valuePos, (double) this.value);
			break;
		case Types.DATE:
			s.setDate(valuePos, (Date) this.value);
			break;
		case Types.VARCHAR:
			s.setString(valuePos, (String) this.value);
			break;
		}
	}

	@Override
	public String toString() {
		return "(" + this.name + ", " + this.dataType + ", " + this.value + ")";
	}

	public boolean equals(TypedAttribute a) {
		return this.name == a.name && this.dataType == a.dataType;
	}
}
