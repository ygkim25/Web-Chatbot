package com.lec.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.domain_dto.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	
	//getMember, insertMember, updateMember, deleteMember, getTotalRowCount = JpaRepository 메서드 사용
	
	
	//getMemberList
	//대소문자 주의
	Page<Member> findByIdContaining(String id, Pageable pageable);
	Page<Member> findByNameContaining(String name, Pageable pageable);
	
	
}
