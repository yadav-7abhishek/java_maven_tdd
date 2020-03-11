package org.agileguru.baby.controller;

import static io.restassured.RestAssured.when;

import org.agileguru.baby.BabyDeemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = BabyDeemoApplication.class)
public class DefaultControllerRestAssuredTest {

    @Value("${local.server.port}")
    private int port;
    private String url;

    @Before
    public void setUp() throws Exception {
        url = "http://localhost:" + port + "/baby";
    }

    @Test
    public void testDefaultContoller() {
        when().get(this.url).then().assertThat().statusCode(HttpStatus.OK.value());
    }

}
