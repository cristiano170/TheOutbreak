package org.academiadecodigo.variachis.uniqueword;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        UniqueWord uniqueWord = new UniqueWord("vamos que vamos voltar que vamos voltar ir quer vamos ficar e voltar a ir");

        uniqueWord.fillSet();


        for (String s : uniqueWord){
            System.out.println(s);
        }
    }

}