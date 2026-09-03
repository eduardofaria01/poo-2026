# Uso de IA:
# Usei o Claude pra me ajudar a evoluir a classe Personagem pra abstrata,
# criar o atacar(alvo) que faltava (as versões anteriores só simulavam
# ataque sem alvo real) e montar a classe Chefe. Depois de gerado, rodei
# o programa pra conferir a saída no console: validei que Personagem não
# pode mais ser instanciada diretamente (TypeError), que a vida do Chefe
# realmente cai a cada ataque recebido (200 -> 190 -> 180, já que Elara e
# Bran causam 10 de dano cada), e que o trecho com isinstance fora do
# laço só afeta os Magos, sem quebrar o restante da lista.

from personagem import Personagem
from mago import Mago
from guerreiro import Guerreiro
from chefe import Chefe

if __name__ == "__main__":
    # Tentar instanciar Personagem diretamente agora lança TypeError,
    # pois ela é abstrata (tem um @abstractmethod não implementado):
    try:
        Personagem("Zé", 100, 1)
    except TypeError as e:
        print(f"Erro esperado ao tentar instanciar Personagem diretamente: {e}")

    herois = [
        Mago("Elara", 100, 1),
        Guerreiro("Bran", 100, 1),
    ]

    rei_lich = Chefe("Rei Lich")

    print("\n======= Ficha do Chefe antes da batalha =======")
    rei_lich.ficha()

    print("\n======= Batalha final =======")
    # Um único laço, sem isinstance: cada herói mostra a própria ficha, a
    # própria habilidade e ataca o mesmo alvo — o polimorfismo decide qual
    # versão de ficha()/habilidade()/receber_dano() é chamada em cada caso.
    for heroi in herois:
        heroi.ficha()
        print(f"{heroi.nome} usa {heroi.habilidade()}")
        heroi.atacar(rei_lich)
        print("--------------------------------")

    print("\n======= Ficha do Chefe depois da batalha =======")
    rei_lich.ficha()

    # Exercício 5 — isinstance com moderação, FORA do laço da batalha.
    # Aqui eu preciso especificamente da mana, um dado que só existe em
    # Mago — não faz sentido subir isso para a superclasse Personagem só
    # para atender esse caso pontual, e usar isinstance aqui não quebra o
    # polimorfismo do combate (que continua tratando todos os heróis de
    # forma uniforme lá em cima). Se eu tivesse colocado esse isinstance
    # dentro do laço da batalha, perderia a vantagem do polimorfismo e
    # teria que criar um "if" para cada tipo de personagem sempre que uma
    # nova subclasse aparecesse.
    print("\n======= Mana dos magos da lista (fora do laço da batalha) =======")
    for p in herois:
        if isinstance(p, Mago):
            print(f"{p.nome} ainda tem {p.mana} de mana.")

# Autoavaliação:
# Personagem agora é abstrata (ABC) com habilidade() abstrato
# (exercício 1); Mago e Guerreiro implementam habilidade() (exercício 2);
# Chefe herda de Personagem com vida/nível fixos e ficha() com o
# indicador [CHEFE] (exercício 3); a batalha final percorre uma lista com
# Mago e Guerreiro em um único laço, sem isinstance, mostrando ficha,
# habilidade e ataque real contra o Chefe, cuja vida cai de 200 para 180
# ao final (exercício 4); o uso opcional de isinstance pra mostrar a mana
# dos magos foi feito fora do laço principal, com comentário explicando o
# motivo (exercício 5).
