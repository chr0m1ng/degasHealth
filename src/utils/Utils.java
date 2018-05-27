/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author eeeeeeeeeeeeeeeeeeee
 */
public class Utils {
    /***
     * Search for special characters on string
     * @param string
     * @return -1 if doens't have any special char or position of special char
     */
    public static int findSpecialChar(String string) 
    {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(!Character.isLetter(chars[i]) && !Character.isWhitespace(chars[i])) {
                return i;
            }
        }
        return -1;
    }
}
