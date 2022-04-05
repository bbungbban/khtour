package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Cos;

@Mapper
public interface CosMapper {

	// 전시회 목록조회
	public List<Cos> getCosList(Map<String, Object> paramMap);
	
	// 전시회 등록
	public int addCos(Cos cos);

	// 전시회 조회(전시회 코드)
	public Cos getCosByCode(String cosCode);
	
	// 전시회 수정(전시회코드)
	public int modifyCos(Cos cos);
	
	// 전시회 삭제
	public int removeCos(String cosCode);
}
