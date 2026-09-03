from personagem import Personagem


class Chefe(Personagem):
    VIDA_FIXA = 200
    NIVEL_FIXO = 10

    def __init__(self, nome: str):
        super().__init__(nome, Chefe.VIDA_FIXA, Chefe.NIVEL_FIXO)
        self.forca = 20

    def habilidade(self) -> str:
        return "ataque devastador"

    def ficha(self) -> None:
        print(f"[CHEFE] {self.nome} (vida: {self.vida}, forca: {self.forca})")
