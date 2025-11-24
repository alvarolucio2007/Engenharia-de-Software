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
