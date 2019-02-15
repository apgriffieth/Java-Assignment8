// Assignment #: Arizona State University CSE205 #8
//         Name: Alan Griffieth
//    StudentID: 1212575453
//      Lecture: MWF 9:40 - 10:30 a.m.
//  Description: This class holds all food in an arraylist and allows user to add/remove food and check if food exists

import java.util.ArrayList;
import java.io.Serializable;

public class GroceryStore implements Serializable {
	private ArrayList<Food> foodList;

	//constructor
	public GroceryStore() {
		foodList = new ArrayList<Food>();

	}
	
	public int idExists(int foodId) {
		int x = -1;
		String check = Integer.toString(foodId);
		for(int i = 0; i < foodList.size(); i++) {
			x = -1;
			if(foodList.toString().contains(check)) {
				x = i;
			}
		}
		if(x > -1 ) {
			return x;
		}
		else {
			return -1;
		}
	}
	
	public int categAndNameExists(String nCategory, String nName) {
		int x = -1;
		for(int i = 0; i < foodList.size(); i++) {
			x = -1;
			if(foodList.toString().contains(nCategory) && foodList.toString().contains(nName)) {
				x = i;
			}
		}
		
		if(x > -1) {
			return x;
		}
		
		else {
			return -1;
		}
	}
	
	public boolean addFoodById(String category, String name, int id) {
		if(idExists(id) == -1 ) { //checks if food already exists
			Food newFood = new Food(category, name, id);
			foodList.add(newFood);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean removeById(int id) {
		if(idExists(id) > -1) { //checks if food exists
			for(int i = 0; i < foodList.size(); i++) {
				Food food = new Food(foodList.get(i).getCategory(), foodList.get(i).getName(), foodList.get(i).getId());
				if(food.getId() == id) {
					foodList.remove(i);
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeByCategAndName(String category, String name) {
		if(categAndNameExists(category, name) > -1) { //checks if food exists
			for(int i = 0; i < foodList.size(); i++) {
				Food food = new Food(foodList.get(i).getCategory(), foodList.get(i).getName(), foodList.get(i).getId());
				if(food.getCategory().equals(category) && food.getName().equals(name)) {
					foodList.remove(i);
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public void sortByCategAndName() { //Uses the categAndNameComparator class and the sorting method to sort
		CategAndNameComparator newCategAndNameComparator = new CategAndNameComparator();
		Sorts.sort(foodList, newCategAndNameComparator); //Selection sort
	}
	
	public void sortById() { //Uses the IdComparator class and the sorting method of the sorts class to sort
		IdComparator newIdComparator = new IdComparator();
		Sorts.sort(foodList, newIdComparator); //Selection sort
	}
	
	public String listFood() {
		String result = "";
		if(foodList.isEmpty()) {
			result = "\nno food\n\n";
		}
		else {
			for(int i = 0; i < foodList.size(); i++) {
				Food food = new Food(foodList.get(i).getCategory(), foodList.get(i).getName(), foodList.get(i).getId());
					result += food.toString(); //Uses Food toString() method
				}
		}
		return result;
	}
	
	public void closeGroceryStore() {
		foodList.clear();
	}
}
