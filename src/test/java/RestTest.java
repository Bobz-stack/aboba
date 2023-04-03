import Steps.UserSteps;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.CreateUser;
import models.CreateUserResponse;
import models.UserPojo;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RestTest {
    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();
    @Test
    public void getUser(){
       List<UserPojo> users= UserSteps.getUsers();

    }
    @Test
    public void postUser(){
        CreateUser rq=  CreateUser.builder()
                .name("bob")
                .job("Janckins")
                .build();
        CreateUserResponse rs=  given()
                .spec(REQ_SPEC)
                .body(rq)
                .when().post()
                .then().extract().as(CreateUserResponse.class);
        System.out.println(rs);
//        assertThat(rs)
//                .isNotNull()
//                .extracting(CreateUserResponse::getName)
//                .isEqualTo(rq.getJob());

    }
}
