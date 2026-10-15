import redis
from supabase import Client, create_client

r = redis.Redis(host="localhost", port=6379)
print(r.ping())
url = ""
key = ""

# supabase = create_client(url, key)


def cadastrar_redis(chave: str, dado: str) -> bool:
    return bool(r.set(chave, dado))


def ler_redis(chave: str) -> str:
    return str(r.get(chave))


def excluir_redis(chave: str) -> int:
    return r.delete(chave)


while True:
    print("\n===== Crud Alunos=====")
    print("1 - Cadastrar")
    print("2 - Listar")
    print("3 - Consultar por ID")
    print("4 - Atualizar")
    print("5 - Excluir")
    print("6 - Sair")
    opcao = input("Escolha uma opção: ")
    if opcao == "1":
        print("Tela de Cadastro")
        chave = input("Qual a chave?")
        valor = input("Qual o valor?")
        if cadastrar_redis(chave, valor):
            print("Cadastrado com sucesso!")
        else:
            print("Não foi cadastrado com sucesso.")
    elif opcao == "2":
        print("Tela de Listagem")

    elif opcao == "3":
        print("Tela de Consultar")

        chave = input("Qual a chave?")
        print(ler_redis(chave))
    elif opcao == "4":
        print("Tela de Atualizar")
        chave = input("Qual a chave?")
        valor = input("Qual o valor?")
        if cadastrar_redis(chave, valor):
            print("Atualizado/Cadastrado com sucesso!")
        else:
            print("Não foi atualizado/cadastrado com sucesso.")
    elif opcao == "5":
        print("Tela de Excluir")
        chave = input("Qual a chave?")
        print(excluir_redis(chave) == 1)
    elif opcao == "6":
        print("Saindo....")
        break
    else:
        print("Opcao invalida")
