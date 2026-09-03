public class Mago extends Personagem {

    private int mana;

    public Mago(String nome, int vida, int nivel) {
        super(nome, vida, nivel);
        setMana(50);
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("A mana não pode ser negativa.");
        }
        this.mana = mana;
    }

    @Override
    public String habilidade() {
        return "rajada arcana";
    }

    @Override
    public void ficha() {
        super.ficha();
        System.out.println("Mana:  " + this.mana);
    }
}
