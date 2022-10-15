package com.sidecarhealth.microservice.care.careepisodecontroller.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;

public class CareEpisodeController extends BaseClass {
    // Swagger reference: https://dev-api.sidecarhealth.com/care/v1/swagger-ui.html#/Care_Episode_Controller
    final private String EPISODES = "/episodes"; // POST, PUT
    final private String REMOVE_CARE_FROM_EPISODE = "/episodes/{uuid}/components/{componentType}/cares/{careUuid}";
    final private String ADD_CARE_TO_EPISODE = "/episodes/{uuid}/components/{componentType}/cares/{careUuid}/units/{units}";
    final private String GET_EPISODE_BY_UUID = "/episodes/info/{uuid}";
}
