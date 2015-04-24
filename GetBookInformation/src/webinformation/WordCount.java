package webinformation;

/**
 * Created by jason-zhang on 4/24/2015.
 */
public class WordCount {

    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWordByCount(int count){
        if(count == this.count){
            return this.word;
        }else {
            return null;
        }
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

