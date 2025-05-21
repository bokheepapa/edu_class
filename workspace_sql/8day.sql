-- Q1 커미션이 null인 사원을 급여 오름차순으로 정렬
SELECT
    *
FROM
    emp
WHERE
    comm IS NULL
ORDER BY
    sal;


-- Q2 급여 등급 별 사원 수를 등급 오름차순으로 정렬,단, 모든 등급을 표시한다
SELECT
    s.grade        AS "등급",
    COUNT(e.empno) AS "사원수"
FROM
    emp      e,
    salgrade s
WHERE
        e.sal >= s.losal
    AND e.sal <= s.hisal
GROUP BY
    s.grade
ORDER BY
    s.grade;


-- Q3 이름, 급여, 급여 등급, 부서이름 조회,
-- 단, 급여 등급 3 이상만 조회. 급여 등급 내림차순, 급여 등급이 같은 경우 급여 내림 차순
SELECT
    grade.ename AS "이름",
    grade.sal   AS "급여",
    grade.grade AS "급여 등급",
    d.dname     AS "부서이름"
FROM
    (
        SELECT
            *
        FROM
            emp      e,
            salgrade s
        WHERE
                e.sal >= s.losal
            AND e.sal <= s.hisal
    )    grade,
    dept d
WHERE
        grade.deptno = d.deptno
    AND grade.grade >= 3
    ORDER BY grade.GRADE DESC, SAL DESC;


SELECT
    e.ename AS "이름",
    e.sal   AS "급여",
    s.grade AS "급여 등급",
    d.dname AS "부서이름"
FROM
    emp      e,
    salgrade s,
    dept     d
WHERE
        e.sal >= s.losal
    AND e.sal <= s.hisal
    AND e.deptno = d.deptno
    AND s.grade >= 3
ORDER BY
    s.grade DESC,
    sal DESC;


-- Q4 부서명이 SALES인 사원 중 급여 등급이 2 또는 3인 사원을 급여 내림차순으로 정렬
SELECT
    ename AS "이름",
    sal   AS "급여",
    grade AS "급여 등급",
    dname     AS "부서이름"
FROM
    (
        SELECT
            *
        FROM
            emp      e,
            dept     d,
            salgrade s
        WHERE
                d.dname = 'SALES'
            AND e.sal >= s.losal
            AND e.sal <= s.hisal
    )
WHERE
    grade IN ( 2, 3 )
ORDER BY
    sal DESC;
    
    

SELECT
    e.ename AS "이름",
    e.sal   AS "급여",
    s.grade AS "급여 등급",
    d.dname AS "부서이름"
FROM
    emp      e,
    dept     d,
    salgrade s
WHERE
        d.dname = 'SALES'
    AND e.sal >= s.losal
    AND e.sal <= s.hisal
    AND s.grade IN ( 2, 3 )
ORDER BY
    e.sal DESC;
    
    
    
---------------------------------------------------------------------------    
desc emp;


create table EMP_DDL(
EMPNO        NUMBER(4),
ENAME        VARCHAR2(10),
JOB          VARCHAR2(9),
MGR          NUMBER(4),
HIREDATE     DATE,
SAL          NUMBER(7,2),
COMM         NUMBER(7,2),
DEPTNO       NUMBER(2)
);

DESC EMP_DDL;

CREATE TABLE empdept_ddl
    AS
        SELECT
            e.empno,
            e.ename,
            e.job,
            e.mgr,
            e.hiredate,
            e.sal,
            e.comm,
            D.deptno,
            d.dname,
            d.loc
        FROM
            emp  e,
            dept d
        WHERE
            1 <> 1;
            
DESC empdept_ddl;


CREATE TABLE EMP_ALTER
AS SELECT * FROM EMP;

DESC EMP_ALTER;

ALTER TABLE EMP_ALTER
    ADD AGE NUMBER(3) DEFAULT 1 ;
    
ALTER TABLE EMP_ALTER
    RENAME COLUMN HP TO TEL;
    
ALTER TABLE EMP_ALTER
MODIFY EMPNO NUMBER(5);

ALTER TABLE EMP_ALTER
DROP COLUMN TEL;

RENAME EMP_COPY TO EMP_DDL_EX;
SELECT * FROM EMP_DDL_EX;
DROP TABLE EMP_DDL_EX;
    
SELECT * FROM EMP_ALTER;


-- 10장
CREATE TABLE DEPT_TEMP
AS SELECT * FROM DEPT;

INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC)
VALUES (50, 'DATABASE', 'SEOUL');


INSERT INTO DEPT_TEMP
VALUES (60, 'NETWORK', 'BUSAN');

SELECT * FROM DEPT_TEMP;

INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC)
VALUES (70, 'WEB', NULL);

INSERT INTO DEPT_TEMP (DEPTNO, DNAME, LOC)
VALUES (80, 'MOBILE', '');

INSERT INTO DEPT_TEMP (DEPTNO, LOC)
VALUES (90, 'INCHEON');

SELECT * FROM DEPT_TEMP;

CREATE TABLE EMP_TEMP
AS SELECT * FROM EMP;

INSERT INTO EMP_TEMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES (2111, '이순신', 'MANAGER', 9999, TO_DATE('2001/05/21','YYYY-MM-DD'), 4000, NULL, 20);

INSERT INTO EMP_TEMP (EMPNO, ENAME, HIREDATE)
VALUES (3111, '심청이', SYSDATE);

INSERT INTO EMP_TEMP
SELECT * FROM EMP WHERE DEPTNO = 10;

DROP TABLE EMP_TEMP;
TRUNCATE TABLE EMP_TEMP;
SELECT * FROM EMP_TEMP;

-------------------------------------------------------------------------
CREATE TABLE DEPT_TEMP2
AS SELECT * FROM DEPT;

SELECT * FROM DEPT_TEMP2;

UPDATE DEPT_TEMP2
SET LOC = 'SEOUL';

UPDATE DEPT_TEMP2
    SET DNAME = 'DATABASE',
        LOC = 'SEOUL'
    WHERE DEPTNO = 40;
    
CREATE TABLE EMP_TMP
AS SELECT * FROM EMP;

SELECT * FROM EMP_TMP WHERE SAL < 1000;

UPDATE EMP_TMP SET SAL = SAL * 1.03 WHERE SAL < 1000;


CREATE TABLE EMP_TEMP2
AS SELECT * FROM EMP;

SELECT E1.EMPNO, E1.ENAME, E1.MGR, E2.ENAME FROM EMP_TEMP2 E1, EMP_TEMP2 E2 WHERE E1.MGR = E2.EMPNO(+);
SELECT E2.ENAME FROM EMP_TEMP2 E1, EMP_TEMP2 E2 WHERE E1.MGR = E2.EMPNO(+);

UPDATE EMP_TEMP2 SET MGR_NAME = (SELECT E2.ENAME FROM EMP_TEMP2 E1, EMP_TEMP2 E2 WHERE E1.MGR = E2.EMPNO(+));

UPDATE emp_temp2 e1
SET
    mgr_name = (
        SELECT
            e2.ename
        FROM
            emp_temp2 e2
        WHERE
            e1.mgr = e2.empno
    );

SELECT * FROM EMP_TEMP2;

ALTER TABLE EMP_TEMP2
    ADD MGR_NAME VARCHAR2(10);

DELETE EMP_TEMP2;

ROLLBACK;

COMMIT;