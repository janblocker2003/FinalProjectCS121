//Note Card class

import java.util.*;
import java.io.*;

public class NoteCard implements HasMenu, Serializable {
	
	String word;
	String definition;
	int correct = 0;
	int incorrect = 0;

	public NoteCard() {
		this.word = "";
		this.definition = "";
	} // end note card no paramater constructor
	
	public NoteCard(String newWord, String newDefinition) {
		this.word = newWord;
		this.definition = newDefinition;
	} // end constructor with paramters
	
	public String getWord() {
		return this.word;
	} // end getWord
	
	public void setWord(newWord) {
		this.word = newWord;
	} // end setWord
	
	public String getDefinition() {
                return this.definition;
        } // end getDefinition

        public void setDefinition(newDefinition) {
                this.definition = newDefinition;
        } // end setDefinition
	
	public int getCorrect() {
		return this.correct;
	} // end getCorrect
	
	public void setCorrect(int newCorrect) {
		this.correct = newCorrect;
	} // end setCorrect
	
	public int getIncorrect() {
                return this.incorrect;
        } // end getIncorrect

        public void setIncorrect(int newIncorrect) {
                this.incorrect = newIncorrect;
        } // end setIncorrect
	
	public String getReport() {
		String report = "NoteCard: " + this.getWord();
		report += ", Definition: " + this.getDefinition();
		report += ", getCorrect: " + this.getCorrect();
		report += ", getIncorrect: " + this.getIncorrect();
		return report;
	} // end getReport

} // end NoteCard class
