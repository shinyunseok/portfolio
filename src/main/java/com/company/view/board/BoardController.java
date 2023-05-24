package com.company.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.company.biz.board.Board;
import com.company.biz.board.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/getBoardList.do")
	public ModelAndView getBoardList(Board vo,ModelAndView mav) {
		System.out.println("글 목록 검색 처리");
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("title");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		if(vo.getPage()==0)
			vo.setPage(1);
		mav.addObject("totalCount", boardService.getTotalCount(vo));
		mav.addObject("boardList", boardService.getBoardList(vo));// Model 정보 저장
		mav.addObject("searchKeyword", vo.getSearchKeyword());
		mav.addObject("searchCondition", vo.getSearchCondition());
		mav.setViewName("getBoardList");
		return mav;
	}
	
	// 글 상세 조회
	@GetMapping("/getBoard.do")
	public ModelAndView getBoard(Board vo,ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		mav.addObject("board", boardService.getBoard(vo));
		mav.setViewName("getBoard");
		return mav;
	}
	
	// 글 등록
	@PostMapping("/insertBoard.do")
	public ModelAndView insertBoard(Board vo, ModelAndView mav) {
		System.out.println("글 등록 처리");
		boardService.insertBoard(vo);
		mav.setViewName("redirect:getBoardList.do?page=1");
		return mav;
	}
	
	@GetMapping("/insertBoard.do")
	public ModelAndView insertBoardView(ModelAndView mav) {
		System.out.println("글 등록 페이지 이동");
		mav.setViewName("insertBoard");
		return mav;
	}
	
	// 글 수정
	@PostMapping("/updateBoard.do")
	public ModelAndView updateBoard(Board vo,ModelAndView mav) {
		System.out.println("글 수정 처리");
		boardService.updateBoard(vo);
		mav.setViewName("redirect:getBoardList.do?page=1");
		return mav;
	}
	
	// 글 삭제
	@GetMapping("/deleteBoard.do")
	public ModelAndView deleteBoard(Board vo,ModelAndView mav) {
		System.out.println("글 삭제 처리");
		boardService.deleteBoard(vo);
		mav.setViewName("redirect:getBoardList.do?page=1");
		return mav;
	}
	
	@RequestMapping("/dataTransfrom.do")
	@ResponseBody	// List 객체를 http 응답 프로토콜의 몸체로 변환
	public List<Board> dataTransform(Board vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		return boardService.getBoardList(vo);
	}
}
