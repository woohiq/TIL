# 2023-04-17 Spring Interceptor

## Interceptor

요청을 처리하는 과정에서 가로채서 처리

HandlerInterceptor(인터페이스) 구현 또는 HandlerInterceptorAdapter(클래스) 상속

### boolean preHandle()

핸들러 실행 이전에 호출, false 반환하면 요청 종료

### void postHandle()

핸들러 실행 후 호출, 핸들러에서 예외 발생 시 실행X

### void afterCompletion()

뷰가 클라이언트에게 응답을 전송한 뒤 실행, 핸들러에서 예외 발생 시 4번째 인자로 전달