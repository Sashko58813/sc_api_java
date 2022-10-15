package com.sidecarhealth.microservice.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

@SuppressWarnings("all")
public class DateUtils {

    //Substract year(s) from current date using date format yyyy-MM-dd. Genearte date of birth based on age. (Example: 2018-04-25)
    public static String subtractYearsYYYYMMDD(int age) {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Timestamp dateOfBirth = Timestamp.valueOf(LocalDateTime.now().minusYears(age));
        return dateFormat.format(dateOfBirth);
    }

    //Add year(s) to current date using date format yyyy-MM-dd'T'HH:mm:ss.SSS'Z'. Genearte date of birth based on age. (Example: 2018-04-25T14:05:15.953Z)
    public static String addYearsYYYYMMDD(int years) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Timestamp dateOfBirth = Timestamp.valueOf(LocalDateTime.now().plusYears(years));
        return dateFormat.format(dateOfBirth);
    }

    //Add day(s) to current date using date format yyyy-MM-dd'T'HH:mm:ss.SSS'Z' (Example: 2018-04-25T14:05:15.953Z)
    public static String addDaysYYYYMMDDHHMMSSSSSZ(int days) {
        DateTimeFormatter dateFormatStartDate = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime dateandtimenow = LocalDateTime.now().plusDays(days);
        return dateandtimenow.format(dateFormatStartDate);

    }

    //Add year(s) to current date using date format yyyy-MM-dd'T'HH:mm:ss.SSS'Z (Example: 2018-04-25T14:05:15.953Z)
    public static String addYearsYYYYMMDDHHMMSSSSSZ(int year) {
        DateTimeFormatter dateFormatStartDate = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime dateandtimenow = LocalDateTime.now().plusYears(year);
        return dateandtimenow.format(dateFormatStartDate);
    }

    //Get current date using date format yyyy-MM-dd'T'HH:mm:ss.SSS'Z (Example: 2018-04-25T14:05:15.953Z)
    public static String currentDateYYYYMMDDHHMMSSSSSZ() {
        DateTimeFormatter dateFormatStartDate = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime dateandtimenow = LocalDateTime.now();
        return dateandtimenow.format(dateFormatStartDate);
    }

    //Get current date using date format yyyy-MM-dd'T'HH:mm:ss.SSS'Z (Example: 2018-04-25)
    public static String getStartOfNextMonthYYYYMMDDHHMMSSSSSZ() {
        DateTimeFormatter dateFormatStartDate = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        LocalDateTime dateandtimenow = LocalDateTime.now().with(TemporalAdjusters.firstDayOfNextMonth());
        return dateandtimenow.format(dateFormatStartDate);
    }
}
