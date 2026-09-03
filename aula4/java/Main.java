/*
Uso de IA:
Ferramenta utilizada: Claude
Usei o Claude para me ajudar a montar a estrutura inicial das classes
e para explicar os conceitos de algumas coisa que eu nao entendia e no final para revisar o codigo.
O que modificou ou validou manualmente: Validação de todas as regras de negócio, testes de execução 
e ajustes nas validações dos atributos.
*/


public class Main {

    public static void main(String[] args) {
        System.out.println("======= Criando item =======");
        Item espada = new Item("Espada de Aço", 3);
        System.out.println("Item criado: " + espada.descricao());

        System.out.println("\n======= Mago pega a espada =======");
        Mago elara = new Mago("Elara", 100, 1);
        elara.pegar(espada);
        elara.ficha();

        System.out.println("\n======= Guerreiro recebe dano (defesa reduz o dano) =======");
        Guerreiro bran = new Guerreiro("Bran", 100, 1);
        bran.ficha();
        bran.receberDano(8); // defesa = 5 -> dano efetivo = max(0, 8-5) = 3
        System.out.println("Vida restante de Bran: " + bran.getVida() + " (esperado: 97)");
        bran.ficha();

        System.out.println("\n======= Tentando definir mana negativa no Mago =======");
        try {
            elara.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir mana=-10 -> " + e.getMessage());
        }
        System.out.println("Mana de Elara permanece: " + elara.getMana());
    }
}
