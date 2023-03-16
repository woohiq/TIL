# 2023-03-16 JDBC



## JDBC

Java 프로그램에서 DB에 일괄된 방식으로 접근할 수 있도록 api를 제공하는 클래스

자료를 쿼리하거나 업데이트 방법 제공

java와 mySql을 쓰고싶다면… 어떻게 연결 ?

java에서 설명서, api, 인터페이스 등을 만들어 놓았음

그래서 mySql 그걸 바탕으로 코드를 만들어 놨음

### 사용법

1. JDBC 드라이버 로드
2. DB연결
3. SQL문
4. DB연결끊기

### JDBC 드라이버 로드

드라이버를 프로그램 시작할때 로드 java.lang.Class 클래스의 forName() 메서드 이용

MySQL에서는

```java
try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
```

### 데이터베이스 연결

DriverManager 클래스 getConnection으로 연결

MySQL에서는

```java
Connection conn = DriverManager.getConnection("URL", "ID", "PW");
// URL은
// `jdbc:mysql://localhost:(포트번호)/(DB이름)?serverTimezone=UTC`
```

### SQL 실행

흔히 생각하는 실행이 이부분. statement객체가 필요

두 가지 방법가능

1. createStatement로 완전한 statement문을 만들어서 호출

```java
String sql = "SELECT * FROM board";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql);
// 얘는 Select하는 Query문이라서 반환값이 ResultSet인거임
// Update하는 애면 

// String sql = "UPDATE board SET title = '엄'"
// int a = stmt.executeUpdate(sql);
```

1. prepareStatement로 `?` 을 사용해서 인자를 채움

```java
String sql = "UPDATE board SET title = ?, content = ? WHERE id = ?";
Statement pstmt = conn.prepareStatement(sql);
pstmt.executeUpdate();
```

두 실행 execute함수에서 인자가 있음/없음에 주의

### 데이터베이스 연결종료

킨 것의 역순으로 종료

만약 null이면 종료가 안되므로 null도 체크해줘야함

근데 ResultSet, Statement, Connection  이 closeable

```java
public void close(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
```

이 함수 써서 ( 클래스이름 ).close( rs, st, cn ); 도 가능

### ResultSet

BOF와 EOF사이 정보들이있음

next로 다음 행으로 이동가능하고 같은 행 안에선

getXXX로 접근가능
