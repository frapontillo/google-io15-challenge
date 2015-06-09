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
        List<Solution> solutions = new ArrayList<Solution>();

        // loop over the document
        for (int i = 0; i < terms.length; i++) {
            String term = terms[i];
            // if it's not a match, go on
            if (!termSet.contains(term)) {
                continue;
            }
            Match newMatch = new Match(term, i);
            // for every other solution, add the match if it does not contain the term already
            for (Solution solution : solutions) {
                if (!solution.containsTerm(term)) {
                    solution.addMatch(newMatch);
                }
            }
            // if there are sufficient terms next in the document, add a new solution containing only term:pos
            if (terms.length - i >= searchTerms.length) {
                Solution baseSolution = new Solution(newMatch);
                solutions.add(baseSolution);
            }
        }

        List<Solution> purgedSolutions = new ArrayList<Solution>();
        for (Solution solution : solutions) {
            if (solution.isComplete(searchTerms.length)) {
                purgedSolutions.add(solution);
            }
        }

        return Collections.min(purgedSolutions).getDocumentPortion(terms);
    }

    private static class Solution implements Comparable<Solution> {
        private List<Match> matches;
        private Set<String> termSet;

        public Solution(Match match) {
            this.matches = new ArrayList<Match>();
            this.termSet = new HashSet<String>();
            addMatch(match);
        }

        public boolean isComplete(int searchTermsQty) {
            return (matches.size() == searchTermsQty);
        }

        public int getDistance() {
            if (matches.size() <= 1) {
                return MAX_TERMS;
            }
            Match min = Collections.min(matches);
            Match max = Collections.max(matches);
            return max.position - min.position;
        }

        public boolean containsTerm(String term) {
            return this.termSet.contains(term);
        }

        public void addMatch(Match match) {
            if (match != null) {
                this.matches.add(match);
                this.termSet.add(match.term);
            }
        }

        public String getDocumentPortion(String[] terms) {
            int minPos = matches.get(0).position;
            int maxPos = matches.get(matches.size() - 1).position;
            StringBuilder solutionBuilder = new StringBuilder();
            for (int i = minPos; i <= maxPos; i++) {
                solutionBuilder.append(terms[i]);
                if (i < maxPos) {
                    solutionBuilder.append(" ");
                }
            }
            return solutionBuilder.toString();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matches.size(); i++) {
                sb.append(matches.get(i).toString());
                if (i < matches.size() - 1) {
                    sb.append(" / ");
                }
            }
            return sb.toString();
        }

        @Override
        public int compareTo(Solution o) {
            return Integer.compare(this.getDistance(), o.getDistance());
        }
    }

    private static class Match implements Comparable<Match> {
        private String term;
        private int position;

        public Match(String term, int position) {
            this.term = term;
            this.position = position;
        }

        @Override
        public int compareTo(Match o) {
            return Integer.compare(this.position, o.position);
        }

        @Override
        public String toString() {
            return term + ":" + position;
        }
    }
}