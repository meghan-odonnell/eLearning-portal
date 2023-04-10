BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, courses;

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
	cost integer default 0
);

COMMIT TRANSACTION;
