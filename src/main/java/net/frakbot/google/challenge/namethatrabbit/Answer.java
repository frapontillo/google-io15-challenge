package net.frakbot.google.challenge.namethatrabbit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Francesco Pontillo
 */
public class Answer {
    public static String[] answer(String[] names) {
        Name[] compNames = new Name[names.length];
        for (int i = 0; i < names.length; i++) {
            compNames[i] = new Name(names[i]);
        }
        List<Name> nameList = Arrays.asList(compNames);
        Collections.sort(nameList);
        String[] outNames = new String[nameList.size()];
        for (int i = 0; i < nameList.size(); i++) {
            outNames[i] = nameList.get(i).getName();
        }
        return outNames;
    }

    public static class Name implements Comparable<Name> {
        String name;
        int value;

        public Name(String name) {
            this.name = name;
            this.value = 0;
            for (char c : name.toLowerCase().toCharArray()) {
                this.value += c - 96;
            }
        }

        @Override
        public int compareTo(Name othr) {
            int thisValue = this.value;
            int othrValue = othr.value;
            if (thisValue == othrValue) {
                return othr.name.compareTo(this.name);
            }
            return Integer.valueOf(othrValue).compareTo(thisValue);
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return this.name + ":" + this.value;
        }
    }
}
