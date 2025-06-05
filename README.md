# 📝 Blogging API - Spring Boot

A RESTful API for managing blog posts, built as part of the [Roadmap.sh Project](https://roadmap.sh/projects/blogging-platform-api). This API allows you to create, read, update, delete, and search blog posts. Developed with **Java 21**, **Spring Boot**, and **PostgreSQL**, it's a great foundation for any blogging platform backend.

---

## 🚀 Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Flyway
- PostgreSQL
- Maven
- Lombok
- Insomnia (for API testing)

---

## 📦 Entity: Blogpost

The API currently manages a single entity: `Blogpost`.

### Fields:

| Field        | Type         | Description                               |
|--------------|--------------|-------------------------------------------|
| `id`         | `UUID`       | Unique identifier for the post            |
| `title`      | `String`     | Title of the blog post                    |
| `content`    | `String`     | Main content of the post                  |
| `category`   | `String`     | Category or topic                         |
| `tags`       | `List<String>` | Tags associated with the post           |
| `created_at` | `LocalDateTime` | Timestamp when the post was created   |
| `updated_at` | `LocalDateTime` | Timestamp when the post was last updated |

---

## 📚 Features

- Create a new blog post
- Update an existing post
- Delete a post
- Get a post by ID
- List all blog posts
- Search for posts by a term in title, content, or category

---

## 📌 API Endpoints

| Method | Route                       | Description                                                           |
|--------|-----------------------------|-----------------------------------------------------------------------|
| POST   | `/posts/create`             | Create a new blog post                                                |
| PUT    | `/posts/{id}`               | Update an existing blog post by ID                                    |
| DELETE | `/posts/{id}`               | Delete a blog post by ID                                              |
| GET    | `/posts/{id}`               | Retrieve a single blog post by ID                                     |
| GET    | `/posts`                    | Get all blog posts                                                    |
| GET    | `/posts?term=keyword`       | Search posts containing the term in title, content, or category       |

---

## ▶️ How to Run Locally

### Prerequisites

- Java 21
- PostgreSQL running locally
- Maven
- (Optional) An IDE like IntelliJ or Eclipse

### Steps

1. **Clone the repository**:
   ```bash
   git clone https://github.com/lucashrt/bloggingAPI.git
   cd bloggingAPI
   ```

2. **Configure the database in `application.properties`**:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Run the project**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the API**:
   ```
   http://localhost:8080
   ```

---

## 🧪 API Testing with Insomnia

This API can be tested using [Insomnia](https://insomnia.rest).  

---

## 👨‍💻 Author

This project is part of the [Roadmap.sh Project Challenges](https://roadmap.sh/projects).  
Developed by **Lucas Hartmann**.
