package ksmart42.khtour.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.dto.Heritage;
import ksmart42.khtour.dto.HeritageCategory;
import ksmart42.khtour.mapper.FileMapper;
import ksmart42.khtour.mapper.HeritageMapper;
import ksmart42.khtour.util.FileUtil;

@Service
@Transactional
public class HeritageService {
	//DI 의존성 주입
	private HeritageMapper heritageMapper;
	
	private FileUtil fileUtil;
	
	private FileMapper fileMapper;
	
	public HeritageService(HeritageMapper heritageMapper, FileUtil fileUtil, FileMapper fileMapper) {
		this.heritageMapper = heritageMapper;
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
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
	public void addHeritage(Heritage heritage, MultipartFile[] heritageImageFiles, String fileRealPath) {
		List<FileDto> fileList = fileUtil.parseFileInfo(heritageImageFiles, fileRealPath);
		fileMapper.addFile(fileList);
		heritageMapper.addHeritage(heritage);
		
		List<Map<String,String>> addFileControlList = new ArrayList<Map<String,String>>();
		
		Map<String , String> addMap = null;
		
		if(fileList != null) {
			for(FileDto fileDto : fileList) {
				addMap = new HashMap<String , String>();
				addMap.put("referenceCode", heritage.getHeritageCode());
				addMap.put("fileIdx", fileDto.getFileIdx());
				addFileControlList.add(addMap);
			}
		}
		
		fileMapper.addFileControl(addFileControlList);
		
	}
	
	/**
	 * 문화재 목록 조회
	 */
	public List<Heritage> getHeritageList(Map<String, Object> paramMap){
		List<Heritage> heritageList = heritageMapper.getHeritageList(paramMap);
		
		return heritageList;
	}

	/**
	 * 문화재 분류 목록 조회
	 */
	public List<HeritageCategory> getHeritageCategoryList(){
		
		List<HeritageCategory> heritageCategoryList = heritageMapper.getHeritageCategoryList();
		
		return heritageCategoryList;
	}
	
	/**
	 * 문화재 정보 수정
	 */
	public int modifyHeritage(Heritage heritage) {
		return heritageMapper.modifyHeritage(heritage);
	}
	
	/**
	 * 문화재 정보 삭제
	 */
	public int removeHeritage(String heritageCode) {
		int result = heritageMapper.removeHeritage(heritageCode);
		
		result += heritageMapper.removeHeritage(heritageCode);
		
		return result;
	}
}
