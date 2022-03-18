package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Community;

@Mapper
public interface CommunityMapper {

	
	public List<Community> getCommunityList();
	
	
	
	
	
}
