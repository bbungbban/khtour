package ksmart42.khtour.mapper;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Accommodation;

@Mapper
public interface AccommodationMapper {
	//숙박시설등록
	public int addaccommodation(Accommodation accommodation);

}
