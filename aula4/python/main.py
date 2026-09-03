# Uso de IA:
# Ferramenta utilizada: Claude
# Usei o Claude para me ajudar a montar a estrutura inicial das classes
# e para explicar os conceitos de algumas coisa que eu nao entendia e no final para revisar o codigo.
# O que modificou ou validou manualmente: Validação de todas as regras de negócio, testes de execução 
# e ajustes nas validações dos atributos.


from item import Item
from mago import Mago
from guerreiro import Guerreiro

if __name__ == "__main__":
    print("======= Criando item =======")
    espada = Item("Espada de Aço", 3)
    print(f"Item criado: {espada}")

    print("\n======= Mago pega a espada =======")
    elara = Mago("Elara", 100, 1)
    elara.pegar(espada)
    elara.ficha()

    print("\n======= Guerreiro recebe dano (defesa reduz o dano) =======")
    bran = Guerreiro("Bran", 100, 1)
    bran.ficha()
    bran.receber_dano(8)
    print(f"Vida restante de Bran: {bran.vida} (esperado: 97)")
    bran.ficha()

    print("\n======= Tentando definir mana negativa no Mago =======")
    try:
        elara.mana = -10
    except ValueError as e:
        print(f"Erro ao definir mana=-10 -> {e}")
    print(f"Mana de Elara permanece: {elara.mana}")