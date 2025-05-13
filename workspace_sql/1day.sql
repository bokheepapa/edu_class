
SELECT
    *
FROM
    emp
ORDER BY
    deptno asc, sal desc, ename desc;

SELECT
    *
FROM
    dept;

SELECT
    empno,
    ename,
    deptno
FROM
    emp;

SELECT
    ename,
    sal,
    123
FROM
    emp;

SELECT
    a.ename,
    b.dname,
    b.loc
FROM
    emp  a,
    dept b
WHERE
        a.deptno = b.deptno
    AND a.ename = :name;

SELECT
    ename
FROM
    emp
WHERE
    empno = (
        SELECT
            mgr
        FROM
            emp
        WHERE
            ename = :name
    );
    
select deptno from emp;
select distinct job, deptno from emp;

select ename, sal*12+comm "s s", comm from emp;

select distinct deptno from emp;

select * from emp where deptno = 30;

select * from emp where sal <> 1600;

select * from emp where deptno = 30 and job = 'SALESMAN';

--  OR
/*
    EMP 테이블에서 DEPTNO가 30 이거나 JOB이 'CLERK'인 사람의 정보를 전부 보여줘.
*/
SELECT * FROM EMP;

SELECT * FROM EMP WHERE (JOB = 'SALESMAN' OR DEPTNO = 30) AND SAL < 1200;
SELECT * FROM EMP WHERE NOT JOB = 'SALESMAN' OR DEPTNO = 30 AND SAL < 1200;
SELECT * FROM EMP WHERE NOT (JOB = 'SALESMAN' OR DEPTNO = 30) AND SAL < 1200;


-- 월급 2000이상 4000미만인 사원을 출력
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL < 4000;

-- 부서 번호 10 또는 20인 사원만 출력
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20;

SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20);