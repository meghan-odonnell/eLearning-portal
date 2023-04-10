BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, courses,user_details,curriculum;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE courses (
	course_id SERIAL,
	course_name varchar(50) NOT NULL UNIQUE,
	course_description varchar(500),
	difficulty varchar (50),
	cost integer default 0,
	CONSTRAINT pk_courses_courses PRIMARY KEY (course_id)
);

CREATE TABLE user_details (
	user_detail_id SERIAL,
	first_name varchar(20),
	last_name varchar(20),
	email varchar(30),
	CONSTRAINT pk_user_detail_id PRIMARY KEY (user_detail_id)
);

CREATE TABLE curriculum (
	curriculum_id SERIAL,
	course_id int NOT NULL,
	CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES courses (course_id)	
);

CREATE table assignments (
	assignment_id SERIAL,
	curriculum_id,
);


COMMIT TRANSACTION;

