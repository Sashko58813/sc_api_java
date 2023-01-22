package com.name.microservice.card.api;

import com.name.microservice.baseclass.BaseClass;
import com.name.microservice.card.dto.request.AdminRequestOrCancelCardRequest;
import com.name.microservice.card.dto.response.PostAdminRequestOrCancelCardResponse;
import com.name.microservice.card.dto.response.GetAdminMemberCard;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static io.restassured.RestAssured.given;

@Log4j2
public class CardAdminController extends BaseClass{
    final private String ADMIN_CARDS = "/admin/cards";
    final private String ADMIN_CARDS_MEMBER = "/admin/cards/member/{memberUuid}";

    public List<GetAdminMemberCard> adminMemberCards(String memberUuid, String token, int expectedStatusCode) throws Exception {
        Response response = given().header("token", token)
                .pathParam("memberUuid", memberUuid)
                .when().get(expenseBaseUri + ADMIN_CARDS_MEMBER)
                .then().extract().response();

        validateResponse(response, expectedStatusCode, "Cards returned successfully");

        List<GetAdminMemberCard> memberCards = response.as(new TypeRef<List<GetAdminMemberCard>>() {});
        return memberCards;
    }

    // This POST is behaving like a GET and it's weird
    public PostAdminRequestOrCancelCardResponse adminRequestOrCancelCard(AdminRequestOrCancelCardRequest payload, String token, int expectedStatusCode) throws Exception {
        log.info("Request or cancel a new card");
        log.info("Endpoint: " + expenseBaseUri + ADMIN_CARDS);
        log.info("Payload: \n" + payload);

        Response response =
                given()
                        .header("token", token)
                        .header("Content-Type", "application/json")
                        .queryParam("memberUuid", payload.getMemberUuid())
                        .queryParam("action", payload.getAction())
                        .queryParam("reason", payload.getReason())
                        .queryParam("expedite", payload.getExpedite())
                        .when()
                        .post(expenseBaseUri + ADMIN_CARDS)
                        .then()
                        .extract().response();
        validateResponse(response, expectedStatusCode, "Cards returned successfully");
        PostAdminRequestOrCancelCardResponse adminRequestNewCard = response.as(PostAdminRequestOrCancelCardResponse.class);
        return adminRequestNewCard;

    }
}
