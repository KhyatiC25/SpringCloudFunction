package com.emp.d;

import java.util.function.Function;

public class Test implements Function<String, String> {
    @Override
    public String apply(String t) {
        return "Serverless Functional programming" + t;
    }
}
