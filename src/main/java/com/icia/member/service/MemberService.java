package com.icia.member.service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.entity.MemberEntity;
import com.icia.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private  final MemberRepository memberRepository;
    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        return memberRepository.save(memberEntity).getId();
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
//        for(MemberEntity memberEntity: memberEntityList)
//            MemberDTO memberDTO = MemberDTO.toDTO(memberEntity);
//            memberDTOList.add(memberDTO);
        //memberDTOList.add(MemberDTO.toDTO(memberEntity));
        memberEntityList.forEach(entity ->{
            memberDTOList.add(MemberDTO.toDTO(entity));
        });
        return memberDTOList;
        }

    public MemberDTO findById(Long id) {
       Optional<MemberEntity> optionalMemberEntity =memberRepository.findById(id);
       if(optionalMemberEntity.isPresent()){
           MemberEntity memberEntity =optionalMemberEntity.get();
           return MemberDTO.toDTO(memberEntity);
       } else{
           return null;
       }
      //MemberEntity memberEntity=memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
       // return MemberDTO.toDTO(memberEntity);

    }

    public void update(MemberDTO memberDTO) {
        MemberEntity memberEntity= MemberEntity.toUpdateEntity(memberDTO);
        memberRepository.save(memberEntity);

    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
    public MemberDTO login(MemberDTO memberDTO) {

        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());

        if (byMemberEmail.isPresent()) {
            // 조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
            MemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 불일치(로그인실패)
                return null;
            }
        } else {
            // 조회 결과가 없다(해당 이메일을 가진 회원이 없다)
            return null;
        }
    }


    public String emailCheck(String memberEmail) {
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberEmail);
        if (byMemberEmail.isPresent()) {
            return null;
        } else {
            return "ok";
        }
    }
}
