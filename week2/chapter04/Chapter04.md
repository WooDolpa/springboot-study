# 프로젝트 구조 만들기

---

### ✅ 4.1 프로젝트 와이어프레임
+ 프로젝트를 구성할 때 가장 먼저 와이어프레임(화면 설계서)을 제작하고 진행하는것이 좋다.
+ 와이어프레임을 제작하면 화면의 URI와 전달되는 파라미터 등을 미리 결정할 수 있고, 데이터베이스 설계에 필요한 컬럼들을 미리
파악하는데도 도움이 된다.

#### API 정의
| 기능      | URL                 | GET/POST | 기능 설명      | RedirectURL   |
|---------|---------------------|----------|------------|---------------|
| 목록      | /guestbook/list     | GET      | 목록/페이징/검색  |               |
| 등록      | /guestbook/register | GET      | 입력 화면      | |
|         | /guestbook/register | POST     | 등록처리       | /guestbook/list|
| 조회      | /guestbook/read | GET | 조회화면 | |
|수정 | /guestbook/modify | GET | 수정/삭제 가능 화면 |  |
| | /guestbook/modify | POST | 수정처리 | /guestbook/read|
|삭제 | /guestbook/remove | POST | 삭제처리 | /guestbook/list|

