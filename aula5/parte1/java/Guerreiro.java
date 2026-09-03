public class Guerreiro extends Personagem {

    private int defesa;

    public Guerreiro(String nome, int vida, int nivel) {
        super(nome, vida, nivel);
        setDefesa(5);
    }

    public int getDefesa() {
        return this.defesa;
    }

    public void setDefesa(int defesa) {
        if (defesa < 0) {
            throw new IllegalArgumentException("A defesa não pode ser negativa.");
        }
        this.defesa = defesa;
    }

    @Override
    public void receberDano(int dano) {
        int danoEfetivo = Math.max(0, dano - this.defesa);
        System.out.println(this.getNome() + " bloqueia parte do dano com a defesa (" + this.defesa
                + "). Dano efetivo: " + danoEfetivo);
        super.receberDano(danoEfetivo);
    }

    @Override
    public String habilidade() {
        return "escudo de aço";
    }

    @Override
    public void ficha() {
        super.ficha();
        System.out.println("Defesa: " + this.defesa);
    }
}
