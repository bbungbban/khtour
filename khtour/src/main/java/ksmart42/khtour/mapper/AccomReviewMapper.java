package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.AccomReview;
import ksmart42.khtour.dto.Accommodation;

@Mapper
public interface AccomReviewMapper {
	
	// ldg_code에 맞는 리뷰 조회
	public List<AccomReview> getAccomReviewList(String ldgCode);
	
	//리뷰조회
	public Accommodation getLdgByCode(String ldgCode);
	
	//리뷰등록
	public int addAccomReview(AccomReview accomReview);
	
	//리뷰삭제
	public int deleteReview(String ldgReviewCode);

}
