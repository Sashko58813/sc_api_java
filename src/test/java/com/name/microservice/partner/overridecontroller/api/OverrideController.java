package com.name.microservice.partner.overridecontroller.api;

import com.name.microservice.baseclass.BaseClass;

public class OverrideController extends BaseClass {
    final private String OVERRIDES = "/overrides"; //POST, PUT
    final private String OVERRIDES_UUID = "/overrides/{uuid}"; //GET, DELETE
    final private String OVERRIDES_BY_BROKER_UUID = "/overrides/receiver/{uuid}";
}
