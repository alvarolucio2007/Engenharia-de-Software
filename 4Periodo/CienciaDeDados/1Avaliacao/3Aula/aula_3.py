# OBJETIVOS: Carregar dataset, Inspecionar head info e describe, verificar nulos e corrigir, criar 2 graficos e salvar o arquivo modificado.
import matplotlib.pyplot as plt
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

# Gráficos
separador()
print("Gráficos")
separador()

plt.style.use("seaborn-v0_8")
fig, axes = plt.subplots(1, 2, figsize=(15, 5))
# histograma de idade
axes[0].hist(df_limpo["Idade"].dropna(), bins=20, edgecolor="black", color="skyblue")
axes[0].set_title("Distribuição de Idade")
axes[0].set_xlabel("Idade")
axes[0].set_ylabel("Frequência")
axes[0].grid(True, alpha=0.3)

# boxplot de satisfação
axes[1].boxplot(df_limpo["Satisfação"].dropna())
axes[1].set_title("Boxplot de Satisfação")
axes[1].set_ylabel("Satisfação")
axes[1].grid(True, alpha=0.3)

plt.tight_layout()
plt.savefig("grafico_distribuicao.png", dpi=150)
plt.show()

fig, axes = plt.subplots(1, 2, figsize=(15, 5))
produto_vendas = (
    df_limpo.groupby("Produto")["Quantidade"]
    .sum()
    .sort_values(ascending=False)
    .head(10)
)
produto_vendas.plot(kind="bar", ax=axes[0], color="coral")
axes[0].set_title("Top 10 Produtos por Quantidade Vendida")
axes[0].set_xlabel("Produto")
axes[0].set_ylabel("Quantidade Total")
axes[0].tick_params(axis="x", rotation=45)


cidade_vendas = (
    df_limpo.groupby("Cidade")["Valor_Total"]
    .sum()
    .sort_values(ascending=False)
    .head(10)
)
cidade_vendas.plot(kind="bar", ax=axes[1], color="lightgreen")
axes[1].set_title("Top 10 Cidades por Valor Total")
axes[1].set_xlabel("Cidade")
axes[1].set_ylabel("Valor Total (R$)")
axes[1].tick_params(axis="x", rotation=45)
plt.tight_layout()
plt.savefig("grafico_vendas.png", dpi=150)
plt.show()

separador()
print("Salvando arquivo")
separador()
df_limpo.to_csv("aula3_base_problema_corrigido.csv", index=False)
