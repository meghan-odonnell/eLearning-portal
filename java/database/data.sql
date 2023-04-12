BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('meghan','$2a$10$MXWhj.tMfEHlnKs6GhXFfeDs3Y6NNoTGXt9Xn4CdLs59aZR28qdDa','ROLE_ADMIN');

INSERT INTO course (course_id, course_name, course_description, difficulty) VALUES ('M1', 'Math','Basic Math','Beginner');
INSERT INTO course (course_id, course_name, course_description, difficulty) VALUES ('S2', 'Science','This is a science class','Intermediate');
INSERT INTO course (course_id, course_name, course_description, difficulty) VALUES ('P3','Programming','Learn to wire it up!!','Advanced');

INSERT INTO curriculum (curriculum_id, course_id, curriculum_name, reading, homework, resources) 
	VALUES ('S2C1',	
			'S2',
			'Chapter 1: Introduction to Chemistry',
			'The atomic number of hydrogen is 1, and its atomic weight is approximately 1. The freezing point of water is 0 degrees Celsius (32 degrees Fahrenheit) and the boiling point is 100 degrees Celsius (212 degrees Fahrenheit).
The chemical formula for glucose is C6H12O6.',
		   'homework',
			'links'
		   );
INSERT INTO curriculum (curriculum_id, course_id, curriculum_name, reading, homework, resources) 
	VALUES  ('S2C2',	
			'S2',
			'Chapter 2: Physics of Motion',
			'The acceleration due to gravity on Earth is approximately 9.8 meters per second squared (32 feet per second squared). The speed of light in a vacuum is approximately 299,792,458 meters per second (or about 186,000 miles per second).
Newton\''s second law of motion states that force equals mass times acceleration (F=ma).',
		   'homework',
			'links'
		   );
INSERT INTO curriculum (curriculum_id, course_id, curriculum_name, reading, homework, resources) 
	VALUES  ('S2C3',	
			'M1',
			'Chapter 3: Introduction to Biology',
			'The human body is made up of trillions of cells. The average human heart beats about 100,000 times per day. The genetic material in all living things is made up of DNA, which consists of four bases: adenine, thymine, cytosine, and guanine.',
		   'homework',
			'links'
		   );				   

INSERT INTO assignment (curriculum_id, student_id, submission_date,status) 
	VALUES (
		'S2C1',
		(SELECT user_id FROM users where username = 'user'),
		'2023-04-11',
		'FALSE'
	);

INSERT INTO assignment (curriculum_id, student_id, submission_date,status) 
	VALUES (
		'S2C2',
		(SELECT user_id FROM users where username = 'user'),
		'2023-04-11',
		'FALSE'
	);


INSERT INTO assignment (curriculum_id, student_id, submission_date,status) 
	VALUES (
		'S2C3',
		(SELECT user_id FROM users where username = 'user'),
		'2023-04-11',
		'FALSE'
	);

	
INSERT INTO grade (student_id, assignment_id, grade) 
VALUES ((SELECT user_id FROM users where username = 'user'),
		(SELECT assignment_id from assignment WHERE curriculum_id = 'S2C1'),
		'A');
		
			
INSERT INTO grade (student_id, assignment_id, grade) 
VALUES ((SELECT user_id FROM users where username = 'user'),
		(SELECT assignment_id from assignment WHERE curriculum_id = 'S2C2'),
		'A');
			
INSERT INTO grade (student_id, assignment_id, grade) 
VALUES ((SELECT user_id FROM users where username = 'user'),
		(SELECT assignment_id from assignment WHERE curriculum_id = 'S2C3'),
		'A');


INSERT INTO student_class(student_id, course_id)
	VALUES ((SELECT user_id FROM users where username = 'user'),
			'S2');


COMMIT TRANSACTION;