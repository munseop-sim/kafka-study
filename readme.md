## 아키텍처
- 헥사고날
- adapter
  - in
  - out
- 


## 프로젝트 구조
1. kafka-common 
- DB Access, Producer, 로직 요청 처리
- `kafka-web-application`, `kafka-consumer` 에서 사용
2. kafka-web-application
- `request`요청 처리
3. kafka-consumer 
- `kafka consumer`요청처리