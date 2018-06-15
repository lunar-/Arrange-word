package com.wmf.ArrangeWord;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ArrangeWordTest {
	private ArrangeWord arrangeWord;
	
	@Before
	public void setUp() {
		arrangeWord = new ArrangeWord();
	}
	
	@Test
	public void testBasicWord() {
		assertEquals("a0a1a9a", arrangeWord.arrangeWord("aaa019a"));
		assertEquals("a0b9z", arrangeWord.arrangeWord("abz09"));
		assertEquals("abccz", arrangeWord.arrangeWord("abzcc"));
		assertEquals("00199", arrangeWord.arrangeWord("09019"));
		assertEquals("a0aaaa", arrangeWord.arrangeWord("aaaaa0"));
		assertEquals("a", arrangeWord.arrangeWord("a"));
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void testNull() {
		// null, 빈값, 공백문자 체크
		arrangeWord.arrangeWord(null);
		arrangeWord.arrangeWord("");
		arrangeWord.arrangeWord(" ");
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void testCapital() {
		arrangeWord.arrangeWord("aaa019aA");
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void testSpecialCharacter() {
		arrangeWord.arrangeWord("aaa019a!");
    }
	

}
