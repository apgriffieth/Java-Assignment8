// Assignment #: Arizona State University CSE205 #8
//         Name: Alan Griffieth
//    StudentID: 1212575453
//      Lecture: MWF 9:40 - 10:30 a.m.
//  Description: Uses selection sort to sort everything in order

import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
	public static void sort(ArrayList<Food> foodList, Comparator<Food> xComparator) {
		int min;
		Object temp;
		
		for(int index = 0; index < foodList.size() - 1; index++) { //Selection sort
			min = index;
			for(int scan = index + 1; scan < foodList.size(); scan++) {
				if (xComparator.compare(foodList.get(scan), foodList.get(min)) < 0) {
					min = scan;
				}
			}
			temp = foodList.get(min);
			foodList.set(min, foodList.get(index));
			foodList.set(index, (Food) temp);
		}
	}

}
