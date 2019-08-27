# Spring Boot Web Application Template
Template of JPA Application. Contains many different samples.
Just for the testing purpose, Embedded H2 database is used.

## Template contains
* Framework : Spring Boot - 1.5.7
* ORM : JPA / Hibernate
* Database : H2 - h2-2017-04-23
* Unit Test : jUnit + AssertJ
* Code Quality : Jacoco

## Initialization

#### Create Test Database
```
CREATE TABLE TEST_USER(
    USER_ID VARCHAR(10) PRIMARY KEY,
    PW VARCHAR(20) NOT NULL,
    NAME VARCHAR(20) NOT NULL,
    TITLE VARCHAR(10),
    AGE INT
);

CREATE TABLE POST(
    POST_ID INT AUTO_INCREMENT PRIMARY KEY,
    USER_ID VARCHAR(10),
    SUBJECT VARCHAR(50),
    CONTENT VARCHAR(200),
    CREATED_DATETIME DATETIME,
    FOREIGN KEY (USER_ID) REFERENCES TEST_USER(USER_ID)
);

CREATE TABLE PROVINCE(
    PROVINCE_ID INT PRIMARY KEY,
    NAME VARCHAR(50)
);

CREATE TABLE CITY(
    CITY_ID INT PRIMARY KEY,
    PROVINCE_ID INT NOT NULL,
    NAME VARCHAR(50),
    FOREIGN KEY (PROVINCE_ID) REFERENCES PROVINCE(PROVINCE_ID)
);

```

#### Add some test data
```
// Hibernate side test data
INSERT INTO TEST_USER(USER_ID, PW, NAME, TITLE, AGE) VALUES( 'tester1', '1234', 'Brian Heo', 'Sir', 42);
INSERT INTO TEST_USER(USER_ID, PW, NAME, TITLE, AGE) VALUES('tester2', '1234', 'Phil Lee', 'Mr.', 42);
INSERT INTO TEST_USER(USER_ID, PW, NAME, AGE) VALUES('tester3', '1234', 'Gerrard Lee', 43);

INSERT INTO POST(USER_ID, SUBJECT, CONTENT, CREATED_DATETIME) VALUES( 'tester1', 'Test Subject 1', 'Contents of Test subject 1', CURRENT_TIMESTAMP());
INSERT INTO POST(USER_ID, SUBJECT, CONTENT, CREATED_DATETIME) VALUES( 'tester2', 'Test Subject 2', 'Contents of Test subject 2', CURRENT_TIMESTAMP());
INSERT INTO POST(USER_ID, SUBJECT, CONTENT, CREATED_DATETIME) VALUES( 'tester1', 'Test Subject 3', 'Contents of Test subject 3', CURRENT_TIMESTAMP());
INSERT INTO POST(USER_ID, SUBJECT, CONTENT, CREATED_DATETIME) VALUES( 'tester2', 'Test Subject 4', 'Contents of Test subject 4', CURRENT_TIMESTAMP());
INSERT INTO POST(USER_ID, SUBJECT, CONTENT, CREATED_DATETIME) VALUES( 'tester1', 'Test Subject 5', 'Contents of Test subject 5', CURRENT_TIMESTAMP());
INSERT INTO POST(USER_ID, SUBJECT, CONTENT, CREATED_DATETIME) VALUES( 'tester1', 'Test Subject 6', 'Contents of Test subject 6', CURRENT_TIMESTAMP());
INSERT INTO POST(USER_ID, SUBJECT, CONTENT, CREATED_DATETIME) VALUES( 'tester1', 'Test Subject 7', 'Contents of Test subject 7', CURRENT_TIMESTAMP());
INSERT INTO POST(USER_ID, SUBJECT, CONTENT, CREATED_DATETIME) VALUES( 'tester3', 'Test Subject 8', 'Contents of Test subject 8', CURRENT_TIMESTAMP());
INSERT INTO POST(USER_ID, SUBJECT, CONTENT, CREATED_DATETIME) VALUES( 'tester1', 'Test Subject 9', 'Contents of Test subject 9', CURRENT_TIMESTAMP());

// myBatis side test data
INSERT INTO PROVINCE( PROVINCE_ID, NAME ) VALUES( 1, 'ONTARIO');
INSERT INTO PROVINCE( PROVINCE_ID, NAME ) VALUES( 2, 'BRITISH COLOMBIA');

INSERT INTO CITY( CITY_ID, PROVINCE_ID, NAME) VALUES( 1, 1, 'TORONTO');
INSERT INTO CITY( CITY_ID, PROVINCE_ID, NAME) VALUES( 2, 1, 'OTTAWA');
INSERT INTO CITY( CITY_ID, PROVINCE_ID, NAME) VALUES( 3, 1, 'OTTAWA');

```

#### H2 setup - (in application.properties)
```
# H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Datasource
spring.datasource.url=jdbc:h2:file:~/test
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.properties.hibernate,format_sql=true
spring.jpa.show-sql=true
spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.DefaultNamingStrategy
``` 

## Unit Testing


## Integration Test


## Code Quality Check

