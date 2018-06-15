package com.wmf.ArrangeWord;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrangeWord {
	private static final String REGEX = "^[\\d]*";
	
	public String validationWord(String word) {
		// word 유효성 체크
		// 영어/숫자만인지
		// 대소문자, 문장부호, 빈문자, null 체크 등
		
		return word;
	}
	
	public String sortWordAscending(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		
		//String sortedWord = new String(charArray);
		return new String(charArray);
	}
	
	public String combineWords(String integerWord, String characterWord) {
		int intWordLength = integerWord.length();
		int charWordLength = characterWord.length();
		
		// integerWord 과 characterWord 길이가 0인지 체크
		// 길이가 둘다 0일 때를 배재할 것인지?
		if(intWordLength == 0) {
			return characterWord;
		}
		
		if(charWordLength == 0) {
			return integerWord;
		}
		
		// 둘다 길이가 0이 아닐 때
		int tempLength = (intWordLength <= charWordLength) ? intWordLength : charWordLength;
		
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i<tempLength; i++) {
			builder.append(characterWord.charAt(i));
			builder.append(integerWord.charAt(i));
		}
		
		if(intWordLength < charWordLength) {
			builder.append(characterWord.substring(tempLength));
		} else if(intWordLength > charWordLength) {
			builder.append(integerWord.substring(tempLength));
		}
		
		return builder.toString();
		
	}
	
	
	public String arrangeWord(String word) {
		//String input = "baa019c";
		
		// 유효한 타입인지 체크하는 메소드
		String validatedWord = validationWord(word);
		
		// 단어 소팅
		String sortedWord = sortWordAscending(validatedWord);
		
		//System.out.println(sortedWord);
		
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(sortedWord);
		
		int start = 0;
		int end = 0;
		
		if(matcher.find()) {
			start = matcher.start();
			end = matcher.end();
			//System.out.println("=== matcher start : " + start + " / end : " + end);
		}
		
		String integerWord = sortedWord.substring(0, end);
		String characterWord = sortedWord.substring(end);
		
		//System.out.println(intString);
		//System.out.println(charString);
		
		
		
		// 단어 조합
		
		String result = combineWords(integerWord, characterWord);
		
		System.out.println("[ result : " + result + " ]");
		
		return result;
	}
}
