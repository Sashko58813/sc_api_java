package com.sidecarhealth.microservice.expense.card.tests;

import com.sidecarhealth.microservice.authentication.api.UserController;
import com.sidecarhealth.microservice.authentication.dto.response.SessionDTO;
import com.sidecarhealth.microservice.baseclass.BaseClass;
import com.sidecarhealth.microservice.expense.card.api.CardController;
import com.sidecarhealth.microservice.expense.card.dto.request.RequestCard;
import com.sidecarhealth.microservice.expense.card.dto.response.GetCard;
import com.sidecarhealth.microservice.expense.card.dto.response.GetOnetimeToken;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.sidecarhealth.microservice.expense.card.dataproviders.CardControllerDataProviders.SHARED_LOGIN_DATA;

@Log4j2
@SuppressWarnings("all")
public class CardControllerTests extends BaseClass {
    CardController cardController;
    UserController userController;


    @BeforeMethod
    public void setUpCardControllerTests() {
        cardController = new CardController();
        userController = new UserController();
    }

    @Test()
    public void cardsGet() throws Exception {
        log.info("When: calling get cards with member uuid");

        SessionDTO sessionDTO = userController.login(SHARED_LOGIN_DATA);
        List<GetCard> getCards = cardController.getCards(sessionDTO.getSub(), sessionDTO.getToken(), 200);

        Assert.assertFalse(getCards.isEmpty());
        //TODO: validate GetCard Object
    }

    @Test()
    public void cardsPost() throws Exception {
        log.info("When: requesting a new card for a member");
        SessionDTO sessionDTO = userController.login(SHARED_LOGIN_DATA);
        Response postCardsReponse = cardController.requestCards(RequestCard.builder().accountUuid(sessionDTO.getAud()).build(), sessionDTO.getToken());
        validateResponse(postCardsReponse, 201, "Card requested successfully");

    }

    @Test()
    public void cardsNotifcations() throws Exception {
        log.info("When: hitting the notifications endpoint");

        SessionDTO sessionDTO = userController.login(SHARED_LOGIN_DATA);
        Response cardsNotificationsResponse = cardController.cardsNotifications(sessionDTO.getToken());
        validateResponse(cardsNotificationsResponse, 200, "Notifications successful");

    }

    @Test()
    public void getOnetimeToken() throws Exception {
        log.info("When: calling get onetime token with member uuid");

        SessionDTO sessionDTO = userController.login(SHARED_LOGIN_DATA);
        GetOnetimeToken getOnetimeToken = cardController.getOnetimeToken(sessionDTO.getSub(),
                sessionDTO.getToken(), 200);

        Assert.assertFalse(getOnetimeToken.equals(null));
        //TODO: validate GetOnetimeToken Object
    }
}
