package ksmart42.khtour.mapper;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Museum;

@Mapper
public interface MusMapper {
	// 박물관 등록
	public int addMuseum(Museum museum);
}
