// Assignment #: Arizona State University CSE205 #8
//         Name: Alan Griffieth
//    StudentID: 1212575453
//      Lecture: MWF 9:40 - 10:30 a.m.
//  Description: Compares two foods by their category and name

import java.util.Comparator;

public class CategAndNameComparator implements Comparator<Food> {
	
	public int compare(Food first, Food second) {
		String categ1 = first.getCategory(); //Takes advantage of Food methods to get their categories and names
		String categ2 = second.getCategory();
		String name1 = first.getName();
		String name2 = second.getName();
		
		if (categ1.equals(categ2)) { //if the categories are equal, this will compare the names of the food items
			return name1.compareTo(name2);
		}
		else {
			return categ1.compareTo(categ2); //if the categories aren't equal, this will only compare categories
		}
	}
}
