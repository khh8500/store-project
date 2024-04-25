# final project 1단계 - 상품 판매 사이트


## 프로그램 기능

+ 상품 목록보기
+ 상품 상세보기
+ 상품 등록하기
+ 상품 수정하기
+ 상품 삭제하기


## 기술스택

+ JDK 21
+ Springboot 3.2.3
+ HTML
+ JAVAScript
+ Bootstrap


## 의존성

+ Lombok
+ Spring Boot DevTools
+ Spring WEB
+ Spring Data JPA
+ MySQL
+ Mustache

## mySQL 데이터 연동하기

+ MySQL 세팅

![MySQL설정](https://github.com/khh8500/store-project/assets/153582359/1d90f316-b1fc-4ab6-b430-fc1a26904cbc)

![유저 생성, 권한 부여, DB생성](https://github.com/khh8500/store-project/assets/153582359/4fe4d1b3-39a6-4c78-85c0-6ce4b88426b7)


+ Spring build

```
implementation 'mysql:mysql-connector-java:8.0.28'
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
```

+ yml 설정

```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/store?serverTimezone=UTC&characterEncoding=utf-8
    username: root
    password: 1234
```  

## request객체에 DTO담기

+ DTO(Data Transfer Object)로 담으면 좋은 점

1. 엔티티 내부 구현을 캡슐화로 보안 강화
2. 데이터 의미와 용도가 명확히 파악할 수 있어 유지보수성 향상 ex)DTO필드 이름
3. 레이어 간 결합도 감소로 유연성 향상
4. 클라이언트에게 전달되는 데이터 양을 최적화되어 성능 향상
5. 업데이트할 때 기존 데이터 구조를 변경하지 않고 새로운 기능을 추가하거나 기존 기능을 수정할 수 있어 버전 관리와 호환성 유지가 용이

+ ResponseDTO 생성

```
public class ProductResponse {

    @Data
    public static class DetailDTO {
        private String name;
        private Integer price;
        private Integer qty;
        private Integer id;

        public DetailDTO(Product product){
            this.name = product.getName();
            this.price = product.getPrice();
            this.qty = product.getQty();
            this.id = product.getId();
        }
    }

    @Data
    public static class UpdateDTO {
        private String name;
        private Integer price;
        private Integer qty;
        private Integer id;

        public UpdateDTO(Product product){
            this.name = product.getName();
            this.price = product.getPrice();
            this.qty = product.getQty();
            this.id = product.getId();
        }
    }

    @Data
    public static class ListDTO {
        private String name;
        private Integer price;
        private Integer qty;
        private Integer id;

        public ListDTO(Product product) {
            this.name = product.getName();
            this.price = product.getPrice();
            this.qty = product.getQty();
            this.id = product.getId();
        }
    }

}
```
