package com.test.webservice;

/**
 * Created by Mu on 2014/11/13.
 */

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Learn1 {
    public static void main(String[] args) {
        System.out.println("test");
        get("http://www.weather.com.cn/data/cityinfo/101010100.html").then().body("weatherinfo.cityid", equalTo(101010100));
        System.out.println("test");

    }
}

