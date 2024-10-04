package Nivell_1.ex3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Main {

    private static Scanner input = new Scanner(System.in);
    static int rondas = 10;
    static int puntuacion = 0;
    static HashMap<String, String> hashCapitales = new HashMap<String, String>();
    static ArrayList<Integer> capitalesRepetidas = new ArrayList<>();

    public static void main(String[] args) {
        int oportunidades = 10;
        String user = "";


        volcadoArchivo();
        System.out.println("Introduce tu nombre de usuario:");
        user = input.nextLine();

        while(rondas > 0) {
            preguntaAleatoria();
        }
        System.out.println("Final del juego! " + puntuacion + " puntos aconseguidos");
        writeFile(user,puntuacion);
    }




    public static void preguntaAleatoria() {
        ArrayList<String> capitales = new ArrayList<>();
        ArrayList<String> paises = new ArrayList<>();
        int randomPos = (int) (Math.random() * (hashCapitales.size() + 1));
        while(capitalesRepetidas.contains(randomPos)) {
            randomPos = (int) (Math.random() * (hashCapitales.size() + 1));
        }
        //saco el map y meto el valor y la key en dos listas
        for (Map.Entry<String, String> entry : hashCapitales.entrySet()) {
            paises.add(entry.getKey());
            capitales.add(entry.getValue());
        }

        //hago .get() del num aleatorio en la posicion de cada lista
        System.out.println("Cual es la capital de " + paises.get(randomPos));
        String capital = input.nextLine();
        capitalesRepetidas.add(randomPos);

        if (capital.equalsIgnoreCase(capitales.get(randomPos))) {
            System.out.println("Ha encertat!!!");
            puntuacion++;
        } else {
            System.out.println("Error!!!");
        }
        rondas--;
        System.out.println("Puntuacion actual: " + puntuacion + "\n" +
                "Rondas restantes: "+ rondas);
    }

///////////////////////////////////////////////////////////////////////////////

    public static void volcadoArchivo() {
        try {
            File fichero = new File("countries.txt");
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                String array[] = linea.split(" ");
                hashCapitales.put(array[0], array[1]);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error inesperado" + e.getMessage());
        }
    }

    //////////////////////////////////////////////////////////////////////////////

    private static void writeFile(String user, int encerts) {
        try{
            File file=new File("puntuacion.txt");
            if(file.createNewFile()){
                System.out.println("Archivo " + file.getName() + " ya existente");
            }
            FileWriter fw= new FileWriter("puntuacion.txt",true);
            fw.write("User ");
            fw.write(user);
            fw.write("----------------> ");
            fw.write(encerts);
            fw.write(" puntos.\n");
            fw.close();

        }catch(Exception e){
            System.out.println("Error inesperado" + e.getMessage());
        }

    }

}

