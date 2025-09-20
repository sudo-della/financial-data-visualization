import mysql.connector

#connecting to the mysql database
conn = mysql.connector.connect(
    host = "localhost", 
    user= "root", 
    passwd= "computer", 
    database= "financial_data"
    
    )

cur = conn.cursor()

#Create the users table
cur.execute("""create table users(
user_id INT AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(100))""")

#Create the financial_records table
cur.execute("""create table financial_records ( 
record_id INT AUTO_INCREMENT PRIMARY KEY, 
user_id INT, 
year INT, 
month VARCHAR(20), 
amount DECIMAL(10,2), 
FOREIGN KEY (user_id) REFERENCES users(user_id))""")

#commit changes and close
conn.commit()
conn.close()
