#Primeiro exercício: Função para recerber um nome e retornar uma saudação personalizada.
def exercicio_1(nome,saudacao):
    return f"{saudacao}, {nome}!" if type(nome) is str and type(saudacao) is str and len(nome)>0 and len(saudacao)>0 else "Erro! Por favor, tente novamente com nomes válidos!"

#Segundo exercício: Calculadora para somar, subtrair, multiplicar e dividir 2 números.
def exercicio_2(num_1,num_2, op): #TODO: fazer mais personalizável ao usuário
    if op in ["+","-","*","/","^"]:
        return eval(str(num_1)+str(op).replace("^","**")+str(num_2)) if num_2!=0 else "Erro! Divisão por 0!"
    else:
        raise ValueError
#Terceiro exercício: Validar se uma nota está entre 0 e 10, retornando T/F
def exercicio_3(num):
    return True if 0<= num <=10  else False

