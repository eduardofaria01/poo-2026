/*Planos:

Domínio: Uma plataforma de cursos(gestão de curso e matrícula)

Classes e seus atributos: 
Curso: nome (String), instrutor (String), cargaHoraria (int)
Matrícula: curso (Curso), nomeAluno (String), status (String), nota (double)

Tempo de planejamento:
Planejamento e Cabeçalho: 5 min
Implementação: 50 min
Testes e Autoavaliação: 10 min


Pretendo usar IA apenas para tirar duvidas

 */

class Curso {
    private String nome;
    private int cargaHoraria;

    public Curso(String nome, int cargaHoraria) {
        this.nome = nome;
        setCargaHoraria(cargaHoraria);
    }
    public Curso(String nome) { this(nome, 40); }
    public String getNome() { return nome; }
    public int getCargaHoraria() { return cargaHoraria; }
    
    public void setCargaHoraria(int ch) {
        if (ch < 10) System.out.println("[RECUSA] Carga horária inválida (" + ch + "h). Mínimo 10h.");
        else this.cargaHoraria = ch;
    }
}

class Matricula {
    private Curso curso;
    private String aluno;
    private double nota;

    public Matricula(Curso curso, String aluno, double nota) {
        this.curso = curso;
        this.aluno = aluno;
        setNota(nota);
    }
    public Matricula(Curso curso, String aluno) { this(curso, aluno, 0.0); }

    public double getNota() { return nota; }
    
    public void setNota(double nota) {
        if (nota < 0 || nota > 10) System.out.println("[RECUSA] Nota inválida (" + nota + "). Deve ser entre 0 e 10.");
        else this.nota = nota;
    }

    public void exibir() {
        System.out.println("-> " + aluno + " | Curso: " + curso.getNome() + " (" + curso.getCargaHoraria() + "h) | Nota: " + nota);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. CRIAÇÃO VÁLIDA ---");
        Curso c1 = new Curso("POO em Java", 60);
        Matricula m1 = new Matricula(c1, "Eduardo", 9.5);
        m1.exibir();

        System.out.println("\n--- 2. SEGUNDA FORMA DE CRIAÇÃO (SOBRECARGA) ---");
        Curso cPadrao = new Curso("Lógica de Programação");
        Matricula mPadrao = new Matricula(cPadrao, "Ana");
        mPadrao.exibir();

        System.out.println("\n--- 3. TESTANDO RECUSAS ---");
        System.out.println("Tentando carga horária de 5h:");
        Curso cInvalido = new Curso("Workshop", 5);

        System.out.println("\nTentando nota 12.0:");
        m1.setNota(12.0); 
        m1.exibir();       
    }
}



/*
PASSO 3: AUTOAVALIAÇÃO

Critérios atingidos:
Duas classes, sendo Matricula relacionada a Curso.
Atributos encapsulados com private.
Getters e setters.
Construtores com validação.
Sobrecarga de construtores.
Duas regras de validação.
Demonstração de criação válida, recusas e duas formas de criação.

Critérios não atingidos:
nenhum.

Trecho que deu mais trabalho:
A sobrecarga e o encadeamento dos construtores usando this().
Resolvi utilizando um construtor principal e fazendo o segundo
construtor chamar o primeiro com valores padrão.

Uso de IA:
A IA ajudou na organização e simplificação da estrutura do código.
Não atrapalhou significativamente, mas precisei conferir as sugestões
para garantir que todos os critérios da atividade fossem atendidos.
*/
