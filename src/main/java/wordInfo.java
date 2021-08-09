public class wordInfo {
    private String value;
    private int count;

    public wordInfo(String word, int count){
        this.value =word;
        this.count =count;
    }


    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }


}
