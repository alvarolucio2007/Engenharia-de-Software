
import customtkinter as ctk #importar o q faz janelas
import math as m
janela=ctk.CTk() #Declarar a janela
janela.geometry("400x500")#Dimensões da janela
janela.title("Calculadora")
ctk.set_appearance_mode("dark") #Cores
ctk.set_default_color_theme("blue")
def atualizar_display(valor):
    display_var.set(display_var.get() + valor)
#Notas para si: var.set(a) é mandar a var virar um valor a, var.get() é pegar o valor da var.
def calcular():
    try:
        resultado = eval(display_var.get()) # Usando eval para calcular
        display_var.set(str(resultado)) # Atualiza o display
    except Exception as e:
        display_var.set("Erro") # Se houver erro na expressão, mostra "Erro"
def limpar():
    display_var.set("")
display_var= ctk.StringVar() #Variável ligada ao label
display_label=ctk.CTkLabel(janela, textvariable=display_var, font=("Arial",24), anchor="e", width=300, height=50)
display_label.grid(row=0,column=0,columnspan=4,padx=10,pady=20)
#Declarando os botões
botao_1 = ctk.CTkButton(janela,text="1",width=60,height=60, command=lambda: atualizar_display("1"))
botao_2 = ctk.CTkButton(janela,text="2",width=60,height=60, command=lambda: atualizar_display("2"))
botao_3 = ctk.CTkButton(janela,text="3",width=60,height=60, command=lambda: atualizar_display("3"))
botao_4 = ctk.CTkButton(janela,text="4",width=60,height=60, command=lambda: atualizar_display("4"))
botao_5 = ctk.CTkButton(janela,text="5",width=60,height=60, command=lambda: atualizar_display("5"))
botao_6 = ctk.CTkButton(janela,text="6",width=60,height=60, command=lambda: atualizar_display("6"))
botao_7 = ctk.CTkButton(janela,text="7",width=60,height=60, command=lambda: atualizar_display("7"))
botao_8 = ctk.CTkButton(janela,text="8",width=60,height=60, command=lambda: atualizar_display("8"))
botao_9 = ctk.CTkButton(janela,text="9",width=60,height=60, command=lambda: atualizar_display("9"))
botao_0 = ctk.CTkButton(janela,text="0",width=60,height=60, command=lambda: atualizar_display("0"))
botao_adi = ctk.CTkButton(janela,text="+",width=60,height=60, command=lambda: atualizar_display("+"))
botao_sub = ctk.CTkButton(janela,text="-",width=60,height=60, command=lambda: atualizar_display("-"))
botao_mul = ctk.CTkButton(janela,text="*",width=60,height=60, command=lambda: atualizar_display("*"))
botao_div = ctk.CTkButton(janela,text="/",width=60,height=60, command=lambda: atualizar_display("/"))
botao_exp = ctk.CTkButton(janela,text="**",width=60,height=60, command=lambda: atualizar_display("**"))
botao_pi = ctk.CTkButton(janela,text="π",width=60,height=60, command=lambda: atualizar_display(str(m.pi)))
botao_e = ctk.CTkButton(janela,text="e",width=60,height=60, command=lambda: atualizar_display(str(m.e) ))
botao_calc = ctk.CTkButton(janela,text="=",width=60,height=60, command=(calcular))
botao_lim = ctk.CTkButton(janela,text="C",width=60,height=60, command=limpar)


#Organizando os botões
botao_1.grid(row=1, column=0, padx=5, pady=5)
botao_2.grid(row=1, column=1, padx=5, pady=5)
botao_3.grid(row=1, column=2, padx=5, pady=5)
botao_4.grid(row=2, column=0, padx=5, pady=5)
botao_5.grid(row=2, column=1, padx=5, pady=5)
botao_6.grid(row=2, column=2, padx=5, pady=5)
botao_7.grid(row=3, column=0, padx=5, pady=5)
botao_8.grid(row=3, column=1, padx=5, pady=5)
botao_9.grid(row=3, column=2, padx=5, pady=5)
botao_0.grid(row=4, column=1, padx=5, pady=5)
botao_adi.grid(row=1, column=3, padx=5, pady=5)
botao_sub.grid(row=2, column=3, padx=5, pady=5)
botao_mul.grid(row=3, column=3, padx=5, pady=5)
botao_div.grid(row=4, column=3, padx=5, pady=5)
botao_exp.grid(row=1, column=5, padx=5, pady=5)
botao_pi.grid(row=2, column=5, padx=5,pady=5)
botao_e.grid(row=3, column=5, padx=5, pady=5)
botao_calc.grid(row=4, column=2, padx=5, pady=5)
botao_lim.grid(row=4, column=0, padx=5, pady=5)
janela.mainloop()