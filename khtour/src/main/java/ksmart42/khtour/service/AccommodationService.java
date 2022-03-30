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
	 * 숙박업소 리스트 
	 * */
	public List<Accommodation> getAccommodationList(Map<String, Object> paramMap) {
		List<Accommodation> accommodationList = accommodationMapper.getAccommodationList(paramMap);
		
		return accommodationList;
	}

	
	/**
	 * 숙박업소 등록
	 * */
	public void addaccommodation(Accommodation accommodation) {
		accommodationMapper.addaccommodation(accommodation);
		
	}
	
	/**
	 * 숙박업소 수정
	 * */
	public Accommodation getAccommodationByCode(String ldgCode) {
		return accommodationMapper.getAccommodationByCode(ldgCode);
	}

}
