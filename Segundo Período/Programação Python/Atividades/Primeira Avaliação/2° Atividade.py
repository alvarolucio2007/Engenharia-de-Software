#Aluno: Álvaro Lúcio Mousinho Coelho 18/08/2025
def simple_time_conversion(time):
    return (time//60,time%60)

def weighted_mean(g1,g2,g3,w1,w2,w3):
    return ((g1*w1)+(g2*w2)+(g3*w3))/(w1+w2+w3)

def variable_switch(var_1,var_2):
    var_1=var_1-var_2 # original= a,b , target= b,a , var_1=a-b var_2=b -> a-b, b #ex: a=1, b=2 -> var_1=1-2 = -1, var_2=2
    var_2=var_2+var_1 #var_1=a-b, var_2= a-b+b=a -> a-b, a #ex: var_1=-1, var_2=-1+2 = 1 
    var_1=-var_1+var_2 #var_1=-(a-b)+a=b , var_2=a ->b,a #ex: var_1=-(1-2)+1= 2, b=1
    return (var_1,var_2) 

import math as m
def bhaskara(a,b,c):
    delta=(b**2 - 4*a*c)
    if a!=0 and delta>=0:
        return ((str(((-b+m.sqrt(delta))/(2*a))),str(((-b-m.sqrt(delta))/(2*a))))) #Real roots
    elif delta<0:  
        return ((str(((-b+m.sqrt(-delta))/(2*a))))+"i",str(((-b-m.sqrt(-delta))/(2*a)))+"i") #Imaginary roots
    else:
        raise ZeroDivisionError
    
def unit_conversion(unit):  
    return (unit/1000,unit*100,unit*1000)

def number_inverted(number): #Original number: abc
    number_unit=number%10 # Will get c
    number_tens=(number%100)//10 # Will get b 
    number_hundreds=number//100 #Will get a
    inverted=(str(number_unit)+str(number_tens)+str(number_hundreds)) # Will do "c"+"b"+"a" -> "cba"
    return inverted

def simple_interest_calculation(P,i,t):
    interest= P*i*t #T is monthly

    return f"The final value is {P+interest}"
