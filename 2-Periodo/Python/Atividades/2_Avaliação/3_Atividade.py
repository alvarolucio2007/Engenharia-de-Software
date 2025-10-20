#1° Exercício: 
def exer_1():
    list_=[]
    for i in range(1,15,2): #vai de 1 a 15, passos 2 em 2, ou seja, 1, 3, 5, 7, 9 ...
        list_.append(i+1) #vai adicionar 1 a cada resultado, os deixando pares (1->2 , 3->4, assim por diante.)
    return list_

#2° Exercício: 
def exer_2(tuple_):
    list_tuple_ = []
    for values in tuple_:
        list_tuple_.append(2*values)
    return tuple(list_tuple_)

def exer_2_curto(tuple_):
    return tuple(v*2 for v in tuple_)

#3° Exercício:
def exer_3(dict_):
    frutas_vermelhas=[] #Lista vazia, já sabe
    for keys in dict_: #Pegar os indices (nomes das frutas)
        if dict_[keys].lower()=="vermelho" or  dict_[keys].lower()=="vermelha": #Checando se é "vermelho" ou "vermelha", o .lower() é para deixar a chave em minusculo
            frutas_vermelhas.append(keys)
    return frutas_vermelhas

print(exer_3({"Banana":"Amarela","Maçã":"Vermelha"}))
def exer_3_curto(dict_):
    return [k for k,v in dict_.items() if v.lower()=="vermelho" or v.lower()=="vermelha"]
#4° Exercício:
def exer_4(*lists): #*args, pode colocar quantos valores quiser, mas que sejam do mesmo tipo.
    final_set=set(lists[0]) #Cria o primeiro set, que possui apenas a primeira lista
    for i in range(1,len(lists)):
            final_set=final_set&set(lists[i]) #Transforma o final_set na intercessão entre final_set e do segundo set, que é o das listas
    return final_set
        
def exer_4_curto(*lists):
    return set.intersection(*map(set, lists)) #N to com paciencia pra explicar esse kkkkkkkk claude.ai fez ele, mas o de cima fui eu
        
#5° Exercício:
def exer_5(upper_limit): 
    count=1 #Começar com 1
    while count<=upper_limit:
        print(count) #Imprimir
        count+=1 #Incrementar

#6° Exercício: 
def exer_6(list_):
    return list(len(list_[i]) for i in range(len(list_))) #Cria uma lista cujos componentes são [len(lista[1]),len(lista[2]), ...], etc, vale pra qualquer tamanho.

#7° Exercício:
def exer_7(dict_):
    return sum(dict_.values()) #Retorna a soma dos valores do dicionário

#8° Exercício:
def exer_8(tuple_):
    list_=list(tuple_) #Cria a lista, mutável
    list_.pop() #Retira o último elemento
    return list_ #Retorna

#9° Exercício:
def exer_9(list_):
    return list(i for i in list_ if i>5) #Retorna uma lista, com todos os números maiores que 5, incluidos na lista

#10° Exercício:
def exer_10(upper_limit):
    list_=[] #Lista vazia, pra armazenar os valores
    for i in range(0,upper_limit+1,3):
        list_.append(i)
    list_.remove(0)
    return list_

#11° Exercício:
def exer_11(list_1,list_2):
    return (set(list_1)-set(list_2),set(list_2)-set(list_1))

#12° Exercício:
def exer_12(text):
    return set(list(d for d in text.lower() if d in ["a","e","i","o","u"]))

#13° Exercício: A diferença é que a lista é mutável, e a tupla não.
def exer_13(list_,tuple_):
    list_[0]=3 #Exemplo aleatório
    #tuple_[0]=5 #Gerará TypeError 

#14° Exercício: Não, falso.

#15° Exercício: IndexError 
def exer_15(list_):
    return list_[len(list_)+1] #Gerará IndexError

#16° Exercício: Com o método del[chave]
def exer_16(dict_):
    del dict_[list(dict_.keys())[0]]

#17° Exercício:0, 1 , 4
def exer_17():
    for i in range(3):
        print(i*i)

#18° Exercício: Falso, explicado na 13°

#19° Exercício: Faltam os dois pointos (:)
def exer_19(): #Código Corrigido
    for i in range(5):
        print(i)

#20° Exercício: Acontece IndexError, pois está fora do índice da lista (0,1,2)
def exer_20():
    list_=[1,2,3]
    return list_[3]

#21° Exercício: Imprime {1,2,3}, pois o set não aceita valores repetidos
def exer_21():
    set_=set([1,2,2,3,3,3])
    return(set_)

#22° Exercício: O dicionário possui a mesma chave para 2 valores diferentes.

#23° Exercício: Falso, o break quebra o loop.

#24° Exercício: Não se pode editar tuplas.
def exer_24_errado():
    tuple_=(1,2,3)
    #tuple_(0)=5 #Gerar-se-á erro

def exer_24_certo():
    tuple_,list_tuple_=(1,2,3),list(tuple_)
    list_tuple_[0]=5
    tuple_=tuple(list_tuple_)
    return tuple_

#25° Exercício:
def exer_25(list_):
    list_.append("Banana")
    list_.append("Blueberry")
    return list_

#26° Exercício:
def exer_26(list_):
    list_.pop()
    list_.pop()
    return list_

#27° Exercício:
def exer_27(list_):
    empty_dict=dict()
    for i in range(len(list_)):
        empty_dict[list_[i]]=i
    return empty_dict

#28° Exercício:
def exer_28(list_,list_2):
    return list(set(list_)+set(list_2))

#29° Exercício:
def exer_29(set_):
    set_.add("d")
    set_.add("e")
    return set_


def exer_prova():
    caminhao=[]
    while True:
        sair=input("Deseja adicionar um item ao caminhão? (s/n): ").lower()
        if sair=="n":
            break
        while True:
            try:
                item=float(input("Digite o peso do item a ser adicionado (kg): "))
                break
            except ValueError:
                print("Valor inválido. Por favor, insira um número.")
        if item+sum(caminhao)<=1000:
            caminhao.append(item)
            print(f"Item de {item} kg adicionado ao caminhão.")
        else:
            print("Capacidade máxima do caminhão atingida. Não é possível adicionar mais itens.")
            break
    print(f"Peso total no caminhão: {sum(caminhao)} kg, peso restante: {1000 - sum(caminhao)} kg")
    print(f"Itens no caminhão: {caminhao}")
    return caminhao
exer_prova()