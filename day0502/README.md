## Template Syntax

렌더링된 DOM을 기본 Vue인스턴스 데이터에 바인딩

### 보간법

이중중괄호를 사용한 Mustache구문을 사용해 텍스트 보간

```jsx
<span>{{msg}}</span>
<span v-once>{{msg}}</span> //한 번만
```

이중중괄호는 HTML이 아닌 일반 텍스트로 해석 실제 HTML은 v-html 사용

JavaScript표현식 기능 사용 가능 (단, 표현식만 가능)

### 디렉티브

v-접두사가 있는 특수 속성

속성값은 단일 javaScript 표현식

```html
<span v-once>{{msg}} </span> : 한번만 실행
<span v-text="msg" /> : textContext 출력
<span v-html="msg" /> : textContext를 html적용해서 출력
<span v-bind:id="msg" /> : 할당
<span :id="msg" />
<span v-mode="msg" /> 양 방향 바인딩
<span v-show="msg"> (결과) </span> 조건에 따라 표시 (단, 항상 렌더링)
<span v-if="msg"> (결과) </span> 조건에 따라 표시 (단, 조건부 렌더링)
<span v-for="msg in msgs"> (msg사용) </span> 여러 번 렌더링
<span v-on:click="plus" /> 이벤트 유형을 이벤트 리스너에 매핑
<span @click="plus" />
<span v-clock /> Vue Instance가 준비될 때 까지 숨기는데 사용 (주로 style과 연계, 단, 항상렌더링)
```

## Vue Instance Option

methods (메서드 정의)

filter (텍스트 형식화해서 새로운 결과로, 그래서 v-bind랑 많이 씀)

{{이전 | 필터사용}} 처럼

computed (변경사항 실시간 처리, 결과는 method랑 같지만, 결과가 같다면 더이상 호출 X)

watch (변경되면 실행할 메서드 저장)