package org.rajesh;

import java.text.*;
import java.util.*;

public class DateFormatter {

    public String formatDate(String inputDate) throws ParseException{
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);

    }
}
