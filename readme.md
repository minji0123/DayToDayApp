# DayToDayApp

**DayToDayApp with** 
- Spring Boot 
- CRUD pattern
- REST API
- h2

# Database (h2)

데이터베이스로 h2 를 사용했습니다.

<img src="img/db.png" width="200px">

현재 들어있는 데이터 기본값입니다.


<br />


# View
## main page
<br />

<img src="img/main.png" width="300px">

기본적인 CRUD 패턴과 REST api 를 구현하기 위해    
view 페이지를 하나로 표현했습니다.


<hr />

## create

<img src="img/create1.png" width="300px">
<img src="img/create2.png" width="300px">

할 일을 입력하고 확인 버튼을 누르면   
새로운 할 일이 등록됩니다.

<br />
<img src="img/create3.png" width="300px">

h2 db 와 연동되어 데이터가 바로 적용됩니다.

<hr />

## update

<img src="img/update1.png" width="300px">
<img src="img/update2.png" width="300px">

할 일을 입력하고 수정 버튼(연필모양) 을 누르면   
할 일이 수정됩니다.

<br />
<img src="img/update3.png" width="200px">

h2 db 와 연동되어 데이터가 바로 적용됩니다.

<hr />

## delete

<img src="img/delete1.png" width="300px">

삭제 버튼을 누르면 별도의 알람 없이   
바로 삭제됩니다.

<br />
<img src="img/delete2.png" width="200px">

h2 db 와 연동되어 데이터가 바로 적용됩니다.


<hr />

## check box

<img src="img/check.gif" width="300px">

체크박스를 누르면 할 일을 완료할 수 있습니다.

<br />
<img src="img/check.png" width="200px">

h2 db 와 연동되어 데이터가 바로 적용됩니다.   
이때, check box (컬럼COMPLETE) 는 boolean 값입니다.

# Reference
https://codepen.io/shshaw/pen/WXMdwE