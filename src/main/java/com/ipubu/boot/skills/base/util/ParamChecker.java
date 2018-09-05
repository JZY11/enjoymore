package com.ipubu.boot.skills.base.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/**
 * @ClassName ParamChecker
 * @Description	  
 * @Author jzy
 */
public class ParamChecker {

    private ParamChecker() {
        throw new IllegalStateException("this is Utility class ,can't construction.");
    }

    /**
     * 检查参数有效性（单个）
     * 
     * @param para
     * @return 若该参数有效，返回TRUE；否则返回FALSE
     */
    public static boolean isValidPara(String para) {
        return !(para == null || para.length() == 0);
    }

    /**
     * 检查参数有效性（单个）
     * 
     * @param para
     * @return 若该参数无效，如果无效返回TRUE；否则返回FALSE
     */
    public static boolean isInvalidPara(String para) {
        return (para == null || para.length() == 0);
    }

    /**
     * 检查参数有效性（单个）
     * 
     * @param para
     * @return 若该参数无效，如果无效返回TRUE；否则返回FALSE
     */
    public static boolean isInvalidPara(Object para) {
        return (para == null);
    }

    public static boolean isValidPara(int para) {
        return (para != Integer.MIN_VALUE);
    }

    public static boolean isValidPara(long para) {
        return (para != Long.MIN_VALUE);
    }

    public static boolean isValidPara(double para) {
        return (para != Double.MIN_VALUE);
    }

    public static boolean isValidDatePara(long para) {
        return !(para == Long.MIN_VALUE || para == -1 || para == 0);
    }

    public static boolean isNull(String para) {
        return (para == null || para.length() == 0);
    }

    public static boolean isEmpty(Collection<?> c) {
        return (c == null || c.isEmpty());
    }

    public static boolean isNotEmpty(Collection<?> c) {
        return !(c == null || c.isEmpty());
    }

    public static boolean isEmptyMap(Map<?, ?> m) {
        return (m == null || m.isEmpty());
    }

    public static boolean isNotEmptyMap(Map<?, ?> m) {
        return !(m == null || m.isEmpty());
    }

    public static boolean isNull(Object para) {
        return para == null;
    }

    public static boolean isNotNull(Object para) {
        return para != null;
    }

    public static boolean verify(String source, Set<String> paraNames) {

        if (source == null || source.isEmpty()) {
            return false;
        }
        boolean check = true;
        for (String name : paraNames) {
            check = source.contains(name);
        }
        return check;
    }
}
