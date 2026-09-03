from abc import ABC, abstractmethod

from item import Item


class Personagem(ABC):
    DANO_PADRAO = 10

    def __init__(self, nome: str, vida: int, nivel: int):
        self.nome = nome    # usa os setters (via @property) para validar
        self.vida = vida
        self.nivel = nivel
        self._inventario = []

    # ---------- nome ----------
    @property
    def nome(self) -> str:
        return self._nome

    @nome.setter
    def nome(self, valor: str) -> None:
        if valor is None or not valor.strip():
            raise ValueError("O nome não pode ser vazio.")
        self._nome = valor

    # ---------- vida ----------
    @property
    def vida(self) -> int:
        return self._vida

    @vida.setter
    def vida(self, valor: int) -> None:
        # limite ampliado para 200 para acomodar a vida fixa do Chefe (200)
        if valor < 0 or valor > 200:
            raise ValueError("A vida deve estar entre 0 e 200.")
        self._vida = valor

    # ---------- nivel ----------
    @property
    def nivel(self) -> int:
        return self._nivel

    @nivel.setter
    def nivel(self, valor: int) -> None:
        if valor < 1:
            raise ValueError("O nível deve ser no mínimo 1.")
        self._nivel = valor

    # ---------- inventário ----------
    @property
    def inventario(self) -> list:
        return self._inventario

    def pegar(self, item: Item) -> None:
        if item is None:
            raise ValueError("Item inválido.")
        self._inventario.append(item)

    # ---------- combate ----------
    def receber_dano(self, dano: int) -> None:
        nova_vida = self._vida - dano
        if nova_vida < 0:
            nova_vida = 0
        self.vida = nova_vida

    def esta_vivo(self) -> bool:
        return self._vida > 0

    def atacar(self, alvo: "Personagem" = None, dano: int = None) -> None:
        """
        Sem alvo: ataque padrão/ilustrativo, sem afetar ninguém.
        Com alvo: ataque real, chamando receber_dano() no alvo.
        """
        if alvo is None:
            if dano is None:
                dano = Personagem.DANO_PADRAO
            if dano < 0:
                raise ValueError("O dano não pode ser negativo.")
            print(f"{self._nome} ataca causando {dano} de dano!")
            return

        print(f"{self._nome} ataca {alvo.nome} causando {Personagem.DANO_PADRAO} de dano!")
        alvo.receber_dano(Personagem.DANO_PADRAO)

    # Cada subclasse concreta define sua própria habilidade
    @abstractmethod
    def habilidade(self) -> str:
        ...

    def ficha(self) -> None:
        print("----- Ficha do Personagem -----")
        print(f"Nome:  {self._nome}")
        print(f"Vida:  {self._vida}")
        print(f"Nível: {self._nivel}")
        if not self._inventario:
            print("Itens:  (inventário vazio)")
        else:
            print("Itens:")
            for item in self._inventario:
                print(f"  - {item}")
        print("--------------------------------")
