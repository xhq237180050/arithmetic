package com.xuhq.arithmetic.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum CountryEnum {

    ONE(1,"齐"),
    TWO(2,"楚"),
    THREE(3,"燕"),
    FOUR(4,"赵"),
    FIVE(5,"魏"),
    SIX(6,"韩");

    private Integer retCode;
    private String name;

    public static CountryEnum for_counntryEnum(Integer index){

        CountryEnum[] values = CountryEnum.values();

        for (CountryEnum value : values) {

            if (value.retCode.equals(index)){

                return value;
            }
        }
        return null;
    }




}
