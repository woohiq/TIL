# 2023-05-10 Vue Axios

## Vue style guide

작성 가이드

- 컴포넌트 이름에 합성어 사용
- 컴포넌트 데이터는 함수
- Props는 상세하게 정의 (적어도 Type 명시)
- v-for 키 지정
- v-if for 동시 사용 X
- 스타일 scope
- private하게 하려면 $_붙이기

## AJAX

비동기 Asynchronous JavaScript and XML

새로고침 하지 않고 일부만 수정도 가능

### XMLHttpRequest

옛날방식이긴한데, 서버와 상호작용 하기 위해 사용

### 순차 처리 방식

Async Callback

Promise-style

### Promise Object

비동기 작업을 값을 반환해서, 실패 완료 표시

## axios

node.js에서 사용할 수 있는 Promise 기반 Http클라이언트 라이브러리