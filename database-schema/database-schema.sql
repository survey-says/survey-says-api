-- Code to initially create and populate the sql database

--Make the schema
drop schema if exists survey_says cascade;
create schema survey_says;

set schema 'survey_says';

-----------------------
-- Create the tables --
-----------------------

create table survey_user
(
	user_id serial primary key,
	username varchar(20) not null unique,
	password text not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	email varchar(30) not null
);

create table survey
(	
	survey_id serial primary key,
	creator int not null,
	title text not null,
	description text not null,
	date_created date not null,
	closing_date date not null,
	status int not null,
	privacy int not null
);

create table survey_status
(
	status_id serial primary key,
	status varchar(10) not null unique
);

create table survey_privacy
(
	privacy_id serial primary key,
	privacy varchar(10) not null unique
);

create table survey_role
(
	role_id serial primary key,
	survey_role varchar(20) not null unique
);

create table role_junction
(
	junction_id serial primary key,
	survey_id int not null,
	user_id int not null,
	role_id int not null
);

create table question
(	
	question_id serial primary key,
	question_text text not null,
	survey_id int not null,
	type_id int not null
);

create table question_type
(
	type_id serial primary key,
	question_type varchar(20) not null unique
);

create table answer_choice
(	
	choice_id serial primary key,
	answer_text text not null,
	question_id int not null
);

create table response
(	
	response_id serial primary key,
	question_id int not null,
	answer_chosen int not null
);

--------------------------
-- Add the foreign keys --
--------------------------

-- Link the roles to the junction table
alter table role_junction
add constraint fk_role 
foreign key (role_id) references survey_role (role_id);

-- Link the surveys to the junction table
alter table role_junction
add constraint fk_survey_junction
foreign key (survey_id) references survey (survey_id);

-- Link the users to the junction table
alter table role_junction
add constraint fk_user_junction
foreign key (user_id) references survey_user (user_id);

-- Link the creators to the surveys
alter table survey
add constraint fk_survey_creator 
foreign key (creator) references survey_user (user_id)
on delete cascade on update cascade;

-- Link the status to the surveys
alter table survey
add constraint fk_survey_status
foreign key (status) references survey_status (status_id)
on delete cascade on update cascade;

-- Link the privacy to the surveys
alter table survey
add constraint fk_survey_privacy
foreign key (privacy) references survey_privacy (privacy_id)
on delete cascade on update cascade;

-- Link the survey to the questions
alter table question
add constraint fk_survey_question
foreign key (survey_id) references survey (survey_id);

-- Link the question type to the questions
alter table question
add constraint fk_question_type
foreign key (type_id) references question_type (type_id);

-- Link the question to the answer choices
alter table answer_choice
add constraint fk_answer_choice
foreign key (question_id) references question (question_id);

-- Link the question to the responses
alter table response
add constraint fk_response_to_question
foreign key (question_id) references question (question_id);

-- Link the answer_choice to the responses
alter table response
add constraint fk_response
foreign key (answer_chosen) references answer_choice (choice_id);

---------------------
-- Populate tables --
----------------------

insert into survey_role (survey_role) 
values ('creator');
insert into survey_role (survey_role) 
values ('moderator');
insert into survey_role (survey_role) 
values ('user');

insert into survey_status (status)
values ('Open');
insert into survey_status (status)
values ('Closed');

insert into survey_privacy (privacy)
values ('Public');
insert into survey_privacy (privacy)
values ('Private');

insert into question_type (question_type)
values ('Multiple Choice');
insert into question_type (question_type)
values ('Yes or No');
insert into question_type (question_type)
values ('Agree or Disagree');
insert into question_type (question_type)
values ('Rating');
insert into question_type (question_type)
values ('Feedback');

-- Add some users
insert into survey_user (username, password, first_name, last_name, email) 
values ('lori', 'pass55', 'Lori', 'Oliver', 'lori@surveysays.com');
insert into survey_user (username, password, first_name, last_name, email) 
values ('aaron', 'pass66', 'Aaron', 'Gravelle', 'aaron@surveysays.com');
insert into survey_user (username, password, first_name, last_name, email) 
values ('iman', 'pass33', 'Iman', 'Davis-Young', 'iman@surveysays.com');
insert into survey_user (username, password, first_name, last_name, email) 
values ('hank', 'pass44', 'Hank', 'Zimmer', 'hank@surveysays.com');
insert into survey_user (username, password, first_name, last_name, email) 
values ('creator', 'creator', 'Survey', 'Creator', 'mod@surveysays.com');
insert into survey_user (username, password, first_name, last_name, email) 
values ('mod', 'mod', 'Survey','Moderator', 'mod@surveysays.com');

-- Add some surveys
insert into survey (creator, title, description, date_created, closing_date, status, privacy)
values (4, 'Favorite Foods', 'A survey to determine the favorite foods of survey-takers', '2019/2/18', '2019/2/26', 2, 1);
insert into survey (creator, title, description, date_created, closing_date, status, privacy)
values (1, 'City Preferences', 'A survey to determine which cities are most desirable', '2019/2/25', '2019/3/19', 1, 1);


