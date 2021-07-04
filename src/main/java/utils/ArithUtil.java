package utils;

import java.math.BigDecimal;

/**
 * @Author kaboso
 * @Date 2021/3/5
 */
public class ArithUtil {
    /**
     * 保留小数
     * @param number 操作数值
     * @param scale 保留几位小数
     * @return
     */
    public static Double keepDecimals(Double number, Integer scale) {
        return new BigDecimal(number).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
