Spring Cloud LoadBalancer -> user   
MSA -> say-hello

- 같은 서비스를 여러 인스턴스로 분리했을 때 설정해주는 방식에 따라 리퀘스트가 분산됨

- 대신에 서버 도메인이나 포트를 하드코딩해서 넣어줘야하기 때문에 동적바인딩을 위해 eureka 서버를 추가하는 것을 권장
