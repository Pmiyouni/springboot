package com.example.demo.repository;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//interface로 생성함
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    // jpa로 StudentEntity 상속, long은 pk 타입을 의미

}
