package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Cos;
import ksmart42.khtour.dto.Mus;
import ksmart42.khtour.mapper.CosMapper;
import ksmart42.khtour.mapper.MusMapper;

@Service
@Transactional
public class CosService {
	//DI 의존성 주입
	private CosMapper cosMapper;
	private MusMapper musMapper;
	
	public CosService(CosMapper cosMapper,MusMapper musMapper) {
		this.cosMapper = cosMapper;
		this.musMapper = musMapper;
	}
	
	/**
	 * 박물관 목록 조회
	 */
	public List<Mus> getMusList(Map<String, Object> paramMap){
		List<Mus> musList = musMapper.getMusList(paramMap);
		return musList;
	}
	
	/**
	 * 코드에 따른 코스 조회
	 */
	public Cos getCosByCode(String cosCode) {
		return cosMapper.getCosByCode(cosCode);
	}
	
	/**
	 * 코스등록
	 */
	public void addCos(Cos cos) {
		cosMapper.addCos(cos);
	}
	
	public List<Cos> categoryList(Map<String, Object> paramMap){
		List<Cos> cosInsert = cosMapper.categoryList(paramMap);
		return cosInsert;
	}
	
	/**
	 * 코스 목록 조회
	 */
	public List<Cos> getCosList(Map<String, Object> paramMap){
		List<Cos> cosList = cosMapper.getCosList(paramMap);
		return cosList;
	}
	
	/**
	 * 카테고리역사별 코스 목록 조회
	 */
	public List<Cos> history(Map<String, Object> paramMap){
		List<Cos> history = cosMapper.history(paramMap);
		return history;
	}
	
	/**
	 * 코스 정보 수정
	 */
	public int modifyCos(Cos cos) {
		return cosMapper.modifyCos(cos);
	}
	
	/**
	 * 코스 정보 삭제
	 */
	public int removeCos(String cosCode) {
		int result = cosMapper.removeCos(cosCode);
		
		result += cosMapper.removeCos(cosCode);
		
		return result;
	}
}
