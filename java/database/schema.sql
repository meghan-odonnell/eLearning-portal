BEGIN TRANSACTION;

DROP TABLE IF EXISTS student_class, users, course, user_detail, curriculum, assignment;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE course (
	course_id varchar(10),
	course_name varchar(50) NOT NULL UNIQUE,
	course_description varchar(5000),
	difficulty varchar (50),
	cost integer default 0,
	CONSTRAINT pk_courses_course PRIMARY KEY (course_id)
);

CREATE TABLE user_detail (
	user_detail_id SERIAL,
	user_id int NOT NULL,
	first_name varchar(20),
	last_name varchar(20),
	email varchar(30),
	CONSTRAINT pk_user_detail_id PRIMARY KEY (user_detail_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE curriculum (
	curriculum_id varchar(10),
	curriculum_name varchar(50) NOT NULL,
	course_id varchar(10) NOT NULL,
	reading varchar (5000),
	homework varchar (1000),
	resources varchar (1000),
	CONSTRAINT pk_curriculum_id PRIMARY KEY (curriculum_id),
	CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES course (course_id)	
);

CREATE table assignment (
	assignment_id SERIAL,
	curriculum_id varchar(10) NOT NULL,
	student_id int NOT NULL,
	submission_date date,
	status boolean DEFAULT false,
	grade int DEFAULT 0,
	answer varchar(10000),
	CONSTRAINT pk_assignment_id PRIMARY KEY (assignment_id),
	CONSTRAINT fk_curriculum_id FOREIGN KEY (curriculum_id) REFERENCES curriculum (curriculum_id),
	CONSTRAINT fk_student_id FOREIGN KEY (student_id) REFERENCES users (user_id)	
);

CREATE TABLE student_class (
	student_id int,
	course_id varchar(10),
	CONSTRAINT fk_student_id FOREIGN KEY (student_id) REFERENCES users (user_id),
	CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES course (course_id)
);


COMMIT TRANSACTION;
