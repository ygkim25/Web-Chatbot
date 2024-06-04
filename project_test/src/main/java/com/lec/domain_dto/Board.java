package com.lec.domain_dto;

import java.util.Date;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(BoardListeners.class)
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String title;
	@Column(updatable = false)
	//
	private String writer;
	private String content;
	
	//***아래 date default now()가 ddl 에러 나는 거 체크:
	//@Column(insertable = false, updatable = false, columnDefinition = "date default now()")
	@Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date createDate; // 테이블 필드명은 create_date
	@Column(insertable = false, updatable = false, columnDefinition = "bigint default 0")
	private Long cnt; 
	private String fileName;
	@Transient
	private MultipartFile uploadFile;
	
	//페이지 관련 변수
	private Long board_ref;
	private Long board_lev;
	private Long board_seq;
	
}
