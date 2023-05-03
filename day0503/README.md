# 2023-05-03 Vue Event

## Vue Life Cycle

### Instance Life Cycle

생성될 때 초기화

생성, 부착, 갱신, 소멸의 4개 파트

Instance Life Cycle Hook은 각 파트 이전, 이후 2개씩 해서 총 8개

## Vue Event

### 이벤트 청취

```html
v-on:click = "count += 1" // 이런식으로 v-on:이나 @사용
```

### 이벤트 핸들러 처리

위의 예시에서 메서드의 이름과 연결하면됨

### 이벤트 모디파이어

event.preventDefault() 등을 호출하는 일은 흔한데, method가 이를 처리가능하지만, method는 주로  data를 처리하는데에만 쓴다. 따라서 v-on 이벤트에 이를 수식어로 제공

### 이벤트 키 모디파이어

키 이벤트 수신

## Vue Bindings

$refs : ref 속성이 등록된 컴포넌트

ref : 엘리먼트 또는 자식에 대한 참조 등록

class 바인딩

form input bindings