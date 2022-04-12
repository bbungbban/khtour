package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.Accommodation;

@Mapper
public interface AccommodationMapper {
	
	//숙박업소 등록
	public int addAccommodation(Accommodation accommodation);
	
	//숙박업소 리스트 조회
	public List<Accommodation> getAccommodationList(Map<String, Object> paramMap);
	
	//숙박업소 리스트(숙박업소 코드)
	public Accommodation getLdgByCode(String ldgCode);
	
	//숙박업소 삭제
	public int removeAccommodation(String ldgCode);
	
	//숙박업소 수정
	public int modifyAccommodation(Accommodation accommodation);
	
	//숙박업소 리뷰 평점에 대한 평균 업데이트
	public int updateGrade(String ldgCode);
	
	//숙박업소 평균별점 조회 
	public String avgGrade(String ldgCode);
	
	//숙박업소 청결도평균 점수 조회
	public String avgCleanliness(String ldgCode);
	
	//숙박업소 리뷰 + 
	public void addReviewCnt(String ldgCode);
	
	//숙박업소 리뷰 - 
	public void subtractReviewCnt(String ldgCode);
}
