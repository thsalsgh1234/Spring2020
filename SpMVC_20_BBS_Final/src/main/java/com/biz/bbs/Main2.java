package com.biz.bbs;

import java.util.ArrayList;
import java.util.List;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.service.FileReaderService;

public class Main2 {
	
	public static void main(String[] args) {
		
		FileReaderService fService = new FileReaderService();
		
		List<BBsVO> bbsList = fService.getBBsData();
		List<BBsVO> pList = fService.getMain(bbsList);
		
		List<BBsVO> prList = new ArrayList<BBsVO>();
		
		pList.forEach(vo->{
			prList.add(vo);
			prList.addAll(fService.getRepl(bbsList,vo));
		});
		prList.forEach(System.out::println);
		
	}
}

