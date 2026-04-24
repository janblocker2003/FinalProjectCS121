import FinalProjectCS121.NotesDatabase.java;
import java.util.*;
import java.io;

public class CollectiveDatabase implements HasMenu, Serializable {
	String databasesString;
	DatabaseList databaseNames = new DatabaseList();
	String chooseDatabase;

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
	
	public void printDatabases() {

	} // end print databases
	
	public void start() {
		boolean keepGoing = true;
		while (keepGoing) {
			String response = menu();
			if (response.equals("0")) {
				keepGoing = false;
			} // end if
			else if (response.equals("1")) {
				System.out.println();
				System.out.println(BOLD + "Admin login" + RESET);
				System.out.println("______________________________");
				System.out.println();
				if (this.admin.login()) {
					startAdmin();
				} // end if
			} // end else if
			else if (response.equals("2")) {
				System.out.println();
				System.out.println(BOLD + "Customer login" + RESET);
				System.out.println("______________________________");
				System.out.println();
			} // end else if
			else {
				System.out.println("Please enter 0, 1, or 2 ");
			} // end else
		} // end while
	} // end start
	
	public void addUser() {
		Scanner input = new Scanner(System.in);
		System.out.print("User name: ");
		String userName = input.nextLine();
		System.out.print("PIN: ");
		String PIN = input.nextLine();
		customers.add(new Customer(userName, PIN));
	} // end addUser

	String BOLD = "\u001B[1m";
        String RESET = "\u001B[0m";


class DatabaseList extends ArrayList<NoteCardList> {};