-- Add questions to survey 1 (Favorite Food)
insert into question (question_text, survey_id, type_id)
values ('Of the following, what type of cuisine do your like the best?', 1, 1);
insert into question (question_text, survey_id, type_id)
values ('Are you a fan of Mango?', 1, 2);
insert into question (question_text, survey_id, type_id)
values ('I love pizza!', 1, 3);
insert into question (question_text, survey_id, type_id)
values ('What type of food do you want to think is underrated?', 1, 5);

-- Add questions for survey 2 (City Preferences)
insert into question (question_text, survey_id, type_id)
values ('Do you enjoy living in Tampa?', 2, 2);
insert into question (question_text, survey_id, type_id)
values ('Which city is the best of the following?', 2, 1);
insert into question (question_text, survey_id, type_id)
values ('I love cities', 2, 3);
insert into question (question_text, survey_id, type_id)
values ('With 5 being the best, how would you rate Tampa?', 2, 4);
insert into question (question_text, survey_id, type_id)
values ('Are there any other cities that you love?', 2, 5);

-- Insert Question Choices --

-- Question 1 (Survey 1, Favorite Food)
insert into answer_choice (answer_text, question_id)
values('Chinese', 1);
insert into answer_choice (answer_text, question_id)
values('Jamaican', 1); 
insert into answer_choice (answer_text, question_id)
values('Italian', 1);
insert into answer_choice (answer_text, question_id)
values('Mexican', 1);
insert into answer_choice (answer_text, question_id)
values('American', 1);
insert into answer_choice (answer_text, question_id)
values('Japanese', 1);
insert into answer_choice (answer_text, question_id)
values('Thai', 1);
insert into answer_choice (answer_text, question_id)
values('Indian', 1);
insert into answer_choice (answer_text, question_id)
values('Mediterranean', 1);
insert into answer_choice (answer_text, question_id)
values('Filipino', 1);

-- Question 2 (Survey 1, Favorite Food)
insert into answer_choice (answer_text, question_id)
values('Yes', 2);
insert into answer_choice (answer_text, question_id)
values('No', 2); 
insert into answer_choice (answer_text, question_id)
values('Maybe', 2); 

-- Question 3 (Survey 1, Favorite Food)
insert into answer_choice (answer_text, question_id)
values('Strongly Agree', 3);
insert into answer_choice (answer_text, question_id)
values('Agree', 3);
insert into answer_choice (answer_text, question_id)
values('Neutral', 3);
insert into answer_choice (answer_text, question_id)
values('Disagree', 3);
insert into answer_choice (answer_text, question_id)
values('Strongly Disagree', 3);

-- Question 5 (Survey 2, City Preferences)
insert into answer_choice (answer_text, question_id)
values('Yes', 5);
insert into answer_choice (answer_text, question_id)
values('No', 5);
insert into answer_choice (answer_text, question_id)
values('Maybe', 5);

-- Question 6 (Survey 2, City Preferences)
insert into answer_choice (answer_text, question_id)
values('Miami', 6);
insert into answer_choice (answer_text, question_id)
values('New York City', 6);
insert into answer_choice (answer_text, question_id)
values('Atlanta', 6);
insert into answer_choice (answer_text, question_id)
values('Los Angeles', 6);
insert into answer_choice (answer_text, question_id)
values('London', 6);
insert into answer_choice (answer_text, question_id)
values('Tokyo', 6);
insert into answer_choice (answer_text, question_id)
values('Beijing', 6);
insert into answer_choice (answer_text, question_id)
values('Denver', 6);
insert into answer_choice (answer_text, question_id)
values('Zurich', 6);
insert into answer_choice (answer_text, question_id)
values('Seattle', 6);
insert into answer_choice (answer_text, question_id)
values('San Diego', 6);
insert into answer_choice (answer_text, question_id)
values('Houston', 6);

-- Question 7 (Survey 2, City Preferences)
insert into answer_choice (answer_text, question_id)
values('Strongly Agree', 7);
insert into answer_choice (answer_text, question_id)
values('Agree', 7);
insert into answer_choice (answer_text, question_id)
values('Neutral', 7);
insert into answer_choice (answer_text, question_id)
values('Disagree', 7);
insert into answer_choice (answer_text, question_id)
values('Strongly Disagree', 7);

-- Question 7 (Survey 2, City Preferences)
insert into answer_choice (answer_text, question_id)
values('1', 8);
insert into answer_choice (answer_text, question_id)
values('2', 8);
insert into answer_choice (answer_text, question_id)
values('3', 8);
insert into answer_choice (answer_text, question_id)
values('4', 8);
insert into answer_choice (answer_text, question_id)
values('5', 8);

