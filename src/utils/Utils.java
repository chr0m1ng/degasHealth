/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
    public static boolean validateDate(String dateToValidate) throws Exception
    {
        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);

        } catch (ParseException e) {

            return false;
        }

        return true;
    }
    
    public static Date createDateFromString(String date) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(date);
    }
    
    public static String formatDateBR(Date date)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);
    }
    
    public static boolean isStringInteger(String input)
    {
       try
       {
          Integer.parseInt( input );
          return true;
       }
       catch(NumberFormatException ex)
       {
          return false;
       }
    }
}
