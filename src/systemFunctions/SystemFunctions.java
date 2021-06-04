package systemFunctions;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;



import clientTypes.CorporateClient;
import clientTypes.IndependentClient;



public class SystemFunctions {
	
	
	/***************************************
	 * Name: bubbleSortCorporate
	 * Date: 20/05/2021
	 * Description: Runs a bubble sort on the corporate contacts.
	 * Input: The CorporateClient ArrayList.
	 * Output: -
	 ***************************************/
	public static void bubbleSortCorporate(ArrayList<CorporateClient> arr) {
		//Initialize swap check boolean as true
		boolean swapped = true;
		//While a swap has been made in the last check
		while (swapped == true) {
			//set swapped to false
			swapped= false;
			//Iterate through all non null elements of the array except for the first one
			for (int i=1; i < arr.size(); i++) {
				//Check if adjacent elements need to be swapped for specified order
				if (arr.get(i - 1).getName().compareTo(arr.get(i).getName()) > 0) {
					//Swap the elements in each ArrayList
					bubbleSwapCorporate(i,arr);

					//Set swapped as true
					swapped = true;
				}
			}
		}
		
	}
		
	
	/***************************************
	 * Name: bubbleSwapCorporate
	 * Date: 20/05/2021
	 * Description: Runs a swap for the bubbleSort algorithm.
	 * Input: The CorporateClient ArrayList and index to swap.
	 * Output: -
	 ***************************************/
	public static void bubbleSwapCorporate(int index, ArrayList<CorporateClient> array) {
		//Set temporary first string to lowest index pair
		CorporateClient tempfirst = array.get(index-1);
		//Set temporary last string to highest index pair
		CorporateClient templast = array.get(index);
		//Set lowest index pair to temporary last string
		array.set(index-1, templast);
		//Set highest index pair to temporary first string
		array.set(index, tempfirst);
	}
	
	
	
	
	
	
	/***************************************
	 * Name: bubbleSortIndependent
	 * Date: 20/05/2021
	 * Description: Runs a bubble sort on the independent contacts.
	 * Input: The IndependentClient ArrayList.
	 * Output: -
	 ***************************************/
	public static void bubbleSortIndependent(ArrayList<IndependentClient> arr) {
		//Initialize swap check boolean as true
		boolean swapped = true;
		//While a swap has been made in the last check
		while (swapped == true) {
			//set swapped to false
			swapped= false;
			//Iterate through all non null elements of the array except for the first one
			for (int i=1; i < arr.size(); i++) {
				//Check if adjacent elements need to be swapped for specified order
				if (arr.get(i - 1).getName(false).compareTo(arr.get(i).getName(false)) > 0) {
					//Swap the elements in each ArrayList
					bubbleSwapIndependent(i,arr);

					//Set swapped as true
					swapped = true;
				}
			}
		}
		
	}
		
	
	
	/***************************************
	 * Name: bubbleSwapIndependent
	 * Date: 20/05/2021
	 * Description: Runs a swap for the bubbleSort algorithm.
	 * Input: The IndependentClient ArrayList and index to swap.
	 * Output: -
	 ***************************************/
	public static void bubbleSwapIndependent(int index, ArrayList<IndependentClient> array) {
		//Set temporary first string to lowest index pair
		IndependentClient tempfirst = array.get(index-1);
		//Set temporary last string to highest index pair
		IndependentClient templast = array.get(index);
		//Set lowest index pair to temporary last string
		array.set(index-1, templast);
		//Set highest index pair to temporary first string
		array.set(index, tempfirst);
	}
		


	
	
	
	
