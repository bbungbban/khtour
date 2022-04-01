package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Member;
import ksmart42.khtour.dto.LoginHistory;
import ksmart42.khtour.dto.MemberLevel;

@Mapper
public interface MemberMapper {

	// 로그인 이력조회1
		public List<LoginHistory> getLoginHistory1();

		// 로그인 이력조회2
		public List<Map<String, Object>> getLoginHistory2();
		
		// 회원의 로그인 이력을 삭제
		public int removeLoginHistory(String memberId);
		
		// 회원 삭제
		public int memberList(String memberId);
		
		// 회원수정
		public int memberModify(Member member);
		
		// 아이디별 회원정보 조회
		public static Member getMemberInfoById(String memberId) {
			// TODO Auto-generated method stub
			return null;
		}
		
		// 회원 아이디 중복체크
		public static boolean isIdCheck(String memberId) {
			// TODO Auto-generated method stub
			return false;
		}
		
		// 회원 등급 목록 조회
		public List<MemberLevel> getMemberLevelList();
		
		// 회원 전체 목록 조회
		public List<Member> getMemberList(String searchKey, String searchValue);
		
		// 회원 가입
		public int memberInsert(Member member);
		
}

		

