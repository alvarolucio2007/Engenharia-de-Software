#Questão 1
def saudar() -> None:
    print("Bem-vindo ao módulo de funções em Python!")
#Questão 2
def dobrar_numero(numero:int) -> int: 
    return 2*numero
#Questão 3
def eh_inteiro(numero:int) -> bool:
    return isinstance(numero,int)
#Questão 4
def calcular_preco_final(preco:float,desconto:float = 0.1) -> float:
    return preco*(1-desconto)
#Questão 5: Dentro da função, x será 10, mas fora, será 50.

#Questão 6
def contar_pares(lista:list) -> int :
    return len([d for d in lista if d%2==0])
