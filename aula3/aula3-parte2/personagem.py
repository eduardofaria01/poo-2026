class Personagem:
    def __init__(self, nome: str = "Sem nome", vida: int = 100, nivel: int = 1):
        self.nome = nome
        self.vida = vida
        self.nivel = nivel

    @property
    def nome(self) -> str:
        return self._nome

    @nome.setter
    def nome(self, valor: str):
        if not isinstance(valor, str) or not valor.strip():
            raise ValueError("Erro: O nome não pode ser vazio.")
        self._nome = valor.strip()

    @property
    def vida(self) -> int:
        return self._vida

    @vida.setter
    def vida(self, valor: int):
        if not isinstance(valor, int) or not (0 <= valor <= 100):
            raise ValueError("Erro: A vida deve ser um número inteiro entre 0 e 100.")
        self._vida = valor

    @property
    def nivel(self) -> int:
        return self._nivel

    @nivel.setter
    def nivel(self, valor: int):
        if not isinstance(valor, int) or valor < 1:
            raise ValueError("Erro: O nível deve ser um número inteiro maior ou igual a 1.")
        self._nivel = valor

    def atacar(self, dano: int = None):
        if dano is None:
            print(f"{self.nome} realizou um ataque básico!")
        elif isinstance(dano, int) and dano > 0:
            print(f"{self.nome} atacou causando {dano} de dano!")
        else:
            print("Erro: O dano do ataque deve ser um inteiro maior que 0.")

    def __str__(self):
        return f"Personagem(nome='{self.nome}', vida={self.vida}, nivel={self.nivel})"


if __name__ == "__main__":
    p1 = Personagem()
    p2 = Personagem("Geralt", 90, 5)

    print("--- Testando Construtores ---")
    print(f"P1 (Padrão): {p1}")
    print(f"P2 (Parametrizado): {p2}")

    print("\n--- Testando Ataques do Personagem 1 ---")
    p1.atacar()
    p1.atacar(15)

    print("\n--- Testando Ataques do Personagem 2 ---")
    p2.atacar()
    p2.atacar(40)