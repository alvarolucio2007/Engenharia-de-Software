#1° Exercício: 
def exer_1():
    list_=[]
    for i in range(1,15,2): #vai de 1 a 15, passos 2 em 2, ou seja, 1, 3, 5, 7, 9 ...
        list_.append(i+1) #vai adicionar 1 a cada resultado, os deixando pares (1->2 , 3->4, assim por diante.)
    return list_

#2° Exercício: 
def exer_2(tuple_):
    list_tuple_=[] #Cria lista vazia, que irá ser transportada em tupla depois
    for values in tuple_: #Pega todos os valores da tupla, um por um
        list_tuple_.append(2*values) #Adiciona na lista no último espaço, multiplicado por 2
    return tuple(list_tuple_) #Retorna ao usuário

#3° Exercício:
def exer_3(dict_):
    frutas_vermelhas=[] #Lista vazia, já sabe
    for keys in dict_: #Pegar os indices (nomes das frutas)
        if dict_[keys].lower()=="vermelho" or  dict_[keys].lower()=="vermelha": #Checando se é "vermelho" ou "vermelha", o .lower() é para deixar a chave em minusculo
            frutas_vermelhas.append(keys)
    return frutas_vermelhas
    
#4° Exercício:
def exer_4(*lists): #*args, pode colocar quantos valores quiser, mas que sejam do mesmo tipo.
    final_set=set(lists[0]) #Cria o primeiro set, que possui apenas a primeira lista
    for i in range(1,len(lists)):
            final_set=final_set&set(lists[i]) #Transforma o final_set na intercessão entre final_set e do segundo set, que é o das listas
    return final_set
        
def exer_4_curto(*lists):
    return set.intersection(*map(set, lists)) #N to com paciencia pra explicar esse kkkkkkkk claude.ai fez ele, mas o de cima fui eu
        
print(exer_4_curto([1,2,3,4,5],[1,2,3,4],[1,2,3],[1,2,3],[1,2]))

