from personagem import Personagem


class Mago(Personagem):
    def __init__(self, nome: str, vida: int, nivel: int):
        super().__init__(nome, vida, nivel)
        self.mana = 50

    @property
    def mana(self) -> int:
        return self._mana

    @mana.setter
    def mana(self, valor: int) -> None:
        if valor < 0:
            raise ValueError("A mana não pode ser negativa.")
        self._mana = valor

    def habilidade(self) -> str:
        return "rajada arcana"

    def ficha(self) -> None:
        super().ficha()
        print(f"Mana:  {self._mana}")
