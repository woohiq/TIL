# 2023-05-08 Vue CLI

## Vue Command Line Interface

필수는 아니지만 사실상 필수

Vue 관련 오픈소스들이 대부분 CLI를 통해 구성 가능

### WebPack

모듈 간 의존성 문제 해결

### Vue Project 구조

`node_modules` : node.js 환경의 여러 의존성 모듈 (그래서 보통 용량크고, git에서도 올리지 않음, git ignore를 활용)

`public` : index.html, favicon.ico 하나의 html 화면,

`src` assets 정적 파일 components 하위 컴포넌트 App.vue 최상위 컴포넌트 main.js 가장 먼저 불러오는 entry point, DOM과 data연결하는 작업 등

## SFC Single File Component

확장자가 .vue

template + script + style