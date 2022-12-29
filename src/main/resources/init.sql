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

   techStack_id int,
   CONSTRAINT fk_techStack FOREIGN KEY(techStack_id) REFERENCES position(techStackId),
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

CREATE TABLE [IF NOT EXISTS] techStack (
    techStackId SERIAL PRIMARY KEY,
    back_id int,
    front_id int,
    qa_id int,
    designer_id int
    CONSTRAINT fk_back FOREIGN KEY(back_id) REFERENCES position(backId),
    CONSTRAINT fk_front FOREIGN KEY(front_id) REFERENCES position(frontId),
    CONSTRAINT fk_qa FOREIGN KEY(qa_id) REFERENCES position(qaId),
    CONSTRAINT fk_designer FOREIGN KEY(designer_id) REFERENCES position(designerId),
--    level
);

CREATE TABLE [IF NOT EXISTS] techStack (
    techStackId SERIAL PRIMARY KEY,
    back_id int,
    front_id int,
    qa_id int,
    designer_id int
    CONSTRAINT fk_back FOREIGN KEY(back_id) REFERENCES position(backId),
    CONSTRAINT fk_front FOREIGN KEY(front_id) REFERENCES position(frontId),
    CONSTRAINT fk_qa FOREIGN KEY(qa_id) REFERENCES position(qaId),
    CONSTRAINT fk_designer FOREIGN KEY(designer_id) REFERENCES position(designerId),
--    level
);