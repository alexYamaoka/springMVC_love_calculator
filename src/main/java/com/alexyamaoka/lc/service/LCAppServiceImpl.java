package com.alexyamaoka.lc.service;

import org.springframework.stereotype.Service;


@Service
public class LCAppServiceImpl implements LCAppService {

	public final String LC_APP_FORMULA = "FLAME";
	
	
	@Override
	public String calculateLove(String username, String crushName) {
		
		String name = username + crushName;
		int charCount = name.length();
		int formulaCount = LC_APP_FORMULA.length();
		
		int index = charCount % (formulaCount);
		
		if (index != 0) {
			index -= 1;
		}
		
		char result = LC_APP_FORMULA.charAt(index);
		
		String relation = matchResult(result);
		
		return relation;
	}


	@Override
	public String matchResult(char result) {
		
		String relation = null;
		
		switch (result) {
		case 'F':
			relation =  "FRIEND";
			break;
			
		case 'L':
			relation = "LOVE";
			break;
			
		case 'A':
			relation = "AFFECTION";
			break;
			
		case 'M':
			relation = "MARRIAGE";
			break;
			
		case 'E':
			relation = "ENEMY";
			break;

		default:
			System.out.println(">>> error within match result");
			break;
		}
		
		return relation;
	}
}
