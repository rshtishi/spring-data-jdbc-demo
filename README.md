# spring-data-jdbc-demo

A practical guide of using spring-data-jdbc for accessing the relational databases.

## Topics

Spring Data JDBC is a new way of accessing relational databases. Is simpler than JPA to use and understand because there is no cache, dirty dirty tracking and lazy
loading features like JPA. Every time we load the entity and SQL statement is run to the database. If we save an entity then it is inserted in database. It offers 
a simple ORM tool for mapping entities to tables. Below are the topics that we are going to cover in this example:

- defining entity
- creating a repository
- adding derived queries
- adding custom queries with ```@Query``` annotation
- mapping association between entities
- domain driven design

### Defining an Entity

It is mandatory that each to have an ```@Id``` annotation to be recognized as an entity. Spring Data JDBC uses the ID to identify entities. Spring Data JDBC 
will map the camel case identifiers of the entity with the snake case identifiers of the table. To customize the mapping between table and entity we use ```@Table``` 
annotation and the ```@Column``` annotation to customize the mapping between the entity fields and table fields. Below is an example of defining this entity:

```
public class Person {
	
	@Id
	private Long id;
	@Column("FIRST_NAME")
	private String firstname;
	@Column("LAST_NAME")
	private String lastname;
	private LocalDate birthdate;
  
  ...
}
```

### Creating a Repository

To create a repository we need to create an interface that extends ```CrudRepository``` or ```PagingAndSortingRepository``` interface.  By default we receive the 
implementation of the basic methods like ```findAll, save, delete```. Below is an example:

```
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
}
```

### Adding Derived Queries

Spring Data JDBC has included support for derived queries. This means by declaring a method in our interface where the method name adheres to the convention of Spring 
Data JDBC we get query expression derived from the method name. The following code demonstrates an example of derived queries:

```
public interface PersonRepository extends CrudRepository<Person, Long>{
	
	List<Person> findByFirstname(String firstname);
}
```

### Adding Custom Queries with ```@Query``` Annotation

We use the ```@Query``` annotation for defining queries that are not supported with query derivation. Also, it is reasonable to use custom queries with ```@Query``` annotation when the method name is too long when defined with query derivation. If the query modifies the database tables then we need to add the ```@Modifier``` annotation.
The following example defines two customer queries using the ```@Query``` annotation:

```
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	
	@Query("select * from person where first_name=:name or last_name=:name")
	List<Person> findByName(@Param("name") String name);

	@Modifying
	@Query("UPDATE person SET first_name=:firstname, last_name=:lastname WHERE id=:id")
	boolean updatePersonName(@Param("id") Long id, @Param("firstname") String firstname,
			@Param("lastname") String lastname);

}
```

### Mapping Associations between Entities

In database design, we have three types of relationships between tables. They are :

- **one to one** when a row from the parent table is associated with a single row of the child table
- **one to many** when a row from the parent table is associated with multiple rows of the child table
- **many to many** when  both tables are associated with multiple rows from each other

#### One to One Mapped by Spring Data JDBC

One to one relationship expressed between tables:

```
create table if not exists product
(
	id integer primary key AUTO_INCREMENT,
	name varchar(30)
);

create table if not exists product_details
(
  product integer primary key references product(id),
  created_by varchar(30),
  created_on timestamp
);
```

Mapping the one to one association between entities with Spring Data JDBC:

```
public class Product {

	@Id
	private Long id;
	private String name;
	private ProductDetails details;
	
	...
}
```

```
public class ProductDetails {
	
	private String createdBy;
	private LocalDateTime createdOn;
}
```

#### One to Many Mapped by Spring Data JDBC

One to many relationship expressed between tables:

```
create table if not exists review
(
	id integer primary key AUTO_INCREMENT,
	product integer references product(id),
	comment varchar(250)	
);
```

Mapping the one to many association between entities with Spring Data JDBC:

```
public class Product {

	@Id
	private Long id;
	private String name;
	private ProductDetails details;
	private Set<Review> reviews;
	
	...
}

public class Review {
	
	private String comment;
}
```

#### Many to Many Mapped by Spring Data JDBC

Many to many relationship expressed between tables:

```
create table if not exists manufacturer 
(
	id integer primary key AUTO_INCREMENT,
	name varchar(30),
	location varchar(30)
);

create table if not exists product_manufacturer
(
	manufacturer integer,
	product integer,
	primary key( manufacturer,product)
)
```

Mapping the many to many association between entities with Spring Data JDBC:

```
public class Product {

	@Id
	private Long id;
	private String name;
	private ProductDetails details;
	private Set<Review> reviews;
	private Set<ManufacturerRef> manufacturers = new HashSet<>();
}

public class Manufacturer {

	@Id
	private Long id;
	private String name;
	private String location;
}

@Table("PRODUCT_MANUFACTURER")
public class ManufacturerRef {

	Long manufacturer;
}
```


### Domain Driven Design

Domain-Driven-Design is about dedicated time to understand the domain by collaborating with domain experts, analysts and produce a conceptual form that will be used
as a model for building powerful, correct, and flexible software. When translating the model into code we should keep in mind to have software code to match the
business domain. 

**Entities** are the objects that have an identity that remains the same throughout the state of the software. For entities, the object is not the attributes which matter,
but then a thread of continuity and identity that spans the life of the system and can broaden beyond it. Therefore, implementing entities in software means creating
an identity. In our demo we have the following entities:

- Person
- Product
- Manufacturer

**Value Objects** are objects used for describing a certain aspect of the domain. We are not interested in the identity of the object but in the attributes it has.
Having no identity the value objects can be easily created and discarded. It will be a good design approach to make the value objects immutable because it will 
ensure data integrity if shared. In this demo the value objects are:

- ProductDetails
- Review
- ManufacturerRef


**Service** are objects that don't have an internal state and its purpose is to simply provide functionality for the domain. We should create services when important operation stands out as an important concept in the domain and it doesn't seem to belong naturally to any of the domain entities.

**Modules** are used to organize related concepts into different units to reduce complexity. It increases the level of abstraction and decreases the complexity of the
model. We can understand much easier the model by looking at modules. It’s a simple and efficient way to manage complexity.

**Aggregates** are a group of associated objects that are considered as one unit with regard to data changes. The Aggregate marks a boundary that separates the objects
from inside from those outsides. Eash Aggregate has a root. The root is an entity it is the only object accessible from the outside. In our demo, ```Product``` is an
aggregate that has as root the ```Product``` entity. The object inside this the ```Product``` aggregate are ```ProductDetails``` and  ```Review```. The identity of ```ProductDetails``` and ```Review``` are local and make sense only inside the ```Product``` aggregate. The ```Product``` aggregate hold reference to ```Manufacturer``` aggregate.

**Factories** are objects used to encapsulate the process of complex object creation. They are very useful when dealing with large and complex Aggregates because the client isn't required to have specific knowledge about the object build(internal structure of the object and the relationship between the object contained). In our demo, we are not using Factories object for creating aggregates because the construction is not complicated.

**Repositories**  are objects used to encapsulate the logic needed to obtain object references. Repository acts as a storage place for globally accessible objects.
In our demo we have the following repositories:

- PersonRepository
- ProductRepository









