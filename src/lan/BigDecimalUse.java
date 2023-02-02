package lan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalUse {
    public static void main(String[] args) {
        // 创建使用字符串保证不丢失精度
        BigDecimal bigDecimal = new BigDecimal("0.333");
        BigDecimal bigDecimal1 = BigDecimal.valueOf(0.333);

        // 转换
        System.out.println(bigDecimal.toString()); // 有肯能使用科学计数法
        System.out.println(bigDecimal.toPlainString());

        // 格式化
        NumberFormat numberFormater = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat percentFormater = NumberFormat.getPercentInstance(Locale.CHINA);
        System.out.println(numberFormater.format(bigDecimal));
        System.out.println(percentFormater.format(bigDecimal));

        // divide 必须传入精度否则有可能是无限小数
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.3");
        System.out.println(a.divide(b, RoundingMode.HALF_UP));

        // BigDecimal比较 默认也比较精度是否一致
        BigDecimal c = new BigDecimal("0.10");
        BigDecimal d = new BigDecimal("0.1");
        System.out.println(c.equals(d));
        System.out.println(c.compareTo(d));
    }
}
