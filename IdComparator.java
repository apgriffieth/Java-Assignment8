// Assignment #: Arizona State University CSE205 #8
//         Name: Alan Griffieth
//    StudentID: 1212575453
//      Lecture: MWF 9:40 - 10:30 a.m.
//  Description: Compares two foods by their ID number

import java.util.Comparator;

public class IdComparator implements Comparator<Food> {
	
	public int compare(Food first, Food second) {
		int id1 = first.getId(); //takes advantage of methods in Food class to get IDs
		int id2 = second.getId();
		String id11 = Integer.toString(id1); //must be converted to Strings to use .compareTo()
		String id22 = Integer.toString(id2);
		return id11.compareTo(id22);
	}



}
