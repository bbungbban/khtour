package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Board;

@Mapper
public interface BoardMapper {
	
	// 1:1 문의게시판리스트 조회
	List<Board> getBoardList(Map<String, Object> paramMap);

}
