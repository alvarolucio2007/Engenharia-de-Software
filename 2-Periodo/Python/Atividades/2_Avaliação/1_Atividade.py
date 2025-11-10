#Aluno: Álvaro Lúcio Mousinho Coelho
#Segundo Período Engenharia de Software
#Contagem Simples
from math import factorial, sqrt

def count_up(n):
    for i in range(n):
        print(i)

#Tabuada

def number_table(n):
    for i in range(11):
        print(i*n)

#Soma de 1 a N

def progression_sum(n):
    return (n/2)*(1+n)

#Contagem Regressiva

def countdown(limit):
    for i in range(limit,0,-1):
        print(i)

#Fatorial

def factorial_fuction(n):
    mult=1
    for i in range(1,n+1):
        mult*=i
    return mult

#Quantidade de dígitos

def digit_quantity(n):
    return len(str(abs(n)))

#Números Primos


def is_prime_fancy(n):
    return (factorial(n-1)+1)%n==0

#OU

def is_prime_normal(n):
    return len([d for d in range(1,n+1) if n%d==0])==2

#Sequencia de Fibonacci



def fib(n): #Fórmula de Binet
    sqrt5=sqrt(5)
    phi=(1+sqrt5)/2
    psi=(1-sqrt5)/2
    return round((1/sqrt(5))*(((phi)**n)-(psi**n)))

#Números Perfeitos
def is_perfect(n):
    return (sum(d for d in range(1,n) if n%d==0)==n)

#Progressão Aritmética
def gen_a_p(first,quantity,rate):
    return [first+d*rate for d in range(quantity)]

#Construindo o sistema de natação
def swimming_team_system(time_chart,name_chart):
    if min(time_chart)<0:
        raise ValueError("Please insert only positive values!")
    if len(time_chart)!=len(name_chart):
        raise ValueError("Please insert only the same length!")

    best_time=name_chart[time_chart.index(min(time_chart))]
    worst_time=name_chart[time_chart.index(max(time_chart))]
    mean_time=sum(time_chart)/len(time_chart)
    between_12_15=sum(1 for d in time_chart if 12<d<15)
    return {"Best time": best_time, "Worst time": worst_time, "Mean time": mean_time, "Quantity of swimmers between 12 and 15 seconds":between_12_15}

#Analisar uma pesquisa de opiniões

def research_with_graphs(age_chart,score_chart):
    satisfied_scores= [score for age, score in zip(age_chart,score_chart) if score>=4]
    mean_satisfied= sum(satisfied_scores)/len(satisfied_scores) if satisfied_scores else 0
    unsatisfied= len([d for d in score_chart if d<=2]) 
    unsatisfied_percentage= (unsatisfied/len(score_chart))*100
    general_mean=sum(score_chart)/len(score_chart)
    return {"Mean score of satisfied clients:":mean_satisfied,"Percentage of unsatisfied clients:":unsatisfied_percentage,"Average mean:":general_mean}
