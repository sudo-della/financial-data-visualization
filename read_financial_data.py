import pandas as pd
import mysql.connector

# # Read excel file

df = pd.read_excel('financial_data.xlsx', engine='openpyxl')

# #Show the first few rows
print(df.head())


conn = mysql.connector.connect(
    host = "localhost", 
    user= "root", 
    passwd= "computer", 
    database= "financial_data")

cur = conn.cursor()

for name in df["Name"].unique():
    cur.execute("INSERT IGNORE into users (name) VALUES (%s)", (name,))

    conn.commit()


cur.execute("SELECT user_id, name FROM users")
user_map = {name: user_id for user_id, name in cur.fetchall()}


# insert rows into finiancial_recoreds table
for index, row in df.iterrows():
    cur.execute("""
    INSERT INTO financial_records (user_id, year, month, amount)
    VALUES (%s, %s, %s, %s)
    """, (user_map[row["Name"]], row["Year"], row["Month"],  row["Amount"]))

conn.commit()
conn.close()