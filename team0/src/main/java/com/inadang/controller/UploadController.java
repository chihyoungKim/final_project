package com.inadang.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.inadang.domain.AttachFileDTO;
import com.inadang.domain.MenuAttach;
import com.inadang.service.MenuService;
import com.inadang.service.StoreService;

import lombok.extern.log4j.Log4j;
@Controller
@Log4j
public class UploadController {
	private static final String UPLOAD_FOLDER = "c:/photo";
	private MenuService menuService;
	private StoreService storeService;
	
	/**
	 * @author 김치형
	 * @param files
	 * @param model
	 * @param category
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@PostMapping("upload/{category}") @ResponseBody
	public List<AttachFileDTO> upload(MultipartFile[] files, Model model, @PathVariable int category) throws IllegalStateException, IOException {
		log.info("upload post");
		List<AttachFileDTO> list = new ArrayList<>();
		File uploadPath = new File(UPLOAD_FOLDER, getFolder(category));
		if(!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile multipartFile : files) {
			String origin = multipartFile.getOriginalFilename();
			
			String ext = "";
			if(origin.lastIndexOf(".") != -1) {
				ext = origin.substring(origin.lastIndexOf("."));
			}
			String uuid = UUID.randomUUID().toString() + ext;
			
			File file = new File(uploadPath, uuid);
			multipartFile.transferTo(file);
			
			AttachFileDTO dto = new AttachFileDTO(null, uuid, origin, getFolder(category), null);
			
			list.add(dto);
		}
		return list;
	}
	
	/**
	 * @author 김치형
	 * @param dto
	 * @return
	 */
	@GetMapping("display") @ResponseBody
	public ResponseEntity<byte[]> getFile(AttachFileDTO dto) {
		File file = new File(UPLOAD_FOLDER, dto.getPath() + "/" + dto.getUuid());
		
		ResponseEntity<byte[]> result = null;
		
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			result = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	/**
	 * @author 김치형
	 * @param dto
	 * @return
	 */
	@GetMapping("download") @ResponseBody
	public ResponseEntity<byte[]> download(AttachFileDTO dto) {
		log.info(dto);
		File file = new File(UPLOAD_FOLDER, dto.getPath() + "/" + dto.getUuid());
		
		ResponseEntity<byte[]> result = null;
		
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
			headers.add("Content-Disposition", "attachment; filename=" + new String(dto.getOrigin().getBytes("utf-8"), "iso-8859-1"));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			result = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	/**
	 * @author 김치형
	 * @param dto
	 * @return
	 */
	@PostMapping("deleteFile") @ResponseBody
	public String deleteFile(AttachFileDTO dto) {
		log.info(dto);
		
		File file = new File(UPLOAD_FOLDER, dto.getPath() + "/" + dto.getUuid());
		file.delete();
		if(dto.getPath().contains("menu")) {
			menuService.removeAttachByUuid(dto.getUuid());
		}
		else if(dto.getPath().contains("logo")) {
			storeService.deleteAttach(dto.getUuid());
		}
		
		return "success";
	}
	
	/**
	 * @author 김치형
	 * @param i
	 * @return
	 */
	private String getFolder(int i) {
		
		String type = "/";
		if(i == 1) {
			type += "logo";
		}
		else if(i == 2) {
			type += "menu";
		}
		else {
			type += "review";
		}
		return type;
	}
	
	/**
	 * @author 김치형
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private boolean isImage(File file) throws IOException {
		String mime = Files.probeContentType(file.toPath());
		
		if(mime == null || mime.equals("image/x-icon")) return false;
		return mime.startsWith("image");
	}

}
