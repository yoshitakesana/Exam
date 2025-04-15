CREATE TABLE IF NOT EXISTS TEST(
    STUDENT_NO VARCHAR(10) NOT NULL,
    SUBJECT_CD CHAR(3) NOT NULL DEFAULT NULL,
    SCHOOL_CD CHAR(10) NOT NULL DEFAULT NULL,
    NO INTEGER(10) NOT NULL DEFAULT NULL,
    POINT INTEGER(10) DEFAULT NULL,
    CLASS_NUM VARCHAR(5) DEFAULT NULL,
    PRIMARY KEY(STUDENT_NO, SUBJECT_CD, SCHOOL_CD, NO)
);