-- Insert responses for question 1 (Favorite Food)
insert into response (question_id, answer_chosen) 
values(1, 2);
insert into response (question_id, answer_chosen) 
values(1, 4);
insert into response (question_id, answer_chosen) 
values(1, 8);
insert into response (question_id, answer_chosen) 
values(1, 1);
insert into response (question_id, answer_chosen) 
values(1, 4);
insert into response (question_id, answer_chosen) 
values(1, 7);
insert into response (question_id, answer_chosen) 
values(1, 4);
insert into response (question_id, answer_chosen) 
values(1, 1);
insert into response (question_id, answer_chosen) 
values(1, 5);
insert into response (question_id, answer_chosen) 
values(1, 4);
insert into response (question_id, answer_chosen) 
values(1, 2);
insert into response (question_id, answer_chosen) 
values(1, 4);
insert into response (question_id, answer_chosen) 
values(1, 6);

-- Insert responses for question 2 (Do you like Mangos)
insert into response (question_id, answer_chosen) 
values(2, 1);
insert into response (question_id, answer_chosen) 
values(2, 2);
insert into response (question_id, answer_chosen) 
values(2, 1);
insert into response (question_id, answer_chosen) 
values(2, 3);
insert into response (question_id, answer_chosen) 
values(2, 1);

-- Insert responses for question 3 (I love pizza)
insert into response (question_id, answer_chosen) 
values(3, 1);
insert into response (question_id, answer_chosen) 
values(3, 6);
insert into response (question_id, answer_chosen) 
values(3, 5);
insert into response (question_id, answer_chosen) 
values(3, 2);
insert into response (question_id, answer_chosen) 
values(3, 1);
insert into response (question_id, answer_chosen) 
values(3, 2);
insert into response (question_id, answer_chosen) 
values(3, 3);
insert into response (question_id, answer_chosen) 
values(3, 2);

-- Insert responses for question 5 (Do you like Tampa)
insert into response (question_id, answer_chosen) 
values(5, 1);
insert into response (question_id, answer_chosen) 
values(5, 2);
insert into response (question_id, answer_chosen) 
values(5, 1);
insert into response (question_id, answer_chosen) 
values(5, 1);
insert into response (question_id, answer_chosen) 
values(5, 3);

-- Insert responses for question 6 (Favorite City)
insert into response (question_id, answer_chosen) 
values(6, 1);
insert into response (question_id, answer_chosen) 
values(6, 3);
insert into response (question_id, answer_chosen) 
values(6, 5);
insert into response (question_id, answer_chosen) 
values(6, 7);
insert into response (question_id, answer_chosen) 
values(6, 3);
insert into response (question_id, answer_chosen) 
values(6, 2);
insert into response (question_id, answer_chosen) 
values(6, 10);
insert into response (question_id, answer_chosen) 
values(6, 5);
insert into response (question_id, answer_chosen) 
values(6, 2);
insert into response (question_id, answer_chosen) 
values(6, 11);

-- Insert responses for question 7 (I like cities)
insert into response (question_id, answer_chosen) 
values(7, 1);
insert into response (question_id, answer_chosen) 
values(7, 2);
insert into response (question_id, answer_chosen) 
values(7, 6);
insert into response (question_id, answer_chosen) 
values(7, 3);
insert into response (question_id, answer_chosen) 
values(7, 1);
insert into response (question_id, answer_chosen) 
values(7, 1);
insert into response (question_id, answer_chosen) 
values(7, 2);
insert into response (question_id, answer_chosen) 
values(7, 4);

-- Insert responses for question 7 (Tampa Ratings)
insert into response (question_id, answer_chosen) 
values(8, 1);
insert into response (question_id, answer_chosen) 
values(8, 2);
insert into response (question_id, answer_chosen) 
values(8, 1);
insert into response (question_id, answer_chosen) 
values(8, 4);
insert into response (question_id, answer_chosen) 
values(8, 1);

-- Add the user-survey-roles
insert into role_junction (survey_id, user_id, role_id)
values(1, 1, 2);
insert into role_junction (survey_id, user_id, role_id)
values(2, 1, 2);
insert into role_junction (survey_id, user_id, role_id)
values(1, 2, 2);
insert into role_junction (survey_id, user_id, role_id)
values(2, 2, 2);
insert into role_junction (survey_id, user_id, role_id)
values(1, 3, 2);
insert into role_junction (survey_id, user_id, role_id)
values(2, 3, 2);
insert into role_junction (survey_id, user_id, role_id)
values(1, 4, 2);
insert into role_junction (survey_id, user_id, role_id)
values(2, 4, 2);
insert into role_junction (survey_id, user_id, role_id)
values(1, 5, 1);
insert into role_junction (survey_id, user_id, role_id)
values(2, 5, 1);
insert into role_junction (survey_id, user_id, role_id)
values(1, 6, 2);
insert into role_junction (survey_id, user_id, role_id)
values(2, 6, 2);