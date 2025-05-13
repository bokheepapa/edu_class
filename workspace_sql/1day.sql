SELECT
    *
FROM
    emp
ORDER BY
    ename DESC;

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