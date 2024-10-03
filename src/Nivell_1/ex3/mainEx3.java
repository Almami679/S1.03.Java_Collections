package Nivell_1.ex3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class mainEx3 {

    static Map<String, String> listaCapitales = new HashMap<>();

    public static void main(String[] args) {
        String respuesta = "";
        int puntuacion = 0;


        Map<String, String> listaCapitales = new HashMap<>();


    }

    public static void recogerDatosDesdeArchivo() {
        String capitales[] = null;
        String linea = "";
        FileReader lectura = null;
        BufferedReader buffer_lectura = null;
        try {
            lectura = new FileReader("ex3/countries.txt");
            buffer_lectura = new BufferedReader(lectura);
            do {
                linea = buffer_lectura.readLine();
                if (linea != null) {
                    capitales = linea.split(" ");
                }
                assert capitales != null;
                listaCapitales.put(capitales[0], capitales[1]);

            } while (linea != null);


        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, codigo de error: \n" +
                    e.getMessage());
        } catch (IOException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

    }

}

