class Personagem:
    def __init__(self):
        self.nome = ""
        self.vida = 100
        self.forca = 10

    def receberDano(self, dano):
        self.vida -= dano

        print(
            self.nome,
            "sofreu",
            dano,
            "de dano."
        )

    def estaVivo(self):
        return self.vida > 0

    def ficha(self):
        return (
            self.nome
            + " (vida: "
            + str(self.vida)
            + ", força: "
            + str(self.forca)
            + ")"
        )

    def atacar(self, alvo):
        print(self.nome, "ataca", alvo.nome)
        alvo.receberDano(self.forca)


if __name__ == '__main__':
    heroi = Personagem()
    heroi.nome = "Herói"
    heroi.vida = 100
    heroi.forca = 20

    chefe = Personagem()
    chefe.nome = "Chefe"
    chefe.vida = 120
    chefe.forca = 15

    print("=== ANTES DA BATALHA ===")
    print(heroi.ficha())
    print(chefe.ficha())

    print("\n=== BATALHA ===")

    while heroi.estaVivo() and chefe.estaVivo():
        heroi.atacar(chefe)

        if chefe.estaVivo():
            chefe.atacar(heroi)

    print("\n=== DEPOIS DA BATALHA ===")
    print(heroi.ficha())
    print(chefe.ficha())

    if heroi.estaVivo():
        print("O herói venceu!")
    else:
        print("O chefe venceu!")