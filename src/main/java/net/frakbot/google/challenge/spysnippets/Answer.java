package net.frakbot.google.challenge.spysnippets;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Francesco Pontillo
 */
public class Answer {
    private static int MAX_TERMS = 500;
    private static Pattern pattern = Pattern.compile("\\s");

    public static String answer(String document, String[] searchTerms) {
        String[] terms = pattern.split(document);
        HashSet<String> termSet = new HashSet<String>(Arrays.asList(searchTerms));
        HashMap<String, List<Integer>> termMap = new HashMap<String, List<Integer>>(searchTerms.length);
        double solutionsQty = 1;

        for (int i = 0; i < terms.length; i++) {
            if (termSet.contains(terms[i])) {
                List<Integer> positions = termMap.get(terms[i]);
                if (positions == null) {
                    positions = new ArrayList<Integer>();
                }
                positions.add(i);
                termMap.put(terms[i], positions);
                int newPositionsCounts = positions.size();
                if (newPositionsCounts > 1) {
                    solutionsQty = solutionsQty / (newPositionsCounts - 1) * newPositionsCounts;
                }
            }
        }

        int minLength = MAX_TERMS, min = terms.length, max = -1;
        Set<String> keys = termMap.keySet();
        for (double i = 0; i < solutionsQty; i++) {
            int localMin = terms.length, localMax = -1, localLength = MAX_TERMS;
            int prevCount = 1;
            // for every term, add the proper values
            for (String s : keys) {
                List<Integer> positions = termMap.get(s);
                int count = positions.size();
                double split = (solutionsQty / count) / prevCount;
                int termPos = positions.get((int) ((i / split) % count));
                prevCount = prevCount * count;
                if (termPos < localMin) {
                    localMin = termPos;
                }
                if (termPos > localMax) {
                    localMax = termPos;
                }
                // calc the temporary solution length, if it already passes the min one, avoid continuing
                localLength = localMax - localMin;
                if (localLength > minLength) {
                    break;
                }
            }
            if ((localLength < minLength) || (localLength == minLength && localMin < min)) {
                minLength = localLength;
                min = localMin;
                max = localMax;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int k = min; k <= max; k++) {
            stringBuilder.append(terms[k]);
            if (k + 1 <= max) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
