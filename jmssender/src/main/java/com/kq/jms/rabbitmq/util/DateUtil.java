package com.kq.jms.rabbitmq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtil
 *
 * @author kq
 * @date 2018-12-18
 */
public class DateUtil {

    public static String formatDateTime() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return f.format(new Date());


    }

}
