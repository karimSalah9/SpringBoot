# SpringBoot

Spring Boot CRUD Operations
What is the CRUD operation?
The CRUD stands for Create, Read/Retrieve, Update, and Delete. These are the four basic functions of the persistence storage.

The CRUD operation can be defined as user interface conventions that allow view, search, and modify information through computer-based forms and reports. CRUD is data-oriented and the standardized use of HTTP action verbs. HTTP has a few important verbs.

POST: Creates a new resource
GET: Reads a resource
PUT: Updates an existing resource
DELETE: Deletes a resource
Within a database, each of these operations maps directly to a series of commands. However, their relationship with a RESTful API is slightly more complex.

Standard CRUD Operation
CREATE Operation: It performs the INSERT statement to create a new record.
READ Operation: It reads table records based on the input parameter.
UPDATE Operation: It executes an update statement on the table. It is based on the input parameter.
DELETE Operation: It deletes a specified row in the table. It is also based on the input parameter.
How CRUD Operations Works
CRUD operations are at the foundation of the most dynamic websites. Therefore, we should differentiate CRUD from the HTTP action verbs.

Suppose, if we want to create a new record, we should use HTTP action verb POST. To update a record, we should use the PUT verb. Similarly, if we want to delete a record, we should use the DELETE verb. Through CRUD operations, users and administrators have the right to retrieve, create, edit, and delete records online.

We have many options for executing CRUD operations. One of the most efficient choices is to create a set of stored procedures in SQL to execute operations.

The CRUD operations refer to all major functions that are implemented in relational database applications. Each letter of the CRUD can map to a SQL statement and HTTP methods.

Spring Boot CrudRepository
Spring Boot provides an interface called CrudRepository that contains methods for CRUD operations. It is defined in the package org.springframework.data.repository. It extends the Spring Data Repository interface. It provides generic Crud operation on a repository. If we want to use CrudRepository in an application, we have to create an interface and extend the CrudRepository.

Syntax

public interface CrudRepository<T,ID> extends Repository<T,ID>  
where,

T is the domain type that repository manages.
ID is the type of the id of the entity that repository manages.
For example:

public interface StudentRepository extends CrudRepository<Student, Integer>  
{  
}  
In the above example, we have created an interface named StudentRepository that extends CrudRepository. Where Student is the repository to manage, and Integer is the type of Id that is defined in the Student repository.

Spring Boot JpaRepository
JpaRepository provides JPA related methods such as flushing, persistence context, and deletes a record in a batch. It is defined in the package org.springframework.data.jpa.repository. JpaRepository extends both CrudRepository and PagingAndSortingRepository.

For example:

public interface BookDAO extends JpaRepository   
{  
}  hy should we use these interfaces?
The interfaces allow Spring to find the repository interface and create proxy objects for that.
It provides methods that allow us to perform some common operations. We can also define custom methods as well.
