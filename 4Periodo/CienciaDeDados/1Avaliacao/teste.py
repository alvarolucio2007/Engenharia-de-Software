# OBJETIVOS: Carregar dataset, Inspecionar head info e describe, verificar nulos e corrigir, criar 2 graficos e salvar o arquivo modificado.
import pandas as pd

FILE_PATH = "aula3_base_problema.csv"
df = pd.read_csv(FILE_PATH)


def separador() -> None:
    print(60 * "=")


separador()
print("DATASET ORIGINAL:")
separador()
print(f"Shape: {df.shape}")
print(f"\nHEAD:\n{df.head()}")
print("\nINFO:")
df.info()
print(f"\nDESCRIBE:\n{df.describe(include='all')}")
print(f"\nNULOS ANTES:\n{df.isnull().sum()}")
separador()
print("CORRIGINDO NULOS")
separador()
df_limpo = df.copy()
df_limpo = df_limpo.dropna(subset=["ID"])
colunas_categorias = ["Nome", "Cidade", "Gênero", "Produto"]
for coluna in colunas_categorias:
    df_limpo[coluna] = df_limpo[coluna].fillna("Desconhecido")
colunas_numericas = [
    "Idade",
    "Quantidade",
    "Preço_Unitário",
    "Valor_Total",
    "Satisfação",
]
for coluna in colunas_numericas:
    df_limpo[coluna] = df_limpo[coluna].fillna(0)
print(f"\nNULOS DEPOIS:\n{df_limpo.isnull().sum()}")
print(f"\nShape antes: {df.shape}")
print(f"Shape depois: {df_limpo.shape}")
