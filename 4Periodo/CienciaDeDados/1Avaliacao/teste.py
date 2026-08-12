#OBJETIVOS: Carregar dataset, Inspecionar head info e describe, verificar nulos e corrigir, criar 2 graficos e salvar o arquivo modificado.
import pandas as pd
FILE_PATH="aula3_base_problema.csv"
df_csv=pd.read_csv(FILE_PATH)
print(df_csv)
print("Hello world")
