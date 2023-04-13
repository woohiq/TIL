# 2023-04-13 Spring MVC

## MVC 요청 흐름

Client → (request) → Controller (WAS using Tomcat) (Web Server + Application Server) ↔ Model

JSP는 View, Controller랑 소통해서 response 돌려보내줌

Servlet를 써서 Front Controller

Controller

Servlet

Model (Service + DAO)

Service : 비즈니스 로직 처리 (사용자에게 기능)

DAO : 퍼시스턴스 로직 처리 (DB랑 소통)

DTO : (Service, Servlet간, DAO, Service간, DB, DAO간 소통)

View

JSP

근데 Spring MVC의 특징은 POJO

Controller는 HttpServlet을 extends했는데, 그걸 안쓰고 MyController라는 class를 새로 만드는 식으로

그래서 `디스패처서블릿`이 먼저 처리해줌

1. 핸들러(컨트롤러) 매핑 : 그럼 굳이 front controller 패턴 안해도되겠다
2. 컨트롤러 동작 후 다음 가야되는 정보를 갖고 돌아감
3. `뷰리졸버`가 경로 완성
4. View로 가서 화면을 만들고 사용자에게 돌려줌

## Spring Web MVC

Servlet API 기반으로 구축된 웹 프레임워크

DispatcherServlet 기반으로 디자인됨

ViewResolver, Handelr, Mapping, Controller와 함께 요청 처리

### Dispatcher Servlet 컨테이너 구성

Servlet WebApplicationContext : Controller + ViewResolver + Handler Mapping (Web과 직접 연관이 있는 애들)

Root WebApplicationContext : Services, Repositories (살짝 연관 덜한 애들)

### 구성요소

`DispatcherServlet` 클라이언트 요청 처리

`Handler Mapping` 어떤 Controller가 처리할지 결정

`Controller` 요청에 따라 수행할 메서드 선언, 수행

`Model And View` 요청 처리를 하기 위해 필요한 것들 저장

`ViewResolver` View이름을 기반으로 반환할 View 결정