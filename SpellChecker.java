
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		if(str.length()==1){
			return "";
		}
		return str.substring(1);
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		int a = word1.length();
		int b = word2.length();
		if(b==0) return a;
		if(a==0) return b;
		if(word1.charAt(0)==word2.charAt(0)){
			return levenshtein(tail(word1),tail(word2));
		}
		String tailA = tail(word1);
		String tailB = tail(word2);
		return 1 + Math.min(Math.min(levenshtein(tailA,word2),levenshtein(tailB,word1)),levenshtein(tailA,tailB));


	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		// Your code here
		for(int i = 0 ; i < dictionary.length ; i++){
			dictionary[i] = in.readString();

		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		int min = levenshtein(dictionary[0],word);
		int distance ;
		String newWord = "" ;
		for (String i : dictionary ){
			distance = levenshtein(i,word);
			if(min >= distance){
				min = distance ;
				newWord = i ;
			}
		}
		if(min>threshold) return word;
		return newWord ;
	}

}
