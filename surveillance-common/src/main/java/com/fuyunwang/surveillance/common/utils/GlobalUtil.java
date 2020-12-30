package com.fuyunwang.surveillance.common.utils;

import com.fuyunwang.chuoyue.common.base.GlobalConstant;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;

/**
 * @description:
 * @author: FuyunWang
 * @time: 2020/7/23 18:25
 */
public class GlobalUtil {

    public static Map<String,Object> data(Object ...objects){
        Map<String,Object> data= Maps.newHashMap();
        if (ArrayUtils.isEmpty(objects)){
            return data;
        }
        if (objects.length>1){
            for (int i = 0; i < objects.length; i++) {
                data.put("message-"+(i+1),objects[i]);
            }
        }
        data.put(GlobalConstant.TOAST_MESSAGE,objects[0]);
        return data;
    }
}
