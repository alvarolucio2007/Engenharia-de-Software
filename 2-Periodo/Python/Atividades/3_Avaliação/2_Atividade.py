#Tratamento de Erros

# 1) Mensagem de erro se usuário não escrever um número
def primeira_questao(entrada:int) -> int|None:
    try:
        entrada_int=int(entrada)
        return 2*entrada_int
    except ValueError:
        print(f"Inválido! é {type(entrada)} ")
        
# 2) Divisão, ZeroDivisionError+ValueError

def segunda_questao(numerador:float,denominador:float) -> float|None:
    try:
        return numerador/denominador
    except ValueError:
        print("Inválido, ambos precisam ser floats.")
    except ZeroDivisionError:
        print("Inválido, não se pode dividir por 0.")
    
# 3) IndexError, ValueError

def terceira_questao(indice:int) -> int|None:
    lista=[10,20,30,40,50]
    try:
        return lista[indice]
    except ValueError:
        print("É necessário q seja número inteiro!")
    except IndexError:
        print("É necessário que esteja entre 0 e 4!")

# 4) KeyError

def quarta_questao(chave:str) ->str|int|None:
    dicionario={'nome':'João','idade':25,'cidade':'São Paulo'}
    try:        
        return dicionario[chave.lower()]
    except KeyError:
        print("Inválido! Por favor, digite 'nome','idade', ou 'cidade'!")

# 5) FileNotFoundError JSON kk

def quinta_questao(nome_json:str)->None:
    JSON_PATH="2-Periodo/Python/Atividades/3_Avaliação/"+nome_json
    try:
        with open(JSON_PATH,"r"):
                print("Arquivo aberto com sucesso!")
    except FileNotFoundError:
        print("Arquivo não encontrado!")
    finally:
        print("Encerrando...")

# 6) Solicitar número de 1 a 100, perguntar até o usuario dar um numero válido. etc etc etc
def sexta_questao(numero: int) -> None :
    while True:
        try:
            if 1<numero<100:
                print(f"Número Válido! O número é {numero}")
                break
            else:
                print(f"Número inválido! O número é {numero}")
                numero=int(input("Qual seria o novo número?"))
        except ValueError:
            print("Por favor, insira apenas inteiros!")

# 7) Solicitar 2 numeros, converter pra inteiro, calcular ssmd, exception e finally.
def setima_questao(numero_1:int,numero_2:int) -> None:
    try:
        print(int(numero_1)+int(numero_2))
        print(int(numero_1)-int(numero_2))
        print(int(numero_1)*int(numero_2))
        print(int(numero_1)/int(numero_2))
    except ValueError:
        print("Por favor, insira apenas números inteiros!")
    except ZeroDivisionError:
        print("O número 2 não pode ser igual a 0! ")
    finally:
        print("Encerrando programa...")

# 8) Lista com valor int,float e str, tentar converter cada elemento pra int, e exibindo o resolltado pra cada.
def oitava_questao() -> None:
    lista=['10','abc','20','30.5','40']
    lista_conv=[]
    for i in range(len(lista)):
        try:
            lista_conv.append(int(lista[i]))
        except ValueError:
            print(f"Elemento {lista[i]} não é int!")
            lista_conv.append(lista[i])
    print(lista_conv)
    print(f"{sum(1 for d in lista_conv if isinstance(d,int))} números foram convertidos com sucesso!")
# 9) raiz quadrada, try,except, finally
def nona_questao(numero:int) -> None:
    try:
        if numero<0:
            print("Não é possível calcular raiz real de número negativo!")
        else:
            print(int(numero)**0.5)
    except ValueError:
        print("Por favor, insira apenas números inteiros!")
    finally:
        print("Encerrando programa...")

# 10) validar e-mail
def decima_questao(email:str) -> None:
    if not isinstance(email,str):
        print("Por favor, apenas insira strings!")
        return
    try:
        arroba_pos=str.find(email,"@")
        ponto_pos=str.find(email,".")
        if arroba_pos==-1 or ponto_pos==-1:
            raise ValueError("O e-mail deve conter '@' e '.'")
        if arroba_pos>=ponto_pos:
            raise ValueError("O '@' deve vir antes do '.'")
        if arroba_pos==0 or ponto_pos==len(email)-1:
            raise ValueError("E-mail não pode começar com '@' e terminar com '.'")
        print(f"E-mail {email} validado com sucesso!")
        
    except Exception:
        print("Erro interno, tente novamente.")
    finally:
        print("Validação Concluída")

# 11) nome,idade e salário, validar cada e etc.
def dec_primeira_questao(nome:str,idade:int,salario:float) -> None:
    try:
        if not isinstance(nome,str) or not nome:
            raise ValueError("Nome não é string, ou nome não dado!")
        if not isinstance(idade,int) or not idade or idade<0:
            raise ValueError("Idade não é int, ou idade não dada, ou idade é menor que 0!")
        if not isinstance(salario,float) or not salario or salario<0:
            raise ValueError("Salário não é float, ou salário não dado, ou salário é menor que 0!")
        print(f"Nome: {nome} \n Idade: {idade} \n Salário: {salario}")
    except Exception:
        print("Erro interno, tente novamente")
    finally:
        print("Programa concluído.")

# 12) Calculadora, já feito kk
# 13) Validação de senha: conter no minimo uma maiuscula, uma minuscula e um número

def dec_terceira_questao(senha:str) -> bool|None:
    try:
        if len(senha)<8:
            raise ValueError("Senha precisa ter no mínimo 8 caracteres!")
        if not any(d for d in senha if d.isupper()):
            raise ValueError("Senha precisa ter no mínimo uma maiúscula!")
        if not any(d for d in senha if d.islower()):
            raise ValueError("Senha precisa ter no mínimo uma minúscula!")
        if not any(d for d in senha if d.isdigit()):
            raise ValueError("Senha precisa ter no mínimo um dígito!")
        return True
    except Exception:
        print("Erro interno! Tente novamente.")
    finally:
        print("Finalizando programa...")

print(dec_terceira_questao("1234567890"))