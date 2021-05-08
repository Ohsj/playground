# PlayGround

## Introduction
스스로 공부하면서 이것 저것 구현해보는 놀이터
 
## Development Environment

- Window 10
- Intellij IDEA Ultimate 2021.1
- Java 1.8.0.275
- Spring Boot 2.4.5
- Gradle 6.8.3
- H2, Jpa
- Git

## Project Structure
2021-04-17 기준
```
src
 L main
     L java
        L com.osj4532.playground
                L config                        --- 설정 패키지
                L controller                    --- 컨트롤러 패키지
                L domain                        --- Entity 패키지
                L dto                           --- DTO 패키지
                L service                       --- 서비스 패키지
     L resources
 L test
```

## Documentation
- [Logback](./docs/Logback.md)
- [OAS(OpenApi Specification)](docs/OAS.md)
- [TDD](./docs/TDD.md)