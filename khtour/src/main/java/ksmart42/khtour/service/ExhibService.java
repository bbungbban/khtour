package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Exhib;
import ksmart42.khtour.mapper.ExhibMapper;

@Service
@Transactional
public class ExhibService {
	//DI 의존성 주입
	private ExhibMapper exhibMapper;
	
	public ExhibService(ExhibMapper exhibMapper) {
		this.exhibMapper = exhibMapper;
	}
	
	/**
	 * 코드에 따른 전시회 조회
	 */
	public Exhib getExhibByCode(String exhibCode) {
		return exhibMapper.getExhibByCode(exhibCode);
	}
	/**
	 * 전시회등록
	 */
	public void addExhib(Exhib exhib) {
		exhibMapper.addExhib(exhib);
	}
	
	/**
	 * 전시회 목록 조회
	 */
	public List<Exhib> getExhibList(Map<String, Object> paramMap){
		List<Exhib> exhibList = exhibMapper.getExhibList(paramMap);
		
		return exhibList;
	}

	/**
	 * 전시회 정보 수정
	 */
	public int modifyExhib(Exhib exhib) {
		return exhibMapper.modifyExhib(exhib);
	}
	
	/**
	 * 전시회 정보 삭제
	 */
	public int removeExhib(String exhibCode) {
		int result = exhibMapper.removeExhib(exhibCode);
		
		result += exhibMapper.removeExhib(exhibCode);
		
		return result;
	}
}
