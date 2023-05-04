# 2023-05-04 Vue Component

## Module

기능별로 여러 개의 파일로 나눔

import, export 사용

## Component

Vue의 가장 강력한 기능

HTML Element를 확장하여 캡슐화

루트에서만 사용하는 옵션을 제외하고 모두 사용 가능 (el, …)

따라서 Vue Component 를 등록해야 한다

1. 전역으로 등록하거나 (Vue.component에서 선언)
2. 인스턴스로 등록해서 범위 한정 (components로 등록)

단, data는 반드시 함수여야 한다

## Vue Component 통신

부모는 자식에게 데이터를 전달 (Pass Props)

자식은 부모에게 일어난 일을 알림 (Emit Event)

따라서 props 데이터는 단방향 통신