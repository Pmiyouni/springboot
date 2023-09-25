package com.icia.member.repository;


import com.icia.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository를 붙이지 않음, JpaRepository 상속 받으면 자동적으로 자바객체(빈)으로 생성되므로

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}
