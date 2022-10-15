package com.sidecarhealth.microservice.doctor.doctorcontroller.tests;

import com.sidecarhealth.microservice.authentication.api.UserController;
import com.sidecarhealth.microservice.authentication.dto.response.SessionDTO;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.doctor.doctorcontroller.api.DoctorController;
import com.sidecarhealth.microservice.doctor.doctorcontroller.data.DoctorControllerData;
import com.sidecarhealth.microservice.doctor.doctorcontroller.data.DoctorDetail1285716969;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorDTO;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorDetailResponse;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorResponse;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorSearchFilterResponse;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorSuggestResponse;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorsDetailRequest;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorsRequest;
import com.sidecarhealth.microservice.doctor.doctorcontroller.dto.DoctorsSuggestRequest;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.regex.Pattern;

import static com.sidecarhealth.microservice.authentication.dataproviders.AuthDataProviders.FI_IL_ACCOUNT1;

@Log4j2
@SuppressWarnings("all")
public class DoctorControllerTests extends BaseClass {
    UserController userController;
    DoctorController doctorController;
    DoctorControllerData doctorControllerData;

    @BeforeMethod
    public void setUpCareTests() {
        userController = new UserController();
        doctorController = new DoctorController();
        doctorControllerData = new DoctorControllerData();
    }

    @Test()
    public void doctorDavidWallisShowsUpInSearch() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: calling doctor endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        DoctorResponse doctorResponse = doctorController.doctors(DoctorsRequest.builder()
                        .page(0).size(20)
                        .lat(33.8409696).lon(-118.3520389).radius(8)
                        .query("David Wallas").city("Torrance").state("CA")
                        .build(),
                sessionDTO.getToken());
        softAssert.assertEquals(doctorResponse.getContent()[0].getFirstName(), "David",
                "firstName mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getLastName(), "Wallis",
                "lastName mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getGender(), "MALE",
                "gender mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getCredential(), "MD",
                "credential mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getAddresses()[0].getCity(), "Redondo Beach",
                "address city mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getAddresses()[0].getState(), "CA",
                "address state mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getAddresses()[0].getZip(), "90277",
                "address zipCode mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getAddresses()[0].getPhone(), "4244374700",
                "address phone mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getAddresses()[0].getFax(), "4244378884",
                "address fax mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getTaxonomies()[0].getUuid(), "taxon-608581a4-3e74-11ea-8b90-f45c89902a79",
                "taxonomy uuid mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getTaxonomies()[0].getLicense(), "A77627",
                "taxonomy license mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getTaxonomies()[0].getCode(), "207R00000X",
                "taxonomy code mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getTaxonomies()[0].getTitle(), "Internal Medicine",
                "taxonomy title mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getTaxonomies()[0].getState(), "CA",
                "taxonomy state mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getTaxonomies()[0].getSpecialty(), "Internal Medicine",
                "taxonomy specialty mismatch");
        softAssert.assertEquals(doctorResponse.getContent()[0].getTaxonomies()[0].getPrimary(), "true",
                "taxonomy primary mismatch");
        softAssert.assertAll();
    }

    @Test()
    public void doctor1285716969HasValidInfo() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: calling doctor detail with 1285716969");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        DoctorDetailResponse doctorDetailResponse = doctorController.doctorsDetail(DoctorsDetailRequest.builder()
                        .npi(1285716969)
                        .build(),
                sessionDTO.getToken());
        log.info("Then: Verify the data is valid");
        DoctorDetail1285716969 doc1285716969 = new DoctorDetail1285716969();
        softAssert.assertEquals(doctorDetailResponse.getNpi(), doc1285716969.npi,
                "npi mismatch");
        softAssert.assertEquals(doctorDetailResponse.getFirstName(), doc1285716969.firstName,
                "firstName mismatch");
        softAssert.assertEquals(doctorDetailResponse.getMiddleName(), doc1285716969.middleName,
                "middleName mismatch");
        softAssert.assertEquals(doctorDetailResponse.getLastName(), doc1285716969.lastName,
                "lastName mismatch");
        softAssert.assertEquals(doctorDetailResponse.getPrefix(), doc1285716969.prefix,
                "prefix mismatch");
        softAssert.assertEquals(doctorDetailResponse.getGender(), doc1285716969.gender,
                "gender mismatch");
        softAssert.assertEquals(doctorDetailResponse.getCredential(), doc1285716969.credential,
                "credential mismatch");
        softAssert.assertEquals(doctorDetailResponse.getStatus(), doc1285716969.status,
                "status mismatch");
        softAssert.assertEquals(doctorDetailResponse.getType(), doc1285716969.type,
                "type mismatch");
        softAssert.assertEquals(doctorDetailResponse.getLicensedAt(), doc1285716969.licensedAt,
                "licensedAt mismatch");
        softAssert.assertEquals(doctorDetailResponse.getTaxonomies()[0].getUuid(), doc1285716969.taxUuid,
                "taxUuid mismatch");
        softAssert.assertEquals(doctorDetailResponse.getTaxonomies()[0].getLicense(), doc1285716969.taxLicense,
                "taxLicense mismatch");
        softAssert.assertEquals(doctorDetailResponse.getTaxonomies()[0].getCode(), doc1285716969.taxCode,
                "taxCode mismatch");
        softAssert.assertEquals(doctorDetailResponse.getTaxonomies()[0].getTitle(), doc1285716969.taxTitle,
                "taxTitle mismatch");
        softAssert.assertEquals(doctorDetailResponse.getTaxonomies()[0].getState(), doc1285716969.taxState,
                "taxState mismatch");
        softAssert.assertEquals(doctorDetailResponse.getTaxonomies()[0].getSpecialty(), doc1285716969.taxSpecialty,
                "taxSpecialty mismatch");
        softAssert.assertEquals(doctorDetailResponse.getTaxonomies()[0].getPrimary(), doc1285716969.taxPrimary,
                "taxPrimary mismatch");
        softAssert.assertEquals(doctorDetailResponse.getCreatedAt(), doc1285716969.createdAt,
                "createdAt mismatch");
        softAssert.assertAll();
    }

    @Test()
    public void doctorSearchFilterHasValidInfo() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: calling doctor search-filter endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        DoctorSearchFilterResponse doctorSearchFilterResponse = doctorController.doctorSearchFilter(sessionDTO.getToken());

        log.info("Then: Verify the data is valid");
        softAssert.assertEquals(doctorSearchFilterResponse.getGender(), doctorControllerData.gender,
                "gender mismatch");
        softAssert.assertEquals(doctorSearchFilterResponse.getLanguages(), doctorControllerData.languages,
                "languages mismatch");
        softAssert.assertEquals(doctorSearchFilterResponse.getPricePoints(), doctorControllerData.pricePoints,
                "pricePoint mismatch");
        softAssert.assertEquals(doctorSearchFilterResponse.getProviderType(), doctorControllerData.providerType,
                "providerType mismatch");
        softAssert.assertEquals(doctorSearchFilterResponse.getLanguages(), doctorControllerData.languages,
                "languages is not matching");
        softAssert.assertEquals(doctorSearchFilterResponse.getPricePoints(), doctorControllerData.pricePoints,
                "pricePoint is not matching");
        softAssert.assertEquals(doctorSearchFilterResponse.getProviderType(), doctorControllerData.providerType,
                "providerType is not matching");
        softAssert.assertAll();
    }

    @Test()
    public void doctorSuggestHasValidInfo() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        log.info("When: calling doctor suggest endpoint with valid token");
        SessionDTO sessionDTO = userController.login(FI_IL_ACCOUNT1);
        DoctorSuggestResponse doctorSuggestResponse = doctorController.doctorSuggest(DoctorsSuggestRequest.builder()
                        .query("John")
                        .build(),
                sessionDTO.getToken());
        List<DoctorDTO> listOfDoctors = doctorSuggestResponse.getDoctors();
        log.info("Then: Verify the data is valid");
        Pattern npiPattern = Pattern.compile("^\\d{10}$");
        for (DoctorDTO doctor : listOfDoctors) {
            softAssert.assertTrue(doctor instanceof DoctorDTO,
                    "DoctorDTO mismatch");
            softAssert.assertTrue(npiPattern.matcher(doctor.getNpi()).find(),
                    "NPI does not match 10 digits rule");
            softAssert.assertAll();
        }
    }
}
