package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Accommodation;

@Mapper
public interface AccommodationMapper {
	
	//숙박업소 등록
	public int addAccommodation(Accommodation accommodation);
	
	//숙박업소 리스트 조회
	public List<Accommodation> getAccommodationList(Map<String, Object> paramMap);
	
	//숙박업소 리스트(숙박업소 코드)
	public Accommodation getLdgByCode(String ldgCode);
	
	//숙박업소 삭제
	public int removeAccommodation(String ldgCode);
	
	//숙박업소 수정
	public int modifyAccommodation(Accommodation accommodation);

	public double updateGrade(String ldgCode);
}
