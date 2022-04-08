package ksmart42.khtour.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.dto.Accommodation;
import ksmart42.khtour.dto.FileDto;
import ksmart42.khtour.mapper.AccommodationMapper;
import ksmart42.khtour.mapper.FileMapper;
import ksmart42.khtour.util.FileUtil;

@Service
@Transactional
public class AccommodationService {
	//DI 의존성 주입
	private AccommodationMapper accommodationMapper;
	
	//파일 업로드 테이블 
	private FileUtil fileUtil;
	
	private FileMapper fileMapper;
	
	public AccommodationService(AccommodationMapper accommodationMapper, FileUtil fileUtil, FileMapper fileMapper) {
		this.accommodationMapper = accommodationMapper;
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}
	
	/**
	 * 코드에 따른 숙박업소 조회
	 */
	public Accommodation getLdgByCode(String ldgCode) {
		return accommodationMapper.getLdgByCode(ldgCode);
	}
	/**
	 * 숙박업소 등록
	 */
	public void addAccommodation(Accommodation accommodation, MultipartFile[] accommodationImageFiles, String fileRealPath) {
		List<FileDto> fileList = fileUtil.parseFileInfo(accommodationImageFiles, fileRealPath);
		fileMapper.addFile(fileList);
		accommodationMapper.addAccommodation(accommodation);
		
		List<Map<String,String>> addFileControlList = new ArrayList<Map<String,String>>();
		
		Map<String , String> addMap = null;
		
		if(fileList != null) {
			for(FileDto fileDto : fileList) {
				addMap = new HashMap<String , String>();
				addMap.put("referenceCode", accommodation.getLdgCode());
				addMap.put("fileIdx", fileDto.getFileIdx());
				addFileControlList.add(addMap);
			}
		}
		
		fileMapper.addFileControl(addFileControlList);
	}
	
	/**
	 * 숙박업소  목록 조회
	 */
	public List<Accommodation> getAccommodationList(Map<String, Object> paramMap){
		List<Accommodation> accommodationList = accommodationMapper.getAccommodationList(paramMap);
		
		return accommodationList;
	}

	/**
	 * 숙박업소 정보 수정
	 */
	public int modifyAccommodation(Accommodation accommodation) {
		return accommodationMapper.modifyAccommodation(accommodation);
	}
	
	/**
	 * 숙박업소  정보 삭제
	 */
	public int removeAccommodation(String ldgCode) {
		int result = accommodationMapper.removeAccommodation(ldgCode);
		
		result += accommodationMapper.removeAccommodation(ldgCode);
		
		return result;
	}
}
