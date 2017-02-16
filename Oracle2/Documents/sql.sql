 ---------------------------------------------------------------
 --        Script Oracle.  
 ---------------------------------------------------------------


------------------------------------------------------------
-- Table: Personne
------------------------------------------------------------
CREATE TABLE Personne(
	id_personne  NUMBER NOT NULL ,
	pseudo       VARCHAR2 (50) NOT NULL  ,
	Role         VARCHAR2 (25)  ,
	CONSTRAINT Personne_Pk PRIMARY KEY (id_personne)
);

------------------------------------------------------------
-- Table: Quizz
------------------------------------------------------------
CREATE TABLE Quizz(
	duree_quizz  NUMBER(10,0)  NOT NULL  ,
	id_quizz     NUMBER NOT NULL ,
	CONSTRAINT Quizz_Pk PRIMARY KEY (id_quizz)
);

------------------------------------------------------------
-- Table: Question
------------------------------------------------------------
CREATE TABLE Question(
	id_question  NUMBER NOT NULL ,
	intitule     VARCHAR2 (200) NOT NULL  ,
	image        VARCHAR2 (50) NOT NULL  ,
	CONSTRAINT Question_Pk PRIMARY KEY (id_question)
);

------------------------------------------------------------
-- Table: Reponses
------------------------------------------------------------
CREATE TABLE Reponses(
	id_reponse  NUMBER NOT NULL ,
	image       VARCHAR2 (50) NOT NULL  ,
	intitule    VARCHAR2 (200) NOT NULL  ,
	CONSTRAINT Reponses_Pk PRIMARY KEY (id_reponse)
);

------------------------------------------------------------
-- Table: Participe
------------------------------------------------------------
CREATE TABLE Participe(
	score        NUMBER(10,0)  NOT NULL  ,
	id_personne  NUMBER(10,0)  NOT NULL  ,
	id_quizz     NUMBER(10,0)  NOT NULL  ,
	CONSTRAINT Participe_Pk PRIMARY KEY (id_personne,id_quizz)
);

------------------------------------------------------------
-- Table: Est_compose_de
------------------------------------------------------------
CREATE TABLE Est_compose_de(
	id_quizz     NUMBER(10,0)  NOT NULL  ,
	id_question  NUMBER(10,0)  NOT NULL  ,
	CONSTRAINT Est_compose_de_Pk PRIMARY KEY (id_quizz,id_question)
);

------------------------------------------------------------
-- Table: Question_Reponse
------------------------------------------------------------
CREATE TABLE Question_Reponse(
	est_juste    NUMBER (1) NOT NULL  ,
	id_question  NUMBER(10,0)  NOT NULL  ,
	id_reponse   NUMBER(10,0)  NOT NULL  ,
	CONSTRAINT Question_Reponse_Pk PRIMARY KEY (id_question,id_reponse) ,
	CONSTRAINT CHK_BOOLEAN_est_juste CHECK (est_juste IN (0,1))
);




ALTER TABLE Participe ADD FOREIGN KEY (id_personne) REFERENCES Personne(id_personne);
ALTER TABLE Participe ADD FOREIGN KEY (id_quizz) REFERENCES Quizz(id_quizz);
ALTER TABLE Est_compose_de ADD FOREIGN KEY (id_quizz) REFERENCES Quizz(id_quizz);
ALTER TABLE Est_compose_de ADD FOREIGN KEY (id_question) REFERENCES Question(id_question);
ALTER TABLE Question_Reponse ADD FOREIGN KEY (id_question) REFERENCES Question(id_question);
ALTER TABLE Question_Reponse ADD FOREIGN KEY (id_reponse) REFERENCES Reponses(id_reponse);

CREATE SEQUENCE Seq_Personne_id_personne START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Quizz_id_quizz START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Question_id_question START WITH 1 INCREMENT BY 1 NOCYCLE;
CREATE SEQUENCE Seq_Reponses_id_reponse START WITH 1 INCREMENT BY 1 NOCYCLE;


CREATE OR REPLACE TRIGGER Personne_id_personne
	BEFORE INSERT ON Personne 
  FOR EACH ROW 
	WHEN (NEW.id_personne IS NULL) 
	BEGIN
		 select Seq_Personne_id_personne.NEXTVAL INTO :NEW.id_personne from DUAL; 
	END;
CREATE OR REPLACE TRIGGER Quizz_id_quizz
	BEFORE INSERT ON Quizz 
  FOR EACH ROW 
	WHEN (NEW.id_quizz IS NULL) 
	BEGIN
		 select Seq_Quizz_id_quizz.NEXTVAL INTO :NEW.id_quizz from DUAL; 
	END;
CREATE OR REPLACE TRIGGER Question_id_question
	BEFORE INSERT ON Question 
  FOR EACH ROW 
	WHEN (NEW.id_question IS NULL) 
	BEGIN
		 select Seq_Question_id_question.NEXTVAL INTO :NEW.id_question from DUAL; 
	END;
CREATE OR REPLACE TRIGGER Reponses_id_reponse
	BEFORE INSERT ON Reponses 
  FOR EACH ROW 
	WHEN (NEW.id_reponse IS NULL) 
	BEGIN
		 select Seq_Reponses_id_reponse.NEXTVAL INTO :NEW.id_reponse from DUAL; 
	END;

