package Nivell_1.ex1.modules;

import java.util.Objects;

public class Month {

    String name;
   // int identificacion;
    //static int identificacionSiguiente = 1;

    public Month(String name) {
        this.name = name;
       // this.identificacion = identificacionSiguiente;
       // identificacionSiguiente++;
    }

    public String toString() {
        return this.name;
    }



    public int hashCode() {
        return Objects.hashCode(name);
    }

    public boolean equals(Object obj) { //
        boolean check = false;
        // hay que asegurar que obj es de la clase Cliente
        if (obj instanceof Month) {
            // se comparan los nombres del mes
            Month otro = (Month) obj;
            if(this.name.equalsIgnoreCase(otro.name)){
               check = true;
            }
        }
        return check;
    }

}
