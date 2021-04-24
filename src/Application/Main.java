package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employees;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);  // Use set default of USA
		Scanner sc = new Scanner(System.in); //Allow the use  of Data entry with keyboard
		
		//List generic, I specify the type of each object in my list, in case is my employees
		List<Employees> list = new ArrayList<>(); //I instantiated my list  with ArrayList
		
		
		System.out.println("How many employees will be registered ");
		int n = sc.nextInt(); //quantity of my employees's numbers
		
		for(int i =0;i<n;i++) { // i used 'for' for write and put all the data and add in my list
			
			System.out.println();
			System.out.println("Employee #"+ (i + 1)+":");
			System.out.println("id: ");
			Integer id = sc.nextInt();
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("salary: ");
			Double salary = sc.nextDouble();
			
			Employees emp = new Employees(id, name, salary);
			
			list.add(emp);
		}
		
		System.out.println("Enter the employee id that will have salary increase: ");
		int idsalary = sc.nextInt();
		Integer pos = position(list, idsalary); //I instantiated my fuction came here to see if the value is valid 
		if(pos == null) {
			System.out.println("This id does not exist!"); 
		}else {
			System.out.println();
			System.out.println("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		System.out.println();
		System.out.println("List of employees: ");
		System.out.println();
		for(Employees emp: list) { 
			System.out.println(emp);  //prints the data by toString made in the Employees class 
		}
		
		sc.close();
	}
	
	public static Integer position(List<Employees> list, int id){ 
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getId() == id) {// i got the position i, and i got the ID him, if it exists it is to return i
					return i;
				}
			}
			return null; // if it doesn't exists the value will be null
	}

}
