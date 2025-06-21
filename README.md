
# 🧠 Smart Training Platform

This is a Java Spring Boot application designed to manage **trainers**, **students**, and **batch assignments** using modern backend practices.

---

## 📌 Teaching Explanation (Mandatory)

### 1. What is Dependency Injection and how is it used in your app?
**Dependency Injection (DI)** is a design pattern where objects are passed their dependencies instead of creating them internally.  
In this project, Spring Boot automatically injects services and repositories using `@Autowired`.  
For example:
```java
@Autowired
private TrainerService trainerService;
```
Here, Spring provides the `TrainerService` implementation wherever it’s needed.

### 2. How would you explain the trainer assignment logic to students?
When a student is assigned to a batch:
- We check for trainers with the correct subject expertise.
- We filter trainers based on availability.
- We sort eligible trainers by rating.
- The best trainer is assigned to the batch.

### 3. Why did you choose your architecture and flow?
- **Controller → Service → Repository** structure ensures separation of concerns.
- **DTOs** manage incoming/outgoing data efficiently.
- Clean, modular design allows scalability and easy maintenance.

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- **H2 Database (in-memory)**
- Docker
- Git & GitHub
- Render (for deployment)

---

## 🚀 How to Run

### Using Maven:
```bash
mvn spring-boot:run
```

### Or with Docker:
```bash
docker build -t trainingplatform .
docker run -p 8080:8080 trainingplatform
```

---

## 🔗 Deployment

You must deploy the app to **Render** using Docker.

- Sign up at [https://render.com](https://render.com)
- Connect your GitHub repo
- Set deployment method to **Docker**
- Expose port `8080`
- Name your service URL as:
```
https://<yourname>-machine-test.onrender.com
```

Example: `https://ravikumar-machine-test.onrender.com`