	/***************************************
	 * Name: saveArrays
	 * Date: 20/05/2021
	 * Description: Saves the corporate contacts, independent contacts, and potential leads into respective .txt files
	 * Input: CorporateClient ArrayList, IndepedentClient ArrayList, Queue for potential leads
	 * Output: -
	 ***************************************/
	public static void saveArrays(ArrayList<CorporateClient> corporate, ArrayList<IndependentClient> independent, Queue<String> leads) throws IOException, FileNotFoundException {
		
		
			//Create PrintWriter for corporateClients.txt
		    PrintWriter outputCorporate = new PrintWriter(new FileWriter("corporateClients.txt"));
		    //Create PrintWriter for independentClients.txt
		    PrintWriter outputIndependent = new PrintWriter(new FileWriter("independentClients.txt"));
		    //Create PrintWriter for leads.txt
		    PrintWriter outputLeads = new PrintWriter(new FileWriter("leads.txt"));
		    
		    
		    //Print corporate ArrayList size into respective file
		    outputCorporate.println(corporate.size());
		    //Print independent ArrayList size into respective file
		    outputIndependent.println(independent.size());
		    //Initialize leadsSize as the leads queue size
		    int leadsSize = leads.size();
		    //Print leadsSize into respective file
		    outputLeads.println(leadsSize);
		    
		    //Copy leads into leadsCopy Queue
		    Queue<String> leadsCopy =  leads;
		    
		    
		    //For loop that iterates through the elements in the corporate ArrayList
		    for(int i = 0; i < corporate.size(); i++){
		    	//Write elements to file
		    	outputCorporate.println(corporate.get(i).companyName);
		    	outputCorporate.println(corporate.get(i).phoneNumber);
		    	outputCorporate.println(corporate.get(i).discoveredClient);
		    	outputCorporate.println(corporate.get(i).address);
		    }
		    //Close PrintWriter outputCorporate
		    outputCorporate.close();
		    
		    
		    
		    //For loop that iterates through the elements in the independent ArrayList
		    for(int j = 0; j < independent.size(); j++){
		    	//Write elements to file
		    	outputIndependent.println(independent.get(j).firstName);
		    	outputIndependent.println(independent.get(j).lastName);
		    	outputIndependent.println(independent.get(j).phoneNumber);
		    	outputIndependent.println(independent.get(j).discoveredClient);
		    	outputIndependent.println(independent.get(j).address);
		    }
		    //Close PrintWriter outputIndependent
		    outputIndependent.close();
		    
		    
		   //For loop that iterates through the elements in the leads queue
		   for(int k = 0; k < leadsSize; k++){
			   //Write the potential lead number into the file
			   outputLeads.println(leads.peek());
			   //Remove the lead from the leadsCopy  
			   leadsCopy.remove();
		    }
		    //Close PrintWriter outputLeads
		   outputLeads.close();
		

	}
	
	

	
	
	/***************************************
	 * Name: loadArrays
	 * Date: 20/05/2021
	 * Description: Loads the corporate contacts, independent contacts, and potential leads from respective .txt files
	 * Input: CorporateClient ArrayList, IndepedentClient ArrayList, Queue for potential leads
	 * Output: -
	 ***************************************/
	public static void loadArrays(ArrayList<CorporateClient> corporate, ArrayList<IndependentClient> independent, Queue<String> leads) throws IOException, FileNotFoundException {
		
		//Initialize new BufferedReader for corporateClients.txt called inFileCorporate
	    BufferedReader inFileCorporate = new BufferedReader(new FileReader("corporateClients.txt"));
	    //Initialize new BufferedReader for independentClients.txt called inFileIndepedant
	    BufferedReader inFileIndepedant= new BufferedReader(new FileReader("independentClients.txt"));
	    //Initialize new BufferedReader for leads.txt called inFileLeads
	    BufferedReader inFileLeads= new BufferedReader(new FileReader("leads.txt"));
	    
	    
	    //Read first value in each file to respective int variables
	    int x = Integer.valueOf(inFileCorporate.readLine()).intValue();
	    int y = Integer.valueOf(inFileIndepedant.readLine()).intValue();
	    int z = Integer.valueOf(inFileLeads.readLine()).intValue();

	    //Clear each ArrayList
	    corporate.clear();
	    independent.clear();
	    //Clear the leads Queue
	    leads.clear();
 
	   
	    
	    //For loop that iterates through the the number of corporate contacts to be added
	    for (int i = 0; i < x; i++){
	    	//Add each next line to respective field into temporary variables
	    	String name = inFileCorporate.readLine();
	    	String phone = inFileCorporate.readLine();
	    	boolean discovered = Boolean.parseBoolean(inFileCorporate.readLine());
	    	String location = inFileCorporate.readLine();
	    	//Add the values from the temporary variables to the corporate contact ArrayList
	    	corporate.add(new CorporateClient(name, phone, discovered, location));

	    }
	    //Close BufferedReader inFileCorporate
	    inFileCorporate.close();
	    
	    
	    
	    //For loop that iterates through the number of independent contacts to be added
	    for (int j = 0; j < y; j++){
	    	//Add next line into names at arrayCounter position to temporary variables
	    	String primaryName = inFileIndepedant.readLine();
	    	String surname = inFileIndepedant.readLine();
	    	String phone = inFileIndepedant.readLine();
	    	boolean discovered = Boolean.parseBoolean(inFileIndepedant.readLine());
	    	String location = inFileIndepedant.readLine();
	    	//Add the values from the temporary variables to the independent contact ArrayList
	    	independent.add(new IndependentClient(primaryName, surname ,phone, discovered, location));
	    }
	    //Close BufferedReader inFileIndepedant
	    inFileIndepedant.close();
	    
	    
	    
	    
	    //For loop that iterates through the the number of potential lead numbers to be added
	    for (int k = 0; k < z; k++){
	    	//Add next line into the leads queue 
	    	leads.add(inFileLeads.readLine());
	    }
	    //Close BufferedReader inFileLeads
	    inFileLeads.close();	
	}
	
	

	
	
