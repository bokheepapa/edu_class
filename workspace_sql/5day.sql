select * from emp;

select ename, sal * 12 + nvl(comm,0) as total_pay from emp;

select sysdate from dual;

select to_char(sysdate, 'YYYY/MM/DD hh:mi:ss') as to_day from dual;

select empno, lpad(empno,7,'*') from emp;


SELECT
    empno,
    ename,
    job,
    sal,
        decode(job, 
         'MANAGER', sal * 1.1, 
         'SALESMAN', sal * 1.05,
         'ANALYST', sal, 
         sal * 1.03) AS upsal
FROM
    emp;
    
SELECT
    empno,
    ename,
    job,
    sal,
        decode(job, 
         'MANAGER', '매니져', 
         'SALESMAN', '세일즈맨',
         'ANALYST', '분석가', 
         '쩌리') AS "한글로"
FROM
    emp;
    
    
SELECT
    empno,
    ename,
    job,
    sal,
        case job 
         when 'MANAGER' then case ename when 'JONES' then '킹매니져' else '매니져' end 
         when 'SALESMAN' then '세일즈맨'
         when 'ANALYST' then '분석가' 
         else '쩌리'
         end AS "한글로"
FROM
    emp;
    
    
select nvl(comm, -1) from emp;

SELECT
    comm,
    decode(comm, 
    NULL, -1, 
    comm),
    CASE 
        WHEN comm is NULL THEN - 1
        ELSE comm
    END
FROM
    emp;
    
select empno, ename, comm,
        case
        when comm is null then '해당 사항 없음'
        when comm = 0 then '수당 없음'
        when comm > 0 then '수당 : ' || comm
        end as case
from emp;


-- Q1
select 
    empno, 
    rpad(substr(empno, 1,2),4,'*') AS MASKING_EMPNO,
    ename,
    rpad(substr(ename, 1,1),5,'*') AS MASKING_ENAME  
from 
    emp
where 
    length(ename) >= 5 
    and length(ename) < 6;

-- Q2
SELECT
    empno,
    ename,
    sal,
    trunc(sal / 21.5, 2) AS DAY_PAY,
    round(sal / 21.5 / 8, 1) AS TIME_PAY
FROM
    emp;

-- Q3 case사용
SELECT
    empno,
    ename,
    hiredate,
    to_char(next_day(add_months(hiredate, 3),2),'YYYY-MM-DD') AS r_job,
    CASE
        WHEN comm IS NULL THEN 'N/A'
        WHEN comm IS NOT NULL THEN to_char(comm)
    END AS comm
FROM
    emp
WHERE
    round(months_between(sysdate, hiredate)) > 3;

-- Q3 decode 사용
SELECT
    empno,
    ename,
    hiredate,
    to_char(next_day(add_months(hiredate, 3),2),'YYYY-MM-DD') AS r_job,
    decode(comm, NULL, 'N/A', comm) AS comm
FROM
    emp
WHERE
    round(months_between(sysdate, hiredate)) > 3;



-- Q4
SELECT
    empno,
    ename,
    mgr,
    DECODE(substr(mgr, 1, 2),NULL, '0000',
           75, '5555',
           76, '6666',
           77, '7777',
           78, '8888',
           mgr) AS chg_mgr_DECODE,
    
    CASE
        WHEN mgr IS NULL THEN
            '0000'
        WHEN substr(mgr, 1, 2) = 75 THEN
            '5555'
        WHEN substr(mgr, 1, 2) = 76 THEN
            '6666'
        WHEN substr(mgr, 1, 2) = 77 THEN
            '7777'
        WHEN substr(mgr, 1, 2) = 78 THEN
            '8888'
        ELSE
            to_char(mgr)
    END AS chg_mgr_CASE
FROM
    emp;


SELECT DEPTNO, SUM(SAL), COUNT(*) FROM EMP GROUP BY DEPTNO;

SELECT COUNT(*) FROM EMP WHERE DEPTNO = 30;

SELECT JOB FROM EMP GROUP BY JOB;

SELECT JOB FROM EMP WHERE DEPTNO = 10 GROUP BY DEPTNO, JOB;

SELECT
    job,
    deptno,
    AVG(sal)
FROM
    emp
GROUP BY
    deptno,
    job
HAVING
    AVG(sal) > 2000;
    
    
/* 5 */ SELECT JOB, COUNT(*) AS CNT
/* 1 */ FROM EMP
/* 2 */ WHERE SAL > 1000
/* 3 */ GROUP BY JOB
/* 4 */ HAVING COUNT(*) >= 3
/* 6 */ ORDER BY CNT DESC;
