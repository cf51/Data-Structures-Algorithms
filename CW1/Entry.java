package F28DA_CW1;

import java.util.LinkedList;

public class Entry {

	private String word; 
	public LinkedList<IPosition> pos; //linked list of IPositions 
	
	
	public Entry (String word , IPosition pos) {
		
		LinkedList<IPosition> List = new LinkedList(); 
		
		this.word = word; //current object of word is equal to word 
		this.pos = List; //position is equal to the position in the list 
	}

	
	public LinkedList<IPosition> getPosition() {
		return this.pos; //returning the position 
		
	}

	public String getWord() {
		return word; //returning the word 
	}
	


}
