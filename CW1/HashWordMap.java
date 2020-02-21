package F28DA_CW1;

import java.sql.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class HashWordMap implements IHashMonitor,  IWordMap {
	
	Entry[] hashMap = new Entry[13]; 

	
	public HashWordMap(float maxLoadFactor) {
		
	}
	
	public HashWordMap() {
		this (0.5f); 
	}
	
	
	public float getMaxLoadFactor() {
		
		return 0;
	}

	
	public float getLoadFactor() {
		
		return 0;
	}

	
	public float averNumProbes() {
		
		return 0;
	}

	
	//This method calculates the hash code using the Horner method 
	public int hashCode(String s) {
		
		long hashCode = s.charAt(0);  
		
		for( int i = 1; i< s.length(); i++) {
			hashCode = (long) (s.charAt(i)*Math.pow(33, i) + hashCode); 
		
		}
		
		//Printing ascii code out, used for testing 
	    System.out.println("Ascii code is " + hashCode);
		
	    //Taking the hash code and doing mod 13 (length of the array) 
		 hashCode = (hashCode % hashMap.length);
		
		//Printing hash code out, used for testing 
	    System.out.println("Hash Code is " + hashCode);
		return (int) hashCode;
		
	}
	
	
	public void addPos(String word, IPosition pos) {
	
		//boolean flag that lets me know if word is present in the map 
		boolean foundFlag = false;
			
			//if the hashMap code is equal to the word 
			if (hashMap.equals(word)) {
				foundFlag = true; //As two duplicate words have the same hash code then we check if the hash codes are equal, if they are we dont need to do anything
								  // so we set the 'found flag' to true 
				}
	
			else {
				foundFlag = false; //if its not found, keep found false
			}
		

		if (foundFlag == false) {
			
			//adding a new entry to the map 
			Entry e = new Entry(word, pos);
			
			//making a new copy of the map, adding the word to the map and then returning the new map with the word added 
			Entry[] arr = Arrays.copyOf(hashMap, hashMap.length + 1);
			arr[arr.length - 1] = e; 
	
		}
		
	}

	
	public void removeWord(String word) throws WordException {
		//this method removes a word from the map 
		
	}

	
	public void removePos(String word, IPosition pos) throws WordException {
		//this method removes a position from the map 
		
	}

	
	public Iterator<String> words() {
		//this method returns an iterator over all of the words in the map 
		return null;
	}

	
	public Iterator<IPosition> positions(String word) throws WordException {
		//this method returns an iterator over all of the positons of the map 
		return null;
	}

	
	public int numberOfEntries() {
		//this method returns the number of entries in the map 
			
		return 0; 
		
	}

		
	
	}


