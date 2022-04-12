package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import ksmart42.khtour.dto.Cos;

@Mapper
public interface CosMapper {

	// 코스 조회
	public List<Cos> getCosList(Map<String, Object> paramMap);
	
	// 카테고리별 코스 조회
	public List<Cos> history(Map<String, Object> paramMap);
	
	// 코스 등록
	public int addCos(Cos cos);
	public List<Cos> categoryList(Map<String, Object> paramMap);

	// 코스 조회(코스 코드)
	public Cos getCosByCode(String cosCode);
	
	// 코스 수정(코스코드)
	public int modifyCos(Cos cos);
	
	// 코스 삭제
	public int removeCos(String cosCode);
}
