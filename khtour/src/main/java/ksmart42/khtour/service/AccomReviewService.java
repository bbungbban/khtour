package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

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
		
		
		public AccomReview getAccomReviewList(String ldgCode){
			
			return accomReviewMapper.getAccomReviewList(ldgCode);
		}
}

