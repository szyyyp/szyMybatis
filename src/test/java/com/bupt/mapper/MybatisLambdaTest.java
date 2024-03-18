package com.bupt.mapper;

import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda;
import lombok.Data;

public class MybatisLambdaTest {
    @Data
    class Account {
        private int accountNumber;
        private String address;
    }

    public static void main(String[] args) {
        String s = lN(Account::getAddress);
        String acc = lN(Account::getAccountNumber);
        System.out.println(s);//address
        System.out.println(acc);//accountNumber
    }

    private static <T> String lN(SFunction<T, ?> func) {
        SerializedLambda resolve = LambdaUtils.resolve(func);
        String get = resolve.getImplMethodName().replace("get", "");
        get = get.substring(0, 1).toLowerCase() + get.substring(1);
        return get;
    }
}