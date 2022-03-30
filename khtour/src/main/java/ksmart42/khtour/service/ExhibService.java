package ksmart42.khtour.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Exhibition;
import ksmart42.khtour.mapper.ExhibMapper;

@Service
@Transactional
public class ExhibService {
	// DI 의존성 주입
	private ExhibMapper exhibMapper;

	public ExhibService(ExhibMapper exhibMapper) {
		this.exhibMapper = exhibMapper;
	}

	// 전시회 등록
	public void addExhibition(Exhibition exhibition) {
		exhibMapper.addExhibition(exhibition);

	}
}
