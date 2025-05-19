select * from dept;-- where deptno = 10;

select * from emp, dept order by empno;

SELECT
    *
FROM
    emp,
    dept
WHERE
    emp.deptno = dept.deptno
ORDER BY
    empno;


SELECT
    emp.empno,
    emp.ename,
    dept.dname,
    dept.loc
FROM
    emp,
    dept
WHERE
    emp.deptno = dept.deptno
ORDER BY
    empno;


SELECT
    e.empno,
    e.ename,
    d.dname,
    d.loc
FROM
    emp  e,
    dept d
WHERE
    e.deptno = d.deptno
    and e.sal >= 3000
ORDER BY
    e.empno;
    
    
select * from salgrade;

SELECT
    *
FROM
    emp      e,
    salgrade s
WHERE
    e.sal BETWEEN s.losal AND s.hisal;



SELECT
    *
FROM
    emp      e,
    salgrade s
WHERE
        e.sal > s.losal
    AND e.sal < s.hisal;



SELECT
    e1.empno,
    e1.ename,
    e1.mgr,
    e2.empno AS mgr_empno,
    CASE
        WHEN e2.ename IS NULL THEN
            'CEO'
        ELSE
            e2.ename
    END      AS mgr_ename
FROM
    emp e1,
    emp e2
WHERE
    e1.mgr = e2.empno (+);
    
    
    
SELECT
    *
FROM
         emp e
    NATURAL JOIN dept d
ORDER BY
    deptno,
    empno;
    


SELECT * FROM EMP E JOIN DEPT D USING (DEPTNO) WHERE SAL >= 2000;


SELECT
    *
FROM
         emp e
    JOIN dept d ON ( e.deptno = d.deptno )
WHERE
    sal >= 2000;


SELECT
    e1.empno,
    e1.ename,
    e1.mgr,
    e2.empno,
    e2.ename
FROM
    emp e1
    LEFT OUTER JOIN emp e2 ON ( e1.mgr = e2.empno );
    

SELECT
    e1.empno,
    e1.ename,
    e1.mgr,
    e2.empno,
    e2.ename
FROM
    emp e1
    RIGHT OUTER JOIN emp e2 ON ( e1.mgr = e2.empno );
    
SELECT * FROM EMP WHERE COMM IS NOT NULL;


-- Q1 
-- SQL-99 O
SELECT
    deptno,
    dname,
    empno,
    ename,
    sal
FROM
         emp e
    JOIN dept d USING ( deptno )
WHERE
    sal > 2000;
    
    
-- SQL-99 X
SELECT
    d.deptno,
    d.dname,
    e.empno,
    e.ename,
    e.sal
FROM
    emp  e,
    dept d
WHERE
        e.deptno = d.deptno
    AND sal > 2000;


-- Q2
-- SQL-99 O
SELECT
    d.deptno,
    round(avg(e.sal)) AS avg_sal,
    MAX(e.sal)        AS max_sal,
    MIN(e.sal)        AS min_sal,
    COUNT(e.empno)    AS cnt
FROM
         dept d
    JOIN emp e ON ( d.deptno = e.deptno )
GROUP BY
    d.deptno;
    
    
-- SQL-99 X
SELECT
    d.deptno,
    round(avg(e.sal)) AS avg_sal,
    MAX(e.sal)        AS max_sal,
    MIN(e.sal)        AS min_sal,
    COUNT(e.empno)    AS cnt
FROM
    dept d,
    emp  e
WHERE
    d.deptno = e.deptno
GROUP BY
    D.deptno;
    
    
-- Q3
-- SQL-99 O
SELECT
    d.deptno,
    d.dname,
    e.empno,
    e.ename,
    e.job,
    e.sal
FROM
    emp  e
    RIGHT OUTER JOIN dept d ON ( e.deptno = d.deptno )
ORDER BY
    deptno;


-- SQL-99 X
SELECT
    d.deptno,
    d.dname,
    e.empno,
    e.ename,
    e.job,
    e.sal
FROM
    emp  e,
    dept d
WHERE
    e.deptno (+) = d.deptno
ORDER BY
    deptno;
    
    
-- Q4
-- SQL-99 O 
SELECT
    d.deptno,
    d.dname,
    e1.empno,
    e1.ename,
    e1.mgr,
    e1.sal,
    e1.deptno,
    s.losal,
    s.hisal,
    s.grade,
    e2.empno,
    e2.ename
FROM
    emp      e1
    RIGHT OUTER JOIN dept     d ON ( e1.deptno = d.deptno )
    LEFT OUTER JOIN emp      e2 ON ( e1.mgr = e2.empno )
    FULL OUTER JOIN salgrade s ON ( e1.sal > s.losal
                                    AND e1.sal < s.hisal )
ORDER BY
    d.deptno,
    e1.empno;
                                    

-- SQL-99 X
SELECT
    d.deptno,
    d.dname,
    e1.empno,
    e1.ename,
    e1.mgr,
    e1.sal,
    e1.deptno,
    s.losal,
    s.hisal,
    s.grade,
    e2.empno,
    e2.ename
FROM
    emp      e1,
    dept     d,
    emp      e2,
    salgrade s
WHERE
        e1.deptno (+) = d.deptno
    AND e1.mgr = e2.empno (+)
    AND e1.sal > s.losal (+)
    AND e1.sal < s.hisal (+)
ORDER BY
    d.deptno,
    e1.empno;