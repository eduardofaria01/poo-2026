public class Chefe extends Personagem {

    private static final int VIDA_FIXA = 200;
    private static final int NIVEL_FIXO = 10;

    private int forca;

    public Chefe(String nome) {
        super(nome, VIDA_FIXA, NIVEL_FIXO);
        this.forca = 20;
    }

    public int getForca() {
        return this.forca;
    }

    @Override
    public String habilidade() {
        return "ataque devastador";
    }

    @Override
    public void ficha() {
        System.out.println("[CHEFE] " + getNome() + " (vida: " + getVida() + ", forca: " + this.forca + ")");
    }
}
