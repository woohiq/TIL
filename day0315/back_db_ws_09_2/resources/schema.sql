DROP DATABASE IF EXISTS SSAFY_MOVIE;
CREATE DATABASE SSAFY_MOVIE;

USE SSAFY_MOVIE;

DROP TABLE IF EXISTS MOVIE;
DROP TABLE IF EXISTS RATE;

CREATE TABLE `MOVIE` (
	`ID` INT NOT NULL PRIMARY KEY,
    `TITLE` VARCHAR(40) NOT NULL,
    `DIRECTOR` VARCHAR(40) NOT NULL,
    `GENRE` VARCHAR(40) NOT NULL,
    `RUNNINGTIME` INT NOT NULL,
    `RELEASEDATE` DATE
);

-- ID와 NAME을 복합키로 설정하여 하나의 영화에 대해서 같은 NAME은 하나만 평점등록가능
CREATE TABLE `RATE` (
	`ID` INT NOT NULL,
	`NAME` VARCHAR(40) NOT NULL,
    `RATING` INT NOT NULL,
    `COMMENT` VARCHAR(100) NOT NULL,
    PRIMARY KEY (ID, NAME)
);

INSERT INTO MOVIE
VALUES 
	(1000, '이터널스', '클로이 자오', '액션', 156, '2021-11-05'),
    (1001, '트랜스포터', '루이 트테리에', '액션', 92, '2021-11-05'),
    (1002, '해리포터와 마법사의 돌', '크리스 콜롬버스', '판타지', 156, '2021-11-05'),
    (1003, '해리포터와 비밀의 방', '크리스 콜롬버스', '판타지', 156, '2021-11-05'),
    (1004, '기생충', '봉준호', '스릴러', 156, '2021-11-05');

INSERT INTO RATE
VALUES
	(1000, '마동석아님', 4, '마동석 최고'),
    (1000, 'NOT BAD', 3, '이냥저냥'),
    (1002, 'CHILD', 5, '어린 시절 최고의 판타지 영화'),
    (1003, 'HARRY', 5, '믿고 보는 해리포터 시리즈'),
    (1004, 'KOREAN', 4, '자랑스러운 한국영화'),
    (1004, 'JOHN', 5, 'NICE MOVIE'),
    (1004, '힙스터', 2, '난 별로였는데');

SELECT M.ID 등록번호 , 
	M.TITLE 제목, 
	M.DIRECTOR 감독 , 
    M.GENRE 장르, 
    M.RUNNINGTIME 상영시간, 
    M.RELEASEDATE 개봉일, 
    R.RATING 평점, 
    R.COMMENT 한줄평, 
    R.NAME 닉네임
FROM MOVIE M
LEFT OUTER JOIN RATE R
ON (M.ID = R.ID);


