package Nivell_1.ex3;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class mainEx3 {

    static Map<String, String> listaCapitales = new HashMap<>();
    static int puntuacion = 0;
    static int preguntas = 10;
    static BufferedWriter editarArchivo;
    static String user = "";
    static String marco = "-------------------------------------------\n" +
            "-------Adivina-------la------Capital-------\n" +
            "-------------------------------------------\n";

    public static void main(String[] args) throws FileNotFoundException {

        Map<String, String> listaCapitales = new HashMap<>();

        Scanner input = new Scanner(System.in);


        System.out.println(marco + "Cual es tu nombre de Usuario?");
        user = input.nextLine();
        limpiarCmd();
        while(preguntas > 0) {
            System.out.println(marco + "Te quedan " + preguntas + " intentos");
            limpiarCmd();
            generarPregunta();
            preguntas--;
        }
        System.out.println(marco + "Tu puntuacion ha sido de " + puntuacion + " puntos");
        comprobarArchivo();
        editarArchivo();

        input.close();






    }
    public static void generarPregunta() {
        Scanner input = new Scanner(System.in);
        int posAleatoria = (int) (Math.random() * (listaCapitales.size() + 1));
        List<String> capital = List.of(listaCapitales.get(posAleatoria));
        System.out.println(marco + "Cual es la capital de " + capital.getFirst());
        String respuesta = input.nextLine();
        limpiarCmd();
        if(respuesta.equalsIgnoreCase(capital.getLast())) {
            puntuacion++;
            System.out.println(marco + "Respuesta correcta");
        } else {
            System.out.println(marco + "Respuesta incorrecta");
        }
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

    public static void limpiarCmd() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hacer nada*/
        }
    }

    public static void comprobarArchivo() throws FileNotFoundException {
        try {
            String ruta = "Puntuaciones.txt";
            File archivo = new File(ruta);
            if (archivo.exists()) {
                System.out.println("Abriendo archivo para actualizar el rancking");
            }
            else {
                System.out.println("Creando archivo para almacenar el rancking");
                editarArchivo = new BufferedWriter(new FileWriter(archivo));
                editarArchivo.close();
            }
        } catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado, codigo de error: \n" +
                    e.getMessage());
        } catch(IOException e){
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    public static void editarArchivo() {
        String texto = "User: " + user + "-----------> " + puntuacion + " puntos.";
        try(FileWriter fw = new FileWriter("Puntuaciones.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(texto);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}



