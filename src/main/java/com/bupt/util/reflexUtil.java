package com.bupt.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class reflexUtil {
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            return method.invoke(o, new Object[] {});
        } catch (Exception e) {
            //   log.error(e.getMessage(),e);
            return null;
        }
    }

    public static List<Field> getAllField(Class<?> class1){
        List<Field> list= new ArrayList();
        while (class1!= Object.class){
            list.addAll(Arrays.stream(class1.getDeclaredFields()).collect(Collectors.toList()));
            //获取父类
            class1=class1.getSuperclass();
        }
        return list;
    }
}
