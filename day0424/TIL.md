# 2023-04-24 Spring 정리

## MVC 요청/ 응답 정리

### Client → Server

Request(Get or Post)를 날림, 이 때 filter에 걸림

### Server

1. 맨 처음 `DispatcherServlet`을 만남

2. `Handler Mapping`에서 적절한 Controller를 선택해줌

3. `Controller`에서 처리,

   1. Service (Model&View나 String을 리턴, 인자는 RequestParam등을 이용해 다룸)
   2. Dao : Interface + xml (mapper파일 namespace설정으로 구현)
   3. DB

   이 때, JDBC나 MyBatis등을 써서 DB와 연결

4. `ViewResolver` 에서 prefix나 suffix등을 추가해줌

5. `View` JSP파일 등에서 Servlet사용