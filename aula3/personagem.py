class Personagem:
    def __init__(self, nome: str, vida: int, nivel: int):
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

    def __str__(self):
        return f"Personagem(nome='{self.nome}', vida={self.vida}, nivel={self.nivel})"


if __name__ == "__main__":
    print("--- TESTES COM VALORES VÁLIDOS ---")
    try:
        p1 = Personagem("Aragorn", 100, 1)
        print(f"Criado com sucesso: {p1}")

        p1.vida = 85
        p1.nivel = 5
        print(f"Após alterações válidas: {p1}")
    except ValueError as e:
        print(e)

    print("\n--- TESTES COM VALORES INVÁLIDOS ---")
    
    try:
        p_invalido = Personagem("", 50, 1)
    except ValueError as e:
        print(f"[Falha esperada] {e}")

    try:
        p1.vida = 150
    except ValueError as e:
        print(f"[Falha esperada] {e}")

    try:
        p1.vida = -10
    except ValueError as e:
        print(f"[Falha esperada] {e}")

    try:
        p1.nivel = 0
    except ValueError as e:
        print(f"[Falha esperada] {e}")