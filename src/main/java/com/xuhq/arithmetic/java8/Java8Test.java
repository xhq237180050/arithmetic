package com.xuhq.arithmetic.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author :
 * create at:  2021-12-21  23:21
 * @description:
 */
public class Java8Test {

    public static void main(String[] args) {
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("xiaohua","18"));
        catList.add(new Cat("xiaobai","19"));
        String str = catList.stream().map(f -> f.getName().concat(":").concat(Optional.ofNullable(f.getAge()).orElse(""))).collect(Collectors.joining("|"));
        System.out.println(str);

        Cat cat = new Cat("xiaobai", "12");
        System.out.println(cat);
        update(cat);
        System.out.println(cat);

    }

    private static void update(Cat cat){
        cat = new Cat("xiaohong","16");
    }
}
