# 2023-05-11 Vuex

## Vuex

Vue.js 어플리케이션에 대한 상태관리패턴 + 라이브러리

중앙저장소 역할

만약, 여태까지 배운 것으로 먼 컴포넌트의 데이터를 전달하려면 ? emit, emit, props, props등등 복잡

### 핵심 컨셉

State : 데이터 관리

→ render →

Vue Component :

→ dispatch →

Actions : 메서드 같은 것들, axios등을 사용해서 backend api와 소통

→ commit →

Mutations :

→ mutate →

State

### 저장소 개념

State : data

Getters : computed

Mutations : methods

Actions : 비동기 methods

Module

### 설치하기

npm install vuex —save

vue add vuex