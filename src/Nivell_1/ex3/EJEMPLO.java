package Nivell_1.ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class EJEMPLO {

            Scanner entrada = new Scanner(System.in);

            //Preparativos

            String palabrass[] = null;
            String linea = "";
            FileReader lectura = null;
            BufferedReader buffer_lectura = null;

            Map<String, String> lista = new HashMap<>();
            try {
                lectura = new FileReader("ex3/countries.txt");
                buffer_lectura = new BufferedReader(lectura);
                do {
                    linea = buffer_lectura.readLine();
                    if (linea != null) {
                        palabrass = linea.split(" ");

                    }
                    for (String s : palabrass) {
                        lista.put(s, s);
                    }

                } while (linea != null);


            }
            //Controlando excepciones
            catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    buffer_lectura.close();
                    lectura.close();
                } catch (IOException e) {

                    System.out.println(e.getMessage());

                }
            }
        }

///lo incorrecto es recorrer palabras con un for.
///Tú sabes que dado el formato del documento, palabras siempre tendrá
///2 elementos, por tanto puedes asumir que: lista.put(palabrass[0],palabrass[1]);
///debería funcionar –

