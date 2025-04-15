
import java.util.Scanner;


public class Controladora {
    public static void mostrarMenu(){
        System.out.println("-----Menú Sistema de Biblioteca---");    
        System.out.println("1. Agregar libro");
        System.out.println("2. Eliminar libro");
        System.out.println("3. Consultar el total de libros "
                + "disponibles");
        System.out.println("4. Consultar información de un libro"
                + " específico");
        System.out.println("5. Listar Libros");
        System.out.println("6. Salir");
        System.out.println("Elija una opción");
    }
    public static void agregarLibros(Scanner scanner){
        System.out.print("Título:");
        String titulo = scanner.nextLine();
        System.out.print("Autor:");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Número de ejemplares:");
        int ejemplares = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer de entrada
        
        Libro libro = new Libro(titulo, autor, isbn, ejemplares);
        try {
            Biblioteca.agregarLibro(libro);
            System.out.println("Libro registrado ok");
        } catch (ISBNDuplicadoException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void listarLibros(){
        if(Biblioteca.libros.isEmpty()){
            System.out.print("No hay libros en la biblioteca");
        }
        else{
            System.out.print("Los libros existentes son: ");
            for (Libro libro : Biblioteca.libros) {
                System.out.println("- " + libro.toString());
            }
        }
    }
    public static void eliminarLibros(Scanner linea){
        System.out.print("Ingrese el ISBN del libro a eliminar:");
        String isbn = linea.nextLine();
        Biblioteca.eliminarLibro(isbn);
        System.out.println("Libro eliminado");
    }
    public static void consultarLibroEspecifico(Scanner linea){
        System.out.print("Ingrese el ISBN del libro a consultar:");
        String isbn = linea.nextLine();

        for(Libro libro: Biblioteca.libros){
            if(libro.getISBN().equals(isbn))  {
                  Biblioteca.LibroConsultado consulta = new 
                  Biblioteca.LibroConsultado(libro); //va en una sola linea
                  consulta.mostrarInformacion(); //método de instancia
                  return;
            }
        } System.out.println("No se encontró el libro con el ISBN " + isbn);
    }
    public static void consultarTotalLibros(){
         int total = Biblioteca.obtenerTotalLibros();
         System.out.println("Total de libros en biblioteca "+ total);
    }

    public static void ejecutar(Scanner linea){
        boolean salir = false;
        while(!salir){
            mostrarMenu();//método de clase pq no necesita de un objeto --static
            int opcion = linea.nextInt();
            linea.nextLine();//limpia el buffer
            switch(opcion){
                case 1: agregarLibros(linea); break;
                case 2: eliminarLibros(linea); break;
                case 3: consultarTotalLibros(); break;
                case 4: consultarLibroEspecifico(linea); break;
                case 5: listarLibros(); break;
                case 6: salir = true; break;
                default: System.out.println("Opción no válida, intente "
 + "nuevamente");
            }
        }
    }
    


}
