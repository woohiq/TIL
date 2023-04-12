# 2023-04-12 Spring AOP

## AOP : 관점 지향 프로그래밍

OOP : 객체지향 프로그래밍

| AOP                | OOP                  |
| ------------------ | -------------------- |
| 관점지향           | 객체지향             |
| 모듈화 핵심 : 관점 | 모듈화 핵심 : 클래스 |

Aspect : 공통적으로 구현되는 관심사의 모듈화

join point : 프로그램 실행중의 특정 지점

pointcut : join point 에서 aspect를 적용하기 위한 조건

advice : 특정 join point 에서 aspect에 의해 취해진 행동

target 객체 : 하나 이상의 advice가 적용될 객체

AOP Proxy : AOP를 구현하기 위해 AOP프레임워크에 의해 생성된 객체

Weaving : Aspect를 다른 객체와 연결하여 Advice객체를 생성

## Spring AOP Proxy

Target 호출 하는것 (ex, 예금 인출 기능 호출)

ex. 로깅, 보안, 예금인출기능, 트랜잭션 모두 포함된 프록시 객체 호출

### AOP 시작 (java)

`@AspectJ` 사용

### AOP시작 (XML)

1. xml에 bean등록하기
2. `<aop:config>` 어떤 aspect가 언제 적용될 지 결정
3. `<aop:aspect ref="aspect가 있는 곳">` Aspect 선언
4. `<aop:pointcut expression="execution(메서드())" id="pt아이디">` Pointcut 선언
5. `<aop:[before, after, after Returning, around...] method="메서드이름" pointcuf-ref="pt아이디">` advice type에 따른 메서드 지정

✔ after returning, after throwing 은 각각 실행 결과로 결과와 에러를 인자로 받음

✔ around advice의 경우 ProceedingJointPoint 인자를 받고 .proceed()를 통해 관심 실행

✔ `<aop:aspectj-autoproxy proxy-target-class="true">`가 있으면 인자로 인터페이스 하위 클래스를 줘도(타입 의존성 제거한 곳에서 더 하위 클래스를 사용해도) OK

### AOP시작 (Annotation)

1. 이것도 DI처럼 `<context:component-scan base-package="패키지이름">` 씀
2. Bean을 `@Component` 를 사용해서 등록, 만약 Aspect라면 `@Aspect` 도 필요
3. `pt아이디`  메서드 위에 PointCut을 `@Pointcut("execution(메서드())")`를 써서 등록
4. `@[AdviceType]("pt아이디")` 로 advice type 지정