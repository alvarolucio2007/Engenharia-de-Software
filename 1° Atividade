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

def division_rest_str(number_1,number_2): #Retorna o resto da divisão dos 2 números
    return number_1%number_2 if number_2!=0 else "Division by 0 is forbidden!"

def is_positive_negative_zero_str(number): #Retorna se o número é 0, positivo ou negativo.
    if number!=0 and number<0:
        return "Number is negative!"
    elif number>0:
        return "Number is positive!"
    else:
        return "Number is 0 !"

def is_multiple_str(number_1,number_2): #Retorna True se o número 1 é multiplo do número 2.
    if number_1%number_2==0 and number_2!=0:
        return "The first number is a multiple of the second number."
    elif number_2==0:
        return "The second number is 0, therefore I can't divide by it"
    else:
        return "The first number is not a multiple of the second number."


user_first_number_multiple=secure_input("What is the first number?")
user_second_number_multiple=secure_input("What is the second number?")
print(is_multiple_str(user_first_number_multiple,user_second_number_multiple))
        
    
def bigger_number_str(number_1,number_2): #Retorna qual o número maior, e também retorna se os números são iguais.
    if number_1!=number_2 and number_1>number_2:
        return "Number 1 is bigger than number 2!"
    elif number_2>number_1:
        return "Number 2 is bigger than number 1!"
    else:
        return "The numbers are equal!"

user_first_number=secure_input("Which is the first number would you like to compare?")
user_second_number=secure_input("Which is the second number would you like to compare?")
print(bigger_number_str(user_first_number,user_second_number))
        

def double_triple_str(number): #Retorna o dobro e o triplo do número
    return f"The double of the number is {2*number}, and the triple is {3*number}"

def before_after_str(number): #Retorna o antecessor e o sucessor do número.
    return f"The number before {number} is {number-1}, and after is {number+1}."

def rectangle_area_str(base,height): #Retorna a área do retângulo
    return f"The area is {base*height}!"


user_base=secure_input("What is the base of the rectangle?")
user_height=secure_input("What is the height of the rectangle?")
print(rectangle_area_str(user_base,user_height))


def celsius_to_fahrenheit_str(temperature): #Retorna a temperatura em Fahrenheit
    return f"The temperature in Fahrenheit is {(9*temperature)/5 + 32}!"


user_temperature_celsius=secure_input("What is the temperature in celsius?")
print(celsius_to_fahrenheit_str(user_temperature_celsius))

def simple_average_str(number_1,number_2,number_3,number_4): #Retorna a média simples sobre os 4 números.
    return f"The average for the numbers is {(number_1+number_2+number_3+number_4)/4}"
