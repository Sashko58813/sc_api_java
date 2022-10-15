package com.sidecarhealth.microservice.doctor.bookmark.data;

import com.sidecarhealth.microservice.doctor.bookmark.dto.BookmarkAddressDTO;
import com.sidecarhealth.microservice.doctor.bookmark.dto.BookmarkContentDTO;
import com.sidecarhealth.microservice.doctor.bookmark.dto.BookmarkTaxonomyDTO;
import com.sidecarhealth.microservice.doctor.bookmark.dto.BookmarksDoctorsResponse;

public class BookmarkData {
    public static BookmarkAddressDTO ADDRESS_1255383139() {
        BookmarkAddressDTO address = new BookmarkAddressDTO();
        address.setId("15364274");
        address.setUuid("addr-3e1996b4-c045-11ec-9e63-0e2470250e79");
        address.setStreet("520 N Prospect Ave Ste 309");
        address.setCity("Redondo Beach");
        address.setState("CA");
        address.setZip("90277");
        address.setLat(33.8534063);
        address.setLon(-118.3798942);
        address.setPhone("4244374700");
        address.setFax("4244378884");
        address.setPrimary(true);
        return address;
    }

    public static BookmarkTaxonomyDTO TAXONOMY_1255383139() {
        BookmarkTaxonomyDTO taxonomy = new BookmarkTaxonomyDTO();
        taxonomy.setUuid("taxon-608581a4-3e74-11ea-8b90-f45c89902a79");
        taxonomy.setLicense("A77627");
        taxonomy.setCode("207R00000X");
        taxonomy.setTitle("Internal Medicine");
        taxonomy.setState("CA");
        taxonomy.setSpecialty("Internal Medicine");
        taxonomy.setPrimary("T");
        return taxonomy;
    }

    public static BookmarkContentDTO CONTENT_1255383139() {
        BookmarkContentDTO content = new BookmarkContentDTO();
        content.setNpi(1255383139);
        content.setFirstName("David");
        content.setLastName("Wallis");
        content.setGender("MALE");
        content.setCredential("MD");
        content.setStatus("ACTIVE");
        content.setType("Individual");
        content.setLicensedAt("2006-05-17T00:00:00.000Z");
        content.setRating(1.0);
        content.setReviewCount(1);
        BookmarkTaxonomyDTO[] taxonomy = {TAXONOMY_1255383139()};
        content.setTaxonomies(taxonomy);
        BookmarkAddressDTO[] address = {ADDRESS_1255383139()};
        content.setAddresses(address);
        String[] empty = {};
        content.setLanguages(empty);
        content.setOrganizationOtherNames(empty);
        content.setCreatedAt("2020-01-31T00:07:48.000Z");
        content.setUpdatedAt("2022-04-20T01:00:56.000Z");
        content.setBookmarked(false);
        return content;
    }

    public static BookmarksDoctorsResponse DOCTOR_1255383139() {
        BookmarksDoctorsResponse bookmarksDoctorsResponse = new BookmarksDoctorsResponse();
        bookmarksDoctorsResponse.setPage(0);
        bookmarksDoctorsResponse.setTotalPages(1);
        bookmarksDoctorsResponse.setTotalElements(1);
        bookmarksDoctorsResponse.setSize(20);
        bookmarksDoctorsResponse.setLast(true);
        bookmarksDoctorsResponse.setFirst(true);
        BookmarkContentDTO[] content = {CONTENT_1255383139()};
        bookmarksDoctorsResponse.setContent(content);
        return bookmarksDoctorsResponse;
    }
}
