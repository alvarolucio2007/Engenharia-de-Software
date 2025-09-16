#Aluno: Álvaro Lúcio Mousinho Coelho
#QUESTÃO 1: REFATORAÇÃO
first_number,second_number=10,20
if first_number>second_number:
    print("The first number is bigger.")
elif first_number==second_number:
    print("Both are equal.")
else:
    print("The second number is bigger")

#Questão 2:
def simple_calculator(first_number_calculator,second_number_calculator,operation):
    if operation in ["+","-","*","/"]:
        if operation=="+":
            return first_number_calculator+second_number_calculator
        elif operation=="-":
            return first_number_calculator-second_number_calculator
        elif operation=="*":
            return first_number_calculator*second_number_calculator
        else:
            if second_number_calculator!=0:
                return first_number_calculator/second_number_calculator
            else: 
                raise ZeroDivisionError

def passed_failed(*args):
    if max(args)>10 or min(args)<0:
        raise ValueError("Invalid notes!")
    mean=sum(args)/len(args)
    if mean>=7:
        return f"Passed, mean is {mean}"
    elif mean>=5:
        return f"Retake Test needed, mean is {mean}"
    else:
        return f"Failed, mean is {mean}"

def tension_resistance_current_menu():
    print(
        "*"*40 + "\n"
        + "CALCULATION OF ELECTRICAL VALUES\n"
        + "*"*40 + "\n"
        + "1. Tension (In Volts)\n"
        + "2. Resistance (In Ohms)\n"
        + "3. Current (In Amps)\n"
        + "*"*40 + "\n"
        + "Which value would you like to calculate? "
        )
    try:
        value=int(input(""))
        tension_resistance_current_menu(value)
    except ValueError:
        return("Please insert a valid number! (1, 2 or 3 )!")
def tension_resistance_current_logic(value):
    if value not in [1,2,3]:
        raise ValueError("Invalid input! Please insert either 1, or 2 or 3.")
    else:
    #U=R*I , R=U/I , I=U/R
        if value==1: #U
            resistance=float(input("What is the resistance?"))
            current=float(input("What is the current"))
            result=resistance*current
        elif value==2: #R
            tension=float(input("What is the tension?"))
            current=float(input("What is the current?"))
            result=tension/current
        else: #I
            tension=float(input("What is the tension?"))
            resistance=float(input("What is the resistance?"))
            result=tension/resistance
        return result
        

import math as m
def is_triangle(x1,x2,x3,y1,y2,y3): #A=(x1,y1),B=(x2,y2),C=(x3,y3)
    A=m.sqrt(((x2-x1)**2) + (y2-y1)**2 )
    B=m.sqrt(((x3-x2)**2) + (y3-y2)**2 )
    C=m.sqrt(((x3-x1)**2) + (y3-y1)**2 )
    if ((abs(B-C)<A) and (B+C>A)) and ((abs(A-C)<B) and (A+C>B)) and ((abs(A-B)<C) and (A+B>C)):
        if A!=B and A!=C and B!=C: 
            return "Scalene triangle"
        elif A==B==C: 
            return "Equilateral triangle"
        elif A==B or A==C or B==C: 
            return "Isosceles triangle"
    else: return "Triangle does not exist!"

def reverse_height(*args):
    return sorted(args)[::-1]

def logistics(distance, **kwargs):
    if kwargs.get("car"):
        return distance*5 +10
    if kwargs.get("motorcycle"):
        return distance*3.5 + 10
    if kwargs.get("bike"):
        return distance*2 +10
    
