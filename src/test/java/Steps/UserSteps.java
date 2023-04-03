package Steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.CreateUser;
import models.CreateUserResponse;
import models.UserPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserSteps {
    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in/api")
                    .setBasePath("/users")
                    .setContentType(ContentType.JSON)
                    .build();

    private CreateUserResponse user;
    public CreateUserResponse createUser(CreateUser rq){
        user = given().spec(REQ_SPEC).body(rq).post().as(CreateUserResponse.class);
        return user;
    }

    public UserPojo getUser(){
        return  given().spec(REQ_SPEC).get("/" + user.getId()).as(UserPojo.class);
    }

    public static List<UserPojo> getUsers(){
        return given().spec(REQ_SPEC)
                .get()
                .jsonPath().getList("data", UserPojo.class);
    }

    public static UserPojo getUser(int id){
        return  given().spec(REQ_SPEC).get("/" + id).as(UserPojo.class);
    }
}
