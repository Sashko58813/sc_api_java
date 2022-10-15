package com.sidecarhealth.microservice.baseclass;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@SuppressWarnings("all")
@Log4j2
public class ClientBaseClass {

    public String candorclientapikey = "rYXRJwLrLg7vnmaxWRd2";
    public String zenefitsclientapikey = "aPKI2lvU13QEP43qbd8W";
    public ObjectMapper objectMapper = new ObjectMapper();

    @BeforeSuite()
    @Parameters("env")
    public void setup(@Optional("qa") String env) {
        if (env.equalsIgnoreCase(("qa")) || env.equals(" ")) {
            RestAssured.baseURI = "https://qa-client-api.sidecarhealth.com/v1";
            System.setProperty("test.env", "qa");
        } else if (env.equalsIgnoreCase(("dev"))) {
            RestAssured.baseURI = "https://dev-client-api.sidecarhealth.com/v1";
            System.setProperty("test.env", "dev");
        }
        log.info("Base url: " + RestAssured.baseURI);
    }

    @AfterSuite()
    public void consolidateStatus(ITestContext context) {
        int total = context.getAllTestMethods().length;
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        log.info("Total number of testcases: " + total);
        log.info("Number of testcases PASSED: " + passed);
        log.info("Number of testcases FAILED: " + failed);
        log.info("Number of testcases SKIPPED: " + skipped);
    }
}
