/*
 * PLANO:
 *
 * Domínio: uma biblioteca que controla empréstimos de livros e revistas.
 *
 * Superclasse: ItemBiblioteca
 *
 * Subclasses:
 * - Livro: possui o atributo próprio autor.
 * - Revista: possui o atributo próprio edicao.
 *
 * Método abstrato:
 * - calcularMulta() — cada tipo de item calcula a multa de uma forma diferente.
 *
 * Método sobrescrito:
 * - ficha() — as subclasses reaproveitam super.ficha() e acrescentam
 *   suas próprias informações.
 *
 * IA:
 * Usei IA para ajudar na escolha do domínio e na estrutura inicial
 * das classes. Depois revisei o código e a lógica e tirei duvudas em partes que eu não sabia.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<ItemBiblioteca> itens = new ArrayList<>();

        itens.add(new Livro(
                "O Hobbit",
                3,
                "J. R. R. Tolkien"
        ));

        itens.add(new Revista(
                "Super Interessante",
                5,
                412
        ));

        itens.add(new Livro(
                "Dom Casmurro",
                2,
                "Machado de Assis"
        ));

        System.out.println("===== CONTROLE DA BIBLIOTECA =====");

        double totalMultas = 0;
        for (ItemBiblioteca item : itens) {

            item.ficha();
            double multa = item.calcularMulta();
            System.out.printf("Multa: R$ %.2f%n", multa);
            System.out.println("--------------------------------");
            totalMultas += multa;
        }

        System.out.printf(
                "Total de multas: R$ %.2f%n",
                totalMultas
        );
    }
}

/*
        AUTOAVALIAÇÃO:

        Critério 1: atingido.
        Existe uma superclasse ItemBiblioteca e duas subclasses:
        Livro e Revista. Um Livro é um ItemBiblioteca e uma Revista
        também é um ItemBiblioteca.

        Critério 2: atingido.
        O método calcularMulta() foi declarado como abstrato na
        superclasse e implementado de maneira própria por Livro e Revista.

        Critério 3: atingido.
        Os construtores das subclasses chamam super() e cada subclasse
        possui um atributo próprio.

        Critério 4: atingido.
        O método ficha() é sobrescrito nas duas subclasses e utiliza
        super.ficha() para reaproveitar o código da superclasse.

        Critério 5: atingido.
        A coleção é do tipo ItemBiblioteca e contém objetos Livro e Revista.
        Existe apenas um laço e não foi utilizado instanceof.

        Critério 6: atingido.
        O mesmo comando calcularMulta() produz resultados diferentes
        dependendo do objeto: Livro possui multa de R$ 2,00 por dia,
        enquanto Revista possui multa de R$ 1,00 por dia.

        O trecho que deu mais trabalho foi organizar a diferença entre
        os cálculos de multa. Resolvi colocando a regra específica
        dentro de cada subclasse, .

        A IA ajudou na escolha do domínio e na estrutura inicial.
        Depois revisei o código e conferi a lógica da atividade.
 */