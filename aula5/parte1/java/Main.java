import java.util.ArrayList;
import java.util.List;

/*
 * Uso de IA:
 * Usei o Claude pra me ajudar a evoluir a classe Personagem pra abstrata,
 * criar o método atacar(Personagem alvo) que faltava (as versões
 * anteriores só simulavam ataque sem alvo real) e montar a classe Chefe.
 * Depois de gerado, rodei a versão em Python pra conferir a saída no
 * console: validei que Personagem não pode mais ser instanciada
 * diretamente, que a vida do Chefe realmente cai a cada ataque recebido
 * (200 -> 190 -> 180, já que Elara e Bran causam 10 de dano cada),
 * e que o trecho com instanceof fora do laço só afeta os Magos, sem
 * quebrar o restante da lista.
 */
public class Main {

    public static void main(String[] args) {
        // Tentar instanciar Personagem diretamente não compila mais, pois
        // ela agora é abstrata:
        // Personagem generico = new Personagem("Zé", 100, 1);
        // erro: Personagem is abstract; cannot be instantiated

        List<Personagem> herois = new ArrayList<>();
        herois.add(new Mago("Elara", 100, 1));
        herois.add(new Guerreiro("Bran", 100, 1));

        Chefe reiLich = new Chefe("Rei Lich");

        System.out.println("======= Ficha do Chefe antes da batalha =======");
        reiLich.ficha();

        System.out.println("\n======= Batalha final =======");
        // Um único laço, sem instanceof: cada herói mostra a própria
        // ficha, a própria habilidade e ataca o mesmo alvo — o
        // polimorfismo decide qual versão de ficha()/habilidade()/
        // receberDano() é chamada em cada caso.
        for (Personagem heroi : herois) {
            heroi.ficha();
            System.out.println(heroi.getNome() + " usa " + heroi.habilidade());
            heroi.atacar(reiLich);
            System.out.println("--------------------------------");
        }

        System.out.println("\n======= Ficha do Chefe depois da batalha =======");
        reiLich.ficha();

        // Exercício 5 — instanceof com moderação, FORA do laço da batalha.
        // Aqui eu preciso especificamente da mana, um dado que só existe em
        // Mago — não faz sentido subir isso para a superclasse Personagem
        // só para atender esse caso pontual, e usar instanceof aqui não
        // quebra o polimorfismo do combate (que continua tratando todos os
        // heróis de forma uniforme lá em cima). Se eu tivesse colocado esse
        // instanceof dentro do laço da batalha, perderia a vantagem do
        // polimorfismo e teria que criar um "if" para cada tipo de
        // personagem sempre que uma nova subclasse aparecesse.
        System.out.println("\n======= Mana dos magos da lista (fora do laço da batalha) =======");
        for (Personagem p : herois) {
            if (p instanceof Mago) {
                Mago mago = (Mago) p;
                System.out.println(mago.getNome() + " ainda tem " + mago.getMana() + " de mana.");
            }
        }
    }
}

/*
 * Autoavaliação:
 * Personagem agora é abstrata com habilidade() abstrato (exercício 1);
 * Mago e Guerreiro implementam habilidade() com @Override (exercício 2);
 * Chefe herda de Personagem com vida/nível fixos e ficha() com o
 * indicador [CHEFE] (exercício 3); a batalha final percorre uma
 * List<Personagem> com Mago e Guerreiro em um único laço, sem instanceof,
 * mostrando ficha, habilidade e ataque real contra o Chefe, cuja vida cai
 * de 200 para 180 ao final (exercício 4); o uso opcional de instanceof
 * pra mostrar a mana dos magos foi feito fora do laço principal, com
 * comentário explicando o motivo (exercício 5).
 */
