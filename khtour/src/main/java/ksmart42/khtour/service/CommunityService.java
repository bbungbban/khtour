package ksmart42.khtour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		System.out.println("02 communityList getCommunityList CommunityService.java");
		List<Community> communityList = communityMapper.getCommunityList();
		System.out.println(communityList + "<- communityList getCommunityList CommunityService.java");
		return communityList;
	}
	public Community getCommunityByCode(String commCode) {
		
		Community community = communityMapper.getCommunityByCode(commCode);
		return community;
	}
	
	public List<Rule> getRuleListByCommCode(String commCode){
		
		List<Rule> ruleList = communityMapper.getRuleListByCommCode(commCode);
		return ruleList;
	}
	
	
	
	
	
}
