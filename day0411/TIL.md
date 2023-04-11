# 2023-04-11 Spring DI

## Spring Framework

framework : 뼈대, 틀, 협력을 위한 인터페이스와 클래스의 집합

공통으로 사용되는 기본기능을 일관되게 사용할 수 있도록

### 특징

- POJO (Plain Old Java Object) 방식
- 의존성 주입(DI)를 통한 객체관계 구성
- 관점지향 프로그래밍 (Aspect Oriented Programming)
- 제어 역전(Inversion of Control)

## 의존 관계 역전

객체 생성 의존성 제거 (의존관계역전)

타입 의존성 제거 (느슨한 결합)

## 의존성 주입

생성자 이용

설정자 이용

## Spring Container Build

스프링 핵심역할 객체 : Bean

Container는 Bean 인스턴스화, 조립, 관리, 사용소멸 처리

스프링 설정 정보

Bean과 설정 정보, 의존성을 나타내는 방법

XML, Annotation, Java

### 스프링 컨테이너 객체 빌드

ApplicationContext(인터페이스) GenericXmlApplicationContext(클래스)

```java
ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
```

### 컨테이너로부터 객체 가져오기

```java
Programmer p = (Programmer) context.getBean("programmer");
Desktop desktop = context.getBean("desktop", Desktop.class);
```

### Bean Scope

Bean의 정의를 작성하는것은 객체 생성과 다름, 범위를 지정 가능 Singleton, prototype, request, session

## Spring DI

### xml 파일 수정

의존성 주입 (생성자) constructor-arg

의존성 주입 (설정자) property

### Annotation

xml 파일 context 체크 후,

```java
<context:component-scan base-package = "pacakage이름" ></context:component-scan>
```

`@Component` 로 bean 만들기, `value = “이름”` 으로 이름 설정 가능

`@Autowired` 로 의존성 주입 (생성자, setter, field)

만약 의존성 주입할 때 어느 bean을 선택해야 하는지 선택해야 한다면 `@Qualifier`