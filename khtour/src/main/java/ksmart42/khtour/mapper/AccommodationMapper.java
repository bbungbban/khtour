package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Accommodation;

@Mapper
public interface AccommodationMapper {
	//숙박업소 등록
	public int addaccommodation(Accommodation accommodation);
	
	//숙박업소 리스트
	public List<Accommodation> getAccommodationList(Map<String, Object> paramMap);

}
