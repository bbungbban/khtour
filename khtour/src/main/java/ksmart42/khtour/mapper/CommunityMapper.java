package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;

@Mapper
public interface CommunityMapper {

	
	public List<Community> getCommunityList();
	public Community getCommunityByName(String commName);
	public List<Rule> getRuleListByCommName(String commName);
	public void addCommunity(Community community);
	public boolean commNameCheack(String commName);
	
	
	
}
