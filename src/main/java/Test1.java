import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a text with max length of Integer.MAX_VALUE find the k most
 * frequent words on the text.
 * Consider word sparators between: space, end of line and comma
 *
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Test1 {
    public static void main(String[] args) {
        List<String> words = getKMostFrequentWords("this is such a very very very long sentence this is super super reat", 3);

        System.out.println(words);

        // if k = 1, result should be [very]
        // if k = 2, results can be [very, this] OR [very, is] OR [very, super]
        // if k = 3, results can be  [very, this, is] OR ...
    }

    private static List<String> getKMostFrequentWords(String sentence, int k){
        List<String> kMostFrequentWords = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int count;
        for (String word : sentence.split(" ")){

            if (map.get(word)==null){
                map.put(word, 1);
            }else{
                count = map.get(word);
                map.put(word, ++count);
            }


        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (int i = 0; i < k; i++) {
            kMostFrequentWords.add(list.get(list.size()-i-1).getKey());
        }


        return kMostFrequentWords;
    }


}
