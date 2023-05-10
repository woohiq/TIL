# 2023-05-01 JavaScript 복습

## JavaScript

프로토타입 기반 객체 생성 동적 스크립트 언어

Web Browser에서 주로 사용

HTML 자바스크립트 사용

<script></script> 태그 사용

.js 확장자 파일을 <script src=”위치”>로 가져올수도 있음

### 변수

var, let, const

아무 값도 없으면 undefined

동적타입 (대입 값에 따라 용도 변경)

`null` `undefined` `0` `(비어있는문자열)` `NaN` 이면 false

### 반복문

for of : 배열

for in : 구조체

### 객체

key : value 형태

Prototype이라는 파라미터 있음

접근할 때에는 [’key’] 또는 .key로 (띄어쓰기가 있으면 전자만 가능)

축약 문법 (key - value가 같은 경우)

```jsx
var books = ['책 1' , '책 2']
var bookshop = {books : books}
var bookshop = {books}
```

### 함수

선언식 function fuc() {}

표현식 const fuc = function() {}

화살표함수 function을 지우고, ()와 {} 사이에 ⇒를 넣기

### JSON

parse : json을 객체로

stringify : 객체를 json으로

### array helper method

.forEach, .map, .find, .filter

## Vue.js

### Vue.js

사용자 인터페이스 Progressive framework

Single Page Application를 완벽하게 지원

### MVVM 패턴

Model + View + ViewModel

어플리케이션 로직을 UI로부터 분리

### Vue Instance

새로운 Vue인스턴스를 만드는 것으로 시작

el : 뷰 객체를 마운트(연결) 할 엘리먼트를 설정