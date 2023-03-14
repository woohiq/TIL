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

-- 1.    movie 테이블에 전채 몇개의 행이 있는지 조회하시오.
SELECT COUNT(*) as '영화 수'
FROM movie;

-- 2.    전체 영화의 상영시간 평균을 조회하시오.
SELECT AVG(RunningTime) as '평균'
FROM movie;

-- 3.    전체 영화의 상영시간 합을 조회하시오.
SELECT SUM(RunningTime) as '총 합'
FROM movie;

-- 4.    제목에 '포터' 단어가 포함된 영화들의 상영시간 평균을 둘째짜리 까지 반올림 하여 조회하시오.
SELECT ROUND(AVG(RunningTime), 2) as '포터평균'
FROM movie
WHERE title LIKE '%포터%';

-- 5.    cinemacode 로 그룹핑 했을때 각 그룹에 몇개의 영화가 포함되어 있는지 조회하시오.
SELECT cinemacode, COUNT(*) '수'
FROM movie
GROUP BY cinemacode;

-- 6.    cinemacode 로 그룹핑 했을때 각 그룹의 제일 먼저 개봉한 영화의 날짜를 조회하시오.
SELECT cinemacode, MIN(ReleaseDate) '날짜'
FROM movie
GROUP BY cinemacode;

-- 7.    cinemacode 로 그룹핑 했을때 각 그룹의 제일 긴 상영시간이 몇분인지 조회하시오.
SELECT cinemacode, MAX(RunningTime) '최대'
FROM movie
GROUP BY cinemacode;

-- 8.    cinemacode 로 그룹핑 했을때 상영시간의 평균이 150분 이상인 그룹의 cinemacode 만 조회하시오.
SELECT cinemacode, AVG(RunningTime) '평균'
FROM movie
GROUP BY cinemacode
HAVING AVG(RunningTime) >= 150;

-- 9.    cinemacode로 그룹핑 했을때 상영시간의 합이 300분 이상인 그룹의 cinemacode 만 조회하시오.
SELECT cinemacode, SUM(RunningTime) '합'
FROM movie
GROUP BY cinemacode
HAVING SUM(RunningTime) >= 300;

-- 10. cinemacode 로 그룹핑 했을때 상영시간의 평균이 150분 이상인 그룹들 중 상영시간의 총 합이 300 이상인 그룹의 cinemacode를 조회하시오.
SELECT cinemacode, AVG(RunningTime) 평균 , SUM(RunningTime) 합
FROM movie
GROUP BY cinemacode
HAVING SUM(RunningTime) >= 300 AND AVG(RunningTime) >= 150;