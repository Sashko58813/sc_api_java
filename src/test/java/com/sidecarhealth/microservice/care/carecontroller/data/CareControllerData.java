package com.sidecarhealth.microservice.care.carecontroller.data;

import com.sidecarhealth.microservice.care.carecontroller.dto.CareContentDTO;
import com.sidecarhealth.microservice.care.carecontroller.dto.CareSearchResponse;

import java.util.List;

public class CareControllerData {
    // Response
    public static List<String> expCareTypeValues() {
        return List.of("prescriptions", "therapy-rehab", "hospital-admission", "doctor-visit", "medicine", "surgery", "equipment-supplies", "x-rays-imaging-radiology", "lab-work", "transportation", "maternity-care", "same-day-facility-services");
    }

    public static List<String> expCareTypeLabels() {
        return List.of("Prescriptions", "Therapy/rehab", "Hospital admission", "Doctor visit", "Medicine", "Surgery", "Equipment/supplies", "X-rays, imaging, radiology", "Lab work", "Transportation", "Maternity care", "Same-day facility services");
    }

    public static List<List<String>> expCareTypeOptionsValues() {
        return List.of(List.of(),
                List.of("therapy-rehab-physical-therapy", "therapy-rehab-therapy", "therapy-rehab-psychiatry", "therapy-rehab-counseling"),
                List.of("hospital-admission-infections-and-parasites", "hospital-admission-musculoskeletal-system-and-connective-tissue", "hospital-admission-respiratory-system", "hospital-admission-endocrinology-and-nutrition", "hospital-admission-male-reproductive-system", "hospital-admission-blood-and-immune-system", "hospital-admission-skin-subcutaneous-tissue-and-breast", "hospital-admission-mental-diseases-and-disorders", "hospital-admission-nervous-system", "doctor-visit-care-management", "hospital-admission-alcohol-drug-use", "hospital-admission-liver-gallbladder-bile-ducts-and-pancreas", "hospital-admission-injuries-poisoning-and-toxic-effects-of-drugs", "hospital-admission-eye", "hospital-admission-cancers-and-abnormal-growths", "hospital-admission-female-reproductive-system", "hospital-admission-maternity", "hospital-admission-kidney-and-urinary-tract", "hospital-admission-multiple-significant-trauma", "hospital-admission-hiv-infection", "hospital-admission-burns", "hospital-admission-digestive-system", "hospital-admission-ear-nose-mouth-and-throat", "hospital-admission-circulatory-system", "hospital-admission-rehab-and-other-health-status-factors-contact", "doctor-visit-maternity-care"),
                List.of("doctor-visit-telemedicine", "doctor-visit-hospital-facility", "doctor-visit-home-care", "doctor-visit-emergency", "doctor-visit-office", "doctor-visit-other", "doctor-visit-care-management"),
                List.of("medicine-pulmonary", "medicine-eyes-vision", "medicine-infusion", "medicine-digestion", "medicine-injection", "medicine-chiropractic-osteopathic-care", "medicine-vaccines", "medicine-neurology", "medicine-vascular", "medicine-cardiovascular", "medicine-helps-you-eat", "medicine-special-services", "medicine-chemotherapy", "medicine-ear-nose-throat", "medicine-sleep", "medicine-allergies", "medicine-dialysis", "medicine-brain-waves", "medicine-health-assessment-testing", "medicine-dermatology", "medicine-training", "medicine-pediatric-care", "medicine-home-visit", "medicine-other-medicine"),
                List.of("surgery-preparation", "surgery-examination", "surgery-biopsy", "surgery-suture", "surgery-injection", "surgery-placement", "surgery-replacement", "surgery-dilation", "surgery-removal", "surgery-stabilization", "surgery-repair", "surgery-destruction", "surgery-amputation", "surgery-graft", "surgery-closure", "surgery-fusion", "surgery-drainage", "surgery-insertion", "surgery-revision", "surgery-collection", "surgery-cosmetic-surgery", "surgery-exploration", "surgery-anesthesia", "surgery-treatment", "surgery-reconstruction", "surgery-binding", "surgery-bypass", "surgery-creation", "surgery-other", "surgery-release", "surgery-cast-splint", "surgery-connection", "surgery-incision", "surgery-transplant"),
                List.of("equipment-supplies-helps-you-hear", "equipment-supplies-helps-you-talk", "equipment-supplies-hospital-tools", "equipment-supplies-wound-dressings", "equipment-supplies-nerve-stimulators", "equipment-supplies-lift", "equipment-supplies-helps-you-see", "equipment-supplies-helps-you-sleep", "equipment-supplies-helps-with-circulation", "equipment-supplies-for-diabetes", "equipment-supplies-helps-you-get-around", "equipment-supplies-for-radiology", "equipment-supplies-monitors-you", "equipment-supplies-for-your-heart", "equipment-supplies-batteries-chargers", "equipment-supplies-safety", "equipment-supplies-temperature-control", "prosthetics-and-orthotics", "equipment-supplies-helps-you-bathe", "equipment-supplies-other", "equipment-supplies-contraceptives", "equipment-supplies-helps-with-breast-feeding", "equipment-supplies-cast-splint", "equipment-supplies-for-dialysis", "equipment-supplies-helps-you-breathe", "equipment-supplies-helps-you-eat", "equipment-supplies-helps-you-with-the-bathroom"),
                List.of("x-rays-imaging-radiology-echocardiogram", "x-rays-imaging-radiology-mri", "x-rays-imaging-radiology-video-x-ray", "x-rays-imaging-radiology-ultrasound", "x-rays-imaging-radiology-ct", "x-rays-imaging-radiology-report", "x-rays-imaging-radiology-x-ray", "x-rays-imaging-radiology-other", "x-rays-imaging-radiology-hospital-tools", "x-rays-imaging-radiology-cancer-radiation", "x-rays-imaging-radiology-imaging", "x-rays-imaging-radiology-mammogram", "x-rays-imaging-radiology-nuclear-medicine"),
                List.of("lab-work-miscellaneous-lab-work", "lab-work-reproduction", "lab-work-suppression-test", "lab-work-transfusion", "lab-work-allergy-test", "lab-work-urinalysis", "lab-work-therapeutic-drug-test", "lab-work-chemistry", "lab-work-genetic-test", "lab-work-microbiology", "lab-work-drug-test", "lab-work-surgical-pathology", "lab-work-organ-test", "lab-work-detection-test", "lab-work-cell-examination", "lab-work-blood-test"),
                List.of("transportation-other", "transportation-ground", "transportation-air"),
                List.of("maternity-care-radiology", "maternity-care-newborns", "maternity-care-delivery", "maternity-care-lab-work", "maternity-care-hospital-admission", "maternity-procedures", "maternity-care-sterilization"),
                List.of("same-day-facility-services-hospital", "same-day-facility-services-surgery-center"));
    }

    public static List<List<String>> expCareTypeOptionsLabels() {
        return List.of(List.of(),
                List.of("Physical therapy", "Therapy", "Psychiatry", "Counseling"),
                List.of("Infections and Parasites", "Musculoskeletal System and Connective Tissue", "Respiratory System", "Endocrinology and Nutrition", "Male Reproductive System", "Blood and Immune System", "Skin, Subcutaneous Tissue, and Breast", "Mental Diseases and Disorders", "Nervous System", "Doctor Visit Care Management", "Alcohol and drug use", "Liver, Gallbladder, Bile Ducts, and Pancreas", "Injuries, Poisoning, and Toxic Effects of Drugs", "Eye", "Cancers and Abnormal Growths", "Female Reproductive System", "Hospital admission for maternity", "Kidney and Urinary Tract", "Multiple Significant Trauma", "HIV Infection", "Burns", "Digestive System", "Ear, Nose, Mouth, and Throat", "Circulatory System", "Rehab and other Health Status Factors/Contact", "Doctor visit maternity care"),
                List.of("Telemedicine", "Hospital/facility", "Home care", "Emergency", "Office", "Doctor visit other", "Care management"),
                List.of("Pulmonary", "Eyes/vision", "Infusion", "Digestion", "Injection", "Chiropractic/osteopathic care", "Vaccines", "Neurology", "Vascular", "Cardiovascular", "Helps you eat", "Special services", "Chemotherapy", "Ear/Nose/Throat", "Sleep", "Allergies", "Dialysis", "Brain waves", "Health assessment testing", "Dermatology", "Training", "Pediatric care", "Home visit", "Other medicine"),
                List.of("Preparation", "Examination", "Biopsy", "Suture", "Injection", "Placement", "Replacement", "Dilation", "Removal", "Stabilization", "Repair", "Destruction", "Amputation", "Graft", "Closure", "Fusion", "Drainage", "Insertion", "Revision", "Collection", "Cosmetic Surgery", "Exploration", "Anesthesia", "Treatment", "Reconstruction", "Binding", "Bypass", "Creation", "Other", "Release", "Cast/Splint", "Connection", "Incision", "Transplant"),
                List.of("Helps you hear", "Helps you talk", "Hospital tools", "Wound dressings", "Nerve stimulators", "Lift", "Helps you see", "Helps you sleep", "Helps with circulation", "For diabetes", "Helps you get around", "For radiology", "Monitors you", "For your heart", "Battery chargers", "Safety", "Temperature control", "Prosthetics and orthotics", "Helps you bathe", "Other", "Contraceptives", "Helps with breast feeding", "Cast/splint", "For dialysis", "Helps you breathe", "Helps you eat", "Helps you with the bathroom"),
                List.of("Echocardiogram", "MRI", "Video x-ray", "Ultrasound", "CT", "Report", "X-ray", "Other", "Hospital tools", "Cancer radiation", "Imaging", "Mammogram", "Nuclear medicine"),
                List.of("Miscellaneous lab work", "Reproduction", "Suppression test", "Transfusion", "Allergy test", "Urinalysis", "Therapeutic drug test", "Chemistry", "Genetic test", "Microbiology", "Drug test", "Surgical pathology", "Organ test", "Detection test", "Cell examination", "Blood test"),
                List.of("Other", "Ground", "Air"),
                List.of("Radiology", "Fetus & newborn care", "Labor & delivery", "Lab work", "Hospital admission", "Procedures", "Sterilization"),
                List.of("Hospital", "Surgery Center"));
    }

    public static List<String> expLocationsLabel() {
        return List.of("Home", "Dr office or urgent care", "Pharmacy", "Inpatient Facility", "Outpatient Facility", "Surgical Center");
    }

    public static List<String> expLocationsUuid() {
        return List.of("home", "home-or-office", "pharmacy", "inpatient-hospital-facility", "outpatient-hospital-facility", "ambulatory-surgical-center");
    }

    public static CareContentDTO[] expCrestorSearch() {
        CareContentDTO[] crestorSearch = new CareContentDTO[3];
        crestorSearch[0] = crestorContent();
        crestorSearch[1] = rosuvastatinCalciumContent();
        crestorSearch[2] = ezallorSprinkleContent();
        return crestorSearch;
    }

    public static CareContentDTO crestorContent() {
        CareContentDTO crestorContent = new CareContentDTO();
        crestorContent.setUuid("DhPpJbdNGFzCtaAIoejZ");
        crestorContent.setCode("00310075190");
        crestorContent.setCodeType("ndc");
        crestorContent.setTitle("CRESTOR");
        crestorContent.setCategory("Prescriptions");
        crestorContent.setCategorySlug("prescriptions");
        crestorContent.setOrder(14);
        crestorContent.setEpisode(false);
        crestorContent.setCareEpisode(false);
        return crestorContent;
    }

    public static CareContentDTO rosuvastatinCalciumContent() {
        CareContentDTO crestorContent = new CareContentDTO();
        crestorContent.setUuid("care_RBe8LiPxqeDHtzOgt19eiXjJlCcWed");
        crestorContent.setCode("72205000390");
        crestorContent.setCodeType("ndc");
        crestorContent.setTitle("Rosuvastatin Calcium");
        crestorContent.setCategory("Prescriptions");
        crestorContent.setCategorySlug("prescriptions");
        crestorContent.setOrder(13);
        crestorContent.setEpisode(false);
        crestorContent.setCareEpisode(false);
        return crestorContent;
    }

    public static CareContentDTO ezallorSprinkleContent() {
        CareContentDTO crestorContent = new CareContentDTO();
        crestorContent.setUuid("care_attqGYQZlKZBeChAE726op5Lk9Txva");
        crestorContent.setCode("47335098483");
        crestorContent.setCodeType("ndc");
        crestorContent.setTitle("EZALLOR SPRINKLE");
        crestorContent.setCategory("Prescriptions");
        crestorContent.setCategorySlug("prescriptions");
        crestorContent.setOrder(1);
        crestorContent.setEpisode(false);
        crestorContent.setCareEpisode(false);
        return crestorContent;
    }

    public static CareSearchResponse noMatchingFromSearch() {
        CareSearchResponse empty = new CareSearchResponse();
        empty.setPage(0);
        empty.setTotalPages(0);
        empty.setTotalElements(0);
        empty.setSize(20);
        empty.setFirst(true);
        empty.setLast(true);
        empty.setContent(new CareContentDTO[]{});
        return empty;
    }
}
