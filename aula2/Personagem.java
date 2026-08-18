public class Personagem {
    String nome;
    int vida;
    int forca;

    void receberDano(int dano) {
        vida = vida - dano;

        System.out.println(
            nome + " sofreu " + dano + " de dano."
        );
    }

    boolean estaVivo() {
        return vida > 0;
    }

    String ficha() {
        return nome +
               " (vida: " + vida +
               ", força: " + forca + ")";
    }

    void atacar(Personagem alvo) {
        System.out.println(nome + " ataca " + alvo.nome);
        alvo.receberDano(forca);
    }

    public static void main(String[] args) {
        Personagem heroi = new Personagem();
        heroi.nome = "Herói";
        heroi.vida = 100;
        heroi.forca = 20;

        Personagem chefe = new Personagem();
        chefe.nome = "Chefe";
        chefe.vida = 120;
        chefe.forca = 15;

        System.out.println("=== ANTES DA BATALHA ===");
        System.out.println(heroi.ficha());
        System.out.println(chefe.ficha());

        System.out.println("\n=== BATALHA ===");

        while (heroi.estaVivo() && chefe.estaVivo()) {
            heroi.atacar(chefe);

            if (chefe.estaVivo()) {
                chefe.atacar(heroi);
            }
        }

        System.out.println("\n=== DEPOIS DA BATALHA ===");
        System.out.println(heroi.ficha());
        System.out.println(chefe.ficha());

        if (heroi.estaVivo()) {
            System.out.println("O herói venceu!");
        } else {
            System.out.println("O chefe venceu!");
        }
    }
}