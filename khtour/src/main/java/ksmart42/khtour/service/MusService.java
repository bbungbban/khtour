package ksmart42.khtour.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Museum;
import ksmart42.khtour.mapper.MusMapper;

@Service
@Transactional
public class MusService {
	//DI 의존성 주입
	private MusMapper musMapper;
	
	public MusService(MusMapper musMapper) {
		this.musMapper = musMapper;
	}
	//박물관 등록
	public void addMuseum(Museum museum) {
		musMapper.addMuseum(museum);
		
	}
}
