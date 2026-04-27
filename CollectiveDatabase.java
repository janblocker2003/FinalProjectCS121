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
			for (NoteCardList database : databaseNames) {
				System.out.println(index + ") " + database.get(index).getName());
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
			//NotesDatabase currentDatabase = new NotesDatabase();
			//currentDatabase = databaseNames.get(openThisInt);
			//for (int i = 0; i < currentDatabase.size(); i++) {
			database.get(openThis).start();
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

class DatabaseList extends ArrayList<NoteCardList> {};
