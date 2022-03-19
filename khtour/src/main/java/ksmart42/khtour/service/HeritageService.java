package ksmart42.khtour.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.khtour.dto.Heritage;
import ksmart42.khtour.mapper.HeritageMapper;

@Service
@Transactional
public class HeritageService {
	//DI 의존성 주입
	private HeritageMapper heritageMapper;
	
	public HeritageService(HeritageMapper heritageMapper) {
		this.heritageMapper = heritageMapper;
	}
	
	/**
	 * 코드에 따른 문화재 조회
	 */
	public Heritage getHeritageByCode(String heritageCode) {
		return heritageMapper.getHeritageByCode(heritageCode);
	}
	/**
	 * 문화재등록
	 */
	public void addHeritage(Heritage heritage) {
		heritageMapper.addHeritage(heritage);
	}
	
	public List<Heritage> getHeritageList(Map<String, Object> paramMap){
		List<Heritage> heritageList = heritageMapper.getHeritageList(paramMap);
		
		return heritageList;
	}
	
}
