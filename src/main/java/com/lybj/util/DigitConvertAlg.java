package com.lybj.util;

/**
 * 数字转换算法
 *
 * @author gongwq
 * @create 2017-12-11 9:49
 */
public class DigitConvertAlg {
    //62机制转换数组
    private static final String[] _62_CONVERT_ARR = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    /**
     * 10进制数字转换为指定长度[lenght]的62进制数，不足长度补充0
     *
     * @param numberWith10
     * @param length
     * @return
     */
    public static String parse10To62(long numberWith10, int length) {
        StringBuilder sb = new StringBuilder();
        //计算各个位数上的数字
        while (numberWith10 != 0) {
            sb.append(_62_CONVERT_ARR[(int) ((numberWith10 % 62))]);
            numberWith10 /= 62;
        }
        //逆序输出并高位补充0
        StringBuilder result = new StringBuilder();
        for (int len = length - sb.length(); len > 0; len--) {
            result.append("0");
        }
        for (int len = sb.length() - 1; len >= 0; len--) {
            result.append(sb.charAt(len));
        }
        return result.toString();
    }

    /**
     * 62进制数字转换为指定10进制数
     *
     * @param numberWith62
     * @param length       format长度
     * @return
     */
    public static String parse62To10(String numberWith62, int length) {
        if (!numberWith62.matches("\\w+") || length <= 0) {
            throw new IllegalArgumentException(numberWith62 + " is valid");
        }
        int decimal = 0;
        int base = 62;
        int keisu = 0;
        int cnt = 0;

        byte ident[] = numberWith62.getBytes();
        for (int i = ident.length - 1; i >= 0; i--) {
            int num = 0;
            if (ident[i] > 48 && ident[i] <= 57) {
                num = ident[i] - 48;
            } else if (ident[i] >= 65 && ident[i] <= 90) {
                num = ident[i] - 65 + 10 + 26;
            } else if (ident[i] >= 97 && ident[i] <= 122) {
                num = ident[i] - 97 + 10;
            }
            keisu = (int) Math.pow((double) base, (double) cnt);
            decimal += num * keisu;
            cnt++;
        }

        return String.format("%0" + length + "d", decimal);
    }

    public static void main(String[] args) {
        long num1 = 0;
        long num2 = 99;
        long num3 = 100;
        long num4 = 555;
        long num5 = 2804;
        long num6 = 2904;
        long num7 = 3324;
        long num8 = 3824;

        System.out.println(parse10To62(num1, 2));

    }

}
