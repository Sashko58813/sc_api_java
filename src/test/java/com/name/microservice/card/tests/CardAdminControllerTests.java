package com.name.microservice.card.tests;

import com.name.microservice.authentication.api.UserController;
import com.name.microservice.card.api.CardAdminController;
import com.name.microservice.authentication.dto.response.SessionDTO;
import com.name.microservice.baseclass.BaseClass;
import com.name.microservice.card.dataproviders.CardControllerDataProviders;
import com.name.microservice.card.dto.request.AdminRequestOrCancelCardRequest;
import com.name.microservice.card.dto.response.PostAdminRequestOrCancelCardResponse;
import com.name.microservice.card.dto.response.GetAdminMemberCard;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

@Log4j2
@SuppressWarnings("all")

public class CardAdminControllerTests extends BaseClass {
    CardAdminController cardAdminController;
    UserController userController;

    @BeforeMethod
    public void setUpCardControllerTests() {
        cardAdminController = new CardAdminController();
        userController = new UserController();
    }

    @Test()
    public void adminMemberCard() throws Exception {
        log.info("When: calling get member cards through admin with member uuid");

        SessionDTO memberSessionDTO = userController.login(CardControllerDataProviders.SHARED_LOGIN_DATA);
        SessionDTO adminSessionDTO = userController.login(CardControllerDataProviders.ADMIN_LOGIN_DATA);
        List<GetAdminMemberCard> memberCards = cardAdminController.adminMemberCards(memberSessionDTO.getSub(),
                adminSessionDTO.getToken(), 200);

        Assert.assertFalse(memberCards.isEmpty());
        //TODO: validate GetAdminMemberCard Object
    }

    @Test()
    public void adminRequestAndCancelCard() throws Exception {
        log.info("When: requesting a new card for a member");

        SessionDTO memberSessionDTO = userController.login(CardControllerDataProviders.SHARED_LOGIN_DATA);
        SessionDTO adminSessionDTO = userController.login(CardControllerDataProviders.ADMIN_LOGIN_DATA);

        // Request new card
        PostAdminRequestOrCancelCardResponse adminRequestCardResponse = cardAdminController.adminRequestOrCancelCard(
                AdminRequestOrCancelCardRequest.builder().memberUuid(memberSessionDTO.getSub()).build(),
                adminSessionDTO.getToken(), 200);
        Assert.assertFalse(adminRequestCardResponse.equals(null));

        // Cancel Card
        PostAdminRequestOrCancelCardResponse adminCancelCardResponse = cardAdminController.adminRequestOrCancelCard(
                AdminRequestOrCancelCardRequest.builder().memberUuid(
                        memberSessionDTO.getSub()).action("cancel").build(),
                adminSessionDTO.getToken(), 200);
        Assert.assertFalse(adminCancelCardResponse.equals(null));
        //TODO: validate AdminRequestOrCancelCard Object

    }
}
