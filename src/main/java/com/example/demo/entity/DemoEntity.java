package com.example.demo.entity;

import javax.persistence.*;

@Entity
//클래스를 테이블처럼 사용하겠음, 필드를 컬럼으로 사용
@Table(name="demo_table")
public class DemoEntity {

    @Id
    //필수로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 자동생성 : @Id와 @GeneratedValue를 같이 사용
    private  Long id; //기본적으로 Long로 지정, 기본값은 null

    @Column(name="student_name") //name을 지정 가능
    private String name;

    @Column(length=30, nullable = false, unique = true)
    private String mobile;

    @Column
    private  String studentAddress;   // student_address로 지정
}
