package ksmart42.khtour.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.khtour.dto.AccomReview;

@Mapper
public interface AccomReviewMapper {
	
	public AccomReview getAccomReviewList(String ldgCode);


}
