## Spring MVC Security Project
### 2020-04-08

### 개요
* Spring MVC 기반 Security Coding
* Security 기능을 포함한 WebSockete Coding
* React 기반 Front-End 기능 Coding

* JDBC, MyBatis 연동
* MySQL DB 연동
* Transaction 설정

* 회원가입 E-mail 인증
* 비밀번호 분실 E-mail 인증 후 재 설정

### Spring Security Dependency
* spring seucurity 설정
* spring-security-core
* spring-security-web
* spring-security-config
* spring-seurity-taglibs

* jasypt
* jasypt-spring31

### DB Dependency(MySQL, Mybatis 연동)
* mysql-connector-java
- MySQL과 Java를 연결 해주는데 사용하는 DB Driver 

* commons-dbcp2
- JDBC와 Driver 사이에서 DB Connection Pool을 만들고, Connection, DiConnection 을 수행해주는 보조 Class

* spring-jdbc
- Java(Spring)와 DB Driver 사이에서 명령어, 데이터를 변환 시켜주는 보조 Class

* mybatis
- spring-jdbc와 DB Driver 사이에서 Mybatis Mapper 등으로 작성된 SQL을 변환하고, 데이터를 VO에 쉽게 매핑시키는 용도의 Class

* mybatis-spring
- spring-jdbc와 mybatis 엔진사이에서 서로 잘 맞지않는 부분을 잘 조정하여 버전에 관계없이 연동이 쉽도록 만들어주는 보조 Class

## Security와 관련 용어

#### 접근주체(principal)
* 보호된 대상에 접근하는 유저(User)

#### 인증(Authenticate)
* 접근하는 유저가 누구인지 확인(로그인 절차)

#### 인가(Autherize)
* 접근한 유저가 어떤 서비스, 어떤 페이지에 접근할 수 있는 권한이 있는가 확인

#### 권한(Role)
* 인증(Authenticate)된 주제(User)가 어떤 페이지, 기능, 서비스에 접근할 수 있는 권한이 있다 는 것을 보증,증명

#### 무결성,보안
* 무결성 : 인가된 사용자에 의해 손상될 수 있는 것들
* 보안 : 인가되지 않은 사용자에 의해 손상될 수 있는 것들

## Spring Security
* Filter를 사용하여 접근하는 사용자의 인증절차와 인가를 통해 권한이 있는가를 파악하고, 적절한 조치(되돌리기, Redirect, 사용가능)
   를 비교적 적은 코드 양으로 처리할 수 있도록 만든 framework
   
* sprint security는 세션과 쿠키방식을 병행하여 사용한다.

### 유저가 로그인을 시도하면
1. Authentication Filter에서 부터 users table까지 접근하여 사용자 정보를 인증하는 절차를 거친다.

2. 인증이 되면 user table, user detail table에서 사용자 정보를 fetch(select)하여 session에 저장 

3. 일반적인 HttpSession은 서버의 활동 영역 메모리에 session을 저장하는데 비해 Spring Security는 SecurityContextHolder 라는 메모리에 저장

4. view로 유저 정보가 담긴 session을 session ID와 함께 응답으로 전달
* JSESSIONID 라는 쿠키에 session ID를 담아서 보내고

5. 이후에 유저가 접근을 하면 JSESSIONID에서 쿠키를 추출하여 사용자 인증을 시도한다.
*	?JESSIONID=asdfasdfa 이러한 값이 URL 뒤에 따라 붙기도 한다.

6.JESSIONID에서 추출한 session ID가 유효하면 접근 request에게 Authentication을 부착한다.






		