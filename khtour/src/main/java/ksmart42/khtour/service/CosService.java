package ksmart42.khtour.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.Cos;
import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.dto.Mus;
import ksmart42.khtour.mapper.CosMapper;
import ksmart42.khtour.mapper.FileMapper;
import ksmart42.khtour.mapper.MusMapper;
import ksmart42.khtour.util.FileUtil;

@Service
@Transactional
public class CosService {
	// DI 의존성 주입
	private CosMapper 	cosMapper;
	private MusMapper 	musMapper;
	private FileUtil 	fileUtil;
	private FileMapper 	fileMapper;

	public CosService(CosMapper cosMapper, MusMapper musMapper, FileUtil fileUtil, FileMapper fileMapper) {
		this.cosMapper = cosMapper;
		this.musMapper = musMapper;
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}

	/**
	 * 박물관 목록 조회
	 */
	public List<Mus> getMusList() {
		List<Mus> musList = musMapper.getMusList();
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
	public void addCos(Cos cos, MultipartFile[] cosImageFiles, String fileRealPath) {
		List<FileDto> fileList = fileUtil.parseFileInfo(cosImageFiles, fileRealPath);
		fileMapper.addFile(fileList);
		cosMapper.addCos(cos);
		
		List<Map<String,String>> addFileControlList = new ArrayList<Map<String,String>>();
	      
		Map<String, String> addMap = null;

		if (fileList != null) {
			for (FileDto fileDto : fileList) {
				addMap = new HashMap<String, String>();
				addMap.put("referenceCode", cos.getCosCode());
				addMap.put("fileIdx", fileDto.getFileIdx());
				addFileControlList.add(addMap);
			}
		}
		fileMapper.addFileControl(addFileControlList);
	}

	public List<Cos> categoryList(Map<String, Object> paramMap) {
		List<Cos> cosInsert = cosMapper.categoryList(paramMap);
		return cosInsert;
	}

	/**
	 * 코스 목록 조회
	 */
	public List<Cos> getCosList(Map<String, Object> paramMap) {
		List<Cos> cosList = cosMapper.getCosList(paramMap);
		return cosList;
	}

	/**
	 * 카테고리별 코스 목록 조회
	 */
	public List<Cos> cosHistory(Map<String, Object> paramMap) {
		List<Cos> cosHistory = cosMapper.cosHistory(paramMap);
		return cosHistory;
	}
	public List<Cos> cosHumanities(Map<String, Object> paramMap) {
		List<Cos> cosHumanities = cosMapper.cosHumanities(paramMap);
		return cosHumanities;
	}
	public List<Cos> cosWar(Map<String, Object> paramMap) {
		List<Cos> cosWar = cosMapper.cosWar(paramMap);
		return cosWar;
	}
	public List<Cos> cosReligion(Map<String, Object> paramMap) {
		List<Cos> cosReligion = cosMapper.cosReligion(paramMap);
		return cosReligion;
	}
	public List<Cos> cosFolklore(Map<String, Object> paramMap) {
		List<Cos> cosFolklore = cosMapper.cosFolklore(paramMap);
		return cosFolklore;
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
	public int removeCos(String cosCode, String fileRootPath) throws IOException {
		
		FileDto fileDto = cosMapper.fileInfoByFileIdx(cosCode);
		  
		int result = 0;

	      if(fileDto != null) {
	         
	         String fileIdx = fileDto.getFileIdx();
	         String filePath = fileDto.getFilePath();
	   
	         if(fileIdx != null) {
	            
	            fileMapper.removeFileControl(fileIdx);
	            
	            fileMapper.removeFile(fileIdx);
	            
	            result += cosMapper.removeCos(cosCode);
	            
	            if(result > 0) fileUtil.fileDelete(fileRootPath, filePath);
	         }
	      }else {
	         
	         result += cosMapper.removeCos(cosCode);
	         
	      }
	      return result;
	   }
	}
