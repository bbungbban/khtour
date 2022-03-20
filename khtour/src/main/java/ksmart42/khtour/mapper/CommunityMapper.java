package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;

@Mapper
public interface CommunityMapper {

	
	public List<Community> getCommunityList();
	public Community getCommunityByCode(String commCode);
	public List<Rule> getRuleListByCommCode(String commCode);
	
	
	
	
}
