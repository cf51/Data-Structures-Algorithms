package F28DA_CW1;

import static org.junit.Assert.*;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ListWordMapTest {
 
	//Testing that there should be 1 entry when we call number of entries on a list that we have added 1 entry to 
	@Test
	public void addPosTest_1Pos() {
		//creating new linked list 'list' 
		ListWordMap list = new ListWordMap() ; 
	
		//creating the word, its fileName and its lineNumber 
		String word = "WordOne";
		String fileName = "f1";
		int lineNumber = 1;
		
		//adding the word to the list 
		WordPosition pos = new WordPosition(fileName, lineNumber, word);
		list.addPos(word, pos);
		
		//checking that it should be 1 
		assertEquals(1, list.numberOfEntries()); 

	}
	
	//Testing what happens if we run number of entries on an empty list 
	@Test
	public void addPosTest0Pos() {
		
		//creating new linked list 'list' 
		ListWordMap list = new ListWordMap(); 
		
		//checking that it should be 0 
		assertEquals(0, list.numberOfEntries()); 

	}
	
	//Testing that there should be 2 entries when we call number of entries on a list that we have added 2 entries to 
	@Test
	public void addPosTest_2Pos() {
		
		//creating new linked list 'list' 
		ListWordMap list = new ListWordMap() ; 
	
		//creating the word, its fileName and its lineNumber 
		String word = "WordOne";
		String fileName = "f1";
		int lineNumber = 1;
		
		//creating the second word, its fileName and its lineNumber 
		String word2 = "WordTwo";
		String fileName2 = "f1";
		int lineNumber2 = 1;
		
		//adding the word to the list 
		WordPosition pos = new WordPosition(fileName2, lineNumber2, word2);
		list.addPos(word, pos);
	
		//adding the second word to the list 
		WordPosition pos2 = new WordPosition(fileName, lineNumber, word);
		list.addPos(word2, pos2);
		
		//checking that it should be 2
		assertEquals(2, list.numberOfEntries()); 

	}
	
	@Test
	public void removeWordTest() throws WordException {
		
		//creating new linked list 'list' 
		ListWordMap list = new ListWordMap();
		
		//creating the word, its fileName and its lineNumber 
		String word = "WordOne";
		String fileName = "f1";
		int lineNumber = 2;
		
		//adding the word to the list 
		WordPosition pos = new WordPosition(fileName, lineNumber, word);
		list.addPos(word, pos);
		
		//try part: removing the word from the list 
		try {
			list.removeWord(word);
			}
		
		catch (Exception e){
			System.out.println("Word Exception - removeWordTest");
		}
		//there should be zero words in the list now 
		assertEquals(0, list.numberOfEntries()); 
	}
	 
	@Test
	public void removePosTest_1Pos() throws WordException {
		
		//creating new linked list 'list' 
		ListWordMap list = new ListWordMap();
		
		//creating the word, its fileName and its lineNumber 
		String word = "WordOne";
		String fileName = "f1";
		int lineNumber = 2;
		
		//adding the word to the list 
	    WordPosition pos = new WordPosition(fileName, lineNumber, word);
		list.addPos(word, pos);
		
		//try part: removing the position from the list 
		try {
			list.removePos(word, pos);
			}
		
		catch (Exception e){
			System.out.println("Word Exception - removePosTest_1Pos");
		}
		//there should be zero entries in the list now  
		assertEquals(0, list.numberOfEntries()); 
	}
	
	@Test
	public void removePosTest_2Pos() throws WordException {
		
		//creating new linked list 'list' 
		ListWordMap list = new ListWordMap();
		
		//creating the word, its fileName and its lineNumber 
		String word = "WordOne";
		String fileName = "f1";
		int lineNumber = 2;
		
		String word2 = "WordTwo";
		String fileName2 = "T1";
		int lineNumber2 = 3;
	
		//adding the word to the list 
		WordPosition pos = new WordPosition(fileName, lineNumber, word);
		list.addPos(word, pos);
		
		WordPosition pos2 = new WordPosition(fileName2, lineNumber2, word2);
		list.addPos(word2, pos2);
		
		//removing the position 
		try {
			list.removePos(word, pos);
			}
		
		catch (Exception e){
			
		}
		//there should be 1 entry in the list now 
		assertEquals(1, list.numberOfEntries()); 
	}
	
	//testing the number of entries when we have added one 
	@Test
	public void numberOfEntriesTest_1Entry() {
		ListWordMap list = new ListWordMap() ; 
		
		String word = "WordOne";
		String fileName = "f1";
		int lineNumber = 2;
	
		WordPosition pos = new WordPosition(fileName, lineNumber, word);
		
		list.addPos(word, pos);
		
		assertEquals(1, list.numberOfEntries()); 
	}
	
	//testing the number of entries when we have added 2 
	@Test
	public void numberOfEntriesTest_2Entry() {
		ListWordMap list = new ListWordMap() ; 
		
		String word = "WordOne";
		String fileName = "f1";
		int lineNumber = 2;
	
		WordPosition pos = new WordPosition(fileName, lineNumber, word);
		
		String word2 = "WordTwo";
		String fileName2 = "T2";
		int lineNumber2 = 3;
	
		WordPosition pos2 = new WordPosition(fileName2, lineNumber2, word2);
		
		list.addPos(word, pos);
		list.addPos(word2, pos2);
		
		assertEquals(2, list.numberOfEntries()); 
	}
	
	//testing the iterator for words, it should return false when we have no words in the list 
	@Test
	public void wordsTest_empty() {
		
		ListWordMap list = new ListWordMap() ; 
		Iterator<String> iterate = list.words(); 
				
		assertFalse(iterate.hasNext()); 
	 		
	}
	
	@Test
	public void positionTest() throws WordException {
		
		ListWordMap list = new ListWordMap() ; 
		Iterator<IPosition> iterate = list.positions(toString()); 
		
		try {
			
		}
		
		catch(Exception e) {
			
		}
				
		assertFalse(iterate.hasNext()); 
	 	
	}

	@Test
	public void signatureTest() {
        try {
            IWordMap map = new ListWordMap();
            String word1 = "test1";
            String word2 = "test2";
            IPosition pos1 = new WordPosition("test.txt", 4, word1);
            IPosition pos2 = new WordPosition("test.txt", 5, word2);      
            map.addPos(word1, pos1);
            map.addPos(word2, pos2);
            map.words();
            map.positions(word1);
            map.numberOfEntries();
            map.removePos(word1, pos1);
            map.removeWord(word2);
        } catch (Exception e) {
            fail("Signature of solution does not conform");
        }
	}

}
