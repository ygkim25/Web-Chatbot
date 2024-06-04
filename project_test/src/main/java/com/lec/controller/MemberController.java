package com.lec.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lec.domain_dto.Member;
import com.lec.domain_dto.PagingInfo;
import com.lec.service.MemberService;

@Controller
@SessionAttributes("pagingInfo") //없으면 paging
public class MemberController {

//객체
	@Autowired
	MemberService memberService;
	
	public PagingInfo pagingInfo = new PagingInfo();

//insert
	//insert창으로 가기
	@GetMapping("/insertMember")
	public String insertMemberForm(Member member) {
		return "member/insertMember";
	}	
	//양식 입력해서 insert하기
	@PostMapping("/insertMember")
	public String insertMember(Member member) {
		if(member.getId() == null) {
			return "redirect:login";
		}	
		member.setRole(member.getRole() != null ? "ADMIN" : "USER");
		memberService.insertMember(member);
		return "redirect:login";//임시
		//return "redirect:getMemberList";
	}

//update
	@GetMapping("/updateMember")
	public String updateMember(Member member, Model model) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		model.addAttribute("member", memberService.getMember(member));
		return "member/updateMember";
	}
	
	@PostMapping("/updateMember")
	public String updateMember(Member member) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		member.setRole(member.getRole() != null ? "ADMIN":"USER");
		memberService.updateMember(member);
		return "redirect:getMemberList";
	}
//delete
	@GetMapping("/deleteMember")
	public String deleteMember(Member member) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		memberService.deleteMember(member);
		return "forward:getMemberList";
	}

//getMemberList.html
	@GetMapping("getMemberList")
	public String getMemberList(Model model
								, @RequestParam(defaultValue = "0") int curPage
								, @RequestParam(defaultValue = "10") int rowSizePerPage
								, @RequestParam(defaultValue = "name") String searchType
								, @RequestParam(defaultValue = "") String searchWord) {
		Pageable pageable = PageRequest.of(curPage, rowSizePerPage, Sort.by(searchType).ascending());
		Page<Member> pagedResult = memberService.getMemberList(pageable, searchType, searchWord);
		
		int totalRowCount = pagedResult.getNumberOfElements();
		int totalPageCount = pagedResult.getTotalPages();
		int pageSize = pagingInfo.getPageSize();
		int startPage = curPage / pageSize * pageSize + 1;
		int endPage = startPage + pageSize -1;
		endPage = endPage > totalPageCount? (totalPageCount > 0 ? totalPageCount : 1) : endPage;
		
		//@Setter을 통해 생성
		pagingInfo.setCurPage(curPage);
		pagingInfo.setTotalRowCount(totalRowCount);
		pagingInfo.setTotalPageCount(totalPageCount);
		pagingInfo.setStartPage(startPage);
		pagingInfo.setEndPage(endPage);
		pagingInfo.setSearchType(searchType);
		pagingInfo.setSearchWord(searchWord);
		pagingInfo.setRowSizePerPage(rowSizePerPage);
		
		model.addAttribute("pagingInfo", pagingInfo);
		model.addAttribute("pagedResult", pagedResult);
		model.addAttribute("pageable", pageable);
		model.addAttribute("cp", curPage);
		model.addAttribute("sp", startPage);
		model.addAttribute("ep", endPage);
		model.addAttribute("ps", pageSize);
		model.addAttribute("rp", rowSizePerPage);
		model.addAttribute("tp", totalPageCount);
		model.addAttribute("st", searchType);
		model.addAttribute("sw", searchWord);
		
		return "member/getMemberList";
	}

	
}
