	/***************************************
	 * Name: binarySearchLeads
	 * Date: 20/05/2021
	 * Description: Runs a binary search on the leads queue.
	 * Input: String name, queue for leads.
	 * Output: -
	 ***************************************/
	public static int binarySearchLeads(String name, Queue<String> leads) {
		
		
		//Initialize a leadCopy Array with the size of the queue
		String[] leadCopy = new String[leads.size()];
		//For the size of the leads queue
		for (int i = 0; i < leads.size(); i++) {
			//Set the current position in the leadCopy as the next leads element
			leadCopy[i] = leads.remove();
		}
		//Sort the leadCopy
		Arrays.sort(leadCopy);
		
		//Initialize position as the returned value of the binary search method
		int position = binarySearchLeads(name, 0 , leadCopy.length -1, leadCopy);
		//If the position is not -1
		if (position != -1) {
			//Return where the key was found
			return position;
		}
		//Else return -1
		else {
			return -1;
		}
		
	}
	
	/***************************************
	 * Name: binarySearchLeads
	 * Date: 20/05/2021
	 * Description: Runs a binary search on the specified array.
	 * Input: String name, int lower bound, int higher bound, String array.
	 * Output: position of the element.
	 ***************************************/
	private static int binarySearchLeads(String x, int low, int high, String[] leadCopy) {
		//If the lower bound is higher than the higher bound
		if (low > high) {
			//Return -1
			return -1;
		}
		//Initialize int mid as the average of low and high
		int mid = (low + high) / 2;
		//If the element in the arrayList at mid is the key
		if(leadCopy[mid].compareTo(x) == 0) {
			//Return mid
			return mid;
		}
		//Else if the element in the arrayList at mid is less than the key
		else if (leadCopy[mid].compareTo(x) < 0) {
			//Return a binarySearch with the same key, the lower bound as mid + 1, and the higher bound as the same
			return binarySearchLeads(x, mid + 1, high, leadCopy);
		}
		//Else the element in the arrayList at mid is greater than the key
		else {
			//Return a binarySearch with the same key, the lower bound as the same, and the higher bound as mid -1
			return binarySearchLeads(x, low, mid - 1, leadCopy);
		}
	}
	

	
	
	
	
	
	
	
	/***************************************
	 * Name: binarySearchContactIdentities
	 * Date: 20/05/2021
	 * Description: Runs a binary search on a specified contact type
	 * Input: String name, int lower bound, int higher bound, String array.
	 * Output: position of the element.
	 ***************************************/
	public static int binarySearchContactIdentities(ArrayList<IndependentClient> independent, ArrayList<CorporateClient> corporate, boolean isIndependent, String key) {
		//If the independent contacts are to be searched
		if (isIndependent) {
			//Run a bubble sort on the independent contacts
			bubbleSortIndependent(independent);
			//Create an array copy with the size of the independent ArrayList
			String[] copy = new String[independent.size()];
			//For the size of the independent ArrayList
			for (int i = 0; i < independent.size(); i++) {
				//Set the current position in copy as the current value of the independent contact name
				copy[i] = independent.get(i).getName(false);
			}
			//Return the binary searched contact
			return Arrays.binarySearch(copy,key);
		}
		else {
			//Run a bubble sort on the corporate contacts
			bubbleSortCorporate(corporate);
			//Create an array copy with the size of the corporate ArrayList
			String[] copy = new String[corporate.size()];
			//For the size of the corporate ArrayList
			for (int i = 0; i < corporate.size(); i++) {
				//Set the current position in copy as the current value of the corporate contact name
				copy[i] = corporate.get(i).getName();
			}
			//Return the binary searched contact
			return Arrays.binarySearch(copy,key);
		}
	}
	
	

	
	
