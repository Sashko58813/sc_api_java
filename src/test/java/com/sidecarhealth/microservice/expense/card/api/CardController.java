package com.sidecarhealth.microservice.expense.card.api;

import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.expense.card.dto.request.RequestCard;
import com.sidecarhealth.microservice.expense.card.dto.response.GetCard;
import com.sidecarhealth.microservice.expense.card.dto.response.GetOnetimeToken;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import lombok.val;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import static io.restassured.RestAssured.given;

@Log4j2
public class CardController extends BaseClass {
    // Swagger reference: https://qa-api.sidecarhealth.com/exp/v1/swagger-ui.html#/Card_Controller
    final private String CARDS = "/cards"; // GET, POST
    final private String NOTIFICATIONS = "/cards/notifications";
    final private String ONETIME_TOKEN = "/cards/onetime-token";
    final private String ORDER_CARDS = "/cards/order-cards";
    final private String SWIPE = "/cards/swipe";

    public List<GetCard> getCards(String memberUuid, String token, int expectedStatusCode) throws Exception {
        Response response = given().header("token", token)
                .queryParam("memberUuid", memberUuid)
                .when().get(expenseBaseUri + CARDS)
                .then().extract().response();

        validateResponse(response, expectedStatusCode, "Cards returned successfully");

        List<GetCard> getCards = response.as(new TypeRef<List<GetCard>>() {});
        return getCards;
    }

    public void validateResponse(Response response, int expectedStatusCode, String description) throws Exception {
        val resStatusCode = response.statusCode();
        val resBody = "Response:\n" + response.getBody().asString();
        if (resStatusCode == expectedStatusCode) {
            log.info(description + " returns " + expectedStatusCode + " as expected");
            log.info(resBody);
        } else {
            log.error(description + " returns " + resStatusCode + " is not expected");
            log.error(resBody);
            throw new Exception(resStatusCode + " is not expected");
        }
    }

    public Response requestCards(RequestCard payload, String token) {
        log.info("Request a new card");
        log.info("Endpoint: " + expenseBaseUri + CARDS);
        log.info("Payload: \n" + payload);

        Response requestCardsResponse =
                given()
                        .header("token", token)
                        .header("Content-Type", "application/json")
                        .body(payload)
                        .when()
                        .post(expenseBaseUri + CARDS)
                        .then()
                        .extract().response();
        return requestCardsResponse;
    }

    // This endpoint appears to just post an empty payload and return a response code
    public Response cardsNotifications(String token) {
        log.info("Request a new card");
        log.info("Endpoint: " + expenseBaseUri + NOTIFICATIONS);
        log.info("Payload: \n" + token);

        return given()
                .header("token", token)
                .header("Content-Type", "application/json")
                .when()
                .post(expenseBaseUri + NOTIFICATIONS)
                .then()
                .extract().response();
    }

    public GetOnetimeToken getOnetimeToken(String memberUuid, String token, int expectedStatusCode) throws Exception {
        Response response = given().header("token", token)
                .queryParam("memberUuid", memberUuid)
                .when().get(expenseBaseUri + ONETIME_TOKEN)
                .then().extract().response();

        validateResponse(response, expectedStatusCode, "Cards returned successfully");
        GetOnetimeToken getOneTimeToken = response.as(GetOnetimeToken.class);
        return getOneTimeToken;
    }
}
