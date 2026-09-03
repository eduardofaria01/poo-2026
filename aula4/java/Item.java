public class Item {

    private String nome;
    private int bonus;

    public Item(String nome, int bonus) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do item não pode ser vazio.");
        }
        if (bonus < 0) {
            throw new IllegalArgumentException("O bônus não pode ser negativo.");
        }
        this.nome = nome;
        this.bonus = bonus;
    }

    public String getNome() {
        return this.nome;
    }

    public int getBonus() {
        return this.bonus;
    }

    // Ex: "Espada de Aço (+3)"
    public String descricao() {
        return this.nome + " (+" + this.bonus + ")";
    }
}