	/***************************************
	 * Name: copySearchIntoStorage
	 * Date: 20/05/2021
	 * Description: Copies the position of a search into the duplicateStorage ArrayList.
	 * Input: independent ArrayList, corporate ArrayList, String item, duplicateStorage ArrayList, boolean isIndependent
	 * Output: position of the element.
	 ***************************************/
	public static void copySearchIntoStorage(ArrayList<IndependentClient> independent, ArrayList<CorporateClient> corporate, 
			String item, ArrayList<Integer> duplicateStorage, boolean isIndependent) throws IOException {

		
		//Initialize arraySize int
		int arraySize;
		//Initialize int location as the result of binarySearchContactIdentities
		int location = binarySearchContactIdentities(independent, corporate, isIndependent, item);

		//If the method is for the independent contacts
		if (isIndependent) {
			//Set the arraySize as the independent ArrayList size
			arraySize = independent.size();
		}
		else {
			//Set the arraySize as the corporate ArrayList size
			arraySize = corporate.size();
		}
		
		//If the contact were not found
		if (location < 0) {
			//Add -1 to duplicateStorage
			duplicateStorage.add(-1);
		}
		else {
			//If the method is for the independent contacts
			if (isIndependent) {
				//Initialize boolean duplicate as true
				boolean duplicate = true;
				//Initialize x as location
				int x = location;
				//While only duplicates have been found and the position is below the total arraySize
				while(duplicate && x < arraySize) {
					//If the current position in the independent ArrayList is the same as the search item 
					if (item.compareTo(independent.get(x).getName(false)) == 0) {
						//add the position to duplicateStorage
						duplicateStorage.add(x);
						//Increment x
						x++;
					}
					else {
						//Set duplicate as false
						duplicate = false;
					}
				}
				
				
				//Reset duplicate as true
				duplicate = true;
				//Set x to the location minus one
				x = location - 1;
				//While only duplicates have been found and the position is above -1
				while(duplicate && x > -1) {
					//If the current position in the independent ArrayList is the same as the search item 
					if (item.compareTo(independent.get(x).getName(false)) == 0) {
						//add the position to duplicateStorage
						duplicateStorage.add(x);
						//Decrement x
						x--;
					}
					else {
						//Set duplicate as false
						duplicate = false;
					}
				}
				
				
			}
			else {
				//Initialize boolean duplicate as true
				boolean duplicate = true;
				//Initialize x as location
				int x = location;
				//While only duplicates have been found and the position is below the total arraySize
				while(duplicate && x < arraySize) {
					//If the current position in the corporate ArrayList is the same as the search item 
					if (item.compareTo(corporate.get(x).getName()) == 0) {
						//add the position to duplicateStorage
						duplicateStorage.add(x);
						//Increment x
						x++;
					}
					else {
						//Set duplicate as false
						duplicate = false;
					}
				}
				
				
				
				//Reset duplicate as true
				duplicate = true;
				//Set x to the location minus one
				x = location -1;
				//While only duplicates have been found and the position is above -1
				while(duplicate && x > -1) {
					//If the current position in the corporate ArrayList is the same as the search item 
					if (item.compareTo(corporate.get(x).getName()) == 0) {
						//add the position to duplicateStorage
						duplicateStorage.add(x);
						//Decrement x
						x--;
					}
					else {
						//Set duplicate as false
						duplicate = false;
					}
				}
			}
		}
	}
	
	
	
	
	
