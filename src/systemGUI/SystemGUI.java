package systemGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import clientTypes.CorporateClient;
import clientTypes.IndependentClient;
import systemFunctions.SystemFunctions;




@SuppressWarnings("serial")
public class SystemGUI extends JFrame implements ActionListener{
	
	public static Queue<String> leads =  new LinkedList<>();		/*Queue of Strings called leads*/
	
	public static int flag = 0;										/*Global flag for deleting entries*/										
	
	public static ArrayList<CorporateClient> corporate = new ArrayList<CorporateClient>();			/*ArrayList that stores corporate contacts*/
	public static ArrayList<IndependentClient> independent = new ArrayList<IndependentClient>();	/*ArrayList that stores independent contacts*/
	
	public static ArrayList<Integer> duplicateStorage = new ArrayList<Integer>();					/*ArrayList that stores duplicate contact positions*/
	
	
	public Container contentPane;					/*Container called contentPane for contentPane items*/
	public JPanel myJPanel;							/*Global JPanel*/
	
	public JTable table;							/*Global JTable*/
	public JFrame frame;							/*Global JFrame*/
	
	public JTextField searchingTextField;				/*Global JTextField used to store search items*/
	public JTextField modifyingTextField;				/*Global JTextField used to store modification to search items*/

	
	public JTextField firstNamesTextField;				/*Global JTextField for first name input*/
	public JTextField lastNamesTextField;				/*Global JTextField for last name input*/
	public JTextField numbersTextField;					/*Global JTextField for number input*/
	public JTextField discoveredTextField;				/*Global JTextField for the method of discovery input*/
	public JTextField addressesTextField;				/*Global JTextField for address input*/
	
	public JTextField companyTextField;					/*Global JTextField for company name input*/
	
	public JTextField leadTextField;					/*Global JTextField for lead number input*/
	
	
	public SystemGUI() {
		
		frame = new JFrame();									/*Initialize new JFrame using global variable*/
		contentPane = getContentPane();							/*Initialize new container from getContentPane using global variable*/
	
		
		JMenuBar menuBar = new JMenuBar();						/*Initialize new JMenuBar called menuBar*/	
	    
		JMenu file = new JMenu("File");							/*Initialize new JMenu called file*/
		JMenu edit = new JMenu("Edit");							/*Initialize new JMenu called edit*/
		JMenu view = new JMenu("View");							/*Initialize new JMenu called view*/
		menuBar.add(file);										/*Add file to menuBar*/
		menuBar.add(edit); 										/*Add edit to menuBar*/
		menuBar.add(view);										/*Add view to menuBar*/
		
		JMenuItem quit = new JMenuItem("Quit");					/*Initialize new JMenuItem called quit*/
		JMenuItem save = new JMenuItem("Save");					/*Initialize new JMenuItem called save*/
		JMenuItem load = new JMenuItem("Load");					/*Initialize new JMenuItem called load*/
		quit.addActionListener(this);							/*Add listener to quit JMenuItem*/
		save.addActionListener(this);							/*Add listener to save JMenuItem*/
		load.addActionListener(this);							/*Add listener to load JMenuItem*/
		file.add(quit);											/*Add quit to file*/
		file.add(save);											/*Add save to file*/
		file.add(load);											/*Add load to file*/
		
		JMenuItem addIndependent = new JMenuItem("Add An Independent Client Contact");				/*Initialize new JMenuItem called addIndependent*/
		JMenuItem addCorporate = new JMenuItem("Add A Corporate Client Contact");					/*Initialize new JMenuItem called addCorporate*/
		JMenuItem delete = new JMenuItem("Delete Contact From List");								/*Initialize new JMenuItem called delete*/
		JMenuItem editContact = new JMenuItem("Edit Contact");										/*Initialize new JMenuItem called editContact*/
		JMenuItem potentialLead = new JMenuItem("Add Potential Lead Number");						/*Initialize new JMenuItem called potentialLead*/
		addIndependent.addActionListener(this);														/*Add listener to addIndependent JMenuItem*/
		addCorporate.addActionListener(this);														/*Add listener to addCorporate JMenuItem*/
		delete.addActionListener(this);																/*Add listener to delete JMenuItem*/
		potentialLead.addActionListener(this);														/*Add listener to potentialLead JMenuItem*/
		editContact.addActionListener(this);														/*Add listener to editContact JMenuItem*/
		edit.add(addIndependent);																	/*Add addIndependent to edit*/
		edit.add(addCorporate);																		/*Add addCorporate to edit*/
		edit.add(delete);																			/*Add delete to edit*/
		edit.add(editContact);																		/*Add editContact to edit*/
		edit.add(potentialLead);																	/*Add potentialLead to edit*/
		
		JMenuItem viewContactsIndependent = new JMenuItem("View Independent Client Contacts");		/*Initialize new JMenuItem called viewContactsIndependent*/
		JMenuItem viewContactsCorporate = new JMenuItem("View Corporate Client Contacts");			/*Initialize new JMenuItem called viewContactsCorporate*/
		JMenuItem sort = new JMenuItem("Sort Contacts");											/*Initialize new JMenuItem called sort*/
		JMenuItem searchContact = new JMenuItem("Search Contact Details");							/*Initialize new JMenuItem called searchContact*/
		JMenuItem leadContact = new JMenuItem("Search If Lead Is In Queue");						/*Initialize new JMenuItem called leadContact*/
		JMenuItem leads = new JMenuItem("View Next Potential Lead");								/*Initialize new JMenuItem called leads*/
		JMenuItem instructionMenu = new JMenuItem("View Instruction Menu");							/*Initialize new JMenuItem called instructionMenu*/
		viewContactsIndependent.addActionListener(this);											/*Add listener to viewContactsIndependent JMenuItem*/
		viewContactsCorporate.addActionListener(this);												/*Add listener to viewContactsCorporate JMenuItem*/
		sort.addActionListener(this);																/*Add listener to sort JMenuItem*/
		searchContact.addActionListener(this);														/*Add listener to searchContact JMenuItem*/
		leadContact.addActionListener(this);														/*Add listener to leadContact JMenuItem*/
		leads.addActionListener(this);																/*Add listener to leads JMenuItem*/
		instructionMenu.addActionListener(this);													/*Add listener to instructionMenu JMenuItem*/
		view.add(viewContactsIndependent);															/*Add viewContactsIndependent to view*/
		view.add(viewContactsCorporate);															/*Add viewContactsCorporate to view*/
		view.add(sort);																				/*Add sort to view*/
		view.add(searchContact);																	/*Add searchContact to view*/
		view.add(leadContact);																		/*Add leadContact to view*/
		view.add(leads);																			/*Add leads to view*/
		view.add(instructionMenu);																	/*Add instructionMenu to view*/
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);										/*Set frame defaultCloseOperation to EXIT_ON_CLOSE*/
		frame.setSize(500,500);																		/*Initialize window as 500 pixels by 500 pixels*/
		frame.setTitle("Client Contact Manager");													/*Set windows name as "Client Contact Manager*/
		
		
		myJPanel = new JPanel();																	/*Initialize new JPanel using global variable called myJPanel*/
		JLabel L1 =  new JLabel("Client Contact Manager");											/*Initialize new JLabel called L1 to display welcome message*/
    	myJPanel.add(L1, BorderLayout.CENTER);														/*Add L1 to Center of window*/
    	
    	
    	contentPane.add(myJPanel);																	/*Add myJPanel to the global contentPane*/
		frame.add(myJPanel);																		/*Add myJPanel to the global frame*/							
			
