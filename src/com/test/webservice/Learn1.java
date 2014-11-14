package com.test.webservice;

/**
 * Created by Mu on 2014/11/13.
 */

import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.is;

public class Learn1 {

    String url = null;

    @BeforeClass
    public void setUp(){
        url = "http://www.weather.com.cn/data/cityinfo/101270101.html";
    }

    @Test(groups = { "json" })
    public void chengdu() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectBody("weatherinfo.cityid", is(101270101));
        ResponseSpecification responseSpec = builder.build();

        get(url).then().spec(responseSpec);

    }

    public static void main(String[] args) {
        String json = get("http://www.weather.com.cn/data/cityinfo/101270101.html").asString();
        JsonPath jsonPath = new JsonPath(json).setRoot("weatherinfo");
        jsonPath.prettyPrint();
        int cityId = jsonPath.getInt("cityid");
        System.out.println(cityId);
    }
}

