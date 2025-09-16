#Aluno: Álvaro Lúcio Mousinho Coelho 18/08/2025
def simple_time_conversion(time):
    if time<0 or type(time)!=int:
        raise ValueError
    return (time//60,time%60)

def weighted_mean(g1,g2,g3,w1,w2,w3):
    return ((g1*w1)+(g2*w2)+(g3*w3))/(w1+w2+w3)

def variable_switch(var_1,var_2):
    var_1=var_1-var_2 
    var_2=var_2+var_1 
    var_1=-var_1+var_2 
    return (var_1,var_2) 

import math as m
def bhaskara(a,b,c):
    delta=(b**2 - 4*a*c)    
    if a!=0 and delta>=0:
        return (((-b+m.sqrt(delta))/(2*a))),((-b-m.sqrt(delta))/(2*a)) #Real roots
    elif delta<0:  
        real_part=-b/(2*a)
        complex_part=(m.sqrt(-delta)/(2*a))
        return (complex(real_part,complex_part),complex(real_part,-complex_part)) #Imaginary roots
    else:
        if b!=0:
            return -c/b
        else:
            raise ValueError("Invalid equation! Doesn't have any variables!")
    
def unit_conversion(unit):
    return {"kilo":unit/1000,"centi":unit*100,"mili":unit*1000}

def number_inverted(number): #Original number: abc
    number_unit=number%10 # Will get c
    number_tens=(number%100)//10 # Will get b 
    number_hundreds=number//100 #Will get a
    inverted=(str(number_unit)+str(number_tens)+str(number_hundreds)) # Will do "c"+"b"+"a" -> "cba"
    return inverted

def simple_interest_calculation(P,i,t):
    i=i/100 if i>1 else i
    if P<=0 or t<0 or i<0:
        raise ValueError("All three numbers must be positive!")
    interest= P*i*t #T is monthly
    return P+interest
