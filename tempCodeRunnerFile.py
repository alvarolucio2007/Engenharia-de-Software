# Chatbot minimalista baseado em regras + perceptron simples
# Ele vai “aprender” respostas simples a partir de exemplos

# Base de treinamento: perguntas curtas e respostas
training_data = [
    ("oi", "Olá!"),
    ("tudo bem", "Tudo ótimo, e você?"),
    ("qual seu nome", "Eu sou um chatbot minimalista."),
    ("adeus", "Até mais!"),
    ("como vai", "Estou bem, obrigado!")
]

# Função de similaridade simples (conta palavras iguais)
def similarity(input_text, question):
    input_words = set(input_text.lower().split())
    question_words = set(question.lower().split())
    return len(input_words & question_words)

# Função de “treinamento” (só organiza os dados)
def train_chatbot(data):
    questions, answers = zip(*data)
    return list(questions), list(answers)

# Função de resposta
def get_response(user_input, questions, answers):
    best_score = 0
    best_index = None
    for i, question in enumerate(questions):
        score = similarity(user_input, question)
        if score > best_score:
            best_score = score
            best_index = i
    if best_index is not None and best_score > 0:
        return answers[best_index]
    else:
        return "Desculpa, não entendi."

# Treina o chatbot
questions, answers = train_chatbot(training_data)

# Loop de conversa
print("Chatbot minimalista iniciado! Digite 'sair' para encerrar.")
while True:
    user_input = input("Você: ")
    if user_input.lower() == "sair":
        print("Chatbot: Até mais!")
        break
    response = get_response(user_input, questions, answers)
    print("Chatbot:", response)
