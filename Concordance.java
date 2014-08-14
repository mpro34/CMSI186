import java.io.*;

public class Concordance {
	public static void main(String args[]) throws Exception {
		BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
		String s = Input.readLine();
		//Go through each line in text and put into a Trie.
		Trie t = new Trie();
		TrieIterator.itr = TrieIterator(t);
	
	}
}