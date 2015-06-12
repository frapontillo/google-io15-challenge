package net.frakbot.google.challenge.stringcleaning;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Francesco Pontillo
 */
public class Answer {
    private static Pattern match;

    public static String answer(String chunk, String word) {
        match = Pattern.compile(word);
        List<String> candidates = new ArrayList<String>();
        Set<String> handledCandidates = new HashSet<String>();

        candidates.add(chunk);
        buildCandidates(candidates, handledCandidates);
        return Collections.min(candidates, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int comparison = Integer.compare(o1.length(), o2.length());
                if (comparison == 0) {
                    comparison = o1.compareTo(o2);
                }
                return comparison;
            }
        });
    }

    private static List<String> buildCandidates(List<String> candidates, Set<String> handledCandidates) {
        for (int i = 0; i < candidates.size(); i++) {
            // get a candidate and analyze it
            String candidate = candidates.get(i);
            List<String> newCandidates = removeOnce(candidate);
            // if there are new candidates remove the current one and add the new ones
            if (newCandidates.size() > 0) {
                candidates.remove(i);
                i -= 1;
                // remove already handled candidates and mark the remaining ones and handled for future steps
                newCandidates.removeAll(handledCandidates);
                handledCandidates.addAll(newCandidates);
                candidates.addAll(newCandidates);
            }
        }
        return candidates;
    }

    private static List<String> removeOnce(String from) {
        List<String> newCandidates = new ArrayList<String>();
        Matcher matcher = match.matcher(from);
        int start = 0;
        while (matcher.find(start)) {
            String newCandidate = from.substring(0, matcher.start()) + from.substring(matcher.end(), from.length());
            newCandidates.add(newCandidate);
            start = matcher.start() + 1;
        }
        return newCandidates;
    }
}