from pymongo import MongoClient

url="mongodb+srv://alvarolucio2007_db_user:senha@engsoft.xjri79d.mongodb.net"
print(url)
client=MongoClient(url)
try:
    client.admin.command("ping")
    print("Connected sucessfully hooray")
except Exception as e:
    raise Exception(
        "Error: ",e
    )
database = client["test-1-atividade"]
collection = database["produtos"]

result=collection.insert_one({"nome":"gta 6","preco":999})
print(result.acknowledged)
client.close()
