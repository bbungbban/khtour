package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.CommTag;
import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;

@Mapper
public interface CommunityMapper {

	
	public List<Community> getCommunityList();
	public Community getCommunityByName(String commName);
	public List<Rule> getRuleListByCommName(String commName);
	public List<CommTag> getTagListByCommName(String commName);
	
	
	public void addCommunity(Community community);
	public void addRule(Rule rule);
	public void addTag(CommTag commTag);
	public boolean commNameCheck(String commName);
	
	
	
	
}
