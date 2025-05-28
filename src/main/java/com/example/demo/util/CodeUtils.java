package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeUtils {

    /*产生商品的编码*/
    public static String toItemCode() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return simpleDateFormat.format(new Date());
    }

    public static void main(String[] args) {
        String code = toItemCode();
        System.out.println(code);
    }
}

