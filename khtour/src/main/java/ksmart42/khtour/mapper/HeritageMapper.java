package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Heritage;

@Mapper
public interface HeritageMapper {

	// 문화재 목록조회
	public List<Heritage> getHeritageList(Map<String, Object> paramMap);
	
	// 문화재 등록
	public int addHeritage(Heritage heritage);

	// 문화재 조회(문화재 코드)
	public Heritage getHeritageByCode(String heritageCode);
	
	
}
