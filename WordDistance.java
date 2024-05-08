import java.util.*;

public class WordDistance {
    private Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        // Preprocessing: Store the index of each word in the map
        for (int i = 0; i < wordsDict.length; i++) {
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indices1 = map.get(word1);
        List<Integer> indices2 = map.get(word2);
        int minDistance = Integer.MAX_VALUE;
        
        // Find the minimum distance using two-pointer technique
        int i = 0, j = 0;
        while (i < indices1.size() && j < indices2.size()) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(j);
            if (index1 < index2) {
                minDistance = Math.min(minDistance, index2 - index1);
                i++;
            } else {
                minDistance = Math.min(minDistance, index1 - index2);
                j++;
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wordDistance = new WordDistance(wordsDict);
        System.out.println(wordDistance.shortest("coding", "practice")); // Output: 3
        System.out.println(wordDistance.shortest("makes", "coding"));    // Output: 1
    }
}
