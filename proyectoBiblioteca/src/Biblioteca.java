
import java.util.ArrayList;
import java.util.List;


public class Biblioteca {
    public static List<Libro> libros = new ArrayList<>();
    public  static int totalLibros = 0;
    
    
    //método que permita agregar libros
    public static void agregarLibro(Libro libro) throws 
            ISBNDuplicadoException{
        //VERIFICAR SI EL ISBN YA existe
        for (Libro libro1 : libros) {
            if(libro1.getISBN().equals(libro.getISBN())){
                throw new ISBNDuplicadoException("Error el ISBN " +
                        libro.getISBN() + " ya existe.");
            }
        }
        libros.add(libro); //agrega
        totalLibros += libro.getNumeroEjemplares();       
    }
    public static int obtenerTotalLibros(){
        return totalLibros;
    }
    public static void eliminarLibro(String isbn){
        for (Libro libro : libros) {
            if(libro.getISBN().equals(isbn)){
                totalLibros -=libro.getNumeroEjemplares();
                libros.remove(libro); //elimina
                break;
            }
        }
    }
    //clase anidada estática
    public static class LibroConsultado{
        private Libro libro;
        
        public LibroConsultado(Libro li){
            this.libro = li;
        }
        public void mostrarInformacion (){
            System.out.println("Informacion del libro " + libro.toString());
        }
    }
}
