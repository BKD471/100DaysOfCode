package Day32;

public class CheckIfWordOccursAsPrefix {

    // Better to use KMP here instead of built in
    // but im too lazy to do
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words=sentence.split(" ");

        int index=1;
        for(String word:words){
           if(word.startsWith(searchWord)) return index;
           index++;
        }
        return -1;
    }
}
