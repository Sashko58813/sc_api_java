package com.name.microservice.care.careepisodecontroller.api;

import com.name.microservice.baseclass.BaseClass;

public class CareEpisodeController extends BaseClass {
    final private String EPISODES = "/episodes"; // POST, PUT
    final private String REMOVE_CARE_FROM_EPISODE = "/episodes/{uuid}/components/{componentType}/cares/{careUuid}";
    final private String ADD_CARE_TO_EPISODE = "/episodes/{uuid}/components/{componentType}/cares/{careUuid}/units/{units}";
    final private String GET_EPISODE_BY_UUID = "/episodes/info/{uuid}";
}
