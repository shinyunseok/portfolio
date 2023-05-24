package com.company.biz.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // @Getter,@setter @ToString,
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 멤버변수 초기화하는 생성자 생성
@Builder // 빌더 패턴이 적용된 bulder()메소드 생성
public class Board {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int cnt;
	private String searchCondition;
	private String searchKeyword;
	private int page; 
	private int totalCount;
}
