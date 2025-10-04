import customtkinter as ctk
from PIL import Image
import variaveis as var
from janelas import *

class JogoDaVida(ctk.CTk):
    def __init__(self):
        self.pergunta_atual="1"
        super().__init__()
        self.geometry('1350x750')
        self.title('Jogo da Vida')
        self.resizable(False,False)

        #layout/ label-pergunta
        self.pergunta_label = ctk.CTkLabel(
            self, text="", font=("Consolas",25), text_color="white"
        )
        imagem_personagem = ctk.CTkImage(Image.open("Engenharia-de-Software/2-Periodo/Educacao_Socio_Emocional/imagens/chaves.png"),size=(200,300))
        imagem_label = ctk.CTkLabel(self,image=imagem_personagem,text='')
        imagem_label.pack(pady=60)

        #frame dos butões de pergunta
        butao_frame = ButaoFrame(self,larg=1000,alt=300)
        col = 0 
        for k,v in var.dados['perguntas'][self.pergunta_atual]['respostas'].items():
            Butao(butao_frame,fg='green',font=('consolas',20),text=k,func=lambda:self.passar_valores(v),col=col)
            col += 1

    def passar_valores(self,valor):
        print(valor)
        self.pergunta_atual=str(int(self.pergunta_atual)+1)


if __name__ == '__main__':
    jogo = JogoDaVida()
    jogo.mainloop()