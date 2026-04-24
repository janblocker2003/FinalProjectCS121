// Notes Database

import FinalProjectCS121.NoteCard.java;
import java.util.*;
import java.io;

public class NotesDatabase implements HasMenu, Serializable {
	String name;
	String noteCardString;
	NoteCardList noteCards = new NoteCardList();

	String BOLD = "\u001B[1m";
        String RESET = "\u001B[0m";

	public NotesDataBase() {
		this.name = "";
		this.noteCardString = "";
	} // end NotesDataBase constructor with no parameters
	
	public void loadSampleNote() {
		this.name = "Sample";
		noteCards.add(new NoteCard("Elephant", "land animal"));
		noteCards.add(new NoteCard("Turkey", "sky animal"));
		noteCards.add(new NoteCard("Piranha", "sea animal"));
		//this.noteCardString = "Elephant,an animal,Turkey,flying animal";
		// loadSampleCustomer within Bank.java shows good example of way to do this if this doesn't work well
	} // end Load Sample Note
	
	public void loadNotes() {
		try {
			FileInputStream fi = new FileInputStream("NoteCards.dat");
			ObjectInputStream obIn = new ObjectInputStream(fi);
			noteCards = (NoteCardList)obIn.readObject();
			obIn.close();
			fi.close();
		} // end try
		catch (Exception e) {
			System.out.println(e.Message());
		} // end catch
	} // end load notes
	
	public void saveNotes() {
		try {
			FileOutputStream fo = new FileOutputStream("NoteCards.dat");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(noteCards);
			obOut.close();
			fo.close();
		} // end try
		catch (Exception e) {
			System.out.println(e.getMessage());
		} // end catch
	} // save notes
	
	public String menu() {
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println(BOLD + "NoteCard Menu " + RESET);
		System.out.println("______________________________");
		System.out.println();
		System.out.println("0) Exit "+ this.name + " database");
		System.out.println("1) Progress Report ");
		System.out.println("2) Add a note card to " + this.name);
		System.out.println("3) Delete a note card from " + this.name);
		System.out.println("4) Resort note cards in " + this.name);
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
				System.out.println(BOLD + "Progress Report for " + this.name + RESET);
				System.out.println("______________________________");
				System.out.println();
				progressReport();
				} // end if
			} // end else if
			else if (response.equals("2")) {
				System.out.println();
				System.out.println(BOLD + "Add a note card to " + this.name + RESET);
				System.out.println("______________________________");
				System.out.println();
				addNoteCard();
			} // end else if
			else if (response.equals("3")) {
                                System.out.println();
                                System.out.println(BOLD + "Delete a note card from " + this.name + RESET);
                                System.out.println("______________________________");
                                System.out.println();
                                deleteNoteCard();
                        } // end else if
			else if (response.equals("4")) {
                                System.out.println();
                                System.out.println(BOLD + "Resort notecards in " + this.name + RESET);
                                System.out.println("______________________________");
                                System.out.println();
                                sortNotes();
                        } // end else if
			else {
				System.out.println("Please enter 0, 1, 2, 3, or 4 ");
			} // end else
		} // end while 
	} // end start
	
	public void progressReport() {
		for (NoteCard noteCard: noteCards) {
			report = noteCard.getReport()
			String formattedData = report.replace(",", "\n");
			System.out.println(report);
		} // end for
	} // end progress report
	
	public void addNoteCard() {
		Scanner input = new Scanner(System.in);
		System.out.print("Word: ");
		String word = input.nextLine();
		System.out.print("Definition: ");
		String definition = input.nextLine();
		noteCards.add(new NoteCard(word, definition));
	} // end add Note Card
	
	public void deleteNoteCard() {
		for (i = 0, i < noteCards.size(); i++) {
			System.out.println(index + ") " + noteCard.getWord());
		} // end for loop
		Scanner input = new Scanner(System.in);
		Scanner.out.print("Which word do you want to delete? Enter the number next to the word ");
		String deleteThis = input.nextLine();
		try {
			int deleteThisInt = Integer.parseInt(deleteThis);
			noteCards.remove(deleteThisInt);
			System.out.println();
			System.out.println("Word " + deleteThis + ") " + noteCards.get(deleteThisInt) + "has been removed from " + this.name);
		} // end try
		catch (NumberFormatException e) {
			System.out.println("Please enter a valid integer next time ");
		} // end catch 1
		catch (Exception e) {
                        System.out.println(e.getMessage());
                } // end catch 2
	} // end delete NoteCard
	
	public void sortNotes() {
		System.out.println("Pretend this works for now");
	} // end sortNotes
	
	public String getName() {
		return this.name;
	} // end getName
	
	public void setName(String newName) {
		this.name = newName;
	} // end set Name
	
} // end Notes DataBase


//may need a getName and setName!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! if outside class needs to access name

class NoteCardList extends ArrayList<NoteCard> {};

