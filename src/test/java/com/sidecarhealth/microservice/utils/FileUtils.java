package com.sidecarhealth.microservice.utils;

import java.io.File;

@SuppressWarnings("all")
public class FileUtils {

    public static File licenseFileForPartner() {
        String filename = "LicenseCalifornia.jpeg";
        String workingDirectory = "src/test/java/com/sidecarhealth/microservice/files";
        File license = new File(workingDirectory, filename);
        return license;
    }

    public static File censusFile(String fileName) {
        String filename = fileName;
        String workingDirectory = "src/test/java/com/sidecarhealth/microservice/files";
        File censusFile = new File(workingDirectory, filename);
        return censusFile;
    }
}
