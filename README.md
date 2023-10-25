# 명언 프로그램

멋쟁이사자들처럼 7기 백엔드 과제입니다.

다음 요구사항을 가지고 있습니다.

### 1단계
```shell
종료
== 명언 앱 ==
명령) 종료
```

### 2단계
```shell
등록
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
명령) 종료
```

### 3단계
등록시 생성된 명언번호 노출
```shell
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 종료
```

### 4단계
등록할때 마다 생성되는 명언번호가 증가
```shell
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 종료
```

### 5단계
목록
```shell
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 종료
```

### 6단계
1번 명언삭제
```shell
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 삭제?id=1
1번 명언이 삭제되었습니다.
명령) 종료
```

### 7단계
존재하지 않는 명언삭제에 대한 예외처리
```shell
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 삭제?id=1
1번 명언이 삭제되었습니다.
명령) 삭제?id=1
1번 명언은 존재하지 않습니다.
명령) 종료
```

### 8단계
명언수정
```shell
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 삭제?id=1
1번 명언이 삭제되었습니다.
명령) 삭제?id=1
1번 명언은 존재하지 않습니다.
명령) 수정?id=2
명언(기존) : 과거에 집착하지 마라.
명언 : 현재와 자신을 사랑하라.
작가(기존) : 작자미상
작가 : 홍길동
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 홍길동 / 현재와 자신을 사랑하라.
명령) 종료
```

### 9단계
파일을 통한 영속성
```shell
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 종료

프로그램 다시 시작...

== 명언 앱 ==
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
```

### 10단계
data.json 빌드
```shell
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 삭제?id=1
1번 명언이 삭제되었습니다.
명령) 삭제?id=1
1번 명언은 존재하지 않습니다.
명령) 수정?id=2
명언(기존) : 과거에 집착하지 마라.
명언 : 현재와 자신을 사랑하라.
작가(기존) : 작자미상
작가 : 홍길동
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 홍길동 / 현재와 자신을 사랑하라.
명령) 빌드
data.json 파일의 내용이 갱신되었습니다.
명령) 종료
```

data.json 양식
```json
[
    {
        "id": 1,
        "content": "명언 1",
        "author": "작가 1"
    },
    {
        "id": 2,
        "content": "명언 2",
        "author": "작가 2"
    }
]
```

### 추가요구사항
~~1. 소스코드 리팩토링~~

~~4. 간단한 MVC 프레임워크 구현하여 적용~~

~~5. 요청처리하는 객체 Rq 도입~~

2. 반복문은 최대로 줄이고, 스트림 최대로 활용
3. 모든 기능에 대해서 TDD 적용
6. 회원가입, 로그인, 로그아웃, 내가 작성한 명언 보기
7. 검색, 페이징
8. JDBC 사용하여 영속화
9. JDBC 유틸 : JDBC를 편하게 쓸 수 있는 유틸 클래스
10. @Autowired 기능 구현