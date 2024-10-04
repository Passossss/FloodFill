package Aula;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> notas = new LinkedList<>();
        //for (Integer n:notas)
        //n.add(0);
        notas.add(8);
        notas.add(9);
        notas.add(6);
        notas.add(10);
        notas.add(2);

        System.out.println("Topo da fila: " +notas.peek());
        System.out.println(notas.poll());
        System.out.println(notas);
        System.out.println(notas.isEmpty()?"Fila vazia":"Fila com elementos");


    }


    //pilha
    /*public static void main (String[] args) {
        Stack<Integer> notas = new Stack<>();
        notas.push(2);
        notas.push(2);
        notas.push(2);
        notas.push(2);
        notas.push(7);
        notas.push(2);
        notas.push(2);

        System.out.println(notas);
        for(Integer n:notas){
            System.out.println(n);
        }
    }
    */
}
