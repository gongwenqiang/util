package com.lybj.base.jvm;

public class MyStringByteClass {
  
    public static void main(String[] args) {  
          
        String str = "中国abc";  
        System.out.println("字符串str长度为：" + str.length());//字符个数，不是字节的个数  
          
        byte[] bArr = str.getBytes();  
          
        int num = 1;  
        for(byte b : bArr) {

            System.out.println("第" + num + "个字节为：" + b);
            num++;
        }
          
        System.out.println("\n");  
        num = 1;  
          
        int len = str.length();  
        for(int i = 0; i < len; i++) {  
              
            System.out.println("第" + num + "个字符为：" + str.charAt(i));
            System.out.println("第" + num + "个字符字节数为：" + String.valueOf(str.charAt(i)).getBytes().length);
            num++;  
        }  
          
        //char c = '\u4E2D';  
        //int aa = (int)c;  
        //System.out.println(c);  
        //System.out.println(aa);//吻合  
    }  
}  