// Notes Database

import FinalProjectCS121.NoteCard.java;
import java.util.*;
import java.io;

public class NotesDatabase implements HasMenu, Serializable {
	String name;
	String noteCardString;
	NoteCardList noteCards = new NoteCardList();

	public NotesDataBase() {
		this.name = "";
		this.noteCardString = "";
	} // end NotesDataBase constructor with no parameters
	
	public loadSampleNote() {
		this.name = "Sample";
		this.noteCardString = "Elephant,an animal,Turkey,flying animal";
	} // end Load Sample Note
	
} // end Notes DataBase

class NoteCardList extends ArrayList<NoteCard> {};

