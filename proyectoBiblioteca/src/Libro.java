
public class Libro {
    public String titulo;
    public String autor;
    public String ISBN;
    public int numeroEjemplares;
    //constuctor 
    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN=null;
        this.numeroEjemplares=0;
    }
    public Libro(String t, String a, String isbn, int num){
        this.titulo = t;
        this.autor =a;
        this.ISBN = isbn;
        this.numeroEjemplares = num;
    }
    public void setTitulo(String t){
        this.titulo = t;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setAutor(String a){
        this.autor = a;
    }
    public String getAutor(){
        return this.autor;
    }
    public void setISBN(String isbn){
        this.ISBN = isbn;
    }
    public String getISBN(){
        return this.ISBN;
    }
    public void setNumeroEjemplares(int num){
        this.numeroEjemplares = num;
    }
    public int getNumeroEjemplares(){
        return this.numeroEjemplares;
    }
    @Override
    public String toString(){
        return "Titulo:"+ this.getTitulo() + " Autor:"+ 
                this.getAutor() + " CódigoISBN: "+
                this.getISBN() + " Cantidad:" + 
                this.getNumeroEjemplares() + "\n";
    }
    
}

