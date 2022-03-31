package ksmart42.khtour.mapper;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.AccomReview;

@Mapper
public interface AccomReviewMapper {
	
	/* 댓글 등록 */
	public int addAccomReview(AccomReview accomreview);


}
