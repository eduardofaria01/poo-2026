public abstract class ItemBiblioteca {

    private String titulo;
    private int diasAtraso;

    public ItemBiblioteca(String titulo, int diasAtraso) {
        this.titulo = titulo;
        this.diasAtraso = diasAtraso;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    // Cada subclasse calcula sua multa de maneira diferente.
    public abstract double calcularMulta();

    // Método comum que será reaproveitado pelas subclasses.
    public void ficha() {
        System.out.println("Título: " + titulo);
        System.out.println("Dias de atraso: " + diasAtraso);
    }
}