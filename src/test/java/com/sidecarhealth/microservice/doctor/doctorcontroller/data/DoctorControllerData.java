package com.sidecarhealth.microservice.doctor.doctorcontroller.data;

import java.util.Arrays;
import java.util.List;

public class DoctorControllerData {
    public List<String> providerType = Arrays.asList("individual", "organization");
    public List<String> pricePoints = Arrays.asList("high", "low", "medium");
    public List<String> gender = Arrays.asList("female", "male");
    public List<String> languages = Arrays.asList("Arabic", "Armenian", "Bengali", "Chinese (Cantonese)",
            "Chinese (Mandarin)", "Creole (Haitian)", "English", "Farsi", "Filipino", "French", "German", "Greek",
            "Gujarati", "Hebrew", "Hindi", "Italian", "Japanese", "Korean", "Polish", "Portuguese", "Punjabi",
            "Romanian", "Russian", "Spanish", "Tagalog", "Tamil", "Telugu", "Ukrainian", "Urdu", "Vietnamese");
}
