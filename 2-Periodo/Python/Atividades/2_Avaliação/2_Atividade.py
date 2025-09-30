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
print(exercise_4([1,2,2,3,4,4,5,1]))

#Exercício 5:
def exercise_5(list_of_dicts):
    