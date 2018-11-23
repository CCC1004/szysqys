package cn.stylefeng.guns.modular.szys.utils;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: superC
 * @Date: 2018/11/22 13:21
 */
public class GuidUtils {

    /**
     * 获取uuid（32位）
     * @return
     */
    public static String getGuid(){
        String guid = UUID.randomUUID().toString().replaceAll("-", "");
        return guid;
    }

    /**
     * 获取系统当前时间
     */
    public static Date getCreateTime(){
        Date date = new Date();
        return date;
    }

}
