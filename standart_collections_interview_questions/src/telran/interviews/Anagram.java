package telran.interviews;


import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
/**
 * 
 * @param word
 * @param anagram
 * @return true if anagram is one of the possible anagrams of a given word
 * anagram is a string containing all symbols from a given word with different order
 * Example: yellow (wolely, lowlye, yellow) , wrong anagrams (yello, yelllw)
 */
	public static boolean isAnagram(String word, String anagram) {
		//
		boolean flAnagram = true;
		final int DEF_VALUE = 0;
		System.out.println(DEF_VALUE);
		if (word.length() != anagram.length() || word.isEmpty() || anagram.isEmpty()) {
			flAnagram = false;
			//return false;
		}
		else {
			HashMap<Character, Integer> wordHashMap = getHashMap(word);
			char [] anagramArray = anagram.toLowerCase().toCharArray();
			System.out.println(anagramArray);
			System.out.println(word);
			for (char letter : anagramArray) {
				int count = wordHashMap.getOrDefault(letter, DEF_VALUE);
				
				if (count == DEF_VALUE) {
					flAnagram = false;
					wordHashMap.remove(letter, DEF_VALUE);
					} else {
					count--;
					if (count > 0) {
					wordHashMap.put(letter, count);
					} else {
						wordHashMap.remove(letter);
					}
				}
				
							} 
			
			if (!wordHashMap.isEmpty()) {
				flAnagram = false;
			}
		
		}
		return flAnagram;
		
	}
	 
	private static HashMap getHashMap (String word) {
		HashMap<Character, Integer> wordHashMap = new HashMap<>();
		 char[] wordArray = word.toLowerCase().toCharArray();
		
		for (Character letter: wordArray) {
			wordHashMap.merge(letter, 1, (a, b) -> a+b);
		}
		return wordHashMap;
	}
	


}