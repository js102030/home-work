package middletest.q4;

import java.util.*;

public class StringAnalysis {
    private final String longestWord;
    private final Map<String, Integer> wordFrequencyMap;

    public StringAnalysis(String str) {
        longestWord = findLongestWord(str);
        wordFrequencyMap = createWordFrequencyMap(str);
    }

    private String findLongestWord(String str) {
        String[] split = str.split(" ");
        String longestWord = "";
        for (String s : split) {
            if (longestWord.length() < s.length()) {
                longestWord = s;
            }
        }
        return longestWord;
    }

    private Map<String, Integer> createWordFrequencyMap(String str) {
        String[] split = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : split) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }

    public void printLongestWord() {
        System.out.println("문자열에서 가장 긴 단어 : ⭐ " + longestWord + " ⭐");
    }

    public void printTopFrequentWords(int topFrequencyGroupsLimit) {
        System.out.println("⬇️ " + "문자열에서 가장 많이 나온 단어 Top " + topFrequencyGroupsLimit + " ⬇️");
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFrequencyMap.entrySet());

        // 병합 정렬을 사용하여 리스트 내림차순 정렬.
        Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue(Comparator.reverseOrder());
        List<Map.Entry<String, Integer>> sortedEntries = SortUtil.mergeSort(entries, comparator);

        // topFrequencyGroupsLimit 개의 빈도수를 가진 단어를 찾아 출력.
        int printedGroups = 0;
        Integer lastFrequency = null;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (printedGroups >= topFrequencyGroupsLimit && !entry.getValue().equals(lastFrequency)) {
                break;
            }
            System.out.println(entry.getKey() + " : " + entry.getValue() + "회");
            if (lastFrequency == null || !lastFrequency.equals(entry.getValue())) {
                printedGroups++;
            }
            lastFrequency = entry.getValue();
        }
    }
}