# **markdown 문법필기**

## **heading 대주제**

백킷 (`) 을 활용해서 인라인 코드 작성 가능

h1 `#`          html에서는 <h1>내용</h1>

h2 `##`

h3 `###`

h4 `####`

h5 `#####`

h6 `######`

`ctrl + 숫자`하면 자동으로 heading 번호로 바꿀 수 있음

## **list**

### **unordered list (순서가 없는 리스트)**

- `` 이나 `/`을 이용해서 리스트로 만들 수 있음
- 이렇게
  - 탭으로
    - 하나씩도
      - 가능

html에서는 <ul>내용</ul>

### **ordered list (순서가 있는 리스트)**

`1.`등을 이용해서 리스트로 만들 수 있음

1. 이렇게
2. 만듦
   1. 탭으로
      1. 하나씩도
         1. 가능

html에서는 <ol>내용</ol>

## **text style**

### **bold**

- `*`로 표현 가능 (`* 내용 **` ) 아니면 `ctrl + b`로도 가능

**안녕하세요**

### **italic**

- ``로 표현 가능 (`내용 *`) 아니면 `ctrl + i`로도 가능

*안녕하세요*

***세개하면이렇게됨***

## **hyperlink**

### **link**

```
[링크가 표시될 내용](내가 가고 싶은 url)
```

[구글](https://www.google.com/)

### **image**

```
![대체 텍스트](내가 보여주고 싶은 이미지 url)
```

# **markdown 문법필기**

## **heading 대주제**

백킷 (`) 을 활용해서 인라인 코드 작성 가능

h1 `#`          html에서는 <h1>내용</h1>

h2 `##`

h3 `###`

h4 `####`

h5 `#####`

h6 `######`

`ctrl + 숫자`하면 자동으로 heading 번호로 바꿀 수 있음

## **list**

### **unordered list (순서가 없는 리스트)**

- `` 이나 `/`을 이용해서 리스트로 만들 수 있음
- 이렇게
  - 탭으로
    - 하나씩도
      - 가능

html에서는 <ul>내용</ul>

### **ordered list (순서가 있는 리스트)**

`1.`등을 이용해서 리스트로 만들 수 있음

1. 이렇게
2. 만듦
   1. 탭으로
      1. 하나씩도
         1. 가능

html에서는 <ol>내용</ol>

## **text style**

### **bold**

- `*`로 표현 가능 (`* 내용 **` ) 아니면 `ctrl + b`로도 가능

**안녕하세요**

### **italic**

- ``로 표현 가능 (`내용 *`) 아니면 `ctrl + i`로도 가능

*안녕하세요*

***세개하면이렇게됨***

## **hyperlink**

### **link**

```
[링크가 표시될 내용](내가 가고 싶은 url)
```

[구글](https://www.google.com/)

### **image**

```
![대체 텍스트](내가 보여주고 싶은 이미지 url)
```

https://item.kakaocdn.net/do/862539f7f2171437385154b3b749990f7154249a3890514a43687a85e6b6cc82

## **Code Block**

### **inline code block**

백킷 (`) 을 활용해서 인라인 코드 작성 가능

글1, 글2, 글3, `코드1`

### **code block**

일반적으로 코드를 복사하면 indent가 나오지 않음

**public** **class** Main {  **public** **static** **void** main(String[] args) {    System. ***out***.println("Hello World" );  }}

백킷 (`)을 3번 누르고 java를 치면

```
class sample{
    public static void main(String args[]){
        System.out.println("Hello World");
    }
}
// 주석도 이렇게 가능
```

## **Table**

열을 구분하기 위해 `|`를 이용해서 표기 3열인 경우 세로선은 4개가 필요하므로 `| | | |`와 같이 입력하고 엔터

# **git**

## **git 시작하기 ( 계정 설정시 최초 1회 )**

`git config --global user.email '[github 이메일 주소]'` : 내 로컬 컴퓨터 전역에 github email 설정

`git config --global user.name '[github 유저 이름]'` : 내 로컬 컴퓨터 전역에 github username 설정

`git config --global user.email | git config --global user.name`  : 잘 되었는지 확인

## **git 시작하기 ( 프로젝트 만들때 최초 1회 )**

`git init` : git 시작하기, 해당 폴더를 git으로 관리

`git remote add origin [github repo 주소]` : remote 등록, repository 이름 등록

- origin : github와 local사이 branch의 별명
- remote :

`git remote -v` :  잘 되었는지 확인

## **git 명령어**

`git status` : git으로 관리되고 있는 폴더의 현황 조회

`git add` : git에게 tracking을 요청 ( staging area 단계로 올리려고 )

- git add [파일이름.확장자] : 하나만
- git add [파일이름.확장자] [파일이름2.확장자] : 쓴 것 만큼
  - 띄어쓰기가 포함된 파일인 경우 `' '`로 감싸서 씀
- git add . : 전부

`git commit -m '[커밋 메세지]'` : staging area의 올린 컨텐츠에 커밋 메세지 남기기

- 보통 명령조로 작성 ( creating a file , 파일 생성 )

`git push origin master` : github에 파일 모두 올리기

- master : github와 local사이 branch의 진짜 이름

`git pull origin master` : github 내려받기

- 폴더 생성
- 폴더에 들어가서 git init
- 폴더 안에서 git remote

`git clone [나의 github repo 주소]` : 폴더를 만들지 않고 바로 내려받기

- 폴더를 만들지 않고도 바로 내려받기
- A가 A꺼 clone 받기 : add commit push
- B가 A꺼 clone 받기 : pull request ←  B의 코드를 A의 레포에 반영하고 싶을때
