package com.lec.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lec.domain_dto.Member;
import com.lec.persistence.MemberRepository;
import com.lec.service.MemberService;

//없으면 controller에서 인식 못함 주의
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;	
//select	
	@Override
	public Member getMember(Member member) {
		Optional<Member> findmember = memberRepository.findById(member.getId());
		if(findmember.isPresent()) {
			return findmember.get();
		}else {
			return null;
		}
	}
//insert
	@Override
	public void insertMember(Member member) {
		memberRepository.save(member);		
	}
//update
	@Override
	public void updateMember(Member member) {
		memberRepository.save(member);		
	}
//delete
	@Override
	public void deleteMember(Member member) {
		memberRepository.deleteById(member.getId());		
	}

// 단어 검색기능
	@Override
	public Page<Member> getMemberList(Pageable pageable, String searchType, String searchWord) {
		
		if(searchType.equalsIgnoreCase("id")) {
			return memberRepository.findByIdContaining(searchWord,pageable);
		
		} else {
		//
			System.out.println("print : memberRepository.findbyIdContaining(searchWord, pageable).toString()");
			System.out.println(memberRepository.findByIdContaining(searchWord, pageable).toString());
			return memberRepository.findByNameContaining(searchWord, pageable);
		}
	}
//getTotalRowCount
	@Override
	public long getTotalRowCount(Member member) {
		//select count(*) from 테이블명;
		return memberRepository.count();
	}
	
	
}
