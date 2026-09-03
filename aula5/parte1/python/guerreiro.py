from personagem import Personagem


class Guerreiro(Personagem):
    def __init__(self, nome: str, vida: int, nivel: int):
        super().__init__(nome, vida, nivel)
        self.defesa = 5

    @property
    def defesa(self) -> int:
        return self._defesa

    @defesa.setter
    def defesa(self, valor: int) -> None:
        if valor < 0:
            raise ValueError("A defesa não pode ser negativa.")
        self._defesa = valor

    def receber_dano(self, dano: int) -> None:
        dano_efetivo = max(0, dano - self._defesa)
        print(f"{self.nome} bloqueia parte do dano com a defesa ({self._defesa}). "
              f"Dano efetivo: {dano_efetivo}")
        super().receber_dano(dano_efetivo)

    def habilidade(self) -> str:
        return "escudo de aço"

    def ficha(self) -> None:
        super().ficha()
        print(f"Defesa: {self._defesa}")
