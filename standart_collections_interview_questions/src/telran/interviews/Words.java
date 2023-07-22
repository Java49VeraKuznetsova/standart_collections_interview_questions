package telran.interviews;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Words {
	//
	/**
	 * adds word
	 * @param word
	 * @return true if added, otherwise false if an word already exists (case insensitive)
	 */
	private TreeSet<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	public boolean addWord(String word) {
		//TODO
		
		
		return words.add(word);
	}
	
	
	/**
	 * 
	 * @param prefix
	 * @return list of words starting from a given prefix (case insensitive)
	 */
	public List<String> getWordsByPrefix(String prefix) {
		//TODO
		
	String arrayWordsPrefix [] = new String [words.size()-1];
	List<String> listWordsPrefix = new ArrayList<String>();
	
		for(String word: words) {
			if (word.toLowerCase().startsWith(prefix.toLowerCase())) {
				listWordsPrefix.add(word);
			}
			
		}
					
		return listWordsPrefix;
	}
	
}
