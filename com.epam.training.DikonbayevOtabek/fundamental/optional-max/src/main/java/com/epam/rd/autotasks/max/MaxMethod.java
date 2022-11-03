package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        if (values == null || values.length == 0){
            return OptionalInt.empty();
        }
        int max = values[0];
        for(int i = 0; i < values.length; ++i){
            if(max < values[i]){
                max = values[i];
            }
        }
        OptionalInt result = OptionalInt.of(max);
        return result;
    }
}
