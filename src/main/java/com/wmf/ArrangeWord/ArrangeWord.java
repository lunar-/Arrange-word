package com.wmf.ArrangeWord;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class ArrangeWord {
	private static final String REGEX_INTEGER_AND_LOWER_CASE = "^[a-z0-9]*$";
	private static final Pattern PATTERN = Pattern.compile("^[\\d]*");
	
	public String arrangeWord(String word) {
		// 유효한 타입인지 체크하는 메소드
		String validatedWord = validationWord(word);
		
		// 단어 소팅
		String sortedWord = sortWordAscending(validatedWord);
		
		Matcher matcher = PATTERN.matcher(sortedWord);
		
		int integerWordLastIndex = 0;
		if(matcher.find()) {
			integerWordLastIndex = matcher.end();
		}
		
		String integerWord = sortedWord.substring(0, integerWordLastIndex);
		String characterWord = sortedWord.substring(integerWordLastIndex);
		
		// 단어 조합
		String result = combineWords(integerWord, characterWord);
		
		return result;
	}
	
	
	
	private String validationWord(String word) {
		// 빈값 체크
		if(StringUtils.isBlank(word)) {
			throw new IllegalArgumentException();
		}
		
		// 소문자, 숫자만인지
		if(!Pattern.matches(REGEX_INTEGER_AND_LOWER_CASE, word)){
			throw new IllegalArgumentException();
		}
		
		return word;
	}
	
	private String sortWordAscending(String word) {
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		
		return new String(charArray);
	}
	
	private String combineWords(String integerWord, String characterWord) {
		int integerWordLength = integerWord.length();
		int characterWordLength = characterWord.length();
		
		// integerWord 과 characterWord 길이가 0인지 체크
		if(integerWordLength == 0) {
			return characterWord;
		}
		
		if(characterWordLength == 0) {
			return integerWord;
		}
		
		// 둘다 길이가 0이 아닐 때
		int tempLength = (integerWordLength <= characterWordLength) ? integerWordLength : characterWordLength;
		
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i<tempLength; i++) {
			builder.append(characterWord.charAt(i));
			builder.append(integerWord.charAt(i));
		}
		
		if(integerWordLength < characterWordLength) {
			builder.append(characterWord.substring(tempLength));
		} else if(integerWordLength > characterWordLength) {
			builder.append(integerWord.substring(tempLength));
		}
		
		return builder.toString();
		
	}
	
	
	
}
