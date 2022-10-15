package com.sidecarhealth.microservice.baseclass;

import com.beust.jcommander.Strings;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static io.restassured.RestAssured.baseURI;

@SuppressWarnings("all")
@Log4j2
public class BaseClass {

    public static String adminUsername = "oali@sidecarhealth.com";
    public static String adminPassword = "Test1234!";

    public static String XAPIKEY = "oI5tqK1SFkbSIO2GVnamiiNaC";

    public ObjectMapper objectMapper = new ObjectMapper();

    // API BASE URI
    protected final String authentiationBaseUri = baseURI + "/auth/v1";
    protected final String careBaseUri = baseURI + "/care/v1";
    protected final String doctorBaseUri = baseURI + "/doc/v2";
    protected final String partnerBaseUri = baseURI + "/ptnr/v1";
    protected final String expenseBaseUri = baseURI + "/exp/v1";

    @BeforeSuite()
    @Parameters("env")
    public void setup(@Optional("qa") String env) {
        if (env.equalsIgnoreCase(("qa")) || env.equals(" ")) {
            RestAssured.baseURI = "https://qa-api.sidecarhealth.com";
            System.setProperty("test.env", "qa");
        } else if (env.equalsIgnoreCase(("hotfix"))) {
            RestAssured.baseURI = "https://hotfix-api.sidecarhealth.com";
            System.setProperty("test.env", "hotfix");
        } else if (env.equalsIgnoreCase(("dev"))) {
            RestAssured.baseURI = "https://dev-api.sidecarhealth.com";
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

    public void validateResponse(Response response, int expectedStatusCode, String description) throws Exception {
        val resStatusCode = response.statusCode();
        val resBody = "Response:\n" + response.getBody().asString();
        if (resStatusCode == expectedStatusCode) {
            log.info(description + " returns " + expectedStatusCode + " as expected");
            log.info(resBody);
        } else {
            log.error(description + " returns " + resStatusCode + " is not expected");
            log.error(resBody);
            throw new Exception(resStatusCode + " is not expected");
        }
    }

    public void addNonEmptyStringQueryParam(RequestSpecification specification, String key, String value) {
        if (!Strings.isStringEmpty(value)) {
            specification.queryParam(key, value);
        }
    }

    public void addNonNullBooleanQueryParam(RequestSpecification specification, String key, Boolean value) {
        if (value != null) {
            specification.queryParam(key, value);
        }
    }

    public void addNonNegativeIntegerQueryParam(RequestSpecification specification, String key, int value) {
        if (value >= 0) {
            specification.queryParam(key, value);
        }
    }

    public void addNonNegativeNumberQueryParam(RequestSpecification specification, String key, double value) {
        if (value >= 0) {
            specification.queryParam(key, value);
        }
    }

    public void addNonNullStringArrayQueryParam(RequestSpecification specification, String key, String[] value) {
        if (value != null) {
            specification.queryParam(key, value);
        }
    }
}
