package com.lec.domain_dto;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

//Board.java의 어노테이션 @ Entitylisteners가 사용할 클래스
public class BoardListeners {

//아래 어노테이션은 필수 아님
	
	//Board객체가 메모리에 올라올 때 처리할 옵션
	@PostLoad
	public void postLoad(Board board) {
		System.out.println("@PostLoad : {} " + board );
	}
	//영속성 - 데이터 처리 전
	@PrePersist
	public void prePersist(Board board) {
		System.out.println("@PrePersist : {} " + board );
	}
	//영속성 - 데이터 처리 후
	@PostPersist
	public void postPersist(Board board) {
		System.out.println("@PostPersist : {} " + board );
	}
	@PreUpdate
	public void preUpdate(Board board) {
		System.out.println("@PreUpdate : {} " + board );
	}
	@PostUpdate
	public void postUpdate(Board board) {
		System.out.println("@PostUpdate : {} " + board );
	}
	@PreRemove
	public void preRemove(Board board) {
		System.out.println("@PreRemove : {} " + board );
	}
	@PostRemove
	public void postRemove(Board board) {
		System.out.println("@PostRemove : {} " + board );
	}
	
	

}
