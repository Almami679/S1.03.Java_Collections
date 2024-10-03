package Nivell_1.ex1.modules;

public class EJEMPLO {

    ///Código a agregar en la clase Cliente:

    public class Cliente {
        private String nombre;
        private int identificacion;
        // Más atributos
        // Constructores
        @Override
        public boolean equals(Object obj) {
            // hay que asegurar que obj es de la clase Cliente
            if (obj != null && obj instanceof Cliente) {
                // se comparan los números de identificación
                Cliente another = (Cliente) obj;
                return this.identificacion == another.identificacion;
            } else {
                return false;
            }
        }
        // Identificador único del objeto para colecciones HashSet, por ejemplo
        @Override
        public int hashCode() {
            // Se utilizará el número de identificación.
            return this.identificacion;
        }
        // Más código
    }
}
/////////////////////////////////////////////////////////////////////////////////////
private Cliente cliente;

HashSet<Cliente> listaCliente = new HashSet();


private void ingresarCliente() throws IOException{
    System.out.println("Ingrese los datos separados por '&':(Nombre, Edad, Identificacion, Presupuesto)");
    String texto = br.readLine();
    String [] dato = texto.split("&");
    String nombre = dato[0];
    int edad = Integer.parseInt(dato[1]);
    int identificacion = Integer.parseInt(dato[2]);
    double presupuesto = Double.parseDouble(dato[3]);
    if (dato.length==4) {
        Cliente clienteNuevo = new Cliente(nombre,edad,identificacion,presupuesto, false);
        if (edad >= 18 ) {
            if (listaCliente.add(clienteNuevo)) { //Si devuelve true, significa que se agregó
                System.out.println("Usuario Ingresado Correctamente " + "\n" + listaCliente);
            } else{
                System.out.println("Identificacion repetida");
            }
        } else {
            System.out.println("Debe ser mayor de edad");
        }
    }else{
        System.out.println("Datos mal ingresados");
        ingresarCliente();
    }
}
