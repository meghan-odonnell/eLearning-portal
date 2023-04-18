BEGIN TRANSACTION;


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Meghan','$2a$10$MXWhj.tMfEHlnKs6GhXFfeDs3Y6NNoTGXt9Xn4CdLs59aZR28qdDa','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Greg','$2a$10$Kt05kar/KU8thJdUIbsFh.mi3ySCQZww7NC6QlCmK7NjjjkKgjJN.','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Ang','$2a$10$xVYWiewz0t.ZKtIkhaVJUuYF3XEAah6jTW57BxZpLiJZ0VP.0Smzq','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Rose','$2a$10$YexCO6mHqTKzdx0BvGN43.Y6MBIJTgOyNgPNLK4.t6pqYIz3vOzoy','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Bob','$2a$10$0Qe.EDAvMRDYuc4wmd.iyer/O5cHJipyoTin4bqKRbzPtvPPZ/Ree','ROLE_USER');

INSERT INTO course (course_id, course_name, course_description, difficulty) VALUES ('M1', 'Math','This is an introductory level math course that focuses on developing students proficiency in arithmetic, algebra, geometry, and basic statistical concepts. Students will engage in various learning activities, including lectures, discussions, problem-solving exercises, and practical applications of mathematical concepts. The course emphasizes problem-solving skills, critical thinking, and logical reasoning to solve mathematical problems. Topics covered include fundamental arithmetic operations, basic algebraic concepts, geometry, and basic statistical analysis. Assessments include quizzes, tests, homework assignments, and practical applications of mathematical concepts. By the end of Math 101, students will have a solid foundation in basic mathematical concepts, problem-solving skills, and critical thinking abilities that will serve as a strong foundation for further studies in math and related disciplines.','Beginner');
INSERT INTO course (course_id, course_name, course_description, difficulty) VALUES ('S2', 'Science','Unleash Your Inner Curiosity! Join us on an exciting journey to explore the wonders of the natural world. Through hands-on experiments, engaging discussions, and interactive demonstrations, we will delve into the fascinating realms of physics, chemistry, biology, and beyond. Discover how scientific principles shape our everyday lives and unlock the mysteries of the universe. Whether youre a budding scientist or simply curious about the world around you, this class will ignite your passion for scientific inquiry and empower you to uncover the marvels of our amazing world!','Intermediate');
INSERT INTO course (course_id, course_name, course_description, difficulty) VALUES ('P3','Programming','Unlock the Power of Coding! Embark on an exhilarating adventure into the world of programming, where creativity meets technology. Learn the fundamental concepts of coding and gain practical skills to design, develop, and debug software applications. Through hands-on projects and real-world examples, youll master programming languages such as Python, Java, or C++, and build a solid foundation in problem-solving, algorithm development, and software design principles. Join our dynamic community of aspiring programmers and unlock your potential to create innovative solutions, automate tasks, and learn how to wire it up!','Advanced');

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
			'S2',
			'Chapter 3: Introduction to Biology',
			'The human body is made up of trillions of cells. The average human heart beats about 100,000 times per day. The genetic material in all living things is made up of DNA, which consists of four bases: adenine, thymine, cytosine, and guanine.',
		   'homework',
			'links'
		   );				   

INSERT INTO curriculum (curriculum_id, course_id, curriculum_name, reading, homework, resources) 
	VALUES ('M1C1',	
			'M1',
			'Chapter 1: Introduction to Algebra 1',
			'Understanding how to plot points on a coordinate plane and connect them to create a line representing a linear equation.
Analyzing the slope and intercept of a linear equation to interpret the data represented by the graph.
Learning how to graph linear inequalities and shade the regions that satisfy the inequality',
		   'Plot the points (2, 5), (4, 9), and (6, 13) on a coordinate plane and connect them to create a line representing a linear equation. Find the slope and y-intercept of the line and write the equation in slope-intercept form.
Analyze the graph of the equation y = 3x - 2. Identify the x-intercept and y-intercept of the line and shade the region that satisfies the inequality y < 3x - 2.
Create a graph of the inequality y > -2x + 5 on a coordinate plane and shade the region that satisfies the inequality.',
			'links'
		   );

INSERT INTO curriculum (curriculum_id, course_id, curriculum_name, reading, homework, resources) 
	VALUES ('M1C2',	
			'M1',
			'Chapter 2: Measures of Central Tendency',
			'Understanding the concept of mean, median, and mode and how they are calculated.
Analyzing the properties and limitations of each measure of central tendency.
Applying measures of central tendency to interpret data in real-world scenarios.',
		   'Given the data set {2, 4, 6, 8, 10}, find the mean, median, and mode.
Analyze the following statement: "The mean is the best measure of central tendency because it takes into account all the data points."
Given the data set {3, 5, 7, 9, 11, 13, 15}, add an outlier to the data set and observe how it affects the mean, median, and mode.',
			'links'
		   );

