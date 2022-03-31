package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Exhib;

@Mapper
public interface ExhibMapper {

	// 전시회 목록조회
	public List<Exhib> getExhibList(Map<String, Object> paramMap);
	
	// 전시회 등록
	public int addExhib(Exhib exhib);

	// 전시회 조회(전시회 코드)
	public Exhib getExhibByCode(String exhibCode);
	
	// 전시회 수정(전시회코드)
	public int modifyExhib(Exhib exhib);
	
	// 전시회 삭제
	public int removeExhib(String exhibCode);
}
