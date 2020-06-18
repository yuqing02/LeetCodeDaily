import common.model.User;

import javax.xml.crypto.Data;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws ParseException {
//        int rev = 964632435 * 10 +1;
//        System.out.println(rev);

//        String xx = "CMSCCM";
////
////        String ss = xx.replaceAll("CM", "");
////        int num = (xx.length() - ss.length()) / 2;
////        System.out.println(num);
////
////        List<User> userList = Arrays.asList(
////                User.builder().id(1).name("sss").build(),
////                User.builder().id(2).name("www").build(),
////                User.builder().id(2).name("qqq").build(),
////                User.builder().id(3).name("wqqq").build()
////        );
////        Map<Integer,List<String>> ww = userList.stream().collect(Collectors.toMap(User::getId,
////                e -> Arrays.asList(e.getName()),
////                (List<String> oldList, List<String> newList) -> {
////                    oldList.addAll(newList);
////                    return oldList;
////                }));
////
////        System.out.println(ww);


//        String time = getPastDate(2);
//        List<String> time = getDateAfterSevenDays("2020-01-01", 7);
        Long curTime = System.currentTimeMillis();

//        String format = "HH:mm:ss";
//
//        String keyOfCreateTime =  new SimpleDateFormat(format).format(curTime);
//
//
//        Date nowTime = new SimpleDateFormat(format).parse(keyOfCreateTime);
////        Date nowTime = new Date(curTime);
//        Date startTime = new SimpleDateFormat(format).parse("09:00:00");
//        Date endTime = new SimpleDateFormat(format).parse("21:00:00");
//        System.out.println(isEffectiveDate(nowTime, startTime, endTime));
//        System.out.println(time);

//        List<String> times = getDateAfterNDays("2020-03-25",1);

        String xx = "\\x1f\\x8b\\b\\x00\\x00\\x00\\x00\\x00\\x00\\x03\\xbdQ\\xdbn\\x85 \\x10\\xfc\\x97}j\\x13\\x1e@.\\xa2\\xbfrh\\f\\nD\\xd2s\\xd4pic\\x9a\\xfe{W=I\\xfb\\x05}\\xd9\\f\\xb3\\xb33\\xb0|At\\xd03&\\x95\\x10\\x04ʾ\\xf9\\f\\xfd\\x8d\\xbf\\x11\\x98V\\xe7\\xa1\\a \\xb0\\xd8ǁL\\x15\\x9eZS\\x95k[S\\xa5\\xa7\\x8d\\xa9\\x9d\\f\\xd2T\\xadń\\f\\xe7\\xd8m%\\xa7\\x88\\x95wX;\\xa6\\x0e\\x1c\\x10\\xeb\\xf1d&\\x1a\\xb0\\x8eJ\\xbd\\xe0\\xb0\\b\\xd8\\xee\\xe8\\xd1V\\xbaa\\x97\\xc5+&\\xdaqL\\xff\\x9cx\\x8f6_ϵ\\xce%\\x9f\\xf3\\x99\\u007fI\\xafd\\xed|\\x10\\\\\\xebc(\\xb4(\\xcc\\xf3\\x9a\\xca\\xf0+Gj\\xfd\\\\|\\xcasܠ\\xa7\\xd7:\\x87\\xbc\\xe7\\xe2\\x1f\\xe7\\xd9\\xe7b\\xc7{\\xcc\\xf3P\\xe2\\xb1R\\xa4\\xa6X\\xf6\\xe1\\xfc\\x02\\xca\\b\\xb8\\x98K\\x8aSy2\\xb4\\xfbC%\\xbb\\xbc\\x9f#hR*\\xe65\\x04\\xea\\xe6l\\xf1O7&\\xb5Ԋ7\\\\\\x12\\xf8\\xc0[\\xc4uA\\xfd\\xf7\\x0f\\x0f\\xabc\\x1a\\xe2\\x01\\x00\\x00";

        System.out.println(xx.toString());

         DecimalFormat df = new DecimalFormat("#.##");

        Long price = 7600000L;
        double pp = Double.parseDouble(price.toString())/10000;
        String ss = df.format(pp);

        System.out.println(ss);

    }

    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
    public static String getPastDate(int past) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        try {
            Date date = df.parse("2020-12-01");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
            Date today = calendar.getTime();
            String result = df.format(today);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";

    }


    public static List<String> getDateAfterSevenDays(String dateTime, int days) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

        List<String> dates = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        String[] dateTimeArray = dateTime.split("-");
        int year = Integer.parseInt(dateTimeArray[0]);
        int month = Integer.parseInt(dateTimeArray[1]);
        int day = Integer.parseInt(dateTimeArray[2]);
        calendar.set(year, month - 1, day);
        long time = calendar.getTimeInMillis();// 给定时间与1970 年 1 月 1
        // 日的00:00:00.000的差，以毫秒显示

        for (int i = 0; i < days; i++) {
            calendar.setTimeInMillis(time - i * 1000 * 60 * 60 * 24);// 用给定的

            int monthR = (calendar.get(Calendar.MONTH) + 1);
            int dayR = calendar.get(Calendar.DAY_OF_MONTH);

            String outMonth = (monthR / 10 > 0) ? String.valueOf(monthR) : ("0" + monthR);
            String outDay = (dayR / 10 > 0) ? String.valueOf(dayR) : ("0" + dayR);

            dates.add(calendar.get(Calendar.YEAR)
                    + outMonth
                    + outDay);
        }

        // long值设置此Calendar的当前时间值
        return dates;
    }



    public static List<String> getDateAfterNDays(String dateTime, int days) {
        List<String> dates = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        String[] dateTimeArray = dateTime.split("-");
        int year = Integer.parseInt(dateTimeArray[0]);
        int month = Integer.parseInt(dateTimeArray[1]);
        int day = Integer.parseInt(dateTimeArray[2]);
        calendar.set(year, month - 1, day);
        long time = calendar.getTimeInMillis();

        for (int i = 0; i < days; i++) {
            calendar.setTimeInMillis(time - i * 1000 * 60 * 60 * 24);

            int monthR = (calendar.get(Calendar.MONTH) + 1);
            int dayR = calendar.get(Calendar.DAY_OF_MONTH);

            String outMonth = (monthR / 10 > 0) ? String.valueOf(monthR) : ("0" + monthR);
            String outDay = (dayR / 10 > 0) ? String.valueOf(dayR) : ("0" + dayR);

            dates.add(calendar.get(Calendar.YEAR)
                    + outMonth
                    + outDay);
        }

        return dates;
    }

}