	/***************************************
	 * Name: isModifyIndependentSuccessful
	 * Date: 20/05/2021
	 * Description: Returns if the modification to an independent contact was successful
	 * Input: independent ArrayList, String search, String modification, String field
	 * Output: If the modification was successful or not
	 ***************************************/
	public static boolean isModifyIndependentSuccessful(ArrayList<IndependentClient> array, String search, String modification, String field) {
		
		//Initialize boolean found as false.
		boolean found = false;

		
		//If first name is to be modified
		if (field.compareTo("First Name") == 0) {
			//For loop that iterates through the completed array elements
			for (int i = 0; i < array.size(); i++) {
				//If found is false
				if (found == false) {
					//If the search item is the current contacts field value
					if (search.equals(array.get(i).firstName)){	
						//Set the current position field int the ArrayList as the modification
						array.get(i).firstName = modification;		
						//Set found as true
						found = true;
					}
				}
				
			}
		}
		
		//Else if last name is to be modified
		else if (field.compareTo("Last Name") == 0) {
			//For loop that iterates through the completed array elements
			for (int i = 0; i < array.size(); i++) {
				//If found is false
				if (found == false) {
					//If the search item is the current contacts field value
					if (search.equals(array.get(i).lastName)){	
						//Set the current position field int the ArrayList as the modification
						array.get(i).lastName = modification;		
						//Set found as true
						found = true;
					}
				}
			}
		}
		
		//Else if phone number is to be modified
		else if (field.compareTo("Phone Number") == 0) {
			//For loop that iterates through the completed array elements
			for (int i = 0; i < array.size(); i++) {
				//If found is false
				if (found == false) {
					//If the search item is the current contacts field value
					if (search.equals(array.get(i).phoneNumber)){	
						//Set the current position field int the ArrayList as the modification
						array.get(i).phoneNumber = modification;	
						//Set found as true
						found = true;
					}
				}
			}
		}
		
		
		//Else if discovery method is to be modified
		else if (field.compareTo("Was Discovered") == 0) {
			//For loop that iterates through the completed array elements
			for (int i = 0; i < array.size(); i++) {
				//If found is false
				if (found == false) {
					//If the search item is the current contacts field value. This uses the last name as the user is instructed to choose the last name for toggling
					if (search.equals(array.get(i).lastName)){	
						//If the current value is false
						if (array.get(i).discoveredClient == false) {
							//Set the value as true
							array.get(i).discoveredClient = true;
						}
						else {
							//Set the value as false
							array.get(i).discoveredClient = false;
						}
						//Set found as true
						found = true;
					}
				}
			}
		}
		
		//Else if address is to be modified
		else if (field.compareTo("Address") == 0) {
			//For loop that iterates through the completed array elements
			for (int i = 0; i < array.size(); i++) {
				//If found is false
				if (found == false) {
					//If the search item is the current contacts field value
					if (search.equals(array.get(i).address)){	
						//Set the current position field int the ArrayList as the modification
						array.get(i).address = modification;
						//Set found as true
						found = true;
					}
				}
			}
		}
		//If found is true
		if (found == true) {
			//Return true
			return true;
		}
		else {
			//Return false
			return false;
		}
	}
	
	
	
	

	
	/***************************************
	 * Name: isModifyCorporateSuccessful
	 * Date: 20/05/2021
	 * Description: Returns if the modification to a corporate contact was successful
	 * Input: corporate ArrayList, String search, String modification, String field
	 * Output: If the modification was successful or not
	 ***************************************/
	public static boolean isModifyCorporateSuccessful(ArrayList<CorporateClient> array, String search, String modification, String field) {
		
		//Initialize boolean found as false.
		boolean found = false;


		
		
		//If company name is to be modified
		if (field.compareTo("Company Name") == 0) {
			//For loop that iterates through the completed array elements
			for (int i = 0; i < array.size(); i++) {
				//If found is false
				if (found == false) {
					//If the search item is the current contacts field value
					if (search.equals(array.get(i).companyName)){	
						//Set the current position field int the ArrayList as the modification
						array.get(i).companyName = modification;	
						//Set found as true
						found = true;
					}
				}
				
			}
			
			
		}
		
		
		//Else if phone number is to be modified
		else if (field.compareTo("Phone Number") == 0) {
			//For loop that iterates through the completed array elements
			for (int i = 0; i < array.size(); i++) {
				//If found is false
				if (found == false) {
					//If the search item is the current contacts field value
					if (search.equals(array.get(i).phoneNumber)){		
						//Set the current position field int the ArrayList as the modification
						array.get(i).phoneNumber = modification;	
						//Set found as true
						found = true;
					}
				}
			}
		}
		
		
		//Else if discovery method is to be modified
		else if (field.compareTo("Was Discovered") == 0) {
			//For loop that iterates through the completed array elements
			for (int i = 0; i < array.size(); i++) {
				//If found is false
				if (found == false) {
					//If the search item is the current contacts field value. This uses the last name as the user is instructed to choose the company name for toggling
					if (search.equals(array.get(i).companyName)){		
						//If the current value is false
						if (array.get(i).discoveredClient == false) {
							//Set the value as true
							array.get(i).discoveredClient = true;
						}
						else {
							//Set the value as false
							array.get(i).discoveredClient = false;
						}
						//Set found as true
						found = true;
					}
				}
			}
		}
		
		

	
		
		//Else if address is to be modified
		else if (field.compareTo("Address") == 0) {
			//For loop that iterates through the completed array elements
			for (int i = 0; i < array.size(); i++) {
				//If found is false
				if (found == false) {
					//If the search item is the current contacts field value
					if (search.equals(array.get(i).address)){			
						//Set the current position field int the ArrayList as the modification
						array.get(i).address = modification;
						//Set found as true
						found = true;
					}
				}
			}
		}
		//If found is true
		if (found == true) {
			//Return true
			return true;
		}
		else {
			//Return false
			return false;
		}	
	}
	
}
