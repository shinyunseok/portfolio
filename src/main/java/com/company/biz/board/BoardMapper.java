package com.company.biz.board;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {
	
	
	@Select("SELECT * FROM SPRINGBOARD WHERE SEQ=#{seq}")
	public Board getBoard(Board vo);
	
	@Insert("INSERT INTO SPRINGBOARD(SEQ,TITLE,WRITER,CONTENT) VALUES((SELECT NVL(MAX(SEQ),0)+1 FROM SPRINGBOARD),#{title},#{writer},#{content})")
	public void insertBoard(Board vo);
	
	@Update("UPDATE SPRINGBOARD SET TITLE=#{title},\r\n"
			+ "		CONTENT=#{content} WHERE SEQ=#{seq}")
	public void updateBoard(Board vo);
	
	@Delete("DELETE SPRINGBOARD WHERE SEQ=#{seq}")
	public void deleteBoard(Board vo);
	
	@Select("SELECT COUNT(*) FROM SPRINGBOARD WHERE #{searchCondition} LIKE '%'||#{searchKeyword}||'%'")
	int getTotalCount(Board vo);
	
	@Select("SELECT * FROM (SELECT ROWNUM AS RNUM,B.* FROM (SELECT SEQ,TITLE,WRITER,CONTENT,TO_CHAR(REGDATE,'YYYY-MM-DD HH:MI:SS') AS REGDATE,CNT FROM SPRINGBOARD WHERE #{searchCondition} LIKE '%'||#{searchKeyword}||'%' ORDER BY SEQ DESC) B) WHERE RNUM BETWEEN #{page}*10-9 AND #{page}*10")
	List<Board> getBoardList(Board vo);

	@Update("UPDATE SPRINGBOARD SET CNT=CNT+1 WHERE SEQ=#{seq}")
	public void updateBoard2(Board vo);
	
}
