BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO courses (course_name, course_description) VALUES ('Math','Basic Math');
INSERT INTO courses (course_name, course_description) VALUES ('Science','This is a science class');
INSERT INTO courses (course_name, course_description) VALUES ('Programming','Learn to wire it up!!');

COMMIT TRANSACTION;
