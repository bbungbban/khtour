package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.AccomReview;
import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.mapper.AccomReviewMapper;
import ksmart42.khtour.mapper.AccommodationMapper;

@Service
@Transactional
public class AccomReviewService {
	//DI 의존성 주입
		private AccomReviewMapper accomReviewMapper;
		
		private AccommodationMapper accommodationMapper;
		
		public AccomReviewService(AccomReviewMapper accomReviewMapper, AccommodationMapper accommodationMapper) {
			this.accomReviewMapper = accomReviewMapper;
			this.accommodationMapper = accommodationMapper;
		}
		
		public List<AccomReview> getAccomReviewList(String ldgCode){
			
			return accomReviewMapper.getAccomReviewList(ldgCode);
		}
		
		/**
		 * 숙박업소 코드에 따른 리뷰조회
		 */
		public Accommodation getLdgByCode(String ldgCode) {
			
			return accomReviewMapper.getLdgByCode(ldgCode);
		}
		/**
		 * 리뷰등록 
		 */
		public void addAccomReview(AccomReview accomReview) {
			
			accomReviewMapper.addAccomReview(accomReview);
			
		}
		/**
		 * 코드에 따른 리뷰 삭제
		 */
		public int deleteReview(String ldgReviewCode) {
			int result = accomReviewMapper.deleteReview(ldgReviewCode);
			
			result += accomReviewMapper.deleteReview(ldgReviewCode);
			
			return result;
		}
		/**
		 * 최신 리뷰 2개만 화면에 조회 
		 */
		public List<AccomReview> getReviewByDate(String ldgCode){
			
			return accomReviewMapper.getReviewByDate(ldgCode);
		}
		
		/**
		 * 리뷰코드를 가지고 리뷰코드에 맞는 숙박업소 코드를 조회
		 */
		public String getLdgCodeByReviewCode(String ldgReviewCode) {
			
			return accomReviewMapper.getLdgCodeByReviewCode(ldgReviewCode);
		}
		
		
		
}

