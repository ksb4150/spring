package com.spring.pro28.ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	private static final String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	
	public FileUploadController() {
		System.out.println("FileUploadController 객체 생성");
	}
	
	@RequestMapping(value="/form")
	public String form() {
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map map = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		
		
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
				System.out.println(name);
			String value = multipartRequest.getParameter(name);
				map.put(name, value);
		}
		
		List fileList = fileProcess(multipartRequest);
			map.put("fileList", fileList);
		ModelAndView mav = new ModelAndView();
			mav.addObject("map", map);
			mav.setViewName("result");
			
		return mav;
	}
	
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception {
		System.out.println("fileProcess 함수 호출 ");
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
					System.out.println("fileName : "+fileName);
			MultipartFile mFile = multipartRequest.getFile(fileName); //getFile() 메소드는 서버 상에 업로드된 파일에 대한 파일 객체를 반환
					System.out.println("mFile : " + mFile);
			String originalFileName = mFile.getOriginalFilename();
					System.out.println("originalFileName : " + originalFileName);
				fileList.add(originalFileName);
			File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
			
			if(mFile.getSize()!=0) {
				if(! file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH +"\\"+originalFileName));
			}
		}
		
		return fileList; //file의 원래 이름
	}
}
