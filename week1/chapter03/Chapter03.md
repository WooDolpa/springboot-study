# Chapter 03 스프링 MVC 와 Thymeleaf

###  ✅ 템플릿 엔진이란?
+ 지정된 템플릿 양식과 데이터가 합쳐져 HTML 문서를 출력하는 소프르트웨어를 말함
```
지정된 템플릿 양식
--> 웹 사이트의 화면을 어떤 형태로 만들지 도와주는 양식이라고 이해하면 됨
서버 탬플릿 엔진 : JSP, FreeMarker, Mustache
클라이언트 템플릿 엔진 : React, Vue, Angular 
```

### ✅ Thymeleaf
#### 여러 서버 템플릿 엔진 중에 책에서는 타임리프(Thymeleaf) 를 선택했고 다음과 같은 이유를 설명한다.
+ JSP 와 유사하게 ${}을 별도의 처리 없이 이용 가능
+ Model에 담긴 객체를 화면에서 JavaScript로 처리하기 편리
+ 연산이나 포맷과 관련된 기능을 추가적인 개발 없이 지원
+ 개발 도구를 이용할때 .html 파일로 생성하는데 문제가 없고 별도의 확장자를 이용하지 않음

### ✅ Thymeleaf Cache 처리
#### Thymeleaf를 이용하는 프로젝트는 변경 후 만들어진 결과를 보관(캐싱)하지 않도록 설정하는것이 편리 
```
spring.thymeleaf.cache=false
```
+ Thymeleaf 역시 JSP처럼 서버에서 결과를 만들어 브라우저 전송함 
+ 위의 설정을 통해 결과물을 서버에서 계속 가지고 있을건지에 대한 유무 설정
+ Thymeleaf 파일을 수정하고 저장한 후에 브라우저에서 변경된 결과를 확인하기 위한 설정

### ✅ 예제 설명
#### html 태그 내에 xmlns 속성에 thymeleaf 와 관련된 속성값이 지정된 부분 <br> 인텔리제이 Ultimate 버전에서는 thymeleaf 관련 플러그인이 기본으로 설치되어 있으므로 별도 설정이 필요없지만 <br> xmlns 속성을 지정함에 따라 코드 완성을 도와주는 이점이 있음

#### 기본적인 사용 방법은 속성 앞에 'th:' 를 붙여주고 속성값을 지정 <br> JSP 와 달리 별도의 태그를 이용하지 않고 HTML을 그대로 유지하면서 개발할 수 있다.
#### JSP는 별도의 <% %> 등을 이용해서 블록을 설정하는 등 기존 HTML 훼손이 많았지만 Thymeleaf 는 HTML은 그대로 두고 필요한 동작이나 값을 추가하는 방식

```
Lombok 의 @Data
Getter/Setter, toString(), equals(), hashCode()를 자동으로 생성해주는 어노테이션
```

#### thymeleaf에서의 반복은 th:each 라는 속성을 이용함
```
th:each = "변수 : ${목록} "
```
``` html
<ul>
    <li th:each="dto : ${list}">
        [[${dto}]]
    </li>
</ul>
```
#### 부가적으로 사용할 수 있는 상태(state) 객체가 있는데 순번이나 인덱스 번호, 홀수/짝수등을 지정할 수 있음
``` html
<!-- 반복문 -->
    <ul>
        <li th:each="dto, state : ${list}">
            [[${state.index}]] --- [[${dto}]]
        </li>
    </ul>
```
```
index : 0부터 시작하는 반복 인덱스
count : 1부터 시작하는 반복 인덱스
size : 총 수
current : 현재 요소 
even : 짝수 여부 (boolean)
odd : 홀수 여부 (boolean)
first : 첫번째인지 여부 (boolean)
last : 마지막인지 여부 (boolean) 
```

#### 제어문 처리
```
th:if ~ unless 사용 삼항연산자 스타일을 사용할 수 있음
```
``` html
<!-- 제어문 -->
    <ul>
        <li th:each="dto, state : ${list}" th:if="${dto.sno % 5 == 0}">
            [[${dto}]]
        </li>
    </ul>
```
``` html
    <ul>
        <li th:each="dto, state : ${list}">
            <span th:if="${dto.sno % 5 == 0}" th:text="${'----------' + dto.sno}"></span>
            <span th:unless="${dto.sno % 5 == 0}" th:text="${dto.first}"></span>
        </li>
    </ul>
```
#### thymeleaf는 삼항연산자를 사용할 수 있는데 2개의 항만 처리할 수 있음 
``` html
    <ul>
        <li th:each="dto, state : ${list}" th:text="${dto.sno % 5 == 0}?${dto.sno}:${dto.first}">
        </li>
    </ul>
```
#### th:class 를 사용하면 class 속성을 조작 가능 

#### inline 속성 - 예제 참고
+ thymeleaf 여러 속성중 개발에 많이 도움되는 기능이 inline 속성
+ 주로 자바스크립트 처리에서 유용

#### th:block
+ 별도의 태그가 필요하지 않기 때문에 반드시 태그에 붙어서 th:text나 th:value 등을 써야하는 제약이 없음
+ html 로 처리되지 않기 때문에 루프 등을 별도로 처리할때 많이 사용
``` html
    <ul>
        <th:block th:each="dto : ${list}">
            <li th:text="${dto.sno % 5 == 0}?${dto.sno}:${dto.first}"></li>
        </th:block>
    </ul>
```
#### 링크 처리
+ thymeleaf 링크는 '@{}'를 이용해서 사용
+ 파라미터를 전달해야 할 상황에서 좀 더 가독성 좋은 코드를 만들수 있음
``` html
    <li th:each="dto : ${list}">
        <a th:href="@{/sample/exView}">[[${dto}]]</a>
    </li>
```
#### 파라미터 추가 방법
+ key=value로 추가
``` html
    <li th:each="dto : ${list}">
        <a th:href="@{/sample/exView(sno=${dto.sno})}">[[${dto}]]</a>
    </li>
```
#### path로 이용하고 싶으면 다음과 같다.
``` html
    <li th:each="dto : ${list}">
        <a th:href="@{/sample/exView/{sno}(sno=${dto.sno})}">[[${dto}]]</a>
    </li>
```

#### thymeleaf의 기본 객체와 LocalDateTime
+ thymeleaf에는 내부적으로 여러 종류의 기본 객체라는 것을 지원
+ 기본 객체는 문자나 숫자, 웹에서 사용되는 파라미터, request, response, session 등 다양한 객체를 사용해 편하게 코드작성을 할수 있음
+ #numbers 나 #dates 등을 별도의 설정 없이 사용함
``` html
    <li th:each="dto : ${list}">
        [[${#numbers.formatInteger(dto.sno, 5)}]]
    </li>
```
#### --> sno를 모두 5자리를 만듬

```
Java 8버전부터 등장한 LocalDate 타입이나 LocalDateTime에 대해서 상당히 복잡한 방식으로 처리해야함
좀 더 편리하게 처리하기 위해 오픈소스 추가
```
``` 
implementation 'org.thymeleaf.extras:thymeleaf-extras-java8time'
```
``` html
    <ul>
        <li th:each="dto : ${list}">
            [[${dto.sno}]] --- [[${#temporals.format(dto.regTime, 'yyyy/MM/dd')}]]
        </li>
    </ul>
```

#### thymeleaf의 레이아웃
--> thymeleaf의 레이아웃 기능은 크게 2가지 형태로 사용함

