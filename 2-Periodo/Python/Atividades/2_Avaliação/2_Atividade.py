#Álvaro Lúcio Mousinho Coelho
#29/09/2025

#Exercício 1:
def exercise_1(list_supermarket):
    list_supermarket=["Milk","Cheese","Eggs","Butter","Bread"]
    list_supermarket.append("Carvão")
    list_supermarket.append("Picanha")
    list_supermarket.pop(1)
    return list_supermarket

#Exercício 2:
def exercise_2(tuple_ ):
    tuple_=("Monday","Tuesday","Wednesday","Thursday","Friday")
    tuple_[0]="Holiday" #Erro, tuplas são imutáveis.

#Exercício 3:
def exercise_3(movie):
    movie_title=input("What's the title of the movie?")
    movie_year=input("What's the year which the movie has been released?")
    movie_director=input("What's the director of the movie?")
    movie={"Title":movie_title, "Year":movie_year,"Director":movie_director}
    return movie["Year"]

#Exercício 4:
def exercise_4(list_):
    return set(list_)


#Exercício 5:
def exercise_5(list_of_dicts):
    return [list_of_dicts[d]["Name"] for d in range(len(list_of_dicts)) if list_of_dicts[d]["Score"]>=7]

#Exercício 6:
from collections import Counter
def exercise_6(phrase):
    return Counter(phrase)

#Exercício 7:
def exercise_7(work_friends,uni_friends):
    work_friends_set,uni_friends_set=set(work_friends),set(uni_friends)
    return [(work_friends_set | uni_friends_set) , (work_friends_set & uni_friends_set) , (work_friends_set - uni_friends_set)]

#Exercício 8:
def exercise_8(list_):
    list_sorted=sorted(list_)
    return(list_sorted[0],list_sorted[-1])

#Exercício 9:
def exercise_9(dict_): 
    while True:
        while True:
            answer=input("Would you like to use the program? (y/n)")
            if answer.lower()=="y":
                break
            elif answer.lower()=="n":
                return dict_
        try:
            while True:
                choice=int(input("Please choose whether you want to check or add something to the dictionary! (1=check, 2=add)"))
                if choice in [1,2]:
                    break
        except ValueError:
            print("Error! Please insert only numbers!")
        if choice==1:
            while True:
                try:
                    product=input("Which product would you like to check? (type exit to exit)")
                    if product.lower()=="exit":
                        break
                    print(dict_[product])
                except KeyError:
                    print("Please insert a valid product!")
        else:
            while True:
                product=input("Which product would you like to add? (type exit to exit)")
                if product.lower()=="exit":
                    break
                while True:
                    try:
                        price=float(input("What is its price?"))
                        if price <= 0:
                            print("Please insert positive values!")
                            continue
                        break
                    except ValueError:
                        print("Please insert only valid numbers!")
                dict_[product]=price

#Exercício 10:
def exercicio_10(list_):
    dict_ = {}
    for key, value in list_:
        if key in dict_:
            dict_[key] += value
        else:
            dict_[key] = value
    return dict_

#Exercício 11: Não tenho enunciado o suficiente.

#Exercício 12: Uma Tupla, pois é extremamente eficiente para o acesso,imutável, segura.

#Exercício 13: Um Set, que descarta todas as repetições, sendo extremamente eficiente.
def exercicio_13(list_):
    seen=[]
    set_list_=set(list_)
    for _ in range(len(list_)):
        list_indexes=[i for i, v in enumerate(list_) if v==list_[_]]
        if len(list_indexes)>1:
            seen.append(list_[_])
    return (set_list_,seen)

print(exercicio_13(['200.135.80.9', '192.168.1.1', '200.135.80.9', '192.168.1.1', '202.45.12.3']))

#Exercício 14: Um Set de Dicionários, sendo cada dicionário um livro em específico, com atributos como "ISBN","Título","Autor" e "Publicação", sendo complexidade O(1*1)=O(1)

def exercicio_14():
    pass