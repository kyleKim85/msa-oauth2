Security for Microservices
==========================
#Target
* API Service를 제공하는 **Microservices Architecture**를 Spring Framework를 통해 구현
    * Spring version : Greanwich
    * Spring Cloud Netfilx 사용
      * Eureka : Service Discovery
      * Zuul : Router and Filter


* **OAuath 2.0**을 이용한 접근권한 인증
    * Authorization Code Grant 방식으로 인증
    * JWT 사용

![screenshot](./screenshot/target.png)


#Project Structure
* service-registry
    * Eureka Server
    * Service Discovery를 제공


* gateway
    * Zuul을 이용하여 Routing
    * Spring Security를 이용하여 Resource 접근 권한 인가


* oauth2-server
    * Spring Security에서 제공하는 Login 화면을 통한 인증
    * Authorization Code Grant 방식으로 Access Token 발급
    
    
* api-service
    * 테스트용으로 Admin, User, Guest api를 하나의 api-service에서 제공
    
 
    
#Test
### Microservices - Eureka server 구동 확인
![screenshot](./screenshot/eureka_server.png)


### OAuth 2.0 login
![screenshot](./screenshot/fiddler.png)

1. Access Token을 받기 전에 /api/getUserInfo 요청하지만 401 Error
2. /uaa/oauth/authorize 호출
3. 인증되지 않은 사용자의 요청이므로 /uaa/login 으로 302 redirect

![screenshot](./screenshot/login1.png)

![screenshot](./screenshot/login2.png)

4. Resource Owner가 인증을 완료하면 /uaa/oauth/authorize 로 302 redirect
5. Authorization code를 response의 파라미터로 전달
6. 획득한 authorization code로 /uaa/oauth/token 호출해서 Access Token을 획득
7. Access Token을 이용해 /api/getUserInfo 요청하여 200 성공