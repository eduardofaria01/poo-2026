public class Revista extends ItemBiblioteca {

    private static final double MULTA_POR_DIA = 1.00;

    private int edicao;

    public Revista(String titulo, int diasAtraso, int edicao) {
        super(titulo, diasAtraso);
        this.edicao = edicao;
    }

    @Override
    public double calcularMulta() {
        return getDiasAtraso() * MULTA_POR_DIA;
    }

    @Override
    public void ficha() {
        super.ficha();
        System.out.println("Tipo: Revista");
        System.out.println("Edição: " + edicao);
    }
}