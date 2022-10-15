package com.sidecarhealth.microservice.partner.partnercontroller.tests;

import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.partner.partnercontroller.api.PartnerController;
import com.sidecarhealth.microservice.partner.partnercontroller.dto.response.GetValidateEmail;
import com.sidecarhealth.microservice.partner.partnercontroller.dto.response.GetValidateUrl;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Log4j2
public class PartnerControllerTests extends BaseClass {
    PartnerController partnerController;

    @BeforeMethod
    public void setUpPartnerControllerTests() {
        partnerController = new PartnerController();
    }

    @Test
    public void validateTakenPartnerEmail() throws Exception {
        log.info("When: I provide used partner email");
        GetValidateEmail getValidateEmail = partnerController.validatePartnerEmail("partnerbrokerncj8gjpek40r@mailinator.com", 200);

        log.info("Then: I validate that email is taken.");
        Assert.assertEquals(getValidateEmail.getMessage(), "Email is taken.");
    }

    @Test
    public void validateValidAvailablePartnerEmail() throws Exception {
        log.info("When: I provide new partner email");
        GetValidateEmail getValidateEmail = partnerController.validatePartnerEmail("partnerbrokerncj8gasdasdasdjpek40r@mailinator.com", 200);

        log.info("Then: I validate that email is valid and available");
        Assert.assertEquals(getValidateEmail.getMessage(), "The email address is valid and available.");
    }

    @Test
    public void validateInvalidPartnerEmail() throws Exception {
        log.info("When: I provide invalid partner email");
        GetValidateEmail getValidateEmail = partnerController.validatePartnerEmail("partnerbrokerncj8gasdasdasdjpek40r", 200);

        log.info("Then: I validate that email is invalid");
        Assert.assertEquals(getValidateEmail.getMessage(), "Please enter a valid email address. email=partnerbrokerncj8gasdasdasdjpek40r");
    }

    @Test
    public void validateTakenPartnerUrl() throws Exception {
        log.info("When: I provide used partner url");
        GetValidateUrl getValidateUrl = partnerController.validatePartnerUrl("DMPC_Scranton", 200);

        log.info("Then: I validate that url is taken");
        Assert.assertFalse(getValidateUrl.getValid(), "'DMPC_Scranton' url slug is used for existing partner");
    }

    @Test
    public void validateValidPartnerUrl() throws Exception {
        log.info("When: I provide unused partner url");
        GetValidateUrl getValidateUrl = partnerController.validatePartnerUrl("hkjshfkjshfkhsfkjsnfnsdjkfnsdjkfnsfsdlasdasdasdasdasdasdk", 200);

        log.info("Then: I validate that url is available");
        Assert.assertTrue(getValidateUrl.getValid(), "'hkjshfkjshfkhsfkjsnfnsdjkfnsdjkfnsfsdlasdasdasdasdasdasdk' url slug ");

    }


}
