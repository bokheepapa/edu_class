-- QUIZ
-- 각 부서별로 급여가
-- 가장 높은 사원, 가장 낮은 사원의 급여 차이를 출력


SELECT
    d.deptno,
    d.dname,
    MAX(e.sal),
    MIN(e.sal),
    MAX(e.sal) - MIN(e.sal) AS "급여 차이"
FROM
    emp  e,
    dept d
GROUP BY
    e.deptno,
    d.deptno,
    d.dname
HAVING
    e.deptno = d.deptno;
    
    
-- 심화 QUIZ
-- JOB을 총 20자 중 가운데 정렬
SELECT
    length(job) AS "글자수",
    lpad(
        rpad(job, length(job) +((20 - length(job)) / 2), '-'),
        20, '-'
    ) AS "가운데 정렬",
    length(lpad(
        rpad(job, length(job) +((20 - length(job)) / 2), '-'),
        20, '-'
    )) AS "정렬 후 글자수"
FROM
    emp;
    
    
    
SELECT * FROM EMP WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'JONES');
SELECT SAL FROM EMP WHERE ENAME = 'JONES';

SELECT
    *
FROM
    emp
WHERE
    hiredate > (
        SELECT
            hiredate
        FROM
            emp
        WHERE
            ename = 'BLAKE'
    );
    
SELECT * FROM EMP;    
SELECT DEPTNO FROM EMP GROUP BY DEPTNO HAVING DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'ANALYST');

SELECT * FROM EMP
WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);

SELECT DNAME FROM DEPT WHERE DEPTNO = 10;
SELECT * FROM EMP WHERE EXISTS (SELECT DNAME FROM DEPT WHERE DEPTNO = 10);


SELECT * FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO;


SELECT LOC FROM (SELECT * FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO);


WITH RESULT_SQL AS (SELECT * FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO)
SELECT * FROM RESULT_SQL RET;



SELECT ROWNUM, RET.*
FROM (
    SELECT JOB, COUNT(*) AS CNT
        FROM EMP
        GROUP BY JOB
        ORDER BY CNT) RET
WHERE CNT > 3;



-- Q1
SELECT
    e.job,
    e.empno,
    e.ename,
    e.sal,
    d.deptno,
    d.dname
FROM
    emp  e,
    dept d
WHERE
        e.deptno = d.deptno
    AND job = (
        SELECT
            job
        FROM
            emp
        WHERE
            ename = 'ALLEN'
    )
    ORDER BY SAL DESC, ENAME;
    
    
-- Q2
SELECT
    e.empno,
    e.ename,
    d.dname,
    e.hiredate,
    d.loc,
    e.sal,
    s.grade
FROM
    (
        SELECT
            *
        FROM
            emp
        WHERE
            sal > (
                SELECT
                    AVG(sal)
                FROM
                    emp
            )
    )        e,
    dept     d,
    salgrade s
WHERE
        e.deptno = d.deptno
    AND e.sal >= s.losal
    AND e.sal <= s.hisal
ORDER BY
    sal DESC,
    empno;


SELECT
    e.empno,
    e.ename,
    d.dname,
    e.hiredate,
    d.loc,
    e.sal,
    (
        SELECT
            grade
        FROM
            salgrade
        WHERE
                e.sal >= losal
            AND e.sal <= hisal
    ) AS salgrade
FROM
    (
        SELECT
            *
        FROM
            emp
        WHERE
            sal > (
                SELECT
                    AVG(sal)
                FROM
                    emp
            )
    )    e,
    dept d
WHERE
    e.deptno = d.deptno
ORDER BY
    sal DESC,
    empno;
    
-- Q3    
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT JOB FROM EMP WHERE DEPTNO = 30;

SELECT
    e.empno  empno,
    e.ename  ename,
    e.job    job,
    d.deptno deptno,
    d.dname  dname,
    d.loc    loc
FROM
    (
        SELECT
            *
        FROM
            emp
        WHERE
            deptno = 10
    )    e,
    dept d
WHERE
        e.deptno = d.deptno
    AND job NOT IN (
        SELECT
            job
        FROM
            emp
        WHERE
            deptno = 30
    );
    
    
-- Q4
SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN';

SELECT
    e.empno,
    e.ename,
    e.sal,
    (
        SELECT
            grade
        FROM
            salgrade
        WHERE
                e.sal >= losal
            AND e.sal <= hisal
    ) AS salgrade
FROM
    emp  e,
    dept d
WHERE
        e.deptno = d.deptno
    AND e.sal > (
        SELECT
            MAX(sal)
        FROM
            emp
        WHERE
            job = 'SALESMAN'
    );
 
-- 다중행 함수 사용   
SELECT
    e.empno,
    e.ename,
    e.sal,
    (
        SELECT
            grade
        FROM
            salgrade
        WHERE
                e.sal >= losal
            AND e.sal <= hisal
    ) AS salgrade
FROM
    emp  e,
    dept d
WHERE
        e.deptno = d.deptno
    AND e.sal > ALL (
        SELECT
            sal
        FROM
            emp
        WHERE
            job = 'SALESMAN'
    );
    
    
SELECT INSTR('Hello!!world', 'l', -3) from dual;