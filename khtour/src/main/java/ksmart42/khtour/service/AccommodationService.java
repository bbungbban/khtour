package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.mapper.AccommodationMapper;

@Service
@Transactional
public class AccommodationService {
	//DI 의존성 주입
	private AccommodationMapper accommodationMapper;
	
	public AccommodationService(AccommodationMapper accommodationMapper) {
		this.accommodationMapper = accommodationMapper;
	}
	
	/**
	 * 코드에 따른 여행 계획 조회
	 */
	public Accommodation getLdgByCode(String ldgCode) {
		return accommodationMapper.getLdgByCode(ldgCode);
	}
	/**
	 * 여행 계획 등록
	 */
	public void addAccommodation(Accommodation accommodation) {
		accommodationMapper.addAccommodation(accommodation);
	}
	
	/**
	 * 여행 계획 목록 조회
	 */
	public List<Accommodation> getAccommodationList(Map<String, Object> paramMap){
		List<Accommodation> accommodationList = accommodationMapper.getAccommodationList(paramMap);
		
		return accommodationList;
	}

	/**
	 * 여행 계획 정보 수정
	 */
	public int modifyAccommodation(Accommodation accommodation) {
		return accommodationMapper.modifyAccommodation(accommodation);
	}
	
	/**
	 * 여행 계획 정보 삭제
	 */
	public int removeAccommodation(String ldgCode) {
		int result = accommodationMapper.removeAccommodation(ldgCode);
		
		result += accommodationMapper.removeAccommodation(ldgCode);
		
		return result;
	}
}
