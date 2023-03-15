DROP DATABASE IF EXISTS ssafy_movie;

CREATE DATABASE IF NOT EXISTS ssafy_movie;

USE ssafy_movie;

DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS cinema;

CREATE TABLE `cinema` (
	`CinemaCode` int(10) NOT NULL PRIMARY KEY,
    `CinemaName` varchar(10) CHARACTER SET utf8mb4 NOT NULL,
    `Location` varchar(10) CHARACTER SET utf8mb4 NOT NULL
)ENGINE=InnoDB;

CREATE TABLE `movie` (
	`ID` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `CinemaCode` int(10) NOT NULL,
    `Title` varchar(40) CHARACTER SET utf8mb4 NOT NULL,
    `ReleaseDate` date,
    `RunningTime` int(3) NOT NULL,
    CONSTRAINT `movie_ibfk_1` FOREIGN KEY (`CinemaCode`) REFERENCES `cinema` (`CinemaCode`)
)ENGINE=InnoDB;

INSERT INTO `cinema` (CinemaCode, CinemaName, Location) 
VALUES
(0, 's시네마','서울'),
(1, 'G시네마','광주'),
(2, 'B시네마','부산'),
(3, 'i시네마','인천');


INSERT INTO `movie` (Id, CinemaCode, Title, ReleaseDate, RunningTime)
VALUES 
(1000, 0,'이터널스',STR_TO_DATE('5-11-2021','%d-%m-%Y'),156),
(1001, 0,'트랜스포터',STR_TO_DATE('2-10-2002','%d-%m-%Y'), 92),
(1002, 1,'해리포터와 마법사의돌',STR_TO_DATE('14-12-2001','%d-%m-%Y'),152),
(1003, 1,'해리포터와 비밀의방',STR_TO_DATE('14-12-2002','%d-%m-%Y'),162),
(1004, 2,'기생충',STR_TO_DATE('30-5-2019','%d-%m-%Y'),153);

commit;

SELECT * FROM MOVIE;
SELECT * FROM CINEMA;

-- 1.    movie 테이블과 cinema 테이블을 full outer 조인하면 몇개의 행이 조회되는시 출력하시오.
------------------------------------------------------
-- FULL OUTER 조인을 배우지 않았으니까 INNER JOIN 해서 풀겠습니다
------------------------------------------------------
SELECT COUNT(*) AS '행 수'
FROM MOVIE M
INNER JOIN CINEMA C;

-- 2.    모든 영화가 어떤 cinema에서 상영중인지 알 수 있도록 영화 정보와 시네마 정보를 모두 출력하시오.
SELECT *
FROM MOVIE M
INNER JOIN CINEMA C
WHERE M.CINEMACODE = C.CINEMACODE;

-- 3.    서울에 있는 시네마에서 상영하는 영화들을 조회하시오.
SELECT *
FROM MOVIE M
INNER JOIN CINEMA C
ON M.CINEMACODE = C.CINEMACODE
WHERE C.LOCATION = '서울';

-- 4.    광주에 있는 시네마에서 상영하는 영화가 몇개인지 조회하시오.
SELECT COUNT(*) AS '상영중', C.LOCATION
FROM MOVIE M
INNER JOIN CINEMA C
ON M.CINEMACODE = C.CINEMACODE
WHERE C.LOCATION = '광주';

-- 5.    cinema 이름으로 그룹핑 하여 각 시네마 마다 몇개의 영화가 상영중인지 조회하시오.
SELECT C.CINEMANAME, COUNT(*) AS '상영 중'
FROM CINEMA C
INNER JOIN MOVIE M
ON M.CINEMACODE = C.CINEMACODE
GROUP BY C.CINEMANAME;

-- 6.    cinema 이름으로 그룹핑 하여 각 시네마 마다 몇개의 영화가 상영중인지 출력하는데 상영중인 영화가 0개인 시네마도 조회하시오.
SELECT C.CINEMANAME, COUNT(ID) AS '상영 중'
FROM CINEMA C
LEFT OUTER JOIN MOVIE M
ON M.CINEMACODE = C.CINEMACODE
GROUP BY C.CINEMANAME;

-- 7.    cinema 지역으로 그룹핑 하는데 상영하는 영화의 개수가 1개인 시네마의 지역들을 조회하시오.
SELECT A.CNT AS '상영 중', A.지역
FROM ( SELECT COUNT(ID) AS 'CNT', C.LOCATION AS '지역'
	FROM CINEMA C
	LEFT OUTER JOIN MOVIE M
	ON M.CINEMACODE = C.CINEMACODE
	GROUP BY C.CINEMANAME ) A
WHERE A.CNT = 1;

-- 8.    영화 이름이 '이터널스' 인 영화의 상영 시간 이상인 영화 이름과 상영 시간을 출력하시오.
SELECT M.TITLE, M.RUNNINGTIME
FROM MOVIE M
WHERE M.TITLE = '이터널스'
OR M.RUNNINGTIME > ANY (SELECT RUNNINGTIME
						FROM MOVIE
                        WHERE TITLE = '이터널스');

-- 9.    상영 시간이 156분 이상인 영화들을 상영중인 cinema 이름을 출력하시오.
SELECT CINEMANAME
FROM MOVIE M
INNER JOIN CINEMA C
ON M.CINEMACODE = C.CINEMACODE
WHERE M.RUNNINGTIME >= 156;

-- 10. 상영 시간이 156분 이상인 영화들 중 제목에 '해리포터' 라는 단어를 포함하는 영화 제목과 상영시간을 출력하시오.
SELECT TITLE, RUNNINGTIME
FROM MOVIE M
INNER JOIN CINEMA C
ON M.CINEMACODE = C.CINEMACODE
WHERE M.RUNNINGTIME >= 156
AND M.TITLE LIKE '%해리포터%';