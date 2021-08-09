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
             List<wordInfo> wordInfoList = new ArrayList<>();
              for (String word: new HashSet<>(words)){
                  int count = Collections.frequency(words,word);
                  wordInfoList.add(new wordInfo(word,count));
            }
              wordInfoList.sort((firstWrdInfo, secWordInfo) -> secWordInfo.getWordCount() - firstWrdInfo.getWordCount());
              return wordInfoList;
            }
            private String getConstructedWordInfo(List<wordInfo> wordInfoList){
                return wordInfoList.stream()
                                    .map(wordInfo ->wordInfo.getValue()+" "+wordInfo.getWordCount())
                                    .collect(Collectors.joining("\n"));
            }
            private Map<String,List<wordInfo>> getListMap(List<wordInfo> wordInfoList) {
                Map<String, List<wordInfo>> map = new HashMap<>();

                for (wordInfo wordInfo : wordInfoList){
                    if (!map.containsKey(wordInfo.getValue())){
                        ArrayList arr = new ArrayList<>();
                        arr.add(wordInfo);
                        map.put(wordInfo.getValue(), arr);
                    }

                    else {
                        map.get(wordInfo.getValue()).add(wordInfo);
                    }
                }


                return map;
            }


}
