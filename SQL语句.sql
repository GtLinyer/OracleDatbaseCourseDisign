/*
Navicat Oracle Data Transfer
Oracle Client Version : 12.2.0.1.0

Source Server         : 三星Oracle/hxx
Source Server Version : 120200
Source Host           : cloud.linyer.cn:19996
Source Schema         : HXX

Target Server Type    : ORACLE
Target Server Version : 120200
File Encoding         : 65001

Date: 2019-12-16 23:45:23
*/


-- ----------------------------
-- Table structure for Admin
-- ----------------------------
DROP TABLE "HXX"."Admin";
CREATE TABLE "HXX"."Admin" (
"Ano" NUMBER(8) NOT NULL ,
"Aname" VARCHAR2(20 BYTE) NOT NULL ,
"Apwd" VARCHAR2(12 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for Blood
-- ----------------------------
DROP TABLE "HXX"."Blood";
CREATE TABLE "HXX"."Blood" (
"Cno" NUMBER(8) NOT NULL ,
"Pno" NUMBER(8) NOT NULL ,
"RBC" FLOAT(126) NOT NULL ,
"HCT" FLOAT(126) NOT NULL ,
"MCV" FLOAT(126) NOT NULL ,
"HXF" FLOAT(126) NOT NULL ,
"HGB" FLOAT(126) NOT NULL ,
"MCH" FLOAT(126) NOT NULL ,
"MCHC" FLOAT(126) NOT NULL ,
"WBC" FLOAT(126) NOT NULL ,
"MONO%" FLOAT(126) NOT NULL ,
"NEUT" FLOAT(126) NOT NULL ,
"NEUT%" FLOAT(126) NOT NULL ,
"LY" FLOAT(126) NOT NULL ,
"LY%" FLOAT(126) NOT NULL ,
"PLT" FLOAT(126) NOT NULL ,
"PDW" FLOAT(126) NOT NULL ,
"MPV" FLOAT(126) NOT NULL ,
"P-LCR" FLOAT(126) NOT NULL ,
"PCT" FLOAT(126) NOT NULL ,
"CPno" NUMBER(8) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for Departments
-- ----------------------------
DROP TABLE "HXX"."Departments";
CREATE TABLE "HXX"."Departments" (
"DPno" NUMBER(8) NOT NULL ,
"DPname" VARCHAR2(40 BYTE) NOT NULL ,
"DPloca" VARCHAR2(100 BYTE) NULL ,
"DPbrief" VARCHAR2(1000 BYTE) NULL ,
"isClinical" NUMBER(1) DEFAULT 0  NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for DocEmp
-- ----------------------------
DROP TABLE "HXX"."DocEmp";
CREATE TABLE "HXX"."DocEmp" (
"Dno" NUMBER(8) NOT NULL ,
"DPno" NUMBER(8) NOT NULL ,
"Dwork" VARCHAR2(60 BYTE) NULL ,
"Lno" NUMBER(8) NOT NULL ,
"Dxl" VARCHAR2(60 CHAR) NULL ,
"Dyear" NUMBER(8) NULL ,
"Dsalary" NUMBER(8) NULL ,
"DsuperNo" NUMBER(8) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for Doctors
-- ----------------------------
DROP TABLE "HXX"."Doctors";
CREATE TABLE "HXX"."Doctors" (
"Dno" NUMBER(8) NOT NULL ,
"Dname" VARCHAR2(18 BYTE) NOT NULL ,
"Dsex" VARCHAR2(3 BYTE) NOT NULL ,
"Dbirth" DATE NOT NULL ,
"Dphone" NUMBER(11) NOT NULL ,
"Demail" VARCHAR2(40 BYTE) NULL ,
"Dbrief" VARCHAR2(3000 BYTE) NULL ,
"Dpwd" VARCHAR2(12 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for Level
-- ----------------------------
DROP TABLE "HXX"."Level";
CREATE TABLE "HXX"."Level" (
"Lno" NUMBER(8) NOT NULL ,
"Lname" VARCHAR2(20 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for Patients
-- ----------------------------
DROP TABLE "HXX"."Patients";
CREATE TABLE "HXX"."Patients" (
"Pno" NUMBER(8) NOT NULL ,
"Pname" VARCHAR2(21 BYTE) NOT NULL ,
"Psex" VARCHAR2(3 BYTE) NOT NULL ,
"Page" NUMBER(2) NOT NULL ,
"Pphone" NUMBER(11) NOT NULL ,
"Paddress" VARCHAR2(300 BYTE) NULL ,
"Dno" NUMBER(8) NULL ,
"PEnDate" DATE NOT NULL ,
"Pemployer" VARCHAR2(60 BYTE) NULL ,
"Ppwd" VARCHAR2(12 BYTE) NOT NULL ,
"PIDno" NUMBER(18) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for PatientStatus
-- ----------------------------
DROP TABLE "HXX"."PatientStatus";
CREATE TABLE "HXX"."PatientStatus" (
"Pno" NUMBER(8) NOT NULL ,
"isSee" NUMBER(1) DEFAULT 0  NOT NULL ,
"isBlood" NUMBER(1) DEFAULT 0  NOT NULL ,
"isUrine" NUMBER(1) DEFAULT 0  NOT NULL ,
"isStool" NUMBER(1) DEFAULT 0  NOT NULL ,
"isOK" NUMBER(1) DEFAULT 0  NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for Stool
-- ----------------------------
DROP TABLE "HXX"."Stool";
CREATE TABLE "HXX"."Stool" (
"Cno" NUMBER(8) NOT NULL ,
"Pno" NUMBER(8) NOT NULL ,
"Color" VARCHAR2(16 BYTE) NOT NULL ,
"Traits" VARCHAR2(16 BYTE) NOT NULL ,
"WBC" FLOAT(126) NOT NULL ,
"Phagocyte" FLOAT(126) NOT NULL ,
"RBC" FLOAT(126) NOT NULL ,
"HB" NUMBER(1) NOT NULL ,
"Parasite" NUMBER(1) NOT NULL ,
"FG" NUMBER(1) NOT NULL ,
"CPno" NUMBER(8) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for Treatment
-- ----------------------------
DROP TABLE "HXX"."Treatment";
CREATE TABLE "HXX"."Treatment" (
"Dno" NUMBER(8) NOT NULL ,
"Pno" NUMBER(8) NOT NULL ,
"diagnosis" VARCHAR2(400 BYTE) NULL ,
"treat" VARCHAR2(400 BYTE) NULL ,
"describe" VARCHAR2(400 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Table structure for Urine
-- ----------------------------
DROP TABLE "HXX"."Urine";
CREATE TABLE "HXX"."Urine" (
"Cno" NUMBER(8) NOT NULL ,
"Pno" NUMBER(8) NOT NULL ,
"PH" FLOAT(126) NOT NULL ,
"SG" FLOAT(126) NOT NULL ,
"URO" FLOAT(126) NOT NULL ,
"BLD" NUMBER(1) NOT NULL ,
"WBC" NUMBER(1) NOT NULL ,
"PRO" NUMBER(1) NOT NULL ,
"GLU" NUMBER(1) NOT NULL ,
"BIL" NUMBER(1) NOT NULL ,
"KET" NUMBER(1) NOT NULL ,
"RBC" NUMBER(1) NOT NULL ,
"GOL" VARCHAR2(40 BYTE) NOT NULL ,
"CPno" NUMBER(8) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- View structure for DocInfo
-- ----------------------------
CREATE OR REPLACE FORCE VIEW "HXX"."DocInfo" AS 
SELECT
HXX."Doctors"."Dno" AS "医师工号",
HXX."Doctors"."Demail" AS "医师邮箱",
HXX."DocEmp"."DPno" AS "所属科室编号",
HXX."DocEmp"."Dxl" AS "医师学历",
HXX."DocEmp"."Dyear" AS "医师年资",
HXX."Departments"."DPname" AS "所属科室名称",
HXX."Level"."Lname" AS "医师职称",
HXX."DocEmp"."Lno" AS "医师职称编号",
HXX."Doctors"."Dbrief" AS "医师简介",
HXX."Doctors"."Dname" AS "医师姓名",
HXX."Doctors"."Dsex" AS "医师性别"
FROM
HXX."Doctors"
INNER JOIN HXX."DocEmp" ON HXX."DocEmp"."Dno" = HXX."Doctors"."Dno"
INNER JOIN HXX."Departments" ON HXX."DocEmp"."DPno" = HXX."Departments"."DPno"
INNER JOIN HXX."Level" ON HXX."DocEmp"."Lno" = HXX."Level"."Lno";

-- ----------------------------
-- View structure for DoctorLogin
-- ----------------------------
CREATE OR REPLACE FORCE VIEW "HXX"."DoctorLogin" AS 
SELECT
HXX."Doctors"."Dno" AS "工号",
HXX."Doctors"."Dname" AS "姓名",
HXX."Doctors"."Dpwd" AS "密码",
HXX."Departments"."isClinical" AS "是否临床"
FROM
HXX."Doctors"
INNER JOIN HXX."DocEmp" ON HXX."DocEmp"."Dno" = HXX."Doctors"."Dno"
INNER JOIN HXX."Departments" ON HXX."DocEmp"."DPno" = HXX."Departments"."DPno";

-- ----------------------------
-- View structure for PatientLogin
-- ----------------------------
CREATE OR REPLACE FORCE VIEW "HXX"."PatientLogin" AS 
SELECT
HXX."Patients"."Pno" AS "病历号",
HXX."Patients"."Pname" AS "姓名",
HXX."Patients"."Ppwd" AS "密码"
FROM
HXX."Patients";

-- ----------------------------
-- View structure for SelPatient
-- ----------------------------
CREATE OR REPLACE FORCE VIEW "HXX"."SelPatient" AS 
SELECT
HXX."Patients"."Pno" AS "病历号",
HXX."Patients"."Pname" AS "患者姓名",
HXX."Patients"."Psex" AS "患者性别",
HXX."Patients"."Page" AS "患者年龄",
HXX."Patients"."Pphone" AS "患者联系电话",
HXX."Patients"."Paddress" AS "患者住址",
HXX."Patients"."PEnDate" AS "患者入院时间",
HXX."Patients"."Pemployer" AS "患者职业",
HXX."Patients"."Dno" AS "主治医师",
HXX."PatientStatus"."isSee" AS "是否已看诊",
HXX."PatientStatus"."isBlood" AS "是否需要血检",
HXX."PatientStatus"."isUrine" AS "是否需要尿检",
HXX."PatientStatus"."isStool" AS "是否需要便检",
HXX."PatientStatus"."isOK" AS "是否可以出院"
FROM
HXX."Patients"
INNER JOIN HXX."PatientStatus" ON HXX."PatientStatus"."Pno" = HXX."Patients"."Pno";

-- ----------------------------
-- Sequence structure for BCNO_SEQ
-- ----------------------------
DROP SEQUENCE "HXX"."BCNO_SEQ";
CREATE SEQUENCE "HXX"."BCNO_SEQ"
 INCREMENT BY 1
 MINVALUE 30000001
 MAXVALUE 49999999
 START WITH 30000002
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for DNO_SEQ
-- ----------------------------
DROP SEQUENCE "HXX"."DNO_SEQ";
CREATE SEQUENCE "HXX"."DNO_SEQ"
 INCREMENT BY 1
 MINVALUE 1000
 MAXVALUE 9999
 START WITH 1008
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for DPNO_SEQ
-- ----------------------------
DROP SEQUENCE "HXX"."DPNO_SEQ";
CREATE SEQUENCE "HXX"."DPNO_SEQ"
 INCREMENT BY 1
 MINVALUE 101
 MAXVALUE 999
 START WITH 104
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for PNO_SEQ
-- ----------------------------
DROP SEQUENCE "HXX"."PNO_SEQ";
CREATE SEQUENCE "HXX"."PNO_SEQ"
 INCREMENT BY 1
 MINVALUE 10000001
 MAXVALUE 29999999
 START WITH 10000005
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for SCNO_SEQ
-- ----------------------------
DROP SEQUENCE "HXX"."SCNO_SEQ";
CREATE SEQUENCE "HXX"."SCNO_SEQ"
 INCREMENT BY 1
 MINVALUE 70000001
 MAXVALUE 99999999
 START WITH 70000001
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Sequence structure for UCNO_SEQ
-- ----------------------------
DROP SEQUENCE "HXX"."UCNO_SEQ";
CREATE SEQUENCE "HXX"."UCNO_SEQ"
 INCREMENT BY 1
 MINVALUE 50000001
 MAXVALUE 69999999
 START WITH 50000001
 NOCACHE 
 ORDER ;

-- ----------------------------
-- Checks structure for table Admin
-- ----------------------------
ALTER TABLE "HXX"."Admin" ADD CHECK ("Ano" IS NOT NULL);
ALTER TABLE "HXX"."Admin" ADD CHECK ("Aname" IS NOT NULL);
ALTER TABLE "HXX"."Admin" ADD CHECK ("Apwd" IS NOT NULL);

-- ----------------------------
-- Indexes structure for table Blood
-- ----------------------------

-- ----------------------------
-- Triggers structure for table Blood
-- ----------------------------
CREATE OR REPLACE TRIGGER "HXX"."DELETE_BLOOD_FROM_PATIENTS" BEFORE DELETE ON "HXX"."Blood" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
begin
	DELETE "Patients" WHERE "Pno"=:new."Pno";
end Delete_Blood_From_Patients;
-- ----------------------------
-- Checks structure for table Blood
-- ----------------------------
ALTER TABLE "HXX"."Blood" ADD CHECK ("Cno" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("Pno" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("RBC" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("HCT" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("MCV" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("HXF" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("HGB" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("MCH" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("MCHC" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("WBC" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("MONO%" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("NEUT" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("NEUT%" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("LY" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("LY%" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("PLT" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("PDW" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("MPV" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("P-LCR" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("PCT" IS NOT NULL);
ALTER TABLE "HXX"."Blood" ADD CHECK ("CPno" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table Blood
-- ----------------------------
ALTER TABLE "HXX"."Blood" ADD PRIMARY KEY ("Cno");

-- ----------------------------
-- Indexes structure for table Departments
-- ----------------------------

-- ----------------------------
-- Checks structure for table Departments
-- ----------------------------
ALTER TABLE "HXX"."Departments" ADD CHECK ("DPname" IS NOT NULL);
ALTER TABLE "HXX"."Departments" ADD CHECK ("isClinical" IS NOT NULL);
ALTER TABLE "HXX"."Departments" ADD CHECK ("DPno" IS NOT NULL);
ALTER TABLE "HXX"."Departments" ADD CHECK ("DPno" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table Departments
-- ----------------------------
ALTER TABLE "HXX"."Departments" ADD PRIMARY KEY ("DPno");

-- ----------------------------
-- Indexes structure for table DocEmp
-- ----------------------------

-- ----------------------------
-- Triggers structure for table DocEmp
-- ----------------------------
CREATE OR REPLACE TRIGGER "HXX"."DELETE_DOCEMP_FROM_DOCTORS" BEFORE DELETE ON "HXX"."DocEmp" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
begin
	DELETE "Doctors" WHERE "Dno"=:new."Dno";
end Delete_DocEmp_From_Doctors;
-- ----------------------------
-- Checks structure for table DocEmp
-- ----------------------------
ALTER TABLE "HXX"."DocEmp" ADD CHECK ("DPno" IS NOT NULL);
ALTER TABLE "HXX"."DocEmp" ADD CHECK ("Lno" IS NOT NULL);
ALTER TABLE "HXX"."DocEmp" ADD CHECK ("Dno" IS NOT NULL);
ALTER TABLE "HXX"."DocEmp" ADD CHECK ("Dno" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DocEmp
-- ----------------------------
ALTER TABLE "HXX"."DocEmp" ADD PRIMARY KEY ("Dno");

-- ----------------------------
-- Indexes structure for table Doctors
-- ----------------------------

-- ----------------------------
-- Checks structure for table Doctors
-- ----------------------------
ALTER TABLE "HXX"."Doctors" ADD CHECK ("Dname" IS NOT NULL);
ALTER TABLE "HXX"."Doctors" ADD CHECK ("Dsex" IS NOT NULL);
ALTER TABLE "HXX"."Doctors" ADD CHECK ("Dbirth" IS NOT NULL);
ALTER TABLE "HXX"."Doctors" ADD CHECK ("Dphone" IS NOT NULL);
ALTER TABLE "HXX"."Doctors" ADD CHECK ("Dpwd" IS NOT NULL);
ALTER TABLE "HXX"."Doctors" ADD CHECK ("Dno" IS NOT NULL);
ALTER TABLE "HXX"."Doctors" ADD CHECK ("Dno" IS NOT NULL);
ALTER TABLE "HXX"."Doctors" ADD CHECK ("Dsex" IN ('男','女'));

-- ----------------------------
-- Primary Key structure for table Doctors
-- ----------------------------
ALTER TABLE "HXX"."Doctors" ADD PRIMARY KEY ("Dno");

-- ----------------------------
-- Indexes structure for table Level
-- ----------------------------

-- ----------------------------
-- Checks structure for table Level
-- ----------------------------
ALTER TABLE "HXX"."Level" ADD CHECK ("Lname" IS NOT NULL);
ALTER TABLE "HXX"."Level" ADD CHECK ("Lno" IS NOT NULL);
ALTER TABLE "HXX"."Level" ADD CHECK ("Lno" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table Level
-- ----------------------------
ALTER TABLE "HXX"."Level" ADD PRIMARY KEY ("Lno");

-- ----------------------------
-- Indexes structure for table Patients
-- ----------------------------

-- ----------------------------
-- Triggers structure for table Patients
-- ----------------------------
CREATE OR REPLACE TRIGGER "HXX"."ADD_PATIENTSTATUS_FROM_PATIENTS" AFTER INSERT ON "HXX"."Patients" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
begin
	insert into "PatientStatus"("Pno") values(:new."Pno");
end Add_PatientStatus_From_Patients;
-- ----------------------------
-- Checks structure for table Patients
-- ----------------------------
ALTER TABLE "HXX"."Patients" ADD CHECK ("Pname" IS NOT NULL);
ALTER TABLE "HXX"."Patients" ADD CHECK ("Psex" IS NOT NULL);
ALTER TABLE "HXX"."Patients" ADD CHECK ("Page" IS NOT NULL);
ALTER TABLE "HXX"."Patients" ADD CHECK ("Pphone" IS NOT NULL);
ALTER TABLE "HXX"."Patients" ADD CHECK ("PEnDate" IS NOT NULL);
ALTER TABLE "HXX"."Patients" ADD CHECK ("Ppwd" IS NOT NULL);
ALTER TABLE "HXX"."Patients" ADD CHECK ("PIDno" IS NOT NULL);
ALTER TABLE "HXX"."Patients" ADD CHECK ("Pno" IS NOT NULL);
ALTER TABLE "HXX"."Patients" ADD CHECK ("Pno" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table Patients
-- ----------------------------
ALTER TABLE "HXX"."Patients" ADD PRIMARY KEY ("Pno");

-- ----------------------------
-- Checks structure for table PatientStatus
-- ----------------------------
ALTER TABLE "HXX"."PatientStatus" ADD CHECK ("Pno" IS NOT NULL);
ALTER TABLE "HXX"."PatientStatus" ADD CHECK ("isSee" IS NOT NULL);
ALTER TABLE "HXX"."PatientStatus" ADD CHECK ("isBlood" IS NOT NULL);
ALTER TABLE "HXX"."PatientStatus" ADD CHECK ("isUrine" IS NOT NULL);
ALTER TABLE "HXX"."PatientStatus" ADD CHECK ("isStool" IS NOT NULL);
ALTER TABLE "HXX"."PatientStatus" ADD CHECK ("isOK" IS NOT NULL);

-- ----------------------------
-- Indexes structure for table Stool
-- ----------------------------

-- ----------------------------
-- Triggers structure for table Stool
-- ----------------------------
CREATE OR REPLACE TRIGGER "HXX"."DELETE_STOOL_FROM_PATIENTS" BEFORE DELETE ON "HXX"."Stool" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
begin
	DELETE "Patients" WHERE "Pno"=:new."Pno";
end Delete_Stool_From_Patients;
-- ----------------------------
-- Checks structure for table Stool
-- ----------------------------
ALTER TABLE "HXX"."Stool" ADD CHECK ("Cno" IS NOT NULL);
ALTER TABLE "HXX"."Stool" ADD CHECK ("Pno" IS NOT NULL);
ALTER TABLE "HXX"."Stool" ADD CHECK ("Color" IS NOT NULL);
ALTER TABLE "HXX"."Stool" ADD CHECK ("Traits" IS NOT NULL);
ALTER TABLE "HXX"."Stool" ADD CHECK ("WBC" IS NOT NULL);
ALTER TABLE "HXX"."Stool" ADD CHECK ("Phagocyte" IS NOT NULL);
ALTER TABLE "HXX"."Stool" ADD CHECK ("RBC" IS NOT NULL);
ALTER TABLE "HXX"."Stool" ADD CHECK ("HB" IS NOT NULL);
ALTER TABLE "HXX"."Stool" ADD CHECK ("Parasite" IS NOT NULL);
ALTER TABLE "HXX"."Stool" ADD CHECK ("FG" IS NOT NULL);
ALTER TABLE "HXX"."Stool" ADD CHECK ("CPno" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table Stool
-- ----------------------------
ALTER TABLE "HXX"."Stool" ADD PRIMARY KEY ("Cno");

-- ----------------------------
-- Indexes structure for table Treatment
-- ----------------------------

-- ----------------------------
-- Checks structure for table Treatment
-- ----------------------------
ALTER TABLE "HXX"."Treatment" ADD CHECK ("Dno" IS NOT NULL);
ALTER TABLE "HXX"."Treatment" ADD CHECK ("Pno" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table Treatment
-- ----------------------------
ALTER TABLE "HXX"."Treatment" ADD PRIMARY KEY ("Dno");

-- ----------------------------
-- Indexes structure for table Urine
-- ----------------------------

-- ----------------------------
-- Triggers structure for table Urine
-- ----------------------------
CREATE OR REPLACE TRIGGER "HXX"."DELETE_URINE_FROM_PATIENTS" BEFORE DELETE ON "HXX"."Urine" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
begin
	DELETE "Patients" WHERE "Pno"=:new."Pno";
end Delete_Urine_From_Patients;
-- ----------------------------
-- Checks structure for table Urine
-- ----------------------------
ALTER TABLE "HXX"."Urine" ADD CHECK ("Cno" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("Pno" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("PH" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("SG" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("URO" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("BLD" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("WBC" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("PRO" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("GLU" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("BIL" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("KET" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("RBC" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("GOL" IS NOT NULL);
ALTER TABLE "HXX"."Urine" ADD CHECK ("CPno" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table Urine
-- ----------------------------
ALTER TABLE "HXX"."Urine" ADD PRIMARY KEY ("Cno");

-- ----------------------------
-- Foreign Key structure for table "HXX"."Blood"
-- ----------------------------
ALTER TABLE "HXX"."Blood" ADD FOREIGN KEY ("CPno") REFERENCES "HXX"."Doctors" ("Dno");
ALTER TABLE "HXX"."Blood" ADD FOREIGN KEY ("Pno") REFERENCES "HXX"."Patients" ("Pno");

-- ----------------------------
-- Foreign Key structure for table "HXX"."DocEmp"
-- ----------------------------
ALTER TABLE "HXX"."DocEmp" ADD FOREIGN KEY ("DPno") REFERENCES "HXX"."Departments" ("DPno");
ALTER TABLE "HXX"."DocEmp" ADD FOREIGN KEY ("Dno") REFERENCES "HXX"."Doctors" ("Dno");
ALTER TABLE "HXX"."DocEmp" ADD FOREIGN KEY ("DsuperNo") REFERENCES "HXX"."Doctors" ("Dno");
ALTER TABLE "HXX"."DocEmp" ADD FOREIGN KEY ("Lno") REFERENCES "HXX"."Level" ("Lno");

-- ----------------------------
-- Foreign Key structure for table "HXX"."Patients"
-- ----------------------------
ALTER TABLE "HXX"."Patients" ADD FOREIGN KEY ("Dno") REFERENCES "HXX"."Doctors" ("Dno");

-- ----------------------------
-- Foreign Key structure for table "HXX"."PatientStatus"
-- ----------------------------
ALTER TABLE "HXX"."PatientStatus" ADD FOREIGN KEY ("Pno") REFERENCES "HXX"."Patients" ("Pno");

-- ----------------------------
-- Foreign Key structure for table "HXX"."Stool"
-- ----------------------------
ALTER TABLE "HXX"."Stool" ADD FOREIGN KEY ("CPno") REFERENCES "HXX"."Doctors" ("Dno");
ALTER TABLE "HXX"."Stool" ADD FOREIGN KEY ("Pno") REFERENCES "HXX"."Patients" ("Pno");

-- ----------------------------
-- Foreign Key structure for table "HXX"."Treatment"
-- ----------------------------
ALTER TABLE "HXX"."Treatment" ADD FOREIGN KEY ("Pno") REFERENCES "HXX"."Patients" ("Pno");

-- ----------------------------
-- Foreign Key structure for table "HXX"."Urine"
-- ----------------------------
ALTER TABLE "HXX"."Urine" ADD FOREIGN KEY ("CPno") REFERENCES "HXX"."Doctors" ("Dno");
ALTER TABLE "HXX"."Urine" ADD FOREIGN KEY ("Pno") REFERENCES "HXX"."Patients" ("Pno");
