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
public class DateUtils {
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
    
}