		myJPanel.setOpaque(false);																	/*Set mJPanel as transparent*/
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);											/*Set the global frame colour as LIGHT_GRAY*/
		frame.setJMenuBar(menuBar);																	/*Add menuBar to global frame*/
		
		
		myJPanel.revalidate();																		/*Revalidate myJPanel*/
		frame.setVisible(true);																		/*Set frame as visible*/
	}





	public static void main(String[] args) {
		//Start a new SystemGUI 
		new SystemGUI();
	}
	
	
	
	/***************************************
	 * Name: actionPerformed
	 * Date: 20/05/2021
	 * Description: Determines the action to be performed based on GUI interaction
	 * Input: ActionEvent e. This is the action performed in the GUI.
	 * Output: Resulting action.
	 ***************************************/
	@Override
	public void actionPerformed(ActionEvent e) {

		
		//Set event as the String value of the action performed
		String event = e.getActionCommand();				
		
		
		//Clear the JPanel 
		myJPanel.removeAll();
		//Revalidate the JPanel
		myJPanel.revalidate();
		//Repaint the JPanel to avoid frame issues
		myJPanel.repaint();
		//Reset frame colour to LIGHT_GRAY
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		//Set JPanel as invisible
		frame.setVisible(false);
			
		
		
		
		//If the user wants to submit a corporate client contact
		if (event.equals("Add Corporate Client")) { 
			//If the user input for the discovered text field is not a boolean, then rerun the menu
			if (discoveredTextField.getText().compareTo("false") != 0 && discoveredTextField.getText().compareTo("true") != 0) {
				try {
					//Run the the menu for corporate contact entry
					addEntryCorporate();
				} 
				//If there is an error with the format of the submitted data
				catch (IOException e1) {	
					//Display the general error message
					errorHasOccuredMessage();
				}
			}
			else {
				//Print action message to console for debugging
				System.out.println("Add to contact list");
				
				
				
		    	//Add a new contact to the corporate contact ArrayList using data from the JTextFields
	    		corporate.add(new CorporateClient(companyTextField.getText(),numbersTextField.getText(), Boolean.parseBoolean(discoveredTextField.getText()), addressesTextField.getText()));    	
	    		//Display action completed message
	    		actionCompletedMessage();
			}
			
		}
		
		

		//Else if the user wants to submit an independent client
		else if (event.equals("Add Independent Client")) { 
			//If the user input for the discovered text field is not a boolean, then rerun the menu
			if (discoveredTextField.getText().compareTo("false") != 0 && discoveredTextField.getText().compareTo("true") != 0) {
				try {
					//Run the the menu for independent contact entry
					addEntryIndependent();
				} 
				//If there is an error with the format of the submitted data
				catch (IOException e1) {
					//Display the general error message
					errorHasOccuredMessage();
				}
			}
			else {
				//Print action message to console for debugging
				System.out.println("Add to contact list");
						
				
						
				//Add a new contact to the independent contact ArrayList using data from the JTextFields
				independent.add(new IndependentClient(firstNamesTextField.getText(), lastNamesTextField.getText(), numbersTextField.getText(), Boolean.parseBoolean(discoveredTextField.getText()), addressesTextField.getText()));    		
				//Display action completed message
				actionCompletedMessage();
			}
			
		}	
		
		
		
		
		
		//Else if the user wants to submit a potential lead number
		else if (event.equals("Add Number")) { 

			try {
				//If the lead text field is empty
				if (leadTextField.getText().isEmpty() == true) {
					try {
						//Print message to console for debugging
						System.out.println("Add Potential Lead Number");
						//Rerun the menu to add a potential lead number
						addPotentialLeadNumber();
					}
					//If input is not valid
					catch (IOException e1) {
						//Run general error message pop up
						errorHasOccuredMessage();
					}	
				}
				else {
					//Add the specified number to the leads queue
					leads.add(leadTextField.getText());
					//Display completion message
					actionCompletedMessage();	
				}

			}
			//If input causes and illegal state
			catch (IllegalStateException e1) {
				//Display completion message
				errorHasOccuredMessage();
				
			}
			//If input is an illegal argument
			catch (IllegalArgumentException e1) {
				//Display completion message
				errorHasOccuredMessage(); 
			}
			//If input causes a null value to appear
			catch (NullPointerException e1) {
				//Display completion message
				errorHasOccuredMessage();
			}
		}	
		
		
		
	
		
		//Else if the user wants to clear the displayed lead number
		else if (event.equals("Clear Lead")) { 
			try {
				//If the current number is not null
				if (leads.peek() != null) {
					//Remove the current number
					leads.remove();
				}
				//Rerun the display menu to display the next lead number
				displayNextLead();
		
			}
			//If there is an input error
			catch (IOException e1) {
				//Display an error message
				errorHasOccuredMessage(); 
						
			}
		}
	
		

		
		//Else if the user wants to delete and existing independent contact
		else if (event.equals("Delete Independent Client")) {
			//Print message to console for debugging
			System.out.println("Delete Independent Client");		
			try {
				//Run deleteEntry method with global searchingtextField as input for independent contacts
				deleteEntryIndependent(searchingTextField.getText());
			}
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}
		}
		
		
		//Else if the user wants to delete and existing corporate contact 
		else if (event.equals("Delete Corporate Client")) {
			//Print message to console for debugging
			System.out.println("Delete Corporate Client");		
			try {
				//Run deleteEntry method with global searchingtextField as input for corporate contacts
				deleteEntryCorporate(searchingTextField.getText());
			}
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}
		}
		

		
		//Else if the user wants to search for an independent contact
		else if (event.equals("Search For Independent Contact Details")) {
			//Print message to console for debugging
			System.out.println("Search For Independent Contact Details");		

			try {
				//Run searching method for independent contacts with the searchingTextField as input
				searchForItemDisplayIndependent(searchingTextField.getText());
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}
		}
		
		
		//Else if the user wants to search for an corporate contact
		else if (event.equals("Search For Corporate Contact Details")) {
			//Print message to console for debugging
			System.out.println("Search For Corporate Contact Details");		

			try {
				//Run searching method for corporate contacts with the searchingTextField as input
				searchForItemDisplayCorporate(searchingTextField.getText());
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}
		}
					
				
		
		
		
		//Else if the user wants to edit an existing independent contact
		else if(event.equals("Search For Independent Contact Details To Edit")) {
			//Print message to console for debugging
			System.out.println("Search For Independent Contact Details To Edit");
			
			try {
				//Run the menu to specify independent contact to edit
				specifyEditTermIndependent();
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}	
			
	
		}
		
		
		//Else if the user wants to edit an existing corporate contact
		else if(event.equals("Search For Corporate Contact Details To Edit")) {				
			//Print message to console for debugging
			System.out.println("Search For Corporate Contact Details To Edit");
					
			try {
				//Run the menu to specify corporate contact to edit
				specifyEditTermCorporate();
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}	
		}
		
		
	
		
		
		
		//Else if the user wants to modify an independent first name
		else if (event.equals("Modify Independent First Name")) {
			//Print message to console for debugging
			System.out.println("Modify Independent First Name");
			//Initialize boolean successful
			boolean successful;
			//Set successful as the result of isModifyIndependentSuccessful
			successful = SystemFunctions.isModifyIndependentSuccessful(independent, searchingTextField.getText(), modifyingTextField.getText(), "First Name");
			try {
				//Run the display to inform the user if the swap was successful
				wasEditCompleted(successful);
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}


			
		}
		
		
		//Else if the user wants to modify an independent  last name
		else if (event.equals("Modify Independent Last Name")) {
			//Print message to console for debugging
			System.out.println("Modify Independent Last Name");
			//Initialize boolean successful
			boolean successful;
			//Set successful as the result of isModifyIndependentSuccessful
			successful = SystemFunctions.isModifyIndependentSuccessful(independent, searchingTextField.getText(), modifyingTextField.getText(), "Last Name");
			try {
				//Run the display to inform the user if the swap was successful
				wasEditCompleted(successful);
			}
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}
			
		}
		
		
		//Else if the user wants to modify an independent  phone number
		else if (event.equals("Modify Independent Phone Number")) {
			//Print message to console for debugging
			System.out.println("Modify Independent Phone Number");
			//Initialize boolean successful
			boolean successful;
			//Set successful as the result of isModifyIndependentSuccessful	
			successful = SystemFunctions.isModifyIndependentSuccessful(independent, searchingTextField.getText(), modifyingTextField.getText(), "Phone Number");	
			try {
				//Run the display to inform the user if the swap was successful
				wasEditCompleted(successful);
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}
		}
		
		
		
		//Else if the user wants to toggle the discovery method of an independent contact
		else if (event.equals("Toggle Independent Discovery Discovery")) {
			//Print message to console for debugging
			System.out.println("Toggle Independent Discovery Method");
			//Initialize boolean successful
			boolean successful;
			//Set successful as the result of isModifyIndependentSuccessful	
			successful = SystemFunctions.isModifyIndependentSuccessful(independent, searchingTextField.getText(), modifyingTextField.getText(), "Was Discovered");		
			try {
				//Run the display to inform the user if the swap was successful
				wasEditCompleted(successful);
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}			
		}
		
		
		//Else if the user wants to modify an independent address
		else if (event.equals("Modify Independent Address")) {
			//Print message to console for debugging
			System.out.println("Modify Independent Address");
			//Initialize boolean successful
			boolean successful;
			//Set successful as the result of isModifyIndependentSuccessful					
			successful = SystemFunctions.isModifyIndependentSuccessful(independent, searchingTextField.getText(), modifyingTextField.getText(), "Address");	
			try {
				//Run the display to inform the user if the swap was successful
				wasEditCompleted(successful);
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}						
		}
		
		
		
		
		
		
		
		//Else if the user wants to modify a corporate company name
		else if (event.equals("Modify Corporate Company Name")) {
			//Print message to console for debugging
			System.out.println("Modify Corporate Company Name");
			//Initialize boolean successful
			boolean successful;
			//Set successful as the result of isModifyIndependentSuccessful			
			successful = SystemFunctions.isModifyCorporateSuccessful(corporate, searchingTextField.getText(), modifyingTextField.getText(), "Company Name");
			try {
				//Run the display to inform the user if the swap was successful
				wasEditCompleted(successful);
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}		
		}
				
			
				
		//Else if the user wants to modify a corporate phone number
		else if (event.equals("Modify Corporate Phone Number")) {
			//Print message to console for debugging
			System.out.println("Modify Corporate Phone Number");
			//Initialize boolean successful
			boolean successful;
			//Set successful as the result of isModifyIndependentSuccessful			
			successful = SystemFunctions.isModifyCorporateSuccessful(corporate, searchingTextField.getText(), modifyingTextField.getText(), "Phone Number");		
			try {
				//Run the display to inform the user if the swap was successful
				wasEditCompleted(successful);
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}			
		}
				
				
				
		//Else if the user wants to toggle the discovery method of a corporate contact
		else if (event.equals("Toggle Corporate Discovery Method")) {
			//Print message to console for debugging
			System.out.println("Toggle Corporate Discovery Method");
			//Initialize boolean successful
			boolean successful;
			//Set successful as the result of isModifyIndependentSuccessful					
			successful = SystemFunctions.isModifyCorporateSuccessful(corporate, searchingTextField.getText(), modifyingTextField.getText(), "Was Discovered");				
			try {
				//Run the display to inform the user if the swap was successful
				wasEditCompleted(successful);
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}						
		}
				
		
		//Else if the user wants to modify a corporate address
		else if (event.equals("Modify Corporate Address")) {
			//Print message to console for debugging
			System.out.println("Modify Corporate Address");
			//Initialize boolean successful
			boolean successful;
			//Set successful as the result of isModifyIndependentSuccessful										
			successful = SystemFunctions.isModifyCorporateSuccessful(corporate, searchingTextField.getText(), modifyingTextField.getText(), "Address");							
			try {
				//Run the display to inform the user if the swap was successful
				wasEditCompleted(successful);
			} 
			//If the input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}								
		}
						
		
		
		
		
		//Else if the user wants to quit the program
		else if(event.equals("Quit")) {
			//Print message to console for debugging
	        System.out.println("Quit");
	        //Close the program
	        System.exit(0);
	    }
		
		
		//Else if the user wants to save the contacts to respective .txt files
		else if(event.equals("Save")) {
			try {
				//Print message to console for debugging
				System.out.println("Save");
				
				//Run saveArrays method
				SystemFunctions.saveArrays(corporate, independent, leads);
				
				//Display action completed message
				actionCompletedMessage();
			}
			//If a file was not found
			catch(IOException e1){	
				//Run general error message pop up
				errorHasOccuredMessage();
			}		
		}
		
		
		//Else if the user wants to load the contacts from respective .txt files
		else if(event.equals("Load")) {
			try {
				//Print message to console for debugging
				System.out.println("Load");
				//Run loadArrays method
				SystemFunctions.loadArrays(corporate, independent, leads);
				//Display action completed message
				actionCompletedMessage();
			}
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}	
		}
		
	
		
		
		//Else if the user wants to add to the independent contacts list
		else if(event.equals("Add An Independent Client Contact")) {
			try {
				//Print message to console for debugging
				System.out.println("Add An Independent Client Contact");
				//Run addEntry method for independent contacts
				addEntryIndependent();
			}
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}	
		}
		
		//Else if the user wants to add to the corporate contacts list
		else if(event.equals("Add A Corporate Client Contact")) {
			try {
				//Print message to console for debugging
				System.out.println("Add A Corporate Client Contact");
				//Run addEntry method for corporate contacts
				addEntryCorporate();
			}
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}	
		}
		
		
		
		
		//Else if the user wants to add a potential lead number
		else if(event.equals("Add Potential Lead Number")) {
			try {
				//Print message to console for debugging
				System.out.println("Add Potential Lead Number");
				//Run addEntry method for potential lead numbers
				addPotentialLeadNumber();
			}
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}	
		}
		
		
		
		
		
		
		//Else if the user wants to delete a corporate or independent contact
		else if(event.equals("Delete Contact From List")) {
			try {
				//Print message to console for debugging
				System.out.println("Delete Contact From List");
				//Run the delelteEntryMenu
				deleteEntryMenu();	
			}
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}	
		}
		
		
		
		
		
		//Else if the user wants to edit an existing contact
		else if(event.equals("Edit Contact")) {
			try {
				//Print message to console for debugging
				System.out.println("Edit Contact");
				//Run searchForEditFieldMenu method
				searchForEditFieldMenu();	
			}
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}		
		}
		

	
		
		//Else if the user wants to search for a particular corporate or independent contacts details
		else if(event.equals("Search Contact Details")) {
			try {
				//Print message to console for debugging
				System.out.println("Search Contact Details");
				//Run searchToDisplayMenu method
				searchToDisplayMenu();	
			}
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}	
		}
		
		

		
		//Else if the user wants to view all corporate client contacts
		else if(event.equals("View Corporate Client Contacts")) {
			//Print message to console for debugging
			System.out.println("View Corporate Clients");
			//Run displayArraysCorporate method
			displayArraysCorporate();
		}
		
		//Else if the user wants to view all independent client contacts
		else if(event.equals("View Independent Client Contacts")) {
			//Print message to console for debugging
			System.out.println("View Independent Clients");
			//Run displayArraysIndependent method
			displayArraysIndependent();
		}
		
		
		//Else if the user wants to sort the contacts
		else if(event.equals("Sort Contacts")) {
			//Print message to console for debugging
			System.out.println("Sort Contacts");
			
			//Initialize a boolean which stores the state of the ArrayLists
			boolean isListsEmpty = false;
			
			//If the contacts are empty, set isListsEmpty to true
			if (corporate.isEmpty() == true && independent.isEmpty() == true) {
				isListsEmpty = true;
			}
			else {
				//Run the bubbleSortCorporate and bubbleSortIndependent methods
				SystemFunctions.bubbleSortCorporate(corporate);
				SystemFunctions.bubbleSortIndependent(independent);
				;
			}
			
			//Display the contacts sorted message
			contactSortedMessage(isListsEmpty);
			
		}
		
		//Else if the user wants to view the next potential lead number
		else if(event.equals("View Next Potential Lead")) {
			//Print message to console for debugging
			System.out.println("View Next Potential Lead");
			try {
				//Run displayNextLead method
				displayNextLead();
			} 
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}
		}
		
				
		
		//Else if the user wants to view the built in instructions
		else if(event.equals("View Instruction Menu")) {
			//Print message to console for debugging
			System.out.println("View Instruction Menu");
			//Run instructionMenu method
			instructionMenu();			
		}
		
		
		
		//Else if the user wants to search if a particular lead number is in the queue
		else if(event.equals("Search If Lead Is In Queue")) {
			//Print message to console for debugging
			System.out.println("Search If Lead Is In Queue");
			try {
				//Run lookForLeadMenu method
				lookForLeadMenu();
			} 
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}	
		}
		
	
		//Else if the user wants submit the lead to search
		else if(event.equals("Search For Lead")) {
			//Print message to console for debugging
			System.out.println("Search For Lead");
			try {
				//If the text field was left empty, rerun the input method
				if (searchingTextField.getText().length() == 0) {
					lookForLeadMenu();
				}
				else {
					//Create leads clone to send to wasLeadFound
					Queue<String >leadTemp = new LinkedList<>(leads);
					//Run wasLeadFound method to display result
					wasLeadFound(searchingTextField.getText(), leadTemp);
				}				
			} 
			//If input is not valid
			catch (IOException e1) {
				//Run general error message pop up
				errorHasOccuredMessage();
			}			
		}
		
	}
	
	
	
	/***************************************
	 * Name: displayArraysCorporate
	 * Date: 20/05/2021
	 * Description: Displays all the corporate contacts.
	 * Input: -
	 * Output: JTable with corporate contact info.
	 ***************************************/
	public void displayArraysCorporate() {
		//Create new JPanel
		myJPanel = new JPanel();	
		//Create headers for JTable
		String[] columnNames = {"COMPANY NAME", "PHONE NUMBER", "WAS FOUND BY SERVICING COMPANY", "ADDRESS"};
		//Create empty 2D array for JTable
		String[][] twoDimensionalArray = new String[corporate.size()][4];
				
		//For loop that repeats for size of ArrayList and collects contact info into twoDimensionalArray
		for (int i = 0; i < corporate.size(); i++) {
			twoDimensionalArray[i][0] = corporate.get(i).companyName;
			twoDimensionalArray[i][1] = corporate.get(i).phoneNumber;
			twoDimensionalArray[i][2] = String.valueOf(corporate.get(i).discoveredClient);
			twoDimensionalArray[i][3] = corporate.get(i).address;
		}
		
		
		
		


		//Create new JTable with twoDimensionalArray as data and columnNames as column names
		table = new JTable(twoDimensionalArray, columnNames);
		//Make the JTable uneditable directly in the window
		table.setDefaultEditor(Object.class, null);
		//Add a scrollPane to JTable
		JScrollPane scrollPane = new JScrollPane(table);
		//Add the scrollPane to the JPanel
		myJPanel.add(scrollPane);
		
		
		//Resize the JTable so that each of the headings are visible
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setMinWidth(100);

		
		
		//Add the JPanel to the contentPane
		contentPane.add(myJPanel);
		//Set the JPanel as transparent
		myJPanel.setOpaque(false);
		//Add the JPanel to the global frame
		frame.add(myJPanel);
		//Pack the frame
		frame.pack();
		//Set the frame as visible
		frame.setVisible(true);
	}
	
	
	
	
	
	/***************************************
	 * Name: displayArraysIndependent
	 * Date: 20/05/2021
	 * Description: Displays all the independent contacts.
	 * Input: -
	 * Output: JTable with independent contact info.
	 ***************************************/
	public void displayArraysIndependent() {
		//Create new JPanel
		myJPanel = new JPanel();	
		//Create headers for JTable
		String[] columnNames = {"LAST NAME", "FIRST NAME", "PHONE NUMBER", "WAS FOUND BY SERVICING COMPANY", "ADDRESS"};
		//Create empty 2D array for JTable
		String[][] twoDimensionalArray = new String[independent.size()][5];
				
		//For loop that repeats for size of ArrayList and collects contact info into twoDimensionalArray
		for (int i = 0; i < independent.size(); i++) {
			twoDimensionalArray[i][0] = independent.get(i).lastName;
			twoDimensionalArray[i][1] = independent.get(i).firstName;
			twoDimensionalArray[i][2] = independent.get(i).phoneNumber;
			twoDimensionalArray[i][3] = String.valueOf(independent.get(i).discoveredClient);
			twoDimensionalArray[i][4] = independent.get(i).address;
			
		}

		//Create new JTable with twoDimensionalArray as data and columnNames as column names
		table = new JTable(twoDimensionalArray, columnNames);
		//Make the JTable uneditable directly in the window
		table.setDefaultEditor(Object.class, null);
		//Add a scrollPane to JTable
		JScrollPane scrollPane = new JScrollPane(table);
		//Add the scrollPane to the JPanel
		myJPanel.add(scrollPane);
		
		//Resize the JTable so that each of the headings are visible
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		
		
		
		//Add the JPanel to the contentPane
		contentPane.add(myJPanel);
		//Set the JPanel as transparent
		myJPanel.setOpaque(false);
		//Add the JPanel to the global frame
		frame.add(myJPanel);
		//Pack the frame
		frame.pack();
		//Set the frame as visible
		frame.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	/***************************************
	 * Name: deleteEntryMenu
	 * Date: 20/05/2021
	 * Description: Displays the delete contact menu.
	 * Input: last name or company name of contact to be deleted.
	 * Output: -
	 ***************************************/
	public void deleteEntryMenu() throws IOException {
		
		//Initialize new JPanel with 8x2 grid layout
		myJPanel = new JPanel(new GridLayout(8,2));
				
		
		//Create new JLabel called L1 that asks used for first name or company name of the contact to be deleted
		JLabel L1 =  new JLabel("Enter the last name or the company name of the contact to be deleted:");
		//Add L1 to JPanel
    	myJPanel.add(L1);
    	//Initialize new JTextField with 50 spaces as global searchingTextField
    	searchingTextField = new JTextField(50);
    	//Add searchingTextField to JPanel
    	myJPanel.add(searchingTextField);
    	
    	//Create new JButton called submitButton to delete independent contact
    	JButton independentButton = new JButton("Delete Independent Client");
    	//Add submitButton to JPanel
    	myJPanel.add(independentButton);
    	//Add listener to submitButton
    	independentButton.addActionListener(this);
    	
    	//Create new JButton called submitButton to delete corporate contact
    	JButton corporateButton = new JButton("Delete Corporate Client");
    	//Add submitButton to JPanel
    	myJPanel.add(corporateButton);
    	//Add listener to submitButton
    	corporateButton.addActionListener(this);
		
    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	
	/***************************************
	 * Name: deleteEntryCorporate
	 * Date: 20/05/2021
	 * Description: Deletes the specified corporate contact and displays the result.
	 * Input: Company name of the contact to be deleted.
	 * Output: If the contact was deleted or not.
	 ***************************************/
	public void deleteEntryCorporate(String text) throws IOException {
		
		//Create new JPanel using global myJPanel
		myJPanel = new JPanel();
		//Initialize boolean found as false
		Boolean found = false;																					
		//For loop that iterates through the elements in the corporate ArrayList
		for (int i = 0; i < corporate.size(); i++) {
			//If the deletion company name matches element the specified element, set flag as i and found as true
			if (text.equals(corporate.get(i).getName())){						
				flag = i;											
				found = true;										
			}
		}
		
		
		
		//If found is true
		if (found == true) {
			//If the element is in the last possible position in the ArrayList
			if (flag == corporate.size() - 1) {
				//Clear the last element in each ArrayList
				corporate.remove(corporate.size()-1);
		    }
			//If the element is in any position besides the last possible position
			else {
				//For loop to iterate through the elements after the contact desired to be removed
				for (int i = flag; i < corporate.size()-1; i++){
									
					//Replace names element with element after it
					corporate.set(i, corporate.get(i+1));
				}
				
				//Clear the last element in each ArrayList
				corporate.remove(corporate.size()-1);				
			}
			
			//Create new JLabel called L1 which displays the completion message for deletion
			JLabel L1 =  new JLabel("Contact Deleted");
			//Add L1 to JPanel
        	myJPanel.add(L1);
		
		}
		//Else name doesn't exist
		else {
			//Create new JLabel called L1 which displays contact not found message
			JLabel L1 =  new JLabel("Contact Not Found");
			//Add L1 to JPanel
        	myJPanel.add(L1);
		}		
		
		
		//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	
	
	/***************************************
	 * Name: deleteEntryIndependent
	 * Date: 20/05/2021
	 * Description: Deletes the specified independent contact and displays the result.
	 * Input: First name of the contact to be deleted.
	 * Output: If the contact was deleted or not.
	 ***************************************/
	public void deleteEntryIndependent(String text) throws IOException {
		
		//Create new JPanel using global myJPanel
		myJPanel = new JPanel();
		//Initialize boolean found as false
		Boolean found = false;																					
		//For loop that iterates through the elements in the independent ArrayList
		for (int i = 0; i < independent.size(); i++) {
			//If the deletion last name matches element, set flag as i and found as true
			if (text.equals(independent.get(i).getName(false))){						
				flag = i;											
				found = true;										
			}
		}
		
		
		
		//If found is true
		if (found == true) {
			//If the element is in the last possible position in the ArrayList
			if (flag == independent.size() - 1) {
				//Clear the last element in each ArrayList
				independent.remove(independent.size()-1);
		    }
			//If the element is in any position besides the last possible position
			else {
				//For loop to iterate through the elements after the contact desired to be removed
				for (int i = flag; i < independent.size()-1; i++){
									
					//Replace names element with element after it
					independent.set(i, independent.get(i+1));
				}
				
				//Clear the last element in each ArrayList
				independent.remove(independent.size()-1);				
			}
			
			//Create new JLabel called L1 which displays the completion message for deletion
			JLabel L1 =  new JLabel("Contact Deleted");
			//Add L1 to JPanel
        	myJPanel.add(L1);
		
		}
		//Else name doesn't exist
		else {
			//Create new JLabel called L1 which displays contact not found message
			JLabel L1 =  new JLabel("Contact Not Found");
			//Add L1 to JPanel
        	myJPanel.add(L1);
		}		
		
		
		//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	

	/***************************************
	 * Name: errorHasOccuredMessage
	 * Date: 20/05/2021
	 * Description: Display error message and asks for user to ensure contacts are in correct location and input is correct.
	 * Input:-
	 * Output:-
	 ***************************************/
	public void errorHasOccuredMessage() {
		
		//Create New JPanel using global myJPanel
		myJPanel = new JPanel();

		//Create new JLabel called L1 which display the error message
		JLabel L1 =  new JLabel("An error has occured due to a user action. "
				+ "Please ensure all input is proper and that the corporateClients.txt, independentClients.txt, and leads.txt file are in the correct directory and try again.");
		//Add L1 to JPanel
    	myJPanel.add(L1);
    	
    	//Set the frame background colour as red
    	frame.getContentPane().setBackground(Color.red);
    	
    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	/***************************************
	 * Name: addEntryIndependent
	 * Date: 20/05/2021
	 * Description: Displays the menu for adding an independent contact.
	 * Input: first name, last name, phone number, discovery method, and address.
	 * Output:-
	 ***************************************/

	public void addEntryIndependent() throws IOException{

		//Initialize new JPanel with 6x2 grid layout
		myJPanel = new JPanel(new GridLayout(6,2));
		

		//Create new JLabel called L1 to ask for first name input
    	JLabel L1 =  new JLabel("Enter the first name:");
    	//Add L1 to JPanel
    	myJPanel.add(L1);
    	//Create new JTextField size 50 with firstNamesTextField global variable
    	firstNamesTextField = new JTextField(50);
    	//Add firstNamesTextField to JPanel
    	myJPanel.add(firstNamesTextField);
    	
    	//Create new JLabel called L2 to ask for last name input
    	JLabel L2 =  new JLabel("Enter the last name:");
    	//Add L2 to JPanel
    	myJPanel.add(L2);
    	//Create new JTextField size 50 with lastNamesTextField global variable
    	lastNamesTextField = new JTextField(50);
    	//Add lastNamesTextField to JPanel
    	myJPanel.add(lastNamesTextField);
    	
    	//Create new JLabel called L3 to ask for the phone number
    	JLabel L3 =  new JLabel("Enter the phone number (ex. 123-456-7890):");
    	//Add L3 to JPanel
    	myJPanel.add(L3);
    	//Create new JTextField size 50 with numbersTextField global variable
    	numbersTextField = new JTextField(50);
    	//Add numbersTextField to JPanel
    	myJPanel.add(numbersTextField);
    	
    	//Create new JLabel called L4 to ask for the discovery state
    	JLabel L4 =  new JLabel("Enter if the contact was found through the company (true for yes, false for no):");
    	//Add L4 to JPanel
    	myJPanel.add(L4);
    	//Create new JTextField size 50 with emailsTextField global variable
    	discoveredTextField = new JTextField(50);
    	//Add emailsTextField to JPanel
    	myJPanel.add(discoveredTextField);
    	
    	//Create new JLabel called L5 to ask for the address
    	JLabel L5 =  new JLabel("Enter the enter the address (ex. 12 Sesame St):");
    	//Add L5 to JPanel
    	myJPanel.add(L5);
    	//Create new JTextField size 50 with addressesTextField global variable
    	addressesTextField = new JTextField(50);
    	//Add addressesTextField to JPanel
    	myJPanel.add(addressesTextField);
    	
    	//Create new JButton called submitButton to submit contact information
    	JButton submitButton = new JButton("Add Independent Client");
    	//Add submitButton to JPanel
    	myJPanel.add(submitButton);
    	//Add listener to submitButton
    	submitButton.addActionListener(this);    					
	   

	    
	    //Add JPanel to contentPane
		contentPane.add(myJPanel);
		//Set JPanel as transparent
		myJPanel.setOpaque(false);
		//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	/***************************************
	 * Name: addEntryCorporate
	 * Date: 20/05/2021
	 * Description: Displays the menu for adding a corporate contact.
	 * Input: company name, phone number, discovery method, and address.
	 * Output:-
	 ***************************************/
	public void addEntryCorporate() throws IOException{

		//Initialize new JPanel with 5x2 grid layout
		myJPanel = new JPanel(new GridLayout(5,2));
		

		//Create new JLabel called L1 to ask for company name input
    	JLabel L1 =  new JLabel("Enter the company name:");
    	//Add L1 to JPanel
    	myJPanel.add(L1);
    	//Create new JTextField size 50 with companyTextField global variable
    	companyTextField = new JTextField(50);
    	//Add firstNamesTextField to JPanel
    	myJPanel.add(companyTextField);
    	
    	
    	//Create new JLabel called L3 to ask for the phone number
    	JLabel L3 =  new JLabel("Enter the phone number (ex. 123-456-7890):");
    	//Add L3 to JPanel
    	myJPanel.add(L3);
    	//Create new JTextField size 50 with numbersTextField global variable
    	numbersTextField = new JTextField(50);
    	//Add numbersTextField to JPanel
    	myJPanel.add(numbersTextField);
    	
    	//Create new JLabel called L4 to ask for the discovery state
    	JLabel L4 =  new JLabel("Enter if the contact was found through the company  (true for yes, false for no):");
    	//Add L4 to JPanel
    	myJPanel.add(L4);
    	//Create new JTextField size 50 with emailsTextField global variable
    	discoveredTextField = new JTextField(50);
    	//Add emailsTextField to JPanel
    	myJPanel.add(discoveredTextField);
    	
    	//Create new JLabel called L5 to ask for the address
    	JLabel L5 =  new JLabel("Enter the enter the address (ex. 12 Sesame St):");
    	//Add L5 to JPanel
    	myJPanel.add(L5);
    	//Create new JTextField size 50 with addressesTextField global variable
    	addressesTextField = new JTextField(50);
    	//Add addressesTextField to JPanel
    	myJPanel.add(addressesTextField);
    	
    	//Create new JButton called submitButton to submit contact information
    	JButton submitButton = new JButton("Add Corporate Client");
    	//Add submitButton to JPanel
    	myJPanel.add(submitButton);
    	//Add listener to submitButton
    	submitButton.addActionListener(this);    					
	   

	    
	    //Add JPanel to contentPane
		contentPane.add(myJPanel);
		//Set JPanel as transparent
		myJPanel.setOpaque(false);
		//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	
	
	
	/***************************************
	 * Name: contactSortedMessage
	 * Date: 20/05/2021
	 * Description: Display the message that the contacts were sorted.
	 * Input: Boolean isEmpty which checks changes if no contacts existed to sort
	 * Output:-
	 ***************************************/
	
	public void contactSortedMessage(boolean isEmpty) {
		
		
		//Create New JPanel using global myJPanel
		myJPanel = new JPanel();

		
		//If there were no contacts to sort
		if (isEmpty) {
			//Create new JLabel called L1 which display that there were no contacts to sort
			JLabel L1 =  new JLabel("There are no contacts or leads to sort");
			//Add L1 to JPanel
	    	myJPanel.add(L1);
	    	
	    	//Set the frame background colour as yellow
	    	frame.getContentPane().setBackground(Color.yellow);
			
		}
		else {
			//Create new JLabel called L1 which display that the contacts were sorted
			JLabel L1 =  new JLabel("Contacts Sorted");
			//Add L1 to JPanel
	    	myJPanel.add(L1);
	    	
	    	//Set the frame background colour as green
	    	frame.getContentPane().setBackground(Color.green);
		}
		
    	
    	
    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Set the frame size as 200x200 pixels
		frame.setSize(300,300);			
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	
	
	/***************************************
	 * Name: actionCompletedMessage
	 * Date: 20/05/2021
	 * Description: Display the action completed message.
	 * Input:-
	 * Output:-
	 ***************************************/
	public void actionCompletedMessage() {
		
		//Create New JPanel using global myJPanel
		myJPanel = new JPanel();

		//Create new JLabel called L1 which display the action completed message
		JLabel L1 =  new JLabel("Action Completed");
		//Add L1 to JPanel
    	myJPanel.add(L1);
    	
    	//Set the frame background colour as green
    	frame.getContentPane().setBackground(Color.green);
    	
    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();	
		//Set the frame size as 500x500 pixels
		frame.setSize(200,200);																		
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	
	/***************************************
	 * Name: addPotentialLeadNumber
	 * Date: 20/05/2021
	 * Description: Display menu to add a potential lead number.
	 * Input: Lead number.
	 * Output:-
	 ***************************************/
	public void addPotentialLeadNumber() throws IOException{

		//Initialize new JPanel with 8x2 grid layout
		myJPanel = new JPanel(new GridLayout(8,2));
		
		
	    //Create new JLabel called L1 to ask for the lead number
	    JLabel L1 =  new JLabel("Enter the potential leads phone number:");
	    //Add L1 to JPanel
	    myJPanel.add(L1);
	    //Create new JTextField size 50 with leadTextField global variable
	    leadTextField = new JTextField(50);
	    //Add firstNamesTextField to JPanel
	    myJPanel.add(leadTextField);

	    	
	    //Create new JButton called submitButton to submit contact information
	    JButton submitButton = new JButton("Add Number");
	    //Add submitButton to JPanel
	    myJPanel.add(submitButton);
	    //Add listener to submitButton
	    submitButton.addActionListener(this);    					
	   

	    //Add JPanel to contentPane
		contentPane.add(myJPanel);
		//Set JPanel as transparent
		myJPanel.setOpaque(false);
		//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	
	
	/***************************************
	 * Name: displayNextLead
	 * Date: 20/05/2021
	 * Description: Displays the next potential lead number.
	 * Input: -
	 * Output:-
	 ***************************************/
	public void displayNextLead() throws IOException {
		
		//Create new JPanel using global myJPanel
		myJPanel = new JPanel();
		//Initialize the String label
		String label;
		//If the next element in the queue is null
		if (leads.peek() == null) {
			//Set label as there are no new leads message
			label = "There are no new leads";
		}
		else {
			//Set label as the next lead number
			label = ("The next lead number is: " + "'" + leads.peek() + "'.");
		}
		//Create new JLabel called L1 that asks used to display label
		JLabel L1 =  new JLabel(label);
		//Add L1 to JPanel
    	myJPanel.add(L1);

    	
    	//Create new JButton called clearLead to delete contact
    	JButton clearLead = new JButton("Clear Lead");
    	//Add clearLead to JPanel
    	myJPanel.add(clearLead);
    	//Add listener to clearLead
    	clearLead.addActionListener(this);
    	
		
    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	
	

	
	
	
	/***************************************
	 * Name: searchToDisplayMenu
	 * Date: 20/05/2021
	 * Description: Displays menu to search for a contact to display.
	 * Input: Last name or company.
	 * Output:-
	 ***************************************/
	public void searchToDisplayMenu() throws IOException {
		
			//Initialize new JPanel with 8x2 grid layout
			myJPanel = new JPanel(new GridLayout(8,2));
		
		
			//Create new JLabel called L1 which asks for the user to input the last name or company name of the contact to be searched
			JLabel L1 =  new JLabel("Enter the last name or company name of the contact to be searched:");
			//Add L1 to JPanel
	    	myJPanel.add(L1);
	    	//Create new JTextField using searchingTextField global variable
	    	searchingTextField = new JTextField(50);
	    	//Add searchingTextField to JPanel
	    	myJPanel.add(searchingTextField);
			

	    	//Create new JButton called L2 which start the search for the independent contacts details
			JButton L2 =  new JButton("Search For Independent Contact Details");
			//Add L2 to JPanel
	    	myJPanel.add(L2);
	    	//Add listener to L2
	    	L2.addActionListener(this);
	    	
	    	
	    	//Create new JButton called L2 which start the search for the corporate contacts details
			JButton L3 =  new JButton("Search For Corporate Contact Details");
			//Add L2 to JPanel
	    	myJPanel.add(L3);
	    	//Add listener to L2
	    	L3.addActionListener(this);

	    	
	    			
	    	//Add JPanel to contentPane
	    	contentPane.add(myJPanel);
	    	//Set JPanel as transparent
	    	myJPanel.setOpaque(false);
	    	//Add JPanel to frame
			frame.add(myJPanel);
			//Revalidate JPanel
			myJPanel.revalidate();
			//Pack the frame
			frame.pack();
			//Set frame as visible
			frame.setVisible(true);

		
	}


	
	
	
	
	
	
	
	
	/***************************************
	 * Name: searchForItemDisplayIndependent
	 * Date: 20/05/2021
	 * Description: Displays searched independent contacts.
	 * Input: Last name.
	 * Output: JTable with contact information.
	 ***************************************/
	public void searchForItemDisplayIndependent(String item) throws IOException {
		

			
		//Initialize new JPanel using myJPanel global variable
		myJPanel = new JPanel();
		//Initialize L1 as empty space JLabel
		JLabel L1 = new JLabel(" ");
		
		//Clear the duplicate storage ArrayList
		duplicateStorage.clear();
		
		//Run the is search found method for the search term
		SystemFunctions.copySearchIntoStorage(independent, corporate, item, duplicateStorage, true);
	    
	    //If contact is found, display the contact
	    if (duplicateStorage.get(0) != -1) {
	    	//Create String array with column names for JTable
	    	String[] columnNames = {"LAST NAME", "FIRST NAME", "PHONE NUMBER", "WAS FOUND BY SERVICING COMPANY", "ADDRESS"};
			//Create empty 1x6 2D array called twoDimensionalArray
			String[][] twoDimensionalArray = new String[duplicateStorage.size()][5];
			

			
			//For loop that repeats for size of ArrayList and collects contact info into twoDimensionalArray
			for (int i = 0; i < duplicateStorage.size(); i++) {
				twoDimensionalArray[i][0] = independent.get(duplicateStorage.get(i)).lastName;
				twoDimensionalArray[i][1] = independent.get(duplicateStorage.get(i)).firstName;		
				twoDimensionalArray[i][2] = independent.get(duplicateStorage.get(i)).phoneNumber;
				twoDimensionalArray[i][3] = String.valueOf(independent.get(duplicateStorage.get(i)).discoveredClient);
				twoDimensionalArray[i][4] = independent.get(duplicateStorage.get(i)).address;
				
			}
			

			
			//Create new JTable with twoDimensionalArray and columnNames as input
			table = new JTable(twoDimensionalArray, columnNames);
			//Make the JTable uneditable directly for user
			table.setDefaultEditor(Object.class, null);
			//Add scrollPane to JTable
			JScrollPane scrollPane = new JScrollPane(table);
			//Add scrollPane to JPanel
			myJPanel.add(scrollPane);	
			
			
			//Resize the JTable so that each of the headings are visible
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(0).setPreferredWidth(130);
			table.getColumnModel().getColumn(1).setPreferredWidth(130);
			table.getColumnModel().getColumn(2).setPreferredWidth(130);
			table.getColumnModel().getColumn(3).setPreferredWidth(250);
			table.getColumnModel().getColumn(4).setMinWidth(100);
			
		}
				
	   	//Else contact wasn't found
	   	else {
	   		//Set L1 as message that the contact isn't in the list
	   		L1 =  new JLabel("That contact isn't in the contact list");
	   	}

	    //Add L1 to JPanel
		myJPanel.add(L1);
		
		//Add JPanel to contentPane
		contentPane.add(myJPanel);
		//Set JPanel as transparent
		myJPanel.setOpaque(false);
		//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);

	}	
	
	
	
	/***************************************
	 * Name: searchForItemDisplayCorporate
	 * Date: 20/05/2021
	 * Description: Displays searched corporate contacts.
	 * Input: Company name.
	 * Output: JTable with contact information.
	 ***************************************/
	public void searchForItemDisplayCorporate(String item) throws IOException {
		

			
		//Initialize new JPanel using myJPanel global variable
		myJPanel = new JPanel();
		//Initialize L1 as empty space JLabel
		JLabel L1 = new JLabel(" ");

		//Clear the duplicate storage ArrayList
		duplicateStorage.clear();
		
		//Run the is search found method for the search term
		SystemFunctions.copySearchIntoStorage(independent, corporate, item, duplicateStorage, false);
		
		
		
	    //If contact is found, display the contact
	    if (duplicateStorage.get(0) != -1) {
	    	//Create String array with column names for JTable
	    	String[] columnNames = {"COMPANY NAME", "PHONE NUMBER", "WAS FOUND BY SERVICING COMPANY", "ADDRESS"};
			//Create empty 1x6 2D array called twoDimensionalArray
			String[][] twoDimensionalArray = new String[duplicateStorage.size()][4];
						
			
			//For loop that repeats for size of ArrayList and collects contact info into twoDimensionalArray
			for (int i = 0; i < duplicateStorage.size(); i++) {
				twoDimensionalArray[i][0] = corporate.get(duplicateStorage.get(i)).companyName;
				twoDimensionalArray[i][1] = corporate.get(duplicateStorage.get(i)).phoneNumber;
				twoDimensionalArray[i][2] = String.valueOf(corporate.get(duplicateStorage.get(i)).discoveredClient);
				twoDimensionalArray[i][3] = corporate.get(duplicateStorage.get(i)).address;
			}
			
			

			//Create new JTable with twoDimensionalArray and columnNames as input
			table = new JTable(twoDimensionalArray, columnNames);
			//Make the JTable uneditable directly for user
			table.setDefaultEditor(Object.class, null);
			//Add scrollPane to JTable
			JScrollPane scrollPane = new JScrollPane(table);
			//Add scrollPane to JPanel
			myJPanel.add(scrollPane);	
			
			
			//Resize the JTable so that each of the headings are visible
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(0).setPreferredWidth(130);
			table.getColumnModel().getColumn(1).setPreferredWidth(130);
			table.getColumnModel().getColumn(2).setPreferredWidth(250);
			table.getColumnModel().getColumn(3).setMinWidth(100);
			
		}
				
	   	//Else contact wasn't found
	   	else {
	   		//Set L1 as message that the contact wasn't found
	   		L1 =  new JLabel("That contact isn't in the contact list");
	   	}

	    //Add L1 to JPanel
		myJPanel.add(L1);
		
		//Add JPanel to contentPane
		contentPane.add(myJPanel);
		//Set JPanel as transparent
		myJPanel.setOpaque(false);
		//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);

	}	
	
	
	
	
	
	/***************************************
	 * Name: searchForEditFieldMenu
	 * Date: 20/05/2021
	 * Description: Displays menu to select if an independent of corporate contact will be edited.
	 * Input: -
	 * Output: -
	 ***************************************/
	public void searchForEditFieldMenu() throws IOException {
		
		//Initialize new JPanel with 8x2 grid layout
		myJPanel = new JPanel(new GridLayout(8,2));
	
			

    	//Create new JButton called L1 which start the search for the independent contacts details to edit
		JButton L1 =  new JButton("Search For Independent Contact Details To Edit");
		//Add L2 to JPanel
    	myJPanel.add(L1);
    	//Add listener to L2
    	L1.addActionListener(this);
    	
    	
    	//Create new JButton called L2 which start the search for the corporate contacts details to edit
		JButton L2 =  new JButton("Search For Corporate Contact Details To Edit");
		//Add L2 to JPanel
    	myJPanel.add(L2);
    	//Add listener to L2
    	L2.addActionListener(this);


    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);

		
	}
	
	
	
	
	
	/***************************************
	 * Name: specifyEditTermIndependent
	 * Date: 20/05/2021
	 * Description: Displays the menu to specify the edit terms for a specified independent contact.
	 * Input: -
	 * Output: -
	 ***************************************/
	public void specifyEditTermIndependent() throws IOException {
		
		//Create new JPanel using myJPanel global variable with 8x2 grid layout
		myJPanel = new JPanel(new GridLayout(8,2));

		
		
		
		
	
		//Create new JLabel called L1 which asks for original contact item
		JLabel L1 =  new JLabel("Enter the original item:");
		//Add L1 to JPanel
    	myJPanel.add(L1);
    	//Create new JTextField size 50 with searchingTextField global variable
    	searchingTextField = new JTextField(50);
    	//Add searchingTextField to JPanel
    	myJPanel.add(searchingTextField);
		
    	//Create new JLabel called L2 which asks for modified contact item
    	JLabel L2 =  new JLabel("Enter the modified item:");
    	//Add L2 to JPanel
    	myJPanel.add(L2);
    	//Create new JTextField size 50 with modifyingTextField global variable
    	modifyingTextField = new JTextField(50);
    	//Add modifyingTextField to JPanel
    	myJPanel.add(modifyingTextField);
    	//Create new JButton called L3 which is to modify first name
		JButton L3 =  new JButton("Modify Independent First Name");
		//Add L3 to JPanel
    	myJPanel.add(L3);
    	//Create listener for L3
    	L3.addActionListener(this);
    	//Create new JButton called L4 which is to modify last name
    	JButton L4 =  new JButton("Modify Independent Last Name");
    	//Add L4 to JPanel
    	myJPanel.add(L4);
    	//Create listener for L4
    	L4.addActionListener(this);
    	//Create new JButton called L5 which is to modify phone number
    	JButton L5 =  new JButton("Modify Independent Phone Number");
    	//Add L5 to JPanel
    	myJPanel.add(L5);
    	//Create listener for L5
    	L5.addActionListener(this);
    	//Create new JButton called L6 which is to toggle if the contact was discovered
    	JButton L6 =  new JButton("Toggle Independent Discovery Method");
    	//Add L6 to JPanel
    	myJPanel.add(L6);
    	//Create listener for L6
    	L6.addActionListener(this);
    	//Create new JButton called L7 which is to modify address
    	JButton L7 =  new JButton("Modify Independent Address");
    	//Add L7 to JPanel
    	myJPanel.add(L7);
    	//Create listener for L7
    	L7.addActionListener(this);
    	
    	
    	
    	//Create new JLabel called L8 which enters space in the JFrame
    	JLabel L8 =  new JLabel(" ");
    	//Add L8 to JPanel
    	myJPanel.add(L8);
    	
    	//Create new JLabel called L9 which displays notice for discovery method changing
		JLabel L9 =  new JLabel("IF CHANGING THE DISCOVERY METHOD:");
		//Set the font color as red
		L9.setForeground(Color.red);
		//Add L9 to JPanel
    	myJPanel.add(L9);
    	
    	
    	
    	//Create new JLabel called L10 which enters space in the JFrame
		JLabel L10 =  new JLabel(" ");
		//Add L10 to JPanel
    	myJPanel.add(L10);
    	
    	
    	//Create new JLabel called L11 which displays notice for discovery method changing
    	JLabel L11 =  new JLabel("ENTER THE LAST NAME, THEN HIT THE TOGGLE INDEPENDENT DISCOVERY METHOD BUTTON. LEAVE THE MODIFICIED ITEM FIELD AS BLANK.");
    	//Set the font color as red
    	L11.setForeground(Color.red);
    	//Add L11 to JPanel
    	myJPanel.add(L11);

    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);
	}	
	
	
	
	
	
	/***************************************
	 * Name: specifyEditTermCorporate
	 * Date: 20/05/2021
	 * Description: Displays the menu to specify the edit terms for a specified corporate contact.
	 * Input: -
	 * Output: -
	 ***************************************/
	public void specifyEditTermCorporate() throws IOException {
		
			//Create new JPanel using myJPanel global variable with 8x2 grid layout
			myJPanel = new JPanel(new GridLayout(8,2));
		
	    	
			//Create new JLabel called L1 which asks for original contact item
			JLabel L1 =  new JLabel("Enter the original item:");
			//Add L1 to JPanel
	    	myJPanel.add(L1);
	    	//Create new JTextField size 50 with searchingTextField global variable
	    	searchingTextField = new JTextField(50);
	    	//Add searchingTextField to JPanel
	    	myJPanel.add(searchingTextField);
			
	    	//Create new JLabel called L2 which asks for modified contact item
	    	JLabel L2 =  new JLabel("Enter the modified item:");
	    	//Add L2 to JPanel
	    	myJPanel.add(L2);
	    	//Create new JTextField size 50 with modifyingTextField global variable
	    	modifyingTextField = new JTextField(50);
	    	//Add modifyingTextField to JPanel
	    	myJPanel.add(modifyingTextField);
	    	//Create new JButton called L3 which is to modify company name
			JButton L3 =  new JButton("Modify Corporate Company Name");
			//Add L3 to JPanel
	    	myJPanel.add(L3);
	    	//Create listener for L3
	    	L3.addActionListener(this);
	    	//Create new JButton called L4 which is to modify the phone number
	    	JButton L4 =  new JButton("Modify Corporate Phone Number");
	    	//Add L4 to JPanel
	    	myJPanel.add(L4);
	    	//Create listener for L4
	    	L4.addActionListener(this);
	    	//Create new JButton called L5 which is to toggle the discovery method
	    	JButton L5 =  new JButton("Toggle Corporate Discovery Method");
	    	//Add L5 to JPanel
	    	myJPanel.add(L5);
	    	//Create listener for L5
	    	L5.addActionListener(this);
	    	//Create new JButton called L6 which is to modify address
	    	JButton L6 =  new JButton("Modify Corporate Address");
	    	//Add L6 to JPanel
	    	myJPanel.add(L6);
	    	//Create listener for L6
	    	L6.addActionListener(this);

	  
	    	
	    	
	    	//Create new JLabel called L8 which displays notice for discovery method changing
			JLabel L8 =  new JLabel("IF CHANGING THE DISCOVERY METHOD:");
			//Set the font color as red
			L8.setForeground(Color.red);
			//Add L8 to JPanel
	    	myJPanel.add(L8);
	    	
	    	
	    	//Create new JLabel called L9 which enters space in the JFrame
			JLabel L9 =  new JLabel(" ");
			//Add L9 to JPanel
	    	myJPanel.add(L9);
	    	
	    	
	   
	    	//Create new JLabel called L9 which displays notice for discovery method changing
	    	JLabel L10 =  new JLabel("ENTER THE COMPANY NAME, THEN HIT THE TOGGLE CORPORATE DISCOVERY METHOD BUTTON. LEAVE MODIFICIED ITEM AS BLANK.");
	    	//Set the font color as red
	    	L10.setForeground(Color.red);
	    	//Add L10 to JPanel
	    	myJPanel.add(L10);

	    	
	    	//Add JPanel to contentPane
	    	contentPane.add(myJPanel);
	    	//Set JPanel as transparent
	    	myJPanel.setOpaque(false);
	    	//Add JPanel to frame
			frame.add(myJPanel);
			//Revalidate JPanel
			myJPanel.revalidate();
			//Pack the frame
			frame.pack();
			//Set frame as visible
			frame.setVisible(true);
	}	
	
	
	
	
	/***************************************
	 * Name: wasEditCompleted
	 * Date: 20/05/2021
	 * Description: Displays if the edit was completed.
	 * Input: If the change occurred.
	 * Output: -
	 ***************************************/
	public void wasEditCompleted(boolean check) throws IOException {
		
		//Create new JPanel using myJPanel global variable with 8x2 grid layout
		myJPanel = new JPanel(new GridLayout(8,2));
		
		//If the check occurred
		if (check) {
			//Displays that the edit occurred
			JLabel L0 =  new JLabel("Edit Complete");
			//Add L1 to JPanel
	    	myJPanel.add(L0);
	    	//Set background colour as green
	    	frame.getContentPane().setBackground(Color.green);
		}
		else {
			//Displays the edit did not occur
			JLabel L0 =  new JLabel("Edit Term Was Not Found");
			//Add L0 to JPanel
	    	myJPanel.add(L0);
		}
		
	  	
    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Set the frame size as 200x200 pixels
		frame.setSize(200,200);			
		//Set frame as visible
		frame.setVisible(true);
	}	
	
	
	
	/***************************************
	 * Name: wasLeadFound
	 * Date: 20/05/2021
	 * Description: Displays if a given lead was found.
	 * Input: The search string and leads queue.
	 * Output: -
	 ***************************************/
	public void wasLeadFound(String search, Queue<String> leads) throws IOException {
		
		//Create new JPanel using global myJPanel
		myJPanel = new JPanel();
		
		//Initialize the label
		String label;
		//If the search was found
		if (SystemFunctions.binarySearchLeads(search, leads) != -1) {
			//Set the label to display that the lead was found
			label = "The number: " + search + " is indeed in the Queue.";
		}
		else {
			//Set the label to display that the lead is not in the queue
			label = ("The number: " + search + " is not in the Queue.");
		}
		//Create new JLabel called L1 that displays label
		JLabel L1 =  new JLabel(label);
		//Add L1 to JPanel
    	myJPanel.add(L1);

    	    	
    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);
	}
	
	
	
	/***************************************
	 * Name: lookForLeadMenu
	 * Date: 20/05/2021
	 * Description: Displays the menu to enter the lead to be searched.
	 * Input: Potential lead number search key.
	 * Output: -
	 ***************************************/
	public void lookForLeadMenu() throws IOException {
		
		//Create new JPanel using myJPanel global variable with 8x2 grid layout
		myJPanel = new JPanel(new GridLayout(8,2));
	
		//Create new JLabel called L0 which asks for the lead number to check
		JLabel L0 =  new JLabel("Enter the number of the lead to check:");
		//Add L0 to JPanel
    	myJPanel.add(L0);
    	

    	//Create new JTextField size 50 with searchingTextField global variable
    	searchingTextField = new JTextField(50);
    	//Add searchingTextField to JPanel
    	myJPanel.add(searchingTextField);
		
 

    	//Create new JButton called L1 which searches for the lead
		JButton L1 =  new JButton("Search For Lead");
		//Add L1 to JPanel
    	myJPanel.add(L1);
    	//Create listener for L1
    	L1.addActionListener(this);
    	
    	

    	
    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set frame as visible
		frame.setVisible(true);
	}	

	
	
	
	/***************************************
	 * Name: instructionMenu
	 * Date: 20/05/2021
	 * Description: Displays built in instructions.
	 * Input: -
	 * Output: -
	 ***************************************/
	public void instructionMenu() {
		
		//Create new JPanel using myJPanel global variable with 9x2 grid layout
		myJPanel = new JPanel(new GridLayout(9,2));
		
		//Create new JLabel called L0 which displays instructions
		JLabel L0 =  new JLabel("This program is defined to keep track of independent and corporate client contacts.");
		//Add L1 to JPanel
    	myJPanel.add(L0);
    	
		//Create new JLabel called L1 which displays instructions
		JLabel L1 =  new JLabel("The program can also keep a queue of lead numbers for potential client leads.");
		//Add L1 to JPanel
    	myJPanel.add(L1);
    	
 
    	//Create new JLabel called L2 which acts as a separator
    	JLabel L2 =  new JLabel("______________________________________________________________________________________________________________");
    	//Add L2 to JPanel
    	myJPanel.add(L2);

		
    	//Create new JLabel called L3 which displays instructions
    	JLabel L3 =  new JLabel("Corporate Clients: Companies who seek your service.");
    	//Add L3 to JPanel
    	myJPanel.add(L3);

    	//Create new JButton called L4 which displays instructions
    	JLabel L4 =  new JLabel("Independent Clients: Independent individuals who seek your service.");
		//Add L4 to JPanel
    	myJPanel.add(L4);
    	
    	
    	//Create new JButton called L5 which displays instructions
    	JLabel L5 =  new JLabel("Discovery Method: If the contact was found or the contact found the servicing company.");
		//Add L5 to JPanel
    	myJPanel.add(L5);
    	
    	
    	//Create new JLabel called L6 which acts as a separator
    	JLabel L6 =  new JLabel("______________________________________________________________________________________________________________");
    	//Add L6 to JPanel
    	myJPanel.add(L6);
    	
    	
    	
    	//Create new JButton called L7 which displays instructions
    	JLabel L7 =  new JLabel("Note: saving an empty set of contacts will delete saved contact data from respective files.");
		//Add L7 to JPanel
    	myJPanel.add(L7);
    	
    	
    	//Create new JButton called L8 which displays instructions
    	JLabel L8 =  new JLabel("Note: loading from an empty set of files will result in contacts sorted locally in the programs being deleted.");
		//Add L8 to JPanel
    	myJPanel.add(L8);
  
    	

    	
    	//Add JPanel to contentPane
    	contentPane.add(myJPanel);
    	//Set JPanel as transparent
    	myJPanel.setOpaque(false);
    	//Add JPanel to frame
		frame.add(myJPanel);
		//Revalidate JPanel
		myJPanel.revalidate();
		//Pack the frame
		frame.pack();
		//Set the frame size as 800x300 pixels
		frame.setSize(800,300);	
		//Set frame as visible
		frame.setVisible(true);
	}	

	
	
	
}
