import java.util.*;

class Solution {
    public String solution(String X, String Y) {

        Map<Character, Integer> xFreq = new HashMap<>();
        Map<Character, Integer> yFreq = new HashMap<>();

        for (char c : X.toCharArray()) {
            xFreq.put(c, xFreq.getOrDefault(c, 0) + 1);
        }

        for (char c : Y.toCharArray()) {
            yFreq.put(c, yFreq.getOrDefault(c, 0) + 1);
        }

        List<Character> commonChars = new ArrayList<>();
        for (char c : xFreq.keySet()) {
            if (yFreq.containsKey(c)) {
                int minCount = Math.min(xFreq.get(c), yFreq.get(c));
                for (int i = 0; i < minCount; i++) {
                    commonChars.add(c);
                }
            }
        }

        if (commonChars.isEmpty()) {
            return "-1";
        }

        commonChars.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (char c : commonChars) {
            sb.append(c);
        }

        if (sb.toString().matches("0+")) {
            return "0";
        }

        return sb.toString();
    }
}