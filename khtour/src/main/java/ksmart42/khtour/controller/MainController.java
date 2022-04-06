package ksmart42.khtour.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ksmart42.khtour.service.FileService;
import ksmart42.khtour.dto.FileDto;

@Controller
public class MainController {

	private FileService fileService;
	
	public MainController(FileService fileService) {
		this.fileService = fileService;
	}
	@GetMapping("/")
	public String main(Model model) {
		
		model.addAttribute("title", "메인 화면 이동");
		
		return "main";
	}
	
	
	@GetMapping("/file/upload")
	public String archiveUpload(Model model) {
		
		model.addAttribute("title", "파일 업로드 폼");
				
		return "file/uploadView";
	}
	@PostMapping("/file/upload")
	public String archiveUpload(@RequestParam MultipartFile[] uploadfile, Model model, HttpServletRequest request) {
		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)) {				
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		fileService.fileUpload(uploadfile, fileRealPath);
		
		return "redirect:/";
	}
	
	@GetMapping("/file/downloadView")
	public String archiveDownloadView(Model model) {
		model.addAttribute("title", "파일 리스트");
		model.addAttribute("fileList", fileService.getFileList());
		return "file/downloadView";
	}
	
	@RequestMapping("/file/download")
	@ResponseBody
	public ResponseEntity<Object> archiveDownload(@RequestParam(value="fileIdx", required = false) String fileIdx
												   ,HttpServletRequest request
												   ,HttpServletResponse response) throws URISyntaxException{
		
		String serverName = request.getServerName();
		
		
		if(fileIdx != null) {
			FileDto fileDto = fileService.getFileInfoByIdx(fileIdx);
			File file;
			if("localhost".equals(serverName)) {				
				file = new File(System.getProperty("user.dir") + "/src/main/resources/static/"+ fileDto.getFilePath());
			}else {
				file = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/") + fileDto.getFilePath());
			}
		
			Path path = Paths.get(file.getAbsolutePath());
	        Resource resource;
			try {
				resource = new UrlResource(path.toUri());
				String contentType = null;
				contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
				if(contentType == null) {
					contentType = "application/octet-stream";
				}
				return ResponseEntity.ok()
						.contentType(MediaType.parseMediaType(contentType))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncoder.encode(fileDto.getFileOriginalName(),"UTF-8") + "\";")
						.body(resource);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		URI redirectUri = new URI("/");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(redirectUri);
		
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}
}