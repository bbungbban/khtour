package ksmart42.khtour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.CommTag;
import ksmart42.khtour.dto.Community;
import ksmart42.khtour.dto.Rule;
import ksmart42.khtour.mapper.CommunityMapper;


@Service
@Transactional
public class CommunityService {

	private CommunityMapper communityMapper;
	@Autowired
	public CommunityService(CommunityMapper communityMapper) {
		this.communityMapper = communityMapper;
	}
	
	public List<Community> getCommunityList(){
		List<Community> communityList = communityMapper.getCommunityList();
		return communityList;
	}
	public Community getCommunityByName(String commName) {
		
		Community community = communityMapper.getCommunityByName(commName);
		return community;
	}
	
	public List<Rule> getRuleListByCommName(String commName){
		
		List<Rule> ruleList = communityMapper.getRuleListByCommName(commName);
		return ruleList;
	}
	public List<CommTag> getTagListByCommName(String commName){
		
		List<CommTag> tagList = communityMapper.getTagListByCommName(commName);
		return tagList;
	}
	
	public void addCommunity(Community community) {
		
		communityMapper.addCommunity(community);
		
	}
	public void addRule(Rule rule) {
		
		communityMapper.addRule(rule);
		
	}
	
	public void addTag(CommTag commTag) {
		
		communityMapper.addTag(commTag);
		
	}
	
	
	
	
	
	
	
}
