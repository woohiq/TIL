# 2023-05-09 Vue Router

## Vue Router

라우터 : 중계기

Vue에서의 라우팅 : 웹 페이지 간의 이동 방법

route에서 매핑, 어느 주소에서 렌더링 할 지 알려줌

해쉬모드 / 히스토리 모드

### Router 시작

npm install vue

vue add router

### 생성되는 것들

Views 디렉토리 index.js

생성됨

### index.js에서 연결

import를 하던지 아니면 () ⇒ 해서 바로 import 하던지

### Components vs Views

각각 SFC파일 저장

주로 사용자가 구분해서 쓴다 ( 꼭 그럴 필요는 없지만, 공공의 약속 )

views : router 에 매핑되는 애들

compontent: router에 매핑되는 컴포넌트 내부에 작성하는 컴포넌트들

### router-view

일치하는 컴포넌트를 렌더링

해당 경로와 연결되어 있는 index.js에 정의한 컴포넌트가 위치

### named routes

라우트에 이름을 명명하면, router-link의 to로 전달할 수 있음

```
<router-link :to="{name:'about'}">
```

### 프로그래밍 방식 네비게이션

a태그를 만드는 것 이외에도 인스턴스 메서드 사용 가능

Vue 인스턴스 내부에서 라우터 인스턴스에 $router로 접근 가능

this.$router.push = <router-link :to=’…’>를 클릭

### 동적 라우트 매칭

주어진 패턴을 가진 라우트를 동일한 컴포넌트에 매핑 (예를들어, detail기능에서 1,2,3번 게시글은 모두 동일한 기능을)

### Nested Routes

실제 UI는 여러 단계로 중첩된 컴포넌트 구조