# markdown 문법필기

## heading 대주제
백킷 (`) 을 활용해서 인라인 코드 작성 가능

h1 `#`          html에서는 <h1>내용</h1>

h2 `##`

h3 `###`

h4 `####`

h5 `#####`

h6 `######`



`ctrl + 숫자`하면 자동으로 heading 번호로 바꿀 수 있음



## list

### unordered list (순서가 없는 리스트)

`*` 이나 `/`을 이용해서 리스트로 만들 수 있음

* 이렇게
  * 탭으로
    * 하나씩도
      * 가능

html에서는 <ul>내용</ul>



### ordered list (순서가 있는 리스트)

`1.`등을 이용해서 리스트로 만들 수 있음

1. 이렇게
2. 만듦
   1. 탭으로
      1. 하나씩도
         1. 가능

html에서는 <ol>내용</ol>



## text style

### bold

`**`로 표현 가능 (`** 내용 **` )
아니면 `ctrl + b`로도 가능

**안녕하세요**



### italic

`*`로 표현 가능 (`* 내용 *`)
아니면 `ctrl + i`로도 가능

*안녕하세요*



***세개하면이렇게됨***



## hyperlink

### link

`[링크가 표시될 내용](내가 가고 싶은 url)`

[구글](https://www.google.com)



### image

`![대체 텍스트](내가 보여주고 싶은 이미지 url)`

![루피](https://item.kakaocdn.net/do/862539f7f2171437385154b3b749990f7154249a3890514a43687a85e6b6cc82)



## Code Block

### inline code block

백킷 (`) 을 활용해서 인라인 코드 작성 가능

글1, 글2, 글3, `코드1`



### code block

일반적으로 코드를 복사하면 indent가 나오지 않음

**public** **class** Main {  **public** **static** **void** main(String[] args) {    System. ***out\***.println("Hello World" );  }}



백킷 (`)을 3번 누르고 java를 치면

```java
class sample{
    public static void main(String args[]){
        System.out.println("Hello World");
    }
}
// 주석도 이렇게 가능
```



## Table

열을 구분하기 위해 `|`를 이용해서 표기
3열인 경우 세로선은 4개가 필요하므로 `| | | |`와 같이 입력하고 엔터

|  1   |  2   |  3   |
| :--: | :--: | :--: |
|      |      |      |
|      |      |      |



# git

## git 시작하기

`git init` : git 시작하기, 해당 폴더를 git으로 관리

