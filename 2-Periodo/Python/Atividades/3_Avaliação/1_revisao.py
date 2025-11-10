def saudar() -> None:
    print("Bem-vindo ao módulo de funções em Python!")
    return
def dobrar_numero(numero:int) -> int: 
    dobro=int(2*numero)
    return dobro
def eh_inteiro(numero:int) -> bool:
    return isinstance(numero,int)

def calcular_preco_final(preco_original:float,*desconto:float) -> float|bool:
    if desconto and (desconto[0])<=100:
        desconto_produto_args:float=(preco_original*desconto[0]/100)
        return preco_original-desconto_produto_args
    elif desconto and len(desconto)!=1:
        return False
    else:
        desconto_produto:float=(preco_original*0.1)
        return preco_original-desconto_produto
print(calcular_preco_final(100,75)) 
