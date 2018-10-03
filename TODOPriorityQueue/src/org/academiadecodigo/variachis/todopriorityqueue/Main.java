package org.academiadecodigo.variachis.todopriorityqueue;

import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) {

        Todo task1 = new Todo("Dar banho ao cão", Importance.LOW, 1);
        Todo task2 = new Todo("Comer", Importance.HIGH, 2);
        Todo task3 = new Todo("Dormir", Importance.MEDIUM, 1);
        Todo task4 = new Todo("Ir trabalhar", Importance.LOW, 2);
        Todo task5 = new Todo("Beber café", Importance.MEDIUM, 3);
        Todo task6 = new Todo("Fazer o exercicio", Importance.HIGH, 1);


        PriorityQueue<Todo> todoListQueue = new PriorityQueue<>();

        todoListQueue.offer(task1);
        todoListQueue.offer(task2);
        todoListQueue.offer(task3);
        todoListQueue.offer(task4);
        todoListQueue.offer(task5);
        todoListQueue.offer(task6);

        while (!todoListQueue.isEmpty()){
            System.out.println(todoListQueue.poll());
        }
    }
}
