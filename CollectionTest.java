package com.zensar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

class DOB{
	public int day;
	public int month;
	public int year;
	
	public DOB(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	@Override
	public int hashCode() {
		return Integer.parseInt(day + "" +month); //hashcode is daymonth = 102
	}
	@Override
	public boolean equals(Object obj) {
		DOB dob = (DOB)obj;
		if(dob.day==this.day &&dob.month==this.month) //compare if day and month is same of two object then true
			return true;
		return false;
	}
	@Override
	public String toString() {
		return "DOB [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	
}
class Item{
	public String name;
	public Item(String name) {
		this.name = name;
		
	}
	@Override
	public String toString() {
		return name;
	}
}
class Employeee implements Comparable<Employeee>{
	public int id;
	public String name;
	public int salary;
	public Employeee(int id,String name,int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee[id=" + id +",name=" +name +",salary="+salary+ "]";
	}
//	@Override
//	public String toString() {
//		return name;
//	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	@Override
	public int compareTo(Employeee emp) {
		//return this.name.compareTo(emp.name);
		if(this.salary > emp.salary)
			return 1;
		else if(this.salary < emp.salary)
			return -1;
		return 0;
	}
	
	//Employee emp = new Employee("Prashant");
}
class EmployeeeIdComparator implements Comparator<Employeee>{

	@Override
	public int compare(Employeee emp1, Employeee emp2) {
		if(emp1.id > emp2.id)
			return -1;
		else if(emp1.id < emp2.id)
			return 1;
		return 0;
	}
	
}


public class CollectionTest {
	
	private static void testTreeSet() {

		Set<Employeee> empTreeSet = new TreeSet<Employeee>(new EmployeeeIdComparator());
		empTreeSet.add(new Employeee(1,"Tom",12000));
		empTreeSet.add(new Employeee(2,"Jerry",19000));
		empTreeSet.add(new Employeee(3,"Ivan",3000));
		Iterator<Employeee> itr1 = empTreeSet.iterator();
		while(itr1.hasNext()) {
			Employeee key = itr1.next();
			System.out.println("Key:" +key);
		}
		
		Set<String> treeSet = new TreeSet<String>();
		treeSet.add("Tom");
		treeSet.add("Jerry");
		treeSet.add("Ivan");
		treeSet.add("Jerry");
		Iterator<String> itr2 = treeSet.iterator();
		while(itr2.hasNext()) {
			String key = itr2.next();
			System.out.println("Key:" +key);
		}
	}
	private static void testTreeMap() {
		Map<String, Item> treeMap = new TreeMap<>();
		treeMap.put("Chair", new Item("Wooden Chair"));
		treeMap.put("Table", new Item("Wooden Table"));
		treeMap.put("Laptop", new Item("HP Laptop"));
		treeMap.put("Computer", new Item("HCL Computer"));
		
		Set<Entry<String, Item>> entrySet = treeMap.entrySet();
		Iterator<Entry<String, Item>> itr = entrySet.iterator();
		while(itr.hasNext()) {
			Entry<String, Item> entry = itr.next();
			System.out.println("Entry:" + entry.getKey()+ "-"+ entry.getValue());
		}
	}
	private static void testHashSet() { //unordered collection whereas LinkedHashSet is ordered collection
		Set<String> hset = new HashSet<String>();
		hset.add("Tom");
		hset.add("Jerry");
		hset.add("Ivan");
		hset.add("Jerry");
		
		Iterator<String> itr2 = hset.iterator();
		while(itr2.hasNext()) {
			String key = itr2.next();
			System.out.println("Key =" +key);
		}
	}

	private static void testAssessment3() {
		Map<DOB,String> hashMap = new HashMap<DOB, String>();
		DOB dob1 = new DOB(10,2,2002);
		DOB dob2 = new DOB(10,2,2008);
		hashMap.put(dob1, "Tom");
		hashMap.put(new DOB(25,8,2010), "Jerry");
		hashMap.put(dob2, "Ivan");

		DOB dob3 = new DOB(10,2,2002);
		String empName = hashMap.get(dob3);
		System.out.println("empName ="+ empName);
		
		
	}
	
	private static void testArrayListReverseAssess(){
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("Prashant");
		arrayList.add("Daya");
		arrayList.add("Hritik");
		ListIterator<String> List_Iterator =
		arrayList.listIterator(arrayList.size());
		while(List_Iterator.hasPrevious()) {
			String name = List_Iterator.previous();
			System.out.println(name);
			
		}
	}
	
	private static void testHashMap() {
		Map<String, Item> hashMap = new HashMap<String, Item>();
		hashMap.put("Chair", new Item("Wooden Chair"));
		hashMap.put("Table", new Item("Wooden Table"));
		hashMap.put("Laptop", new Item("HP Laptop"));
		hashMap.put("Computer", new Item("HCL Computer"));

		String itemKey = null;
		Item itemValue = null;
		hashMap.put(itemKey, itemValue);
		
		//Taking out One Item
//		Item item = hashMap.get("Laptop");
//		System.out.println("Item:" +item);
		
		//Iterating all entries in hashmap
		Set<Entry<String, Item>> entrySet = hashMap.entrySet();
		Iterator<Entry<String, Item>> itr = entrySet.iterator();
		while(itr.hasNext()) {
			Entry<String, Item> entry = itr.next();
//			System.out.println("Entry:" + entry);
			System.out.println("Entry:" + entry.getKey()+ "-"+ entry.getValue());
		}
		
			//Iterating only Key
			Set<String> set = hashMap.keySet();
			Iterator<String> itr2 = set.iterator();
			while(itr2.hasNext()) {
				String key = itr2.next();
				System.out.println("Key =" +key);
			}
			
			//Iterating Values
			Collection<Item> items = hashMap.values();
			Iterator<Item> itr3 = items.iterator();
			while(itr2.hasNext()) {
				Item value = itr3.next();
				System.out.println("Value =" +value);
			}
	}
	
//	private static void testHashMapEmp() {
//		Map<Employeee, Integer> hashMap = new HashMap<Employeee, Integer>();
//		hashMap.put(new Employeee("Prashant"), 30);
//		hashMap.put(new Employeee("Hritik"), 40);
//		
//		Integer it = hashMap.get(new Employeee("Prashant"));
//		System.out.println("Prashant:" +it);
//		
//		Integer it1 = hashMap.get(new Employeee("Hritik"));
//		System.out.println("Hritik:" +it1);
//	}
	
	private static void testHashtable() {
		Map<String, Item> hashtable = new Hashtable<String, Item>();
		hashtable.put("Chair", new Item("Wooden Chair"));
		hashtable.put("Table", new Item("Wooden Table"));
		hashtable.put("Laptop", new Item("HP Laptop"));
		hashtable.put("Computer", new Item("HCL Computer"));

		Item item = hashtable.get("Laptop");
		System.out.println("Item:" +item);
	}
	
	public static void testArrayList() {
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("Tom");
		arrayList.add("Jerry");
		arrayList.add("Ivan");
		arrayList.remove("Jerry");
		Iterator<String> itr = arrayList.iterator();//itr is similar to linkedlist Head
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
	}
	
	public static void testVector() {
		List<String> vector = new Vector<String>();
		vector.add("Tom");
		vector.add("Jerry");
		vector.add("Ivan");
		vector.remove("Jerry");
		Iterator<String> itr = vector.iterator();//itr is similar to linkedlist Head
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
	}
	public static void linkedlisttest() {
		List<String> linkedlist = new LinkedList<String>();
		linkedlist.add("Tom");
		linkedlist.add("Jerry");
		linkedlist.add("Ivan");
		linkedlist.remove("Jerry");
		Iterator<String> itr = linkedlist.iterator();//itr is similar to linkedlist Head
		while(itr.hasNext()) {
			String name = itr.next();
			System.out.println(name);
		}
	}
	public static void main(String[] args) {
		
		//linkedlisttest();
//		testVector();
		//testArrayList();
		//testHashtable();
		//testHashMap();
//		testArrayListReverseAssess();
	//	testHashMapEmp();
		//testAssessment3();
		//testHashSet();
		//testTreeMap();
		testTreeSet();
	}
}
