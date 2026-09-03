import java.util.ArrayList;
import java.util.List;

public class Personagem {

    private static final int DANO_PADRAO = 10;

    private String nome;
    private int vida;
    private int nivel;
    private List<Item> inventario = new ArrayList<>();

    // Construtor padrão (sem parâmetros)
    public Personagem() {
        this("Sem Nome", 100, 1);
    }

    // Construtor parametrizado
    public Personagem(String nome, int vida, int nivel) {
        setNome(nome);
        setVida(vida);
        setNivel(nivel);
    }

    //Getters

    public String getNome() {
        return this.nome;
    }

    public int getVida() {
        return this.vida;
    }

    public int getNivel() {
        return this.nivel;
    }

    public List<Item> getInventario() {
        return this.inventario;
    }

    //Setters com validação

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public void setVida(int vida) {
        if (vida < 0 || vida > 100) {
            throw new IllegalArgumentException("A vida deve estar entre 0 e 100.");
        }
        this.vida = vida;
    }

    public void setNivel(int nivel) {
        if (nivel < 1) {
            throw new IllegalArgumentException("O nível deve ser no mínimo 1.");
        }
        this.nivel = nivel;
    }

    //Inventário (composição com Item

    public void pegar(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item inválido.");
        }
        this.inventario.add(item);
    }

    //Combate

    public void receberDano(int dano) {
        int novaVida = this.vida - dano;
        if (novaVida < 0) {
            novaVida = 0;
        }
        setVida(novaVida);
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    // Sobrecarga: ataque padrão
    public void atacar() {
        atacar(DANO_PADRAO);
    }

    // Sobrecarga: ataque com dano definido
    public void atacar(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("O dano não pode ser negativo.");
        }
        System.out.println(this.nome + " ataca causando " + dano + " de dano!");
    }

    public void ficha() {
        System.out.println("----- Ficha do Personagem -----");
        System.out.println("Nome:  " + this.nome);
        System.out.println("Vida:  " + this.vida);
        System.out.println("Nível: " + this.nivel);
        if (this.inventario.isEmpty()) {
            System.out.println("Itens:  (inventário vazio)");
        } else {
            System.out.println("Itens:");
            for (Item item : this.inventario) {
                System.out.println("  - " + item.descricao());
            }
        }
        System.out.println("--------------------------------");
    }
}
