package ksmart42.khtour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Member;
import ksmart42.khtour.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {

	private MemberMapper memberMapper;
	
	@Autowired
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	public List<Member> getMemberList(){
		
		List<Member> memberList = memberMapper.getMemberList();
		
		return memberList;
		
	}
}
