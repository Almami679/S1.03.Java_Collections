package Nivell_1.ex1.main;

import Nivell_1.ex1.modules.Month;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    static ArrayList<Month> months = new ArrayList<>();
    static Set<Month> monthsInHash = new HashSet<>();

    public static void main(String[] args) {



        months.add(new Month("January"));
        months.add(new Month("February"));
        months.add(new Month("March"));
        months.add(new Month("April"));
        months.add(new Month("May"));
        months.add(new Month("June"));
        months.add(new Month("July"));
        months.add(new Month("September"));
        months.add(new Month("October"));
        months.add(new Month("November"));
        months.add(new Month("December"));

        Month august = new Month("August");

        anadirMesEnSuPos(august, 8);

        imprimirMesesForEach();

        imprimirMesesIterator();

        //ordenarMesesUndo();

        for(Month month : months) {
            monthsInHash(month);
        }

        Month repetido = new Month("January");

        monthsInHash(repetido);


    }

    public static void anadirMesEnSuPos(Month month, int pos) {


        months.add(pos - 1, month);
    }

    //Esto es del ejercicio 2 xD
    //public static void ordenarMesesUndo() {
    //    Collections.reverse(months);
    //}

    public static void imprimirMesesForEach() {
        System.out.println("Imprimiendo la ArrayList con un forEach");
        for(Month month : months) {
            System.out.println(month.toString());
        }
    }

    public static void monthsInHash(Month month) {
        if (monthsInHash.add(month)) { //Si devuelve true, significa que se agregó
            System.out.println("Mes de " + month.toString() + " Ingresado Correctamente ");
        } else{
            System.out.println("Mes " + month.toString() + " repetido\nNo es posible ingresarlo.");
        }
    }

    public static void imprimirMesesIterator() {
        Iterator<Month> iterador = monthsInHash.iterator();
        System.out.println("Imprimendo el HashSet con un ITERATOR");
        while (iterador.hasNext()) {
            System.out.println(iterador.next().toString());
        }

    }
}
