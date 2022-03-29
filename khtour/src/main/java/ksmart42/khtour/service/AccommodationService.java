package ksmart42.khtour.service;

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

	public void addaccommodation(Accommodation accommodation) {
		accommodationMapper.addaccommodation(accommodation);
		
	}

}