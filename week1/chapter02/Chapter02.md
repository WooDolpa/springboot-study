# Chapter 02 
```
책 예제대로 최초 프로젝트 구성 후 프로젝트 실행시 다음과 같은 에러가 발생

Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.

datasource 관련된 url 설정과 관련된 에러이다.
Spring Data JPA 라이브러리가 추가되었기 때문에 자동으로 이에 관련된 설정을 넣어줘야 한다. 
```
###  ✅ H2
+ 인메모리 관계형 데이터베이스
+ 별도의 설치가 필요 없이 프로젝트 의존성만으로 관리 가능
+ 메모리에서 실행되기 때문에 애플리케이션을 재시작할 때마다 초기화된다는 점을 이용해 테스트 용도로 많이 사용
+ 책에서는 MariaDB 로 테스트하지만 다른 데이터베이스로 변경 가능

###  ✅ Spring Data JPA 소개
+ JPA(Java Persistence API)는 자바 언어를 통해서 데이터베이스와 같은 영속 계층을 처리하고자 하는 스펙
+ JPA를 이해하기 위해서는 ORM을 알아야한다.

###  ✅ ORM(Object-Relational-Mapping)
```
이름 그대로 객체와 관계형 데이터베이스를 매핑한다는 뜻
ORM 프레임워크는 객체와 테이블을 매핑해서 패러다임의 불일치 문제를 개발자 대신 해결
ORM 프레임워크를 사용하면 객체를 DB에 저장할때 Insert SQL을 직접 작성하는게 아니라 
객체를 마치 자바 컬렉션에 저장하듯이 ORM 프레임워크에 저장하면 된다.
```