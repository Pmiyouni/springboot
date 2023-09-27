 <springboot 학생관리>
1. Entity 설계
    - 다음과 같은 테이블이 만들어지도록 Entity 클래스 설계하기
    - 테이블이름: student_table
    - 컬럼
        - id: bigint, auto_increment, pk
        - student_number: varchar(20), not null, unique
        - student_name: varchar(20), not null
        - student_mobile: varchar(30), not null
        - student_major: varchar(50), not null


2. 컨트롤러 작성
    - 프로젝트 시작 페이지: index.html
        - 학생등록 페이지(save.html) 이동을 위한 링크 있음.
    - save.html
        - 학번(studentNumber), 이름(studentName), 전화번호(studentMobile), 학과정보(studentMajor)를 받아서 /save 주소로 post 요청 보냄
            - 학과 정보는 select를 이용(선택값은 컴퓨터공학, 전자공학, 경영학 세가지만 있음.)
        - 요청 데이터는 StudentDTO에 담겨서 컨트롤러로 전달됨.
        - 전달받은 DTO 객체를 StudentService 클래스의 save 메서드로 전달

3. 학생 목록/조회/수정/삭제 진행