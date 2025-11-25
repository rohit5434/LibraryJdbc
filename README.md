# 📚 Library Management System (Java + JDBC + PostgreSQL)

A simple **Library Management System** built using **Core Java**, **JDBC**, and **PostgreSQL**.
This project demonstrates how Java applications interact with databases using SQL queries.

------------------------------------------------------------
🛠️ TECHNOLOGIES USED
------------------------------------------------------------
- Java (Core Java)
- JDBC (Java Database Connectivity)
- PostgreSQL Database
- pgAdmin 4
- Git & GitHub

------------------------------------------------------------
✨ FEATURES
------------------------------------------------------------
📘 Books:
- Add Book
- List All Books
- Search Book by Title
- Remove Book (only if available)
- Issue Status (Available / Issued)

👤 Users:
- Add User
- List All Users

🔄 Issue/Return:
- Issue Book
- Return Book
- Prevent issuing already-issued books

------------------------------------------------------------
🗂️ PROJECT STRUCTURE
------------------------------------------------------------
LibraryJdbc/
 ┣ DB.java
 ┣ BookDAO.java
 ┣ UserDAO.java
 ┣ IssueDAO.java
 ┣ Main.java
 ┣ db.sql
 ┣ postgresql-42.xx.jar
 ┗ README.md

------------------------------------------------------------
🗄️ DATABASE SETUP (POSTGRESQL)
------------------------------------------------------------
Run these SQL commands in pgAdmin → Query Tool:

CREATE DATABASE librarydb;

\c librarydb

CREATE TABLE books (
  id SERIAL PRIMARY KEY,
  title VARCHAR(100),
  author VARCHAR(100),
  available BOOLEAN DEFAULT TRUE
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE issued (
  book_id INT PRIMARY KEY REFERENCES books(id),
  user_id INT REFERENCES users(id)
);

------------------------------------------------------------
🔌 JDBC CONFIGURATION (DB.java)
------------------------------------------------------------
private static final String url = "jdbc:postgresql://localhost:5432/librarydb";
private static final String user = "postgres";
private static final String pass = "your_password";

(Replace "your_password" with actual PostgreSQL password)

------------------------------------------------------------
▶️ HOW TO COMPILE & RUN
------------------------------------------------------------
1️⃣ Navigate to your project:
cd E:\LibraryJdbc

2️⃣ Compile:
javac -cp ".;E:\LibraryJdbc\postgresql-42.xx.jar" "*.java"

3️⃣ Run:
java -cp ".;E:\LibraryJdbc\postgresql-42.xx.jar" Main

------------------------------------------------------------
🖥️ SAMPLE OUTPUT
------------------------------------------------------------
1 Add Book
2 List Books
3 Add User
4 List Users
5 Issue Book
6 Return Book
7 Search Book
8 Remove Book
0 Exit
Choice:

------------------------------------------------------------
🚀 FUTURE ENHANCEMENTS
------------------------------------------------------------
- GUI version (Swing/JavaFX)
- Web version (Spring Boot + React)
- Login & Authentication
- Fine system for late returns
- Export to PDF/Excel

------------------------------------------------------------
🤝 CONTRIBUTING
------------------------------------------------------------
Pull requests are welcome.  
For major changes, please open an issue first.

------------------------------------------------------------
📜 LICENSE
------------------------------------------------------------
This project is free to use for learning and educational purposes.
