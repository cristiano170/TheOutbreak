package org.academiadecodigo.variachis.todopriorityqueue;

import java.util.*;

public class Todo implements Comparable<Todo>{

    private String task;
    private Importance importance;
    private int priority;

    Todo(String task, Importance importance, int priority){

        this.task = task;
        this.importance = importance;
        this.priority = priority;

    }

    @Override
    public int compareTo(Todo o) {
        if (importance.compareTo(o.importance) == 0){
            if (priority > o.priority){
                return 1;
            }
            return -1;
        }
        return importance.compareTo(o.importance);
    }


    @Override
    public String toString() {
        return task + "\n" + importance + "\n" + priority + "\n";
    }
}
