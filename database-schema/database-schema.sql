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
	privacy int not null
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
	survey int not null,
	survey_user int not null,
	survey_role int not null
);

create table question
(	
	question_id serial primary key,
	question_text text not null,
	survey int not null,
	question_type int not null
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
	question int not null
);

create table response
(	
	response_id serial primary key,
	answer_chosen int not null
);

--------------------------
-- Add the foreign keys --
--------------------------

-- Link the roles to the junction table
alter table role_junction
add constraint fk_role 
foreign key (survey_role) references survey_role (role_id);

-- Link the surveys to the junction table
alter table role_junction
add constraint fk_survey_junction
foreign key (survey) references survey (survey_id);

-- Link the users to the junction table
alter table role_junction
add constraint fk_user_junction
foreign key (survey_user) references survey_user (user_id);

-- Link the creators to the surveys
alter table survey
add constraint fk_survey_creator 
foreign key (creator) references survey_user (user_id)
on delete cascade on update cascade;

-- Link the privacy to the surveys
alter table survey
add constraint fk_survey_privacy
foreign key (privacy) references survey_privacy (privacy_id)
on delete cascade on update cascade;

-- Link the survey to the questions
alter table question
add constraint fk_survey_question
foreign key (survey) references survey (survey_id);

-- Link the question type to the questions
alter table question
add constraint fk_question_type
foreign key (question_type) references question_type (type_id);

