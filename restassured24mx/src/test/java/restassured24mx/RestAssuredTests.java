package restassured24mx;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;

public class RestAssuredTests {
 
    @BeforeAll
    public static void init() {
        baseURI = "https://www.24mx.ie/INTERSHOP/rest/WFS/Pierce-24mx-Site/24mx-ie/";
    }

    @Test
    public void checkEndpointsCode200() { // Checking the status of endpoints for which 200 is expected (see Utils class).

        for (int i = 0; i < Utils.endpointsCode200.length; i++) {
            when().
                get(Utils.endpointsCode200[i]).
                then().statusCode(200);
        }
    }

    @Test
    public void checkResponseTimeOfEndpointsCode200() { // Checking the response time of endpoints for which 200 is expected.

        for (int i = 0; i < Utils.endpointsCode200.length; i++) {
            when().
                get(Utils.endpointsCode200[i]).
            then().
                time(Matchers.lessThan(3000L));
        }
    }

    @Test
    public void checkNumberOfBrandSubcategories() { // Number of the brand subcategories should be 27.

        given().
            get("categories/brands").
        then().
            statusCode(200).
            body("subCategoriesCount", equalTo(27));
    }

    @Test
    public void checkListOfBrandsA() { // Checking the completeness of the "BRAND A" list (there should be exactly 38 brands).
        
        int numberOfBrandsA = Utils.brandsA_canonicalNames.length; // There is 38 brands.

        given().
            get("categories/brands/A").
        then().
            statusCode(200).
            body("subCategoriesCount", equalTo(numberOfBrandsA)).
            body("subCategories.canonicalName", hasItems(Utils.brandsA_canonicalNames)); // Brands canonical names should be the same as in the array.
    }

    @Test
    public void checkSuzuki2023Models() { // Checking 2023 Suzuki models

        int modelIndex = 0;
        for (Map.Entry<Integer, String> entry : Utils.suzuki2023Models().entrySet()) {
            String modelsNoId = "models[" + modelIndex + "].id";
            String modelsNoName = "models[" + modelIndex + "].id";

            given().
                get("vehicles/vehiclelist?brand=Suzuki&year=2023").
            then().
                body(modelsNoId, equalTo(Integer.toString(entry.getKey()))).
                body(modelsNoName, equalTo(Integer.toString(entry.getKey())));

            modelIndex++;
        }
    }
}