#Questão 1: Calculadora de IMC
def calcular_imc(peso,altura):
    imc=peso/altura**2
    if imc<=17:
        return f"Muito abaixo do peso! IMC= {imc}"
    elif imc<=18.49:
        return f"Abaixo do peso! IMC={imc}"
    elif imc<=24.99:
        return f"Peso normal! IMC={imc}"
    elif imc<=29.99:
        return f"Acima do peso! IMC={imc}"
    elif imc<=34.99:
        return f"Obesidade I! IMC={imc}"
    elif imc <=39.99:
        return f"Obesidade II (severa)! IMC={imc}"
    else:
        return f"Obesidade III (mórbida)! IMC={imc}"

#Conversor de temperatura bem simples de C pra F
def converter_temperatura(celsius):
    return (celsius *1.8)+32
print(converter_temperatura(25))

#Verificação de números primos pythonico.
def verificar_primo(numero):
    return not any(x for x in range(2,numero) if numero%x==0)
print(verificar_primo(2))