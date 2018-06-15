package com.wmf.ArrangeWord;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrangeWord arrange = new ArrangeWord();
        
        String input = "baa019c";
        String result = arrange.arrangeWord(input);
        
        System.out.println("[ result : " + input + " -> " + result + " ]");
    }
}
