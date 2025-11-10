#Questão 1: Calculadora de IMC
def calcular_imc(peso:float | int ,altura: float | int) -> str:
    imc=peso/altura**2
    if imc<=17:
        return f"Muito abaixo do peso! IMC= {imc:.2f}"
    elif imc<=18.49:
        return f"Abaixo do peso! IMC={imc:.2f}"
    elif imc<=24.99:
        return f"Peso normal! IMC={imc:.2f}"
    elif imc<=29.99:
        return f"Acima do peso! IMC={imc:.2f}"
    elif imc<=34.99:
        return f"Obesidade I! IMC={imc:.2f}"
    elif imc <=39.99:
        return f"Obesidade II (severa)! IMC={imc:.2f}"
    else:
        return f"Obesidade III (mórbida)! IMC={imc:.2f}"

print(calcular_imc(70.5,1.5))
#Conversor de temperatura bem simples de C pra F
def converter_temperatura(celsius: float) -> float:
    return (celsius * 1.8) + 32
print(converter_temperatura(25))

#Verificação de números primos pythonico.
def verificar_primo(numero:int) -> bool | str:
    if numero<0:
        return "Números negativos não podem ser aceitos!"
    elif numero==0 or numero==1:
        return False
    import math
    return not any(numero % x == 0  for x in range(3,int(math.sqrt(numero)+1),2))
print(verificar_primo(1000000))