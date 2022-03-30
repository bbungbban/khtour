package ksmart42.khtour.mapper;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Exhibition;


@Mapper
public interface ExhibMapper {
	// 전시회 등록
	public int addExhibition(Exhibition exhibition);
}
