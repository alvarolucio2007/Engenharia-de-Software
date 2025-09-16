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
        value=int(input(("*"*220 ,"\n","Calculation of electrical values \n".upper(),"*"*220, \n "1. Tension (In Volts) \n","2.Resistance (In Ohms) \n ","3.Current (In Amps)\n","*"*220,"\n","Which value would you like to calculate?")))
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

tension_resistance_current_menu()