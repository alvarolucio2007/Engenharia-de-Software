#Nota: Para as questões com "peça",fiz uma função para forçar o usuário para oferecer valores válidos.
#Aluno: Álvaro Lúcio Mousinho Coelho

def secure_input(prompt):
    while True:
        try:
            return float(input(prompt))
        except ValueError:
            print("Error! Please enter a valid number!")

def is_even_bool(number): #Retorna True se for par, False se ímpar.
    return number%2==0

def division_rest(number_1,number_2): #Retorna o resto da divisão dos 2 números
    if number_2!=0:
        return number_1%number_2
    else:
        raise ZeroDivisionError

def is_positive_negative_zero_str(number): #Retorna se o número é 0, positivo ou negativo.
    if number!=0 and number<0:
        return "Number is negative!"
    elif number>0:
        return "Number is positive!"
    else:
        return "Number is 0 !"

def is_multiple(number_1,number_2): #Retorna True se o número 1 é multiplo do número 2.
    if number_1%number_2==0 and number_2!=0:
        return True
    elif number_2==0:
        raise ZeroDivisionError
    else:
        return False
        
    
def bigger_number(number_1,number_2): #Retorna qual o número maior, e também retorna se os números são iguais.
    if number_1!=number_2 and number_1>number_2:
        return number_1
    elif number_2>number_1:
        return number_2
    else:
        return None

user_first_number=secure_input("Which is the first number would you like to compare?")
user_second_number=secure_input("Which is the second number would you like to compare?")
print(bigger_number(user_first_number,user_second_number))
        

def double_triple(number): #Retorna o dobro e o triplo do número
    return (2*number,3*number)

def before_after(number): #Retorna o antecessor e o sucessor do número.
    return (number-1,number+1)

def rectangle_area(base,height): #Retorna a área do retângulo
    return base*height

def celsius_to_fahrenheit(temperature): #Retorna a temperatura em Fahrenheit
    return (9*temperature)/5 + 32


def simple_average(number_1,number_2,number_3,number_4): #Retorna a média simples sobre os 4 números.
    return (number_1+number_2+number_3+number_4)/4
