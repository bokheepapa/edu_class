SELECT
    *
FROM
    emp;

-- 1. 부서번호 10번인 사람들을 출력
SELECT
    *
FROM
    emp
WHERE
    deptno = 10;

-- 2. 부서번호 10번인 아닌 사람들을 출력
SELECT
    *
FROM
    emp
WHERE
    deptno != 10;

-- 3. 금여가 3000 이상인 사람들을 출력
SELECT
    *
FROM
    emp
WHERE
    sal >= 3000;

-- 4. 금여가 1500~3000 사이(포함)의 사람을 출력
SELECT
    *
FROM
    emp
WHERE
        sal >= 1500
    AND sal <= 3000;

-- 5. 부서번호 10번인 사람 중 금여 2000 이상인 사람을 출력
SELECT
    *
FROM
    emp
WHERE
        deptno = 10
    AND sal >= 2000;

-- 6. 부서번호 30번인 사람 중 1500~3000 사이(미포함) 인 사람을 출력
SELECT
    *
FROM
    emp
WHERE
        deptno = 30
    AND sal >= 1500
    AND sal <= 3000;

-- 7. 부서번호 30번인 사람 중 1500~3000 사이(미포함) 인 사람을 연봉이 작은 순으로 출력, 연봉이 같은 경우 이름이 빠른 순으로 출력
SELECT
    *
FROM
    emp
WHERE
        deptno = 30
    AND sal > 1500
    AND sal < 3000
ORDER BY
    sal ASC,
    ename ASC;

-- 8. 부서번호 20, 30번인 사람 중 1500~3000 사이(미포함) 인 사람을 연봉이 작은 순으로 출력, 연봉이 같은 경우 이름이 빠른 순으로 출력
SELECT
    *
FROM
    emp
WHERE
    ( deptno = 30
      OR deptno = 20 )
    AND sal > 1500
    AND sal < 3000
ORDER BY
    sal ASC,
    ename ASC;

-- 9. 부서번호가 20 또느 30이고 급여가 1500 이상인 직원의 이름과 급여를 급여 오름차순으로 출력
SELECT
    ename AS "이름",
    sal   AS "급여"
FROM
    emp
WHERE
    ( deptno = 30
      OR deptno = 20 )
    AND sal >= 1500
ORDER BY
    sal ASC;
    
    
SELECT
    *
FROM
    emp
WHERE
    sal BETWEEN 1500 AND 2000
    AND sal != 2000
    AND sal != 1500;
    
    
    
-- like
select * from emp where ename like '_L%';

select * from emp where ename like '%T%';

select comm from emp where comm is not null;



SELECT
    *
FROM
    emp
WHERE
    deptno = 10
union
SELECT
    *
FROM
    emp
WHERE
    deptno = 20
    
order by 8;

select deptno from emp
union all
select losal from SALGRADE;

-- Q6
SELECT
    *
FROM
    emp
WHERE
    NOT ename LIKE '_L%'
        AND comm IS NULL
        AND mgr IS NOT NULL
        AND job IN ( 'MANAGER', 'CLERK' );
              
-- Q5
SELECT
    ename,
    empno,
    sal,
    deptno
FROM
    emp
WHERE
    ename LIKE '%E%'
    AND deptno = 30
    AND sal NOT BETWEEN 1000 AND 2000;
    
-- Q4
SELECT * FROM EMP WHERE SAL < 2000 OR SAL > 3000; 

SELECT ENAME FROM EMP WHERE UPPER(ENAME) LIKE LOWER('%AM%');
SELECT JOB, SUBSTR(JOB, -4) FROM EMP;

SELECT * FROM DUAL;

SELECT ENAME, LENGTH(ENAME) FROM EMP WHERE LENGTH(ENAME) = 5;