# 2023-04-25 Spring REST API

## REST

Representational State Transfer

하나의 URI는 하나의 Resource를 대표하도록 설계

### REST 구성

- `Resource` 자원 (URI)
- `Verb` 행위 (HTTP Method)
- `Representations` 표현

예를들어, CRUD 작업의 경우 (Create, Read, Update, Delete)

- 기존에는, `POST`와 `GET` 방식만을 사용, 주소는 각각의액션 이름으로
- REST방식은, `POST`, `GET`, `PUT`, `DELETE`요청 같은 방식 사용, 주소는 QueryString이나 액션 이름을 사용하지 않고 계층 구조를 사용 (조금 달라질수도)

## API

Application Programming Interface

두 소프트웨어 요소들이 서로 통신할 수 있게 하는 방식

`private` vs `public` 

## REST API

요청으로 받은 리소스에 대해 순수한 데이터 전송

Resource 와 HTTP Method를 이용해 명령을 내림

정해진 표준은 없음, 암묵적인 표준정도만 정해짐

기존 Service : 요청에 대한 처리를 한 후 가공된 data를 이용해서 View로 만들면

REST Service : data처리만 or 처리후 반환될 data를 JSON이나 XML형식으로 전달해서 View 신경 X

GET, POST, PUT, DELETE + URI로 request

XML이나 JSON으로 response