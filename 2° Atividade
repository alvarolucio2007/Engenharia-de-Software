#Aluno: Álvaro Lúcio Mousinho Coelho 18/08/2025
def simple_time_conversion(time):   return f"The converted time is {time//60} hours and {time%60} minutes."

def weighted_mean(g1,g2,g3,w1,w2,w3):   return f"The weighted mean of those numbers is {((g1*w1)+(g2*w2)+(g3*w3))/(w1+w2+w3)}"

def variable_switch(var_1,var_2):
    var_1=var_1-var_2 # original= a,b , target= b,a , var_1=a-b var_2=b -> a-b, b #ex: a=1, b=2 -> var_1=1-2 = -1, var_2=2
    var_2=var_2+var_1 #var_1=a-b, var_2= a-b+b=a -> a-b, a #ex: var_1=-1, var_2=-1+2 = 1 
    var_1=-var_1+var_2 #var_1=-(a+b)+a=b , var_2=a ->b,a #ex: var_1=-()
    return (var_1,var_2) 

import math as m
def bhaskara(a,b,c):
    delta=(b**2 - 4*a*c)
    if a!=0 and delta>=0:
        return (((-b+m.sqrt(delta))/2*a),((-b-m.sqrt(delta))/2*a))
    elif (b**2 - 4*a*c)<0:
        return (str(((-b+m.sqrt(-delta))/(2*a))))+"i",str(((-b-m.sqrt(-delta))/(2*a)))+"i"
    else:
        return "Equation can't be solved because a=0."
    
def unit_conversion(unit):  return f"{unit} meters is {unit/1000} kilometers, {unit*100} centimeters and {unit*1000} milimeters."

def number_inverted(number): #PS: me desculpe kkkkkkkkk
    number = ((number//100)/10 + (number%100)//10 +(number%10)*10 )*10 
    if number<10: #Botar 0 à esquerda, se o número for menor que 10 (ex: 7->007, retorna string.)
        return "00"+str(number)
    elif number<100 and number>10: #Mesma coisa de antes, mas menor que 100 (ex: 76->076, retorna string.)
        return "0"+str(number)
    else:
        return number
#original= abc, target=cba, number= (a/10 (0.a))(centena->unidade) + (bc*10//10 (b))(dezena->dezena)  + (c*10 (c0))(unidade->centena), ou seja: o número ficou cb.a, que multiplicado por 10 fica cba, ou seja, o inverso de abc.

def simple_interest_calculation(P,i,t):
    interest= P*i*t #T is monthly

    return f"The final value is {P+interest}"
