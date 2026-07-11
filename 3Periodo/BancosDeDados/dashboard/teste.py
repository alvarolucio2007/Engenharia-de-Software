import pandas as pd
import psycopg2
import plotly.graph_objects as go
from plotly.subplots import make_subplots

conn = psycopg2.connect(
    host="localhost", database="shop_fsa", user="postgres", password="root", port="5432"
)
total = pd.read_sql("SELECT * FROM emprestimos", conn)
print(total)