-- Link the question to the answer choices
alter table answer_choice
add constraint fk_answer_choice
foreign key (question) references question (question_id);

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
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (4, 'Favorite Foods', 'A survey to determine the favorite foods of survey-takers', '2019/2/18', '2019/2/26', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (1, 'City Preferences', 'A survey to determine which cities are most desirable', '2019/2/25', '2019/3/19', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (1, 'Study Habits', 'A survey for the study habits of university students', '2019/2/28', '2019/3/5', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (1, 'Favorite Operating System', 'Questions regarding the primary operating system used on various devices', '2019/2/6', '2019/2/14', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (2, 'Transporation Prefences', 'Methods of transportation used by survey-takers', '2019/1/10', '2019/1/15', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (2, 'Clothing Styles', 'A survey for clothing styles', '2019/2/10', '2019/4/10', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (2, 'Favorite Beverages', 'Which beverages are most popular and most commonly known', '2019/2/6', '2019/3/5', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (3, 'Air travel', 'Everything from airline preferences to travel desires', '2019/2/16', '2019/3/7', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (3, 'Vacation destinations', 'A survey to learn about your favorite places to get away and relax', '2019/1/18', '2019/2/20', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (3, 'Exotic Foods', 'Have you tried the most exotic and unique foods from around the world?', '2019/1/4', '2019/3/5', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (4, 'Favorite animals', 'Which animals are your favorites as pets and to see in the wild', '2019/3/3', '2019/3/20', 1);
insert into survey (creator, title, description, date_created, closing_date, privacy)
values (4, 'Languages', 'A survey about languages', '2019/2/5', '2019/3/5', 1);


-- Add questions to survey 1 (Favorite Food)
insert into question (question_text, survey, question_type)
values ('Of the following, what type of cuisine do your like the best?', 1, 1);
insert into question (question_text, survey, question_type)
values ('Are you a fan of Mango?', 1, 2);
insert into question (question_text, survey, question_type)
values ('I love pizza!', 1, 3);
insert into question (question_text, survey, question_type)
values ('What type of food do you want to think is underrated?', 1, 5);

-- Add questions for survey 2 (City Preferences)
insert into question (question_text, survey, question_type)
values ('Do you enjoy living in Tampa?', 2, 2);
insert into question (question_text, survey, question_type)
values ('Which city is the best of the following?', 2, 1);
insert into question (question_text, survey, question_type)
values ('I love cities', 2, 3);
insert into question (question_text, survey, question_type)
values ('With 5 being the best, how would you rate Tampa?', 2, 4);
insert into question (question_text, survey, question_type)
values ('Are there any other cities that you love?', 2, 5);

-- Insert Question Choices --

-- Question 1 (Survey 1, Favorite Food)
insert into answer_choice (answer_text, question)
values('Chinese', 1);
insert into answer_choice (answer_text, question)
values('Jamaican', 1); 
insert into answer_choice (answer_text, question)
values('Italian', 1);
insert into answer_choice (answer_text, question)
values('Mexican', 1);
insert into answer_choice (answer_text, question)
values('American', 1);
insert into answer_choice (answer_text, question)
values('Japanese', 1);
insert into answer_choice (answer_text, question)
values('Thai', 1);
insert into answer_choice (answer_text, question)
values('Indian', 1);
insert into answer_choice (answer_text, question)
values('Mediterranean', 1);
insert into answer_choice (answer_text, question)
values('Filipino', 1);

-- Question 2 (Survey 1, Favorite Food)
insert into answer_choice (answer_text, question)
values('Yes', 2);
insert into answer_choice (answer_text, question)
values('No', 2); 
insert into answer_choice (answer_text, question)
values('Maybe', 2); 

-- Question 3 (Survey 1, Favorite Food)
insert into answer_choice (answer_text, question)
values('Strongly Agree', 3);
insert into answer_choice (answer_text, question)
values('Agree', 3);
insert into answer_choice (answer_text, question)
values('Neutral', 3);
insert into answer_choice (answer_text, question)
values('Disagree', 3);
insert into answer_choice (answer_text, question)
values('Strongly Disagree', 3);

-- Question 5 (Survey 2, City Preferences)
insert into answer_choice (answer_text, question)
values('Yes', 5);
insert into answer_choice (answer_text, question)
values('No', 5);
insert into answer_choice (answer_text, question)
values('Maybe', 5);

-- Question 6 (Survey 2, City Preferences)
insert into answer_choice (answer_text, question)
values('Miami', 6);
insert into answer_choice (answer_text, question)
values('New York City', 6);
insert into answer_choice (answer_text, question)
values('Atlanta', 6);
insert into answer_choice (answer_text, question)
values('Los Angeles', 6);
insert into answer_choice (answer_text, question)
values('London', 6);
insert into answer_choice (answer_text, question)
values('Tokyo', 6);
insert into answer_choice (answer_text, question)
values('Beijing', 6);
insert into answer_choice (answer_text, question)
values('Denver', 6);
insert into answer_choice (answer_text, question)
values('Zurich', 6);
insert into answer_choice (answer_text, question)
values('Seattle', 6);
insert into answer_choice (answer_text, question)
values('San Diego', 6);
insert into answer_choice (answer_text, question)
values('Houston', 6);

-- Question 7 (Survey 2, City Preferences)
insert into answer_choice (answer_text, question)
values('Strongly Agree', 7);
insert into answer_choice (answer_text, question)
values('Agree', 7);
insert into answer_choice (answer_text, question)
values('Neutral', 7);
insert into answer_choice (answer_text, question)
values('Disagree', 7);
insert into answer_choice (answer_text, question)
values('Strongly Disagree', 7);

-- Question 7 (Survey 2, City Preferences)
insert into answer_choice (answer_text, question)
values('1', 8);
insert into answer_choice (answer_text, question)
values('2', 8);
insert into answer_choice (answer_text, question)
values('3', 8);
insert into answer_choice (answer_text, question)
values('4', 8);
insert into answer_choice (answer_text, question)
values('5', 8);

-- Insert responses for question 1 (Favorite Food)
insert into response (answer_chosen) 
values(2);
insert into response (answer_chosen) 
values(4);
insert into response (answer_chosen) 
values(8);
insert into response (answer_chosen) 
values(1);
insert into response (answer_chosen) 
values(4);
insert into response (answer_chosen) 
values(7);
insert into response (answer_chosen) 
values(4);
insert into response (answer_chosen) 
values(1);
insert into response (answer_chosen) 
values(5);
insert into response (answer_chosen) 
values(4);
insert into response (answer_chosen) 
values(2);
insert into response (answer_chosen) 
values(4);
insert into response (answer_chosen) 
values(6);

-- Insert responses for question 2 (Do you like Mangos)
insert into response (answer_chosen) 
values(11);
insert into response (answer_chosen) 
values(12);
insert into response (answer_chosen) 
values(11);
insert into response (answer_chosen) 
values(13);
insert into response (answer_chosen) 
values(11);

-- Insert responses for question 3 (I love pizza)
insert into response (answer_chosen) 
values(14);
insert into response (answer_chosen) 
values(16);
insert into response (answer_chosen) 
values(15);
insert into response (answer_chosen) 
values(18);
insert into response (answer_chosen) 
values(14);
insert into response (answer_chosen) 
values(15);
insert into response (answer_chosen) 
values(18);
insert into response (answer_chosen) 
values(16);

-- Insert responses for question 5 (Do you like Tampa)
insert into response (answer_chosen) 
values(19);
insert into response (answer_chosen) 
values(20);
insert into response (answer_chosen) 
values(19);
insert into response (answer_chosen) 
values(19);
insert into response (answer_chosen) 
values(21);

-- Insert responses for question 6 (Favorite City)
insert into response (answer_chosen) 
values(22);
insert into response (answer_chosen) 
values(30);
insert into response (answer_chosen) 
values(25);
insert into response (answer_chosen) 
values(27);
insert into response (answer_chosen) 
values(23);
insert into response (answer_chosen) 
values(28);
insert into response (answer_chosen) 
values(31);
insert into response (answer_chosen) 
values(25);
insert into response (answer_chosen) 
values(29);
insert into response (answer_chosen) 
values(32);

-- Insert responses for question 7 (I like cities)
insert into response (answer_chosen) 
values(35);
insert into response (answer_chosen) 
values(36);
insert into response (answer_chosen) 
values(37);
insert into response (answer_chosen) 
values(35);
insert into response (answer_chosen) 
values(34);
insert into response (answer_chosen) 
values(38);
insert into response (answer_chosen) 
values(34);
insert into response (answer_chosen) 
values(34);

-- Insert responses for question 7 (Tampa Ratings)
insert into response (answer_chosen) 
values(39);
insert into response (answer_chosen) 
values(42);
insert into response (answer_chosen) 
values(41);
insert into response (answer_chosen) 
values(43);
insert into response (answer_chosen) 
values(41);

-- Add the user-survey-roles
insert into role_junction (survey, survey_user, survey_role)
values(1, 1, 2);
insert into role_junction (survey, survey_user, survey_role)
values(2, 1, 1);
insert into role_junction (survey, survey_user, survey_role)
values(3, 1, 1);
insert into role_junction (survey, survey_user, survey_role)
values(4, 1, 1);
insert into role_junction (survey, survey_user, survey_role)
values(5, 1, 2);
insert into role_junction (survey, survey_user, survey_role)
values(6, 1, 2);
insert into role_junction (survey, survey_user, survey_role)
values(7, 1, 2);
insert into role_junction (survey, survey_user, survey_role)
values(8, 1, 2);
insert into role_junction (survey, survey_user, survey_role)
values(9, 1, 2);
insert into role_junction (survey, survey_user, survey_role)
values(10, 1, 2);
insert into role_junction (survey, survey_user, survey_role)
values(11, 1, 2);
insert into role_junction (survey, survey_user, survey_role)
values(12, 1, 2);
insert into role_junction (survey, survey_user, survey_role)
values(1, 2, 2);
insert into role_junction (survey, survey_user, survey_role)
values(2, 2, 2);
insert into role_junction (survey, survey_user, survey_role)
values(3, 2, 2);
insert into role_junction (survey, survey_user, survey_role)
values(4, 2, 2);
insert into role_junction (survey, survey_user, survey_role)
values(5, 2, 1);
insert into role_junction (survey, survey_user, survey_role)
values(6, 2, 1);
insert into role_junction (survey, survey_user, survey_role)
values(7, 2, 1);
insert into role_junction (survey, survey_user, survey_role)
values(8, 2, 2);
insert into role_junction (survey, survey_user, survey_role)
values(9, 2, 2);
insert into role_junction (survey, survey_user, survey_role)
values(10, 2, 2);
insert into role_junction (survey, survey_user, survey_role)
values(11, 2, 2);
insert into role_junction (survey, survey_user, survey_role)
values(12, 2, 2);
insert into role_junction (survey, survey_user, survey_role)
values(1, 3, 2);
insert into role_junction (survey, survey_user, survey_role)
values(2, 3, 2);
insert into role_junction (survey, survey_user, survey_role)
values(3, 3, 2);
insert into role_junction (survey, survey_user, survey_role)
values(4, 3, 2);
insert into role_junction (survey, survey_user, survey_role)
values(5, 3, 2);
insert into role_junction (survey, survey_user, survey_role)
values(6, 3, 2);
insert into role_junction (survey, survey_user, survey_role)
values(7, 3, 2);
insert into role_junction (survey, survey_user, survey_role)
values(8, 3, 1);
insert into role_junction (survey, survey_user, survey_role)
values(9, 3, 1);
insert into role_junction (survey, survey_user, survey_role)
values(10, 3, 1);
insert into role_junction (survey, survey_user, survey_role)
values(11, 3, 2);
insert into role_junction (survey, survey_user, survey_role)
values(12, 3, 2);
insert into role_junction (survey, survey_user, survey_role)
values(1, 4, 1);
insert into role_junction (survey, survey_user, survey_role)
values(2, 4, 2);
insert into role_junction (survey, survey_user, survey_role)
values(3, 4, 2);
insert into role_junction (survey, survey_user, survey_role)
values(4, 4, 2);
insert into role_junction (survey, survey_user, survey_role)
values(5, 4, 2);
insert into role_junction (survey, survey_user, survey_role)
values(6, 4, 2);
insert into role_junction (survey, survey_user, survey_role)
values(7, 4, 2);
insert into role_junction (survey, survey_user, survey_role)
values(8, 4, 2);
insert into role_junction (survey, survey_user, survey_role)
values(9, 4, 2);
insert into role_junction (survey, survey_user, survey_role)
values(10, 4, 2);
insert into role_junction (survey, survey_user, survey_role)
values(11, 4, 1);
insert into role_junction (survey, survey_user, survey_role)
values(12, 4, 1);
insert into role_junction (survey, survey_user, survey_role)
values(1, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(2, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(3, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(4, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(5, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(6, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(7, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(8, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(9, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(10, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(11, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(12, 5, 1);
insert into role_junction (survey, survey_user, survey_role)
values(1, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(2, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(3, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(4, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(5, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(6, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(7, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(8, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(9, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(10, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(11, 6, 2);
insert into role_junction (survey, survey_user, survey_role)
values(12, 6, 2);
