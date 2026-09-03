class Item:
    def __init__(self, nome: str, bonus: int):
        if nome is None or not nome.strip():
            raise ValueError("O nome do item não pode ser vazio.")
        if bonus < 0:
            raise ValueError("O bônus não pode ser negativo.")
        self._nome = nome
        self._bonus = bonus

    @property
    def nome(self) -> str:
        return self._nome

    @property
    def bonus(self) -> int:
        return self._bonus

    def __str__(self) -> str:
        return f"{self._nome} (+{self._bonus})"