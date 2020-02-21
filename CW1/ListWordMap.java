package F28DA_CW1;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListWordMap implements IWordMap {


	LinkedList<Entry> map = new LinkedList<Entry>(); 

	public ListWordMap(){

	}

	public void addPos(String word, IPosition pos) {

		Iterator<Entry> iterate = map.iterator(); 
		boolean foundFlag = false; 

		while(iterate.hasNext()) { //while the iterator has a next entry 
			Entry next = iterate.next(); //iterates to the next entry 

			if (next.getWord() == word) { //if the next word is equal to the word we are trying to find 
				foundFlag = true; //set found to true 
			}

			else {
				foundFlag = false; //if its not found, keep found false
			}
		}

		if (foundFlag == false) {
			Entry e = new Entry(word, pos); //create the new entry 
			map.add(e); //add the word to the entry 
		}
	}	

	public int numberOfEntries() {

		Iterator<Entry> iterate = map.iterator(); 

		int counter = 0; 

		while(iterate.hasNext()){
			iterate.next(); 
			counter++ ; 
		}

		return counter; 

	}


	public void removeWord(String word) throws WordException {

		Iterator<Entry> iterate = map.iterator(); 

		while(iterate.hasNext()) { //while the iterator has a next entry 
			Entry next = iterate.next();//iterates to the next entry 

			if (next.getWord() == word) { //if the next word is equal to the word we are trying to find 
				map.remove(next);
			}
		}
	}




	public void removePos(String word, IPosition pos) throws WordException {

		Iterator<Entry> iterate = map.iterator(); 
		Entry next = null; 

		while(iterate.hasNext()) { //while the iterator has a next entry 
			next = iterate.next(); //iterates to the next entry 

			if (next.getWord().equals(word)) { //if the next word is equal to the word we are trying to find 
				map.remove(next); //remove the position from the map 

			}


		}

	}

	public Iterator<IPosition> positions(String word) throws WordException {

		Iterator<Entry> iterate = map.iterator();
		LinkedList<IPosition> posList = new LinkedList<IPosition>(); 
		Entry next = null;

		while(iterate.hasNext()) { //while the iterator has a next entry 
			next = iterate.next(); //iterates to the next entry
			posList.addAll(posList); //Adding the words to a new array list

			if (next.getWord().equals(word)) {
				posList = next.getPosition(); 
			}

		} 
		//returning the iterator over the new array list of positions 
		return posList.iterator(); 

	}


	public Iterator<String> words() {

		Iterator<Entry> iterate = map.iterator();
		ArrayList<String> wordsList = new ArrayList<String>(); 
		Entry next = null; 

		while(iterate.hasNext()) { //while the iterator has a next entry 
			next = iterate.next(); //iterates to the next entry 
			String w = next.toString(); 

			wordsList.add(w); //Adding the words to a new array list 

		} 

		//returning the iterator over the new array list of words 
		return wordsList.iterator(); 
	}

}
