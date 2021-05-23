# PlayGround

## Introduction
스스로 공부하면서 이것 저것 구현해보는 놀이터
 
## Development Environment

- Window 10
- Intellij IDEA Ultimate 2021.1
- Java 1.8.0.275
- Spring Boot 2.4.5
- Gradle 6.8.3
- H2, Postgresql(docker), Jpa
- Git

## Project Structure
2021-05-23 기준
```
src
 L main
     L java
        L com.osj4532.playground
                L aop                           --- AOP 패키지
                L config                        --- 설정 패키지
                L controller                    --- 컨트롤러 패키지
                L domain                        --- Entity 패키지
                L dto                           --- DTO 패키지
                L service                       --- 서비스 패키지
                L utils                         --- 유틸 패키지
     L resources
 L test
```
## Postgresql이 아닌 H2 접근 시
application.yml 파일에 ```spring.profiles.active``` 속성에 ```h2``` 추가

## Postgresql에 접근 시

application-000.yml(현재 프로젝트 기준 application-local.yml)을 생성하고 아래 설정을 추가해 준다.
```
spring.db.datasource.postgres.username=<자신의 Postgresql DB username>
spring.db.datasource.postgres.password=<자신의 Postgresql DB user password>
```

## Documentation
- DB
    - [H2](./docs/db/H2.md)
- Development
    - [DevTools](./docs/springboot/DevTools.md)
- Documentation
    - [OAS(OpenApi Specification)](docs/OAS.md)
- Log
    - [Logback](./docs/Logback.md)
- Test
    - [TDD & Junit](./docs/TDD.md)
