package lib.methods;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.isA;

public class ErrorMessageResponseSpec {



    public static ResponseSpecification response() {
        return new ResponseSpecBuilder()
                .expectBody("success", isA(Boolean.class))
                .expectBody("error.code", isA(Integer.class))
                .expectBody("error.type", isA(String.class))
                .expectBody("error.info", isA(String.class))
                .build();
    }
}
