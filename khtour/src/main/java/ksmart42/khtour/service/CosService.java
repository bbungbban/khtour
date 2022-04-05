package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Cos;
import ksmart42.khtour.mapper.CosMapper;

@Service
@Transactional
public class CosService {
	//DI 의존성 주입
	private CosMapper cosMapper;
	
	public CosService(CosMapper cosMapper) {
		this.cosMapper = cosMapper;
	}
	
	/**
	 * 코드에 따른 전시회 조회
	 */
	public Cos getCosByCode(String cosCode) {
		return cosMapper.getCosByCode(cosCode);
	}
	/**
	 * 전시회등록
	 */
	public void addCos(Cos cos) {
		cosMapper.addCos(cos);
	}
	
	/**
	 * 전시회 목록 조회
	 */
	public List<Cos> getCosList(Map<String, Object> paramMap){
		List<Cos> cosList = cosMapper.getCosList(paramMap);
		
		return cosList;
	}

	/**
	 * 전시회 정보 수정
	 */
	public int modifyCos(Cos cos) {
		return cosMapper.modifyCos(cos);
	}
	
	/**
	 * 전시회 정보 삭제
	 */
	public int removeCos(String cosCode) {
		int result = cosMapper.removeCos(cosCode);
		
		result += cosMapper.removeCos(cosCode);
		
		return result;
	}
}