INSERT INTO curriculum (curriculum_id, course_id, curriculum_name, reading, homework, resources) 
	VALUES ('M1C3',	
			'M1',
			'Chapter 3: Data Distribution',
			'Understanding the shape, center, and spread of a data distribution.
Recognizing and interpreting the various types of distributions, such as normal, skewed, and bimodal.
Analyzing the effects of outliers on the shape and spread of a data distribution.',
		   'Given the following data set: {10, 12, 14, 16, 18, 20}, describe the shape, center, and spread of the distribution.
Analyze the following statement: "If a data set has a normal distribution, the mean and median are always equal."
Given a histogram of a data set, identify the type of distribution (normal, skewed, bimodal) and explain how you determined it.',
			'links'
		   );


INSERT INTO curriculum (curriculum_id, course_id, curriculum_name, reading, homework, resources) 
	VALUES ('P3C1',	
			'P3',
			'Chapter 1: Variables & Data Types',
			'Variables are used to store data in a program and can be assigned different values.
Data types determine the type of data that can be stored in a variable, and what operations can be performed on that data.
Common data types include integers, floats, strings, and booleans.',
		   'Define a variable called "age" and assign it the value of 25. Print the value of the variable to the console.
Analyze the following statement: "In programming, data types are important because they determine the operations that can be performed on the data."
Given a real-world scenario, choose an appropriate data type for a variable and explain why you made that choice.',
			'links'
		   );
		  
INSERT INTO curriculum (curriculum_id, course_id, curriculum_name, reading, homework, resources) 
	VALUES ('P3C2',	
			'P3',
			'Chapter 2: Conditionals and Loops',
			'Conditionals allow a program to make decisions based on the value of a variable or expression.
Loops allow a program to repeat a set of instructions multiple times.
Common loop types include "for" loops and "while" loops.',
		   'Write a program that takes an input from the user and prints "Hello" if the input is "world" and "Goodbye" otherwise.
Analyze the following statement: "In programming, loops are important because they allow the same set of instructions to be repeated multiple times."
Given a real-world scenario, choose an appropriate control structure (conditional or loop) for a program and explain why you made that choice.',
			'links'
		   );
		   
INSERT INTO curriculum (curriculum_id, course_id, curriculum_name, reading, homework, resources) 
	VALUES ('P3C3',	
			'P3',
			'Chapter 3: Functions and Parameters',
			'Functions are reusable blocks of code that perform a specific task.
Parameters are inputs that can be passed to a function to customize its behavior.
Functions can have return values, which can be used to pass data back to the main program.',
		   'Write a function called "square" that takes a number as a parameter and returns its square. Test the function with the number 5.
Analyze the following statement: "In programming, functions are important because they allow code to be reused and organized."
Given a real-world scenario, write a function that solves a problem and explain how you designed the function and chose the parameters.',
			'links'
		   );		   
		   
INSERT INTO student_class(student_id, course_id)
	VALUES ((SELECT user_id FROM users where username = 'user'),'S2');
INSERT INTO student_class(student_id, course_id)
	VALUES ((SELECT user_id FROM users where username = 'Rose'),'S2');
INSERT INTO student_class(student_id, course_id)
	VALUES ((SELECT user_id FROM users where username = 'Rose'),'M1');
INSERT INTO student_class(student_id, course_id)
	VALUES ((SELECT user_id FROM users where username = 'Ang'),'S2');
INSERT INTO student_class(student_id, course_id)
	VALUES ((SELECT user_id FROM users where username = 'Ang'),'M1');			
INSERT INTO student_class(student_id, course_id)
	VALUES ((SELECT user_id FROM users where username = 'Bob'),'M1');

INSERT INTO assignment (curriculum_id, student_id) 
	VALUES ('S2C1',(SELECT user_id FROM users where username = 'Ang'));
INSERT INTO assignment (curriculum_id, student_id) 
	VALUES ('S2C3',(SELECT user_id FROM users where username = 'Rose'));
	
INSERT INTO assignment (curriculum_id, student_id, submission_date,status) 
	VALUES ('S2C1',(SELECT user_id FROM users where username = 'Rose'),'2023-04-11','TRUE');
INSERT INTO assignment (curriculum_id, student_id, submission_date,status) 
	VALUES ('S2C2',(SELECT user_id FROM users where username = 'Rose'),'2023-04-11','TRUE');
INSERT INTO assignment (curriculum_id, student_id, submission_date,status) 
	VALUES ('S2C3',(SELECT user_id FROM users where username = 'Ang'),'2023-04-11','TRUE');
INSERT INTO assignment (curriculum_id, student_id, status) 
	VALUES ('S2C3',(SELECT user_id FROM users where username = 'Bob'),'FALSE');
INSERT INTO assignment (curriculum_id, student_id, status) 
	VALUES ('S2C1',(SELECT user_id FROM users where username = 'Bob'),'FALSE');
INSERT INTO assignment (curriculum_id, student_id, status) 
	VALUES ('S2C3',(SELECT user_id FROM users where username = 'Ang'),'FALSE');

INSERT INTO student_class(student_id, course_id)
	VALUES ((SELECT user_id FROM users where username = 'Bob'),'S2');
INSERT INTO student_class(student_id, course_id)
	VALUES ((SELECT user_id FROM users where username = 'Rose'),'M1');


COMMIT TRANSACTION;



