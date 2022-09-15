# Chapter 01 프로젝트 준비

###  ✅ 스프링이란?
+ 자바 엔터프라이즈 애플리케이션 개발에 사용되는 애플리케이션 프레임워크이다.
<br>

```
애플리케이션 프레임워크 
--> 애플리케이션 개발이 빠르고 효율적으로 할 수 있도록 애플리케이션 바탕이
되는 틀과 공통 프로그래밍 모델, 기술 API 등을 제공하는 역할 
```
![spring_architect.png](./img/spring_architect.png)

### 스프링 핵심 3가지
1. #### Ioc/DI
   + 스프링은 유연하고 확장성이 뛰어난 코드를 만들수 있게 도와주는 객체 지향 설계 원칙과 디자인 패턴의 핵심 원리를 담고 있는 Ioc/DI 프레임워크 근간으로 삼고 있다.
   + 스프링이 직접 제공하는 모든 기술과 API 심지어 컨테이너도 Ioc/DI 방식으로 작성되어 있다.
   <br> ==> 스프링을 효율적으로 사용하려면 Ioc/DI 방식을 제대로 이해해야 한다.
2. #### 서비스 추상화
3. #### AOP 
    + IoC / DI 오브젝트 생명주기와 의존관계에 대한 프로그래밍 모델 <br>


###  ✅ 스프링부트란?
+ 사용자(개발자) 가 복잡한 스프링 설정을 조금 더 쉽고 간단하게 프로젝트를 만들 수 있도록 도와주는 도구

###  ✅ 스프링 부트 실행 시 배너 커스텀 방법
+  스프링 부트를 실행할때 별도의 banner.txt 없으면 스프링에 제공하는 기본 배너가 출력된다.
![springBootDefaultBanner.png](./img/springBoot_default_banner.png)

+ resources 폴더 하위에 banner.txt 파일 추가 <br>
![banner_location.png](./img/banner_location.png)
![banner_txt.png](./img/banner_txt.png)
![banner_output.png](./img/banner_output.png)

### ✅ 프로젝트 실행 에러
+ 책에서 프로젝트 실행 에러 발생시 대부분 Gradle 환경 설정 문제 또는 Tomcat 포트 충돌이라고 소개하고 있다.
+ gradle 환결성정 문제는 개발 환경 컴퓨터 이름이 한글이 들어갈 경우 주로 윈도우에서 많이 발생하는거 같다.
+ 포트 충돌같은 경우 실행 이전에 애플리케이션 정상적으로 종료하지 못했거나 아직 실행중인 상태에서 한번 더 어플리케이션을 실행 할 경우 발생한다.
<br> 해결 방법은 이미 사용중인 8080 포트 서비스를 종료하거나 실행할 어플리케이션 포트를 바꿔 실행하면 된다. <br>
![server_port.png](./img/server_port.png)
![server_port_output.png](./img/server_port_output.png)

### ✅ 테스트 코드 작성
+ spring initializr 를 통해 프로젝트를 생성했으면 별도의 설정 없이 사용이 가능
+ 테스트는 @Test 어노테이션이 선언된 메소드에서 확인이 가능

### ✅ JUnit 
 #### --> Junit 설명에 앞서 유닛 테스트를 알아보자
+ 유닛 테스트는 프로그래밍에서 모든 함수와 메소드에 대한 테스트 케이스를 작성하여 개발자가 의도된 대로 잘 동작하는지 검증하는 절차
 #### --> 유닛테스트를 통해 얻을 수 있는 이점 
+ 프로그램을 작은 단위로 나눠서 테스트 하므로써 안정성을 높음
+ System.out.println 으로 하는 디버깅이 필요없으며 개발 시간을 단축
 #### --> Junit
+ 자바 프로그래밍 언어용 유닛 테스트 프레임워크

### ✅ 테스트 환경에서 Lombok 적용하기
![gradle.png](./img/gradle.png)
![test_code.png](./img/test_code.png)
![test_code_result.png](./img/test_code_result.png)

### ✅ 간단한 컨트롤러 실습 - RESTful API 

#### RESTful API 란 ??
+ 두 컴퓨터 시스템이 인터넷을 통해 정보를 안전하게 교환하기 위해 사용하는 인터페이스
+ 애플리케이션 프로그래밍 인터페이스(API)는 다른 소프트웨어 시스템과 통신하기 위해 따라야 하는 규칙을 정의함

#### RESTful API 이점
+ 확장성
  + REST API 를 구현하는 시스템은 REST 가 클라이언트 - 서버 상호 작용을 최적화하기 때문에 효울적으로 크기 조정할 수 있음
+ 유연성
  + RESTful 웹 서비스는 완전한 클라이언트 - 서버 분리를 지원 각 부분이 독립적으로 발전할 수 있도록 다양한 서버 구성 요소를 단순화하고 분리하여 유연성을 향상 시킴
+ 독립성
  + API 설계에 영향을 주지 않고 다양한 프로그래밍 언어로 클라이언트 및 서버 애플리케이션 작성이 가능함

#### @RestController
+ 스프링프레임워크 4.x 버전 이상부터 사용이 가능한 어노테이션이며 @Controller @ResponseBody 가 결합된 어노테이션
+ @ResponseBody 어노테이션을 붙이지 않아도 문자열과 Json 등을 전송할 수 있음

#### GetMapping
+ HTTP GET 요청을 특정 핸들러 메소드에 맵핑하기 위한 어노테이션

### ✅ 스프링 부트 애플리케이션 Jar 파일 만들기
+ tasks > build > bootJar 를 실행하여 Jar 파일이 생성됨
+ java -jar [파일명] 명령어를 실행하여 애플리케이션 실행  