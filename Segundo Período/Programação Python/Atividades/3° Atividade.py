#Aluno: Álvaro Lúcio Mousinho Coelho
#QUESTÃO 1: REFATORAÇÃO
first_number,second_number=10,20
if first_number>second_number:print("The first number is bigger.")
elif first_number==second_number:print("Both are equal.")
else:print("The second number is bigger")

#Questão 2:
def simple_calculator(first_number_calculator,second_number_calculator,operation):
    try:
        if operation in ["+","-","/","*"]:return eval(str(first_number_calculator)+str(operation)+str(second_number_calculator))
        else: return False
    except Exception:
        return False
    
def passed_failed(*args):
    notes=args
    if max(notes)>10 or min(notes)<0 or len(notes)!=3: raise ValueError           
    mean=(notes[0]+notes[1]+notes[2])/3
    if mean>=7: return "Approved"
    elif mean>=5 and mean<7: return "Retake test needed"
    else: return "Failed."

def tension_resistance_current_menu():
    try:    
        value = int(input(
        "*"*40 + "\n"
        + "CALCULATION OF ELECTRICAL VALUES\n"
        + "*"*40 + "\n"
        + "1. Tension (In Volts)\n"
        + "2. Resistance (In Ohms)\n"
        + "3. Current (In Amps)\n"
        + "*"*40 + "\n"
        + "Which value would you like to calculate? "
        ))
        if str(value) not in ["1","2","3"]:
            raise ValueError
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
    except ValueError:
        print("Please insert valid numbers!")

import math as m
def is_triangle(x1,x2,x3,y1,y2,y3): #A=(x1,y1),B=(x2,y2),C=(x3,y3)
    A,B,C=m.sqrt(((x2-x1)**2) + (y2-y1)**2 ),m.sqrt(((x3-x2)**2) + (y3-y2)**2 ),m.sqrt(((x3-x1)**2) + (y3-y1)**2 )
    if ((abs(B-C)<A) and (B+C>A)) and ((abs(A-C)<B) and (A+C>B)) and ((abs(A-B)<C) and (A+B>C)):
        if A!=B and A!=C and B!=C: return "Scalene triangle"
        elif ((A==B) and (A!=C)) or ((A==C) and (A!=B)) or ((B==C) and (B!=A)): return "Isosceles triangle"
        elif A==B==C: return "Equilateral triangle"
    else: return "Triangle does not exist!"

def reverse_height(*args):
    return sorted(args)[::-1]
def logistics(distance, **kwargs):
    if kwargs.get("car"):
        return distance*5 +10
    if kwargs.get("motorcycle"):
        return distance*3,5 + 10
    if kwargs.get("bike"):
        return distance*2 +10
    
