package com.company.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(Board vo) {
		System.out.println("===> MyBatis insertBoard()");
		mybatis.insert("insertBoard", vo);
	}

	public void updateBoard(Board vo) {
		System.out.println("===> MyBatis updateBoard()");
		mybatis.update("updateBoard", vo);
	}

	public void deleteBoard(Board vo) {
		System.out.println("===> MyBatis deleteBoard()");
		mybatis.delete("deleteBoard", vo);
	}

	public Board getBoard(Board vo) {
		System.out.println("===> MyBatis getBoard()");
		mybatis.update("updateBoard2", vo);
		return (Board)mybatis.selectOne("getBoard", vo);
	}

	public List<Board> getBoardList(Board vo) {
		System.out.println("===> MyBatis getBoardList()");
		return mybatis.selectList("getBoardList", vo);
	}
	
	
	public int getTotalCount(Board vo) {
		System.out.println("총 게시물 수 구하기");
		return mybatis.selectOne("getTotalCount", vo);
	}
	
	public void updateBoard2(Board vo) {
		System.out.println("===> MyBatis updateBoardcntzz()");
		mybatis.update("updateBoard2", vo);
	}
	
}
