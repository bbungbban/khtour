package ksmart42.khtour.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Member;

@Mapper
public interface MemberMapper {

	public List<Member> getMemberList();

	public static Member getMemberInfoById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}
}
