package com.lec.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lec.domain_dto.Member;

public interface MemberService {
	
	Member getMember(Member member);
	void insertMember(Member member);
	void updateMember(Member member);
	void deleteMember(Member member);
	
	Page<Member> getMemberList(Pageable pageable, String searchType, String searchWord);
	long getTotalRowCount(Member member);
	
	
}
