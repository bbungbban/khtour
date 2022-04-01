package ksmart42.khtour.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.AccomReview;
import ksmart42.khtour.mapper.AccomReviewMapper;

@Service
@Transactional
public class AccomReviewService {
	//DI 의존성 주입
		private AccomReviewMapper accomReviewMapper;
		
		public AccomReviewService(AccomReviewMapper accomReviewMapper) {
			this.accomReviewMapper = accomReviewMapper;
		}
	
		/**
		 * 숙박업소 리뷰 등록
		 */
		public void addAccomReview(AccomReview accomReview) {
			accomReviewMapper.addAccomReview(accomReview);
		}
}
