package com.sidecarhealth.microservice.care.carecontroller.dataproviders;

import com.sidecarhealth.microservice.care.carecontroller.dto.CarePubDetailRequest;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareSearchRequest;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;

import static com.sidecarhealth.microservice.authentication.dataproviders.AuthDataProviders.GFI_ACCOUNT1;

@SuppressWarnings("all")
@Log4j2
public class CareControllerDataProviders {
    @DataProvider(name = "CarePubDetail")
    public Object[][] CarePubDetail() {
        return new Object[][]{
                {CarePubDetailRequest.builder()
                        .token("null")
                        .uuid("DhPpJbdNGFzCtaAIoejZ")
                        .insuranceFilingUuid("sch_fi_2021_2022")
                        .zipCode("60411")
                        .drugName("CRESTOR")
                        .category("prescriptions")
                        .build()}
        };
    }

    public CareSearchRequest CarePubSearchFI_MAT() {
        return CareSearchRequest.builder()
                .page(0).size(25)
                .insuranceFilingUuid("sch_maternity_2020_2021")
                .build();
    }

    @DataProvider(name = "CarePubSearchCrestor")
    public Object[][] CarePubSearchCrestor() {
        CareSearchRequest SEARCH_FI_MAT_CRESTOR = CarePubSearchFI_MAT().toBuilder().query("CRESTOR").build();
        return new Object[][]{
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("IL").zipCode("60411").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("OK").zipCode("73107").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("AL").zipCode("35186").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("GA").zipCode("30605").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("KY").zipCode("42701").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("IN").zipCode("46237").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("AR").zipCode("72223").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("NC").zipCode("28327").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("SC").zipCode("29073").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("TX").zipCode("76541").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("MS").zipCode("39042").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("MI").zipCode("48893").build()},
                {SEARCH_FI_MAT_CRESTOR.toBuilder().state("FL").zipCode("33034").build()},
        };
    }

    @DataProvider(name = "CarePubSearchGeneric")
    public Object[][] CarePubSearchGeneric() {
        CareSearchRequest SEARCH_FI_MAT = CarePubSearchFI_MAT().toBuilder().build();
        return new Object[][]{
                {SEARCH_FI_MAT.toBuilder().state("IL").zipCode("60411").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("OK").zipCode("73107").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("AL").zipCode("35186").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("GA").zipCode("30605").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("KY").zipCode("42701").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("IN").zipCode("46237").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("AR").zipCode("72223").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("NC").zipCode("28327").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("SC").zipCode("29073").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("TX").zipCode("76541").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("MS").zipCode("39042").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("MI").zipCode("48893").build(), "Rosuvastatin Calcium", "CRESTOR"},
                {SEARCH_FI_MAT.toBuilder().state("FL").zipCode("33034").build(), "Rosuvastatin Calcium", "CRESTOR"},
        };
    }

    @DataProvider(name = "CareSearchReturnsEmpty")
    public Object[][] CareSearchReturnsEmpty() {
        return new Object[][]{
                {GFI_ACCOUNT1, "MK080100"},
                {GFI_ACCOUNT1, "MT010100"},
                {GFI_ACCOUNT1, "APC97810"},
                {GFI_ACCOUNT1, "APC97813"},
        };
    }
}
