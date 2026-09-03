public class Livro extends ItemBiblioteca {

    private static final double MULTA_POR_DIA = 2.00;

    private String autor;

    public Livro(String titulo, int diasAtraso, String autor) {
        super(titulo, diasAtraso);
        this.autor = autor;
    }

    @Override
    public double calcularMulta() {
        return getDiasAtraso() * MULTA_POR_DIA;
    }

    @Override
    public void ficha() {
        super.ficha();
        System.out.println("Tipo: Livro");
        System.out.println("Autor: " + autor);
    }
}