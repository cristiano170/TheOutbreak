package org.academiadecodigo.variachis.uniqueword;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.lang.String;
import java.util.TreeSet;

public class UniqueWord implements Iterable<String> {

    private String string;
    private Set<String> set = new TreeSet<>();

    public UniqueWord(String string) {
        this.string = string;
    }


    public void fillSet() {

        String[] splited = string.split("\\s+");

        for (String s : splited) {
            set.add(s);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return set.iterator();
    }


}
