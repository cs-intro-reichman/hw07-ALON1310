

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
// Your code here
		for(int i = 0 ; i < dictionary.length ; i++){
			dictionary[i] = in.readString();
		}
		in.close();

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		// Your code here


		for(int i = 0 ; i < dictionary.length ; i++){
			if(dictionary[i]==word) {
				return true;
			}
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return ;
        }
		int N = hashtag.length();
 		boolean found = false ;

		hashtag = hashtag.toLowerCase();
		int startIndex = 0 ;
        for (int i = 1; i <= N; i++) {
			startIndex++;
			if (existInDictionary(hashtag.substring(0, i), dictionary)) {
				System.out.println(hashtag.substring(0, i));
				break;
				}
			else{
				breakHashTag(hashtag.substring(startIndex), dictionary);
				}
        }


    }

}
