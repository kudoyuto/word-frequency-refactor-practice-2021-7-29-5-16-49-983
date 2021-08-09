import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public static final String SPACE = "\\s+";

    public String getResult(String sentence) {
        try {
            List<wordInfo> wordInfoList = getInfo(sentence);
            return getConstructedWordInfo(wordInfoList);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private List<wordInfo> getInfo(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE));

        return
                words.stream()
                        .map(word -> new wordInfo(word, Collections.frequency(words, word)))
                        .sorted((word, word2) -> word2.getWordCount() - word.getWordCount())
                        .collect(Collectors.toList());
    }

    private String getConstructedWordInfo(List<wordInfo> wordInfoList) {
        return wordInfoList.stream()
                .map(wordInfo -> wordInfo.getWord() + " " + wordInfo.getWordCount()).distinct()
                .collect(Collectors.joining("\n"));
    }


}
