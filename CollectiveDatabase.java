//import FinalProjectCS121.NotesDatabase.java;
import java.util.*;
import java.io.*;

public class CollectiveDatabase implements HasMenu, Serializable {
	String databasesString;
	DatabaseList databaseNames = new DatabaseList();
	
	String BOLD = "\u001B[1m";
        String RESET = "\u001B[0m";
	
	public static void main(String[] args) {
		new CollectiveDatabase();
	} // end main
	
	public CollectiveDatabase() {
		this.start();
	} // end initializer (starts the whole thing)

	public String menu() {
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println(BOLD + "Collective Databases of NoteCards Menu  " + RESET);
		System.out.println("______________________________");
		System.out.println();
		System.out.println("0) Exit system ");
		System.out.println("1) Open a Note Card Database ");
		System.out.println("2) Create a new Note Card Database ");
		System.out.println("______________________________");
		System.out.println();
		System.out.print("Your response: ");
		String response = input.nextLine();
		return response;
	} // end menu
	
	public void start() {
		boolean keepGoing = true;
		while (keepGoing) {
			String response = menu();
			if (response.equals("0")) {
				keepGoing = false;
			} // end if
			else if (response.equals("1")) {
				System.out.println();
				System.out.println(BOLD + "Opening a Note Card Database" + RESET);
				System.out.println("______________________________");
				System.out.println();
				chooseDatabase();
			} // end else if
			else if (response.equals("2")) {
				System.out.println();
				System.out.println(BOLD + "Create a new Note Card Database" + RESET);
				System.out.println("______________________________");
				System.out.println();
				NotesDatabase newDatabase = new NotesDatabase();
				Scanner input = new Scanner(System.in);
				System.out.print("What would you like to name this database? ");
				String newName = input.nextLine();
				newDatabase.setName(newName);
				newDatabase.start();
			} // end else if
			else {
				System.out.println("Please enter 0, 1, or 2 ");
			} // end else
		} // end while
	} // end start
	
	 public void chooseDatabase() {
		try {
			//for (int i = 0; i < databaseNames.size(); i++) {
			int index = 0;
			for (NotesDatabase database : databaseNames) {
				//for (NoteCardList database : databaseNames) {
				//This code works if the Array List has Note Card Lists in it
				System.out.println(index + ") " + database.getName());
				index++;
			} // end for loop
		} // end try
		catch (Exception e) {
			System.out.println("There are not databases made yet");
		} // end catch
		Scanner input = new Scanner(System.in);
		System.out.print("Which database would you like to open? Enter the number next to the name of the database ");
		String openThis = input.nextLine();
		try {
			int openThisInt = Integer.parseInt(openThis);
			//NoteCardList nc = databaseNames.get(openThisInt);
			
			// code below is illogical- need to be calling start from notes database not note card
			//for (NoteCard correct : nc) {
            		//	if (correct == databaseName[openThisInt]) {
			//		correct.start();
			// end if
			// end for
			
			NotesDatabase db = databaseNames.get(openThisInt);
                        db.start();
			//this code works if the Array List has Notes Databases in it

			//NotesDatabase currentDatabase = new NotesDatabase();
			//currentDatabase = databaseNames.get(openThisInt);
			//for (int i = 0; i < currentDatabase.size(); i++) {
			//databaseNames.get(openThisInt).start();
			//currentDatabase.start();
                	//} // end for loop
		} // end try
		catch (NumberFormatException e) {
			System.out.println("Please enter a valid integer next time ");
		} // end catch
		catch (Exception e) {
                        System.out.println(e.getMessage());
                } // end catch 2
        } // end choose database
} // end collective database

//class DatabaseList extends ArrayList<NoteCardList> {};
//this needs to have NoteCard Lists in it to access them from within properly
//not true^ I need the databases stored in the database List, not the note card lists: have to call start() with database

class DatabaseList extends ArrayList<NotesDatabase> {};
