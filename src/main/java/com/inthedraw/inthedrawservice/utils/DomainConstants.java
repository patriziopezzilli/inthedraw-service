package com.inthedraw.inthedrawservice.utils;

import com.inthedraw.inthedrawservice.controller.RaffleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DomainConstants {
    static Logger logger = LoggerFactory.getLogger(DomainConstants.class);

    public static final String RAFFLE_STATUS_OPEN = "OPEN";

    public static final String USER_STATUS_ACTIVE = "ACTIVE";
    public static final String USER_STATUS_BANNED = "BANNED";
    public static final String USER_STATUS_DELETED = "DELETED";

    public static final String USER_ROLE_CUSTOMER = "CUSTOMER";
    public static final String USER_ROLE_ADMIN = "ADMIN";

    public static String getTodayDate(String date) throws ParseException {
        Locale locale = new Locale("en", "US");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        Date dateToCheck = dateFormat.parse(date);
        logger.info("> validate date " + dateToCheck.toString());
        return dateFormat.format(dateToCheck);
    }

    public static String getSimpleTodayDate() throws ParseException {
        Locale locale = new Locale("en", "US");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        return dateFormat.format(new Date());
    }
}
