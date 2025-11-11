# Nível 1:
#   1.1: Função Simples:
def saudar_usuario(nome: str) -> str:
    return f"Olá, {nome}! Bem vindo(a)!"


#   1.2: Função com Retorno:
def calcular_media(*args: float) -> float | str:
    if len([d for d in args if d<0 or d>10])!=0:
        return any(args) < 0
    else:
        return sum(args) / len(args)

#   1.3: Função booleana:
def eh_par(numero: int) -> bool:
    return numero % 2 == 0

# Nível 2:
#   2.1: Função com Validação
def calcular_imc(peso:float,altura:float)-> float|str:
    if peso<=0 or altura<=0:
        return "Valor(es) inválido(s)!"
    else:
        return peso/altura**2

#   2.2: Funçao com parâmetros padrões
def calcular_juros(valor_ini:float,taxa:float=5.0, meses:int=1) -> float:
    return valor_ini*(1+(taxa/100)*meses)

#   2.3: Função com args
def calcular_media_ponderada(*args:tuple[float,float]) -> float|str:
    if not args:
        return "Nenhuma nota fornecida"
    else:
        return sum(d[0]*d[1] for d in args)/sum(d[1] for d in args)

def analisar_notas(notas:dict[str,float]) -> dict[str,float|str]|str:
    if not notas:
        return "Nenhuma nota fornecida."
    else:
        
