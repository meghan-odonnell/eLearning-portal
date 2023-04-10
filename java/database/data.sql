BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO courses (course_name, course_description, difficulty) VALUES ('Math','Basic Math','Beginner');
INSERT INTO courses (course_name, course_description, difficulty) VALUES ('Science','This is a science class','Intermediate');
INSERT INTO courses (course_name, course_description, difficulty) VALUES ('Programming','Learn to wire it up!!','Advanced');


INSERT INTO curriculum ((SELECT course_id FROM courses WHERE course_name = 'Math'));
INSERT INTO curriculum ((SELECT course_id FROM courses WHERE course_name = 'Math'));
INSERT INTO curriculum ((SELECT course_id FROM courses WHERE course_name = 'Science'));
INSERT INTO curriculum ((SELECT course_id FROM courses WHERE course_name = 'Programing'));


COMMIT TRANSACTION;
