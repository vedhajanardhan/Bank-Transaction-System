# 🏦 Bank Transaction System

<img width="1774" height="887" alt="ChatGPT Image Jul 20, 2026, 10_02_05 PM" src="https://github.com/user-attachments/assets/948c854f-ead6-4ae6-a497-4329a8bf5618" />


## 📖 Overview

-The Bank Transaction System is a RESTful backend application developed using Java and Spring Boot. It provides secure banking operations such as customer registration, account creation, deposits, withdrawals, fund transfers, balance inquiries, and transaction history.

-The project follows a layered architecture using Spring MVC, Spring Data JPA, and Hibernate to ensure clean code organization and maintainability. MySQL is used for persistent storage, while Swagger provides interactive API documentation for testing and exploration.

## ✨ Features

- 👤 Customer Registration
- 🏦 Bank Account Creation
- 💰 Deposit Money
- 💸 Withdraw Money
- 🔄 Fund Transfer
- 💳 Balance Inquiry
- 📜 Transaction History
- 🔒 Password Encryption using BCrypt
- 📖 Swagger API Documentation
- 🗄️ MySQL Database Integration
- 🧱 Layered Architecture (Controller → Service → Repository)

  ## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Spring Boot | Backend Framework |
| Spring MVC | REST API Development |
| Spring Data JPA | Database Access |
| Hibernate | ORM Framework |
| MySQL | Relational Database |
| Spring Security | Password Encryption (BCrypt) |
| Swagger | API Documentation |
| Maven | Dependency Management |
| Git | Version Control |
| GitHub | Repository Hosting |
| Postman | API Testing |

## 🏗️ Architecture

The application follows a layered architecture to separate business logic, data access, and request handling.

<img width="1536" height="1024" alt="ChatGPT Image Jul 20, 2026, 10_05_25 PM" src="https://github.com/user-attachments/assets/8b961f49-a82c-48d4-85bb-901152ff0afa" />

## 🗄️ Database Design

The database consists of three main entities:

- Customer
- Account
- Transaction

The relationships are:

- One Customer can have multiple Accounts.
- One Account can have multiple Transactions.
<img width="1281" height="344" alt="Untitled" src="https://github.com/user-attachments/assets/c8010c58-9f46-40b1-8542-06a7cb6b1d1d" />

