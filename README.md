# 🛒 E-Commerce Backend Project

This is a Mini functional **E-commerce Backend Application** built using **Spring Boot**. It includes features like Shop management like Product Management, user authentication, and cart functionality. This project was developed in my free time before starting BTech to demonstrate backend development skills and understanding of real-world architecture.

---

## 📌 Features

- 🔐 **User Authentication**
    - Login and Signup using Spring Security
    - Password encryption
    - BasicAuth on Every request not using JWT 

- 📦 **Shop & Product Management**
    - Add, update, delete products (User can create their shops and sell it)
    - View all or single product (User)

- 🛒 **Cart System**
    - Add products to cart
    - View cart items
    - Remove items from cart

- 📄 **DTO Usage**
    - Clean separation of Entity and API layer
    - Better request/response structures

---

## 🧰 Tech Stack

| Layer       | Technology                       |
|-------------|----------------------------------|
| Language    | Java 17                          |
| Framework   | Spring Boot                      |
| Security    | Spring Security                  |
| ORM         | Spring Data JPA                  |
| Database    | Postgre Sql                      |
| Build Tool  | Maven                            |
| IDE         | IntelliJ IDEA                    |
| Architecture| MVC + Service Layer + Repository |

---

## 📂 Project Structure

E-commerce/
├── controller/ # REST Controllers
├── service/ # Business logic
├── repository/ # JPA Repositories
├── model/ # Entities & DTOs
├── config/ # Security Config

.
## 📡 API Endpoints

### 🔐 Authentication

| Method | Endpoint             | Description       |
|--------|----------------------|-------------------|
| POST   | `register` | Register new user |
| POST   | `/login`    | Login             |

---
### 📦 Shop
| Method | Endpoint                      | Description                                             |
|-------|-------------------------------|---------------------------------------------------------| 
| GET   | `/api/myshop/myproducts       | Get product posted Specific user which posted a product |
| POST  | `/api/myshop/add`             | Add new product                                         |
| PUT   | `/api/myshop/update/{prodid}` | Update product                                          |
| DELETE | `/api/myshop/delete/{prodid}` | Delete product                                          |

---
### 📦 Product

| Method | Endpoint             | Description                             |
|--------|----------------------|-----------------------------------------|
| GET    | `/api/home/products` | Get all products  from all users posted |


### 🛒 Cart

| Method | Endpoint                        | Description                 |
|--------|---------------------------------|-----------------------------|
| POST   | `"/api/cart/add/{prodid}"`      | Add product to cart         |
| GET    | `/api/cart/mycart`              | View all cart items         |
| DELETE | `/api/cart/remove/{cartItemId}` | Remove item from cart       |
| DELETE | `/api/cart/clear`               | Remove  all items from cart |



👨‍💻 Author

Akarshit Mahajan

📍 Amritsar, India

💬 Java | Spring Boot | Backend Developer

🧑‍🎓 Pre-BTech Student (Built before starting college)

