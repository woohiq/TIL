## 데이터베이스

여러 사람이 공유하고 사용할 목적으로 통합되는 정보의 집합

내용을 구조화. 중복을 없애고 효율화

통합 데이터

저장 데이터

운영 데이터

공용 데이터



### DBMS

데이터베이스 관리 프로그램





## 관계형 데이터베이스

table 기반의 데이터베이스

데이터를 table에 저장하고 여러 속성을 갖고 있게 해 중복을 최소화, 관계를 통해 검색

행(record) 열(attribute)



### SQL structed query language

관계형 데이터베이스에서 데이터 조작과 정의를 위해 쓰는 언어

선언적 언어

대소문자구분없고 dbms와 독립적



### 스키마

테이블에 저장될 데이터의 구조와 형식

```sql
CREATE DATABASE 생성
ALTER DATABASE 수정
DROP DATABASE 삭제
```

```sql
INSERT INTO (테이블이름) (필드이름) 
VALUES (필드 값들)
[WHERE]                     범위 설정(없으면 모든 행)

UPDATE (테이블이름)
SET (필드이름 = 값)          기본 레코드를  수정
[WHERE]                        

DELETE FROM (테이블 이름)
[WHERE]   

SELECT (필드 이름이나 필드이름을 활용한 연산) [AS (별명)]
FROM (테이블 이름)
[WHERE, GROUP BY, HAVING, ORDER BY, LIMIT]

WHERE : 조건에 맞는 조회 ( AND, OR, NOT, BETWEEN, IS NULL, LIKE 등 사용가능)
ORDER BY : 정렬 ( ASC DESC )
HAVING : 집계함수 결과 내 조건에 맞는 레코드 조회

내장 함수들
POW, MOD, 집계함수

집계함수 예시
AVG, COUNT, MAX, MIN, SUM, STD...
COUNT(*) (이건 GROUP BY와 같이)

```

