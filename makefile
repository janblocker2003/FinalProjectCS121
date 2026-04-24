CollectiveDatabase.class: CollectiveDatabase.java NotesDatabase.class NoteCard.class HasMenu.class
	javac -g CollectiveDatabase.java

NotesDatabase.class: NotesDatabase.java NoteCard.class HasMenu.class
	javac -g NotesDatabase.java

NoteCard.class: NoteCard.java HasMenu.class
	javac -g Customer.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

testNotesDatabase: NotesDatabase.class
	java NotesDatabase

testNoteCard: NoteCard.class
	java NoteCard

clean:
	rm *.class

run: CollectiveDatabase.class
	java CollectiveDatabase

debug: CollectiveDatabase.class
	jdb CollectiveDatabase
