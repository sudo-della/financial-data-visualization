import pandas as pd
import mysql.connector

# # Read excel file

df = pd.read_excel('financial_data.xlsx', engine='openpyxl')

# #Show the first few rows
print(df.head())


conn = mysql.connector.connect(host = "localhost", 
user= "root", 
passwd= "computer", 
database= "financial_data")

cur = conn.cursor()

# insert rows into finiancial_recoreds table
for index, row in df.iterrows():
    cur.execute("""
    INSERT INTO financial_records (user_id, year, month, amount)
    VALUES (%s, %s, %s, %s)
    """), (row["user_id"], row["Year"], row["Month"],  row["Amount"]) 

conn.commit()
conn.close()