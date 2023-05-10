# 2023-04-28 Spring 정리

## DI (의존성 주입)

프로그래머 - Desktop,Laptop예시로 했었던 의존성 (객체생성, 타입 의존성)

1. XML방식 주입
2. Annotation방식 주입 (Autowired,
3. Java파일 방식 주입
4. 설정자 의존성 주입
5. 생성자 의존성 주입
6. 필드 의존성 주입

기본적으로 객체들(스프링컨테이너) 싱글턴, 설정으로 프로토타입 설정 가능

## AOP (관점지향 프로그래밍)

핵심 관심사항에 공통 관심사항을 붙임 (before, after, after-returning, after-throwing, around)

XML이나 Annotation으로 등록

## MVC

DispatcherServlet이 흐름에 따라 처리 하고 돌려줌

## Interceptor

pre, post, aftercompletion

servlet-context의 interceptor태그로 등록 경로 매핑을 필요한 곳마다 추가 or 전체 경로 넣고 일부만 제외

## File

### 업로드

pom.xml에 fileupload관련 추가 servlet-context에 MultipartResolver등록

사용 시에는 form태그에

method태그 `post`, enctype태그 `multipart…` input태그 `file` multiple태그 accept태그 설정

### 다운로드

[DownloadView.java](http://DownloadView.java) 빈으로 등록 BeanNameResolver 우선순위 높게 등록

Mybatis

JDBC를 좀 더 쉽게

1. jar파일 추가
2. pom.xml 에 추가

설정 파일 필요 (순서 있게 넣어야 함, ex. properties, typealias, 환경(url, driver, user, password), mapper)

SqlSessionFactoryBuilder에서 SqlSessionFactory만들고 SqlSession만들어서 Mybatis사용

### 동적쿼리

XML / JSTL이랑 비슷하게 작성

## REST API

기존 : JSP를 이용하여 Page응답

REST : 데이터 응답

URI + GetPostPutDelete 형식으로 입력받음

ResponseBody, RestController등으로 REST 메서드임을 선언 RequestBody로 자동으로 json으로 바꿈 ResponseEntity로 상태코드, 데이터, 헤더 반환

Swagger로 쉽게 확인

## Boot

Spring을 더 쉽게 사용, 하나의 설정 파일로 설정하는 등 편의

WAS 내장

CORS