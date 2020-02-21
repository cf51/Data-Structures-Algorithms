package F28DA_CW1;

import static org.junit.Assert.*;
import org.junit.Test;

public class HashWordMapTest {

	
	@Test
	public void hashCodeTest_1Char(){
		 
		HashWordMap map = new HashWordMap(0.5f);
		
		String s = "a"; 
		assertEquals(6,map.hashCode(s)); 
	
		
	}
	
	@Test
	public void hashCodeTest_2Char(){
		 
		HashWordMap map = new HashWordMap(0.5f);
		
		String s = "ab"; 
		assertEquals(3,map.hashCode(s)); 
		
	}
	
	@Test
	public void hashCodeTest_3Char(){
		 
		HashWordMap map = new HashWordMap(0.5f);
		
		String s = "abc"; 
		assertEquals(5,map.hashCode(s)); 
	
		
	}
	

	
	@Test
	public void signatureTest() {
        try {
            IWordMap map = new HashWordMap(0.5f);
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
