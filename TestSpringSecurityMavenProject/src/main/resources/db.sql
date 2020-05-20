
CREATE SEQUENCE  "LAB3MU_DEPARTMENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 3 CACHE 20 ;


CREATE SEQUENCE  "LAB3MU_JOB_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 4 CACHE 20 ;


CREATE SEQUENCE  "LAB3MU_MEDICINE_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 4 CACHE 20;


CREATE SEQUENCE  "LAB3MU_DIAGNOSIS_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 4 CACHE 20 ;


CREATE SEQUENCE  "LAB3MU_PATIENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 4 CACHE 20 ;


CREATE SEQUENCE  "LAB3MU_PERSONAL_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 5 CACHE 20 ;


CREATE SEQUENCE  "LAB3MU_TREATMENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 4 CACHE 20 ;


CREATE SEQUENCE  "LAB3MU_USER_DATA_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 5 CACHE 20 ;

--DEPARTMENT

CREATE TABLE "LAB3MU_DEPARTMENT"
(	"DEPARTMENT_ID" NUMBER NOT NULL ENABLE,
     "DEPARTMENT_NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "DEPARTMENT_BUDGET" NUMBER NOT NULL ENABLE,
     CONSTRAINT "LAB3MU_DEPARTMENT_PK" PRIMARY KEY ("DEPARTMENT_ID")
);

--PERSONAL

CREATE TABLE "LAB3MU_PERSONAL"
(	"PERSONAL_ID" NUMBER NOT NULL ENABLE,
     "FIRST_NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "LAST_NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "BOSS_ID" NUMBER,
     "JOB_ID" NUMBER,
     "COMMISSIONS" NUMBER,
     "SALARY" NUMBER NOT NULL ENABLE,
     "DEPARTMENT_ID" NUMBER,
     "PATIENT_ID" NUMBER,
     CONSTRAINT "LAB3MU_PERSONAL_PK" PRIMARY KEY ("PERSONAL_ID")
);

--USER_DATA

CREATE TABLE "LAB3MU_USER_DATA"
(	"PERSONAL_ID" NUMBER NOT NULL ENABLE,
     "USER_NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "PASSWORD" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "ROLE" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "ENABLE" NUMBER NOT NULL ENABLE,
     CONSTRAINT "LAB3MU_USER_DATA_PK" PRIMARY KEY ("PERSONAL_ID")
);

--JOBS

CREATE TABLE "LAB3MU_JOBS"
(	"JOB_ID" NUMBER NOT NULL ENABLE,
     "JOB_NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "MIN_SALARY" NUMBER NOT NULL ENABLE,
     "MAX_SALARY" NUMBER NOT NULL ENABLE,
     CONSTRAINT "LAB3MU_JOBS_PK" PRIMARY KEY ("JOB_ID")
);
--TREATMENT

CREATE TABLE "LAB3MU_TREATMENT"
(	"TREATMENT_ID" NUMBER NOT NULL ENABLE,
     "NAME_OF_TREATMENT" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "DURATION_DAYS" NUMBER NOT NULL ENABLE,
     CONSTRAINT "LAB3MU_TREATMENT_PK" PRIMARY KEY ("TREATMENT_ID")
);
--DIAGNOSIS

CREATE TABLE "LAB3MU_DIAGNOSIS"
(	"DIAGNOSIS_ID" NUMBER NOT NULL ENABLE,
     "DAY_TO_DEATH" NUMBER,
     "DIAGNOSIS_NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "TREATMENT_ID" NUMBER,
     CONSTRAINT "LAB3MU_DIAGNOSIS_PK" PRIMARY KEY ("DIAGNOSIS_ID")
);

--PATIENT
CREATE TABLE "LAB3MU_PATIENT"
(	"PATIENT_ID" NUMBER NOT NULL ENABLE,
     "FIRST_NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "LAST_NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "POSITION" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "PHONE" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "ADDRESS" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "DIAGNOSIS_ID" NUMBER,
     "MEDICINE_ID" NUMBER,
     CONSTRAINT "LAB3MU_PATIENT_PK" PRIMARY KEY ("PATIENT_ID")
);

-- MEDICINE

CREATE TABLE "LAB3MU_MEDICINE"
(	"MEDICINE_ID" NUMBER NOT NULL ENABLE,
     "MEDICINE_NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     "ADMISSION_DAYS" NUMBER NOT NULL ENABLE,
     "PROVIDER_NAME" VARCHAR2(50 BYTE) NOT NULL ENABLE,
     CONSTRAINT "LAB3MU_MEDICINE_PK" PRIMARY KEY ("MEDICINE_ID")
);

--PERSONAL

ALTER TABLE "LAB3MU_PERSONAL" ADD CONSTRAINT "LAB3MU_PERSONAL_FK" FOREIGN KEY ("DEPARTMENT_ID")
    REFERENCES "LAB3MU_DEPARTMENT" ("DEPARTMENT_ID") ON DELETE SET NULL ENABLE;

ALTER TABLE "LAB3MU_PERSONAL" ADD CONSTRAINT "LAB3MU_PERSONAL_FK1" FOREIGN KEY ("JOB_ID")
    REFERENCES "LAB3MU_JOBS" ("JOB_ID") ON DELETE SET NULL ENABLE;

ALTER TABLE "LAB3MU_USER_DATA" ADD CONSTRAINT "LAB3MU_PERSONAL_FK2" FOREIGN KEY ("PERSONAL_ID")
    REFERENCES "LAB3MU_PERSONAL" ("PERSONAL_ID") ON DELETE CASCADE ENABLE;

ALTER TABLE "LAB3MU_PERSONAL" ADD CONSTRAINT "LAB3MU_PERSONAL_FK3" FOREIGN KEY ("PATIENT_ID")
    REFERENCES "LAB3MU_PATIENT" ("PATIENT_ID") ON DELETE SET NULL ENABLE;

--DIAGNOSIS

ALTER TABLE "LAB3MU_DIAGNOSIS" ADD CONSTRAINT "LAB3MU_DIAGNOSIS_FK" FOREIGN KEY ("TREATMENT_ID")
    REFERENCES "LAB3MU_TREATMENT" ("TREATMENT_ID") ON DELETE SET NULL ENABLE;


--PATIENT

ALTER TABLE "LAB3MU_PATIENT" ADD CONSTRAINT "LAB3MU_PATIENT_FK" FOREIGN KEY ("DIAGNOSIS_ID")
    REFERENCES "LAB3MU_DIAGNOSIS" ("DIAGNOSIS_ID") ON DELETE SET NULL ENABLE;

--MEDICINE

ALTER TABLE "LAB3MU_PATIENT" ADD CONSTRAINT "LAB3MU_PATIENT_FK1" FOREIGN KEY ("MEDICINE_ID")
    REFERENCES "LAB3MU_MEDICINE" ("MEDICINE_ID") ON DELETE SET NULL ENABLE;

    COMMIT;
