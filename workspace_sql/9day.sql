select * from dict;

select * from USER_INDEXES;
select * from user_ind_columns;

create index idx_emp_sal on emp(sal);
create index idx_emp_sal2 on emp(sal);

update user_ind_columns set descend = 'DESC' WHERE INDEX_NAME = 'IDX_EMP_SAL';


SELECT /*+ index(e idx_emp_sal) */ 
* FROM EMP e WHERE SAL = 2000 ORDER BY SAL DESC;

create view vw_emp20
as ( select empno, ename, job, deptno
from emp where deptno = 20);

create SEQUENCE SEQ_DEPT_SEQUENCE
    INCREMENT BY 1
    START WITH 5000;
    
INSERT INTO EMP_TEMP2 (EMPNO, ENAME)
VALUES (SEQ_DEPT_SEQUENCE.NEXTVAL, '심봉사');

SELECT * FROM EMP_TEMP2;

SELECT SEQ_DEPT_SEQUENCE.NEXTVAL FROM DUAL;
    
CREATE TABLE TABLE_PK2(
    LOGIN_ID VARCHAR2(20) PRIMARY KEY,
    LOGIN_PWD   VARCHAR2(20)    NOT NULL,
    TEL VARCHAR2(20)
    );
    
SELECT * FROM USER_INDEXES;

INSERT INTO TABLE_PK2
VALUES('ID', 'PW', NULL);

INSERT INTO TABLE_PK2
VALUES('ID2', 'PW', NULL);

INSERT INTO TABLE_PK2
VALUES('ID3', '1234', '010-0000-0000');

SELECT * FROM TABLE_PK2;

UPDATE TABLE_PK2 SET LOGIN_ID = 'ID2';


SELECT 
    d.deptno, d.dname, 
    e.empno, e.mgr, e.sal, 
    d.deptno AS deptno_1, 
    s.losal, s.hisal, s.grade, 
    m.empno AS mgr_empno, m.ename AS mgr_ename
FROM emp e
LEFT JOIN dept d ON e.deptno = d.deptno
LEFT JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
LEFT JOIN emp m ON e.mgr = m.empno
ORDER BY d.deptno, e.empno;

SELECT 
    d.deptno, d.dname, 
    e.empno, e.mgr, e.sal, 
    d.deptno AS deptno_1, 
    s.losal, s.hisal, s.grade, 
    m.empno AS mgr_empno, m.ename AS mgr_ename
FROM emp e, dept d, salgrade s, emp m
WHERE e.deptno = d.deptno
AND e.sal BETWEEN s.losal AND s.hisal
AND e.mgr = m.empno(+)
ORDER BY d.deptno, e.empno;

select count(*) from emp_temp2;

create table dept_fk(
    deptno number(2) constraint pk_dept_fk PRIMARY key,
    dname varchar2(14),
    loc varchar2(13)
);

desc dept_fk;

create table emp_fk(
    empno number(4) constraint empfk_empno_pk PRIMARY key,
    ename varchar2(10),
    job varchar2(9),
    mgr number(4),
    hiredate date,
    sal number(7,2),
    comm number(7,2),
    deptno number(2) constraint empfk_deptno_fk references dept_fk (deptno)
);

desc emp_fk;

insert into emp_fk (empno, ename, deptno)
values (1000, '이름', 10);

insert into dept_fk 
values (20, '부서이름', '아산');

update emp_fk set deptno = 20;

delete from dept_fk where deptno = 20;

select * from dept_fk;
select * from emp_fk;

commit;