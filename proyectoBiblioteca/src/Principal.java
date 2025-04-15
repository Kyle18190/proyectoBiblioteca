
import java.util.Scanner;

public class Principal {
       public static void main (String [] args){
             Scanner linea = new Scanner(System.in);
             //ejecutamos el programa
             Controladora.ejecutar(linea);
             linea.close();
       }
}