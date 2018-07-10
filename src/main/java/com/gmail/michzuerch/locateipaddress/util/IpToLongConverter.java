package com.gmail.michzuerch.locateipaddress.util;

/**
 * Created with IntelliJ IDEA.
 * User: michzuerch
 * Date: 10.11.12
 * Time: 23:29
 * <p>
 * Utility zum Konvertieren einer IP-Adresse zu einem Long-Wert
 */
public class IpToLongConverter {

    public static Long IptoLong(String val) {
        String[] splitString = val.split("\\.");
        int o1 = Integer.valueOf(splitString[0]);
        int o2 = Integer.valueOf(splitString[1]);
        int o3 = Integer.valueOf(splitString[2]);
        int o4 = Integer.valueOf(splitString[3]);

        System.out.print("o1:" + o1);
        System.out.print("o2:" + o2);
        System.out.print("o3:" + o3);
        System.out.print("o4:" + o4);

        Long result = (o1 * 16777216L) + (o2 * 65536) + (o3 * 256) + (o4);
        return result;

    }

    public static String LongToIp(Long val) {
        Long o1 = (val / 16777216L) % 256;
        Long o2 = (val / 65536) % 256;
        Long o3 = (val / 256) % 256;
        Long o4 = (val) % 256;
        String result = o1 + "." + o2 + "." + o3 + "." + o4;

        return result;
    }

}
