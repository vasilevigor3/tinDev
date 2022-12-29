CREATE TABLE [IF NOT EXISTS] tinDevUser (
   userId SERIAL PRIMARY KEY,
   userName varchar(20) ,
   userLastName varchar(20) ,

   workType varchar(15) ,
   salaryExpectations integer ,
   experience integer ,
   language_id int,
   CONSTRAINT fk_language FOREIGN KEY(language_id) REFERENCES language(languageId),

   position_id int,
   CONSTRAINT fk_position FOREIGN KEY(position_id) REFERENCES position(positionId),

   stack varchar(50),
);

CREATE TABLE [IF NOT EXISTS] language (
    languageId SERIAL PRIMARY KEY,
    language varchar(30)
--    level
);

CREATE TABLE [IF NOT EXISTS] position (
    positionId SERIAL PRIMARY KEY,
    carrier varchar(15),
    seniority varchar(30)
);


CREATE TABLE [IF NOT EXISTS] vacancy (
    vacancyId SERIAL PRIMARY KEY,
    companyName varchar(100),
    description text,
--    postedOn
    requiredSeniority varchar(30),
    jobTitle varchar(15),
    companyStatus varchar(30),
    vacancyStatus varchar(30),
    techStack varchar(30)

);

