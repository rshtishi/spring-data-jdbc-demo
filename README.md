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
- extending query capabilities with JOOQ 
- extending query capabilities with QueryDSL
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

```
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	
	@Query("select * from person where first_name=:name or last_name=:name")
	List<Person> findByName(@Param("name") String name);

}
```










