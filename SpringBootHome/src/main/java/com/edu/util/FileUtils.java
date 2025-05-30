package com.edu.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.edu.freeBoard.controller.FreeBoardController;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUtils")
public class FileUtils {

	private static final String filePath = "C:\\upload";
	
	public List<Map<String, Object>> parseInsertFileInfo(int parentId,
		MultipartHttpServletRequest mhr) throws Exception{
		
		Iterator<String> iterator = mhr.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
		Map<String, Object> fileInfoMap = null;
		
		File file = new File(filePath);
		
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = mhr.getFile(iterator.next());
		//	
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(
					originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() 
					+ originalFileExtension;
				
				file = new File(filePath, storedFileName);
				multipartFile.transferTo(file);
				
				fileInfoMap = new HashMap<>();
				fileInfoMap.put("parentId", parentId);
				fileInfoMap.put("originalFileName", originalFileName);
				fileInfoMap.put("storedFileName", storedFileName);
				fileInfoMap.put("fileSize", multipartFile.getSize());
				
				fileList.add(fileInfoMap);
			}
		}
		
		return fileList;
	}

	public void parseDeleteFileInfo(List<Map<String, Object>> tempFileList) 
		throws Exception{
		// TODO Auto-generated method stub
	
		for (Map<String, Object> tempFileMap : tempFileList) {
			String storedFileName = (String)tempFileMap.get("STORED_FILE_NAME");
			
			File file = new File(filePath + "/" + storedFileName);
			
			if(file.exists()) {
				file.delete();
			}else {
				System.out.println("파일이 존재하지 않습니다.");
			}
		}
		
	}
}
