# 프로젝트 구조 만들기

---

### ✅ 4.1 프로젝트 와이어프레임
+ 프로젝트를 구성할 때 가장 먼저 와이어프레임(화면 설계서)을 제작하고 진행하는것이 좋다.
+ 와이어프레임을 제작하면 화면의 URI와 전달되는 파라미터 등을 미리 결정할 수 있고, 데이터베이스 설계에 필요한 컬럼들을 미리
파악하는데도 도움이 된다.

### 🔻 API 정의
| 기능      | URL                 | GET/POST | 기능 설명      | RedirectURL   |
|---------|---------------------|----------|------------|---------------|
| 목록      | /guestbook/list     | GET      | 목록/페이징/검색  |               |
| 등록      | /guestbook/register | GET      | 입력 화면      | |
|         | /guestbook/register | POST     | 등록처리       | /guestbook/list|
| 조회      | /guestbook/read | GET | 조회화면 | |
|수정 | /guestbook/modify | GET | 수정/삭제 가능 화면 |  |
| | /guestbook/modify | POST | 수정처리 | /guestbook/read|
|삭제 | /guestbook/remove | POST | 삭제처리 | /guestbook/list|

### 🔻 프로젝트 구조
![img_01.png](./img/img_01.png)
1. 브라우저에서 들어오는 Request는 GuestbookController라는 객체로 처리
2. GuestbookController는 GuestbookService 타입을 주입받는 구조로 만들고, 이를 이용해서 원하는 작업을 처리
3. GuestbookRepository는 Spring Data JPA를 이용해서 구성하고, GuestbookServiceImpl 클래스에 주입해서 사용
4. 마지막 결과는 Thymeleaf를 이용해서 레이아웃 템플릿을 활용해서 처리

![img_02.png](./img/img_02.png)

5. 브라우저에서 잔달되는 Request는 GuestbookController에서 DTO의 형태로 처리
6. GuestbookRepository는 엔티티 타입을 이용하므로 중간에 Service 계층에서는 DTO의 엔티티의 변환을 처리

### 🔻 프로젝트 라이브러리
+ Spring Boot DevTools
+ Spring Data JPA
+ Spring Web
+ Lombok
+ Thymeleaf

### 🔻 H2 데이터 베이스 설치
공식홈페이지 접속하여 사용하고자 하는 OS 버전 h2 데이터베이스 zip 파일을 다운받는다.
https://www.h2database.com/html/main.html
(필자는 Mac 으로 진행)
![img_03.png](./img/img_03.png)
+ 압축해제 후 해당 폴더에 접근
+ ./bin/h2.sh 명령어를 사용해 h2 데이터베이스 서버 실행
+ localhost:8082 로 접속하면 h2 웹 콘솔로 진입이 가능하다.

![img_04.png](./img/img_04.png)
+ ```최초 사용시 데이터 베이스를 만들어야 한다.```
+ jdbc:h2:~/workspace/h2/testdb --> 필자는 홈 다운받았던 h2 디렉토리 안에 testdb를 생성

![img_05.png](./img/img_05.png)
+ 생성 후 해당 디렉토리에서 다시 조회하면 testdb.mv.db 파일이 생성되며 이안에 h2 데이터 베이스 정보가 담겨져 있다.

### 🔻 Spring Boot + h2 연결

#### Gradle 에 h2 드라이버 추가
``` groovy
implementation 'com.h2database:h2'
```
#### application.yaml 파일에 config 추가
```
spring:
  datasource:
    url: jdbc:h2:tcp://localhost/~/workspace/h2/testdb
    username: sa
    password:
    driver-class-name: org.h2.Driver
```

