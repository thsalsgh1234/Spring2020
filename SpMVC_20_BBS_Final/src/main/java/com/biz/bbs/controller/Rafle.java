package com.biz.bbs.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rafle {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();

		
		for(int i = 0 ; i < 10 ; i++) {
			Collections.shuffle(names);
		}

		System.out.println(names.toString());
		
		
		
	}
	
}
