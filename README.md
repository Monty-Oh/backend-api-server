# 토이프로젝트 #1
In-Memory 프로젝트

---
## Getting Started
깃허브 주소: https://github.com/Monty-Oh/inmemory  
HTTPS clone URL: https://github.com/Monty-Oh/inmemory.git

---
## Local 개발 환경 구성
### Docker 사용 시
```
1. Docker 설치

2. Gradle 에서 :build setup:buildLocalSetup 실행
    - src/main/resources/db/docker-compose.yaml 직접 실행 가능

3. Docker 에 DB 컨테이너 확인

4. DB 접속 확인
    - application.yaml local 프로필 DB 정보 참고

5. Application 실행
```

### 로컬 DB 사용 시
```
1. MySQL 8.0 설치

2. 다음 위치 SQL 문 실행
    - src/main/resources/db/database/schema_initialisation.sql

3. DB 접속 확인
    - application.yaml local 프로필 DB 정보 참고

4. Application 실행
```

## 깃 브랜치 전략
```
1. feature 아래 브랜치 생성 후 개발 작업

2. develop 으로 Pull Request 생성

3. 깃허브 리포지토리 Actions 탭에서 Build & Test 확인

4. Actions 성공 후 merge

5. 깃허브 리포지토리 Actions 탭에서 Build & Deploy 확인
```

---