package com.helpingoldies;

import com.helpingoldies.domain.groceries.GroceryItem;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.UUID;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;
import static org.assertj.core.api.Assertions.assertThat;

public class GroceryListResourceIntegrationTest {

    @ClassRule
    public static final DropwizardAppRule<DoMyGroceriesConfiguration> RULE = new DropwizardAppRule<>(App.class, "config.yaml"); //TODO get config on the way explained in the manual
    public  URI uri;
    private Client client;

    @Before
    public void setUp() {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
                .nonPreemptive().credentials("wsuser", "wspassword").build();
        client = ClientBuilder.newClient().register(feature);
        uri = URI.create(String.format("http://localhost:%d/groceryItems", RULE.getLocalPort()));
    }

    @Test
    public void testAddGroceryItem() {
        GroceryItem groceryItem = GroceryItem.buildGrocertyItem("Two bottles of water", UUID.randomUUID());
        Response response = doPOST(groceryItem);
        assertThat(response.getStatus()).isEqualTo(CREATED.getStatusCode());

        response = doGET(groceryItem.getOwnerId());
        //TODO robs: test fixen
      //  assertThat(response.getStatus()).isEqualTo(OK.getStatusCode());
       // List<GroceryItem> groceryItems = response.readEntity(new GenericType<List<GroceryItem>>(GroceryItem.class) {
        //});
       // assertThat(groceryItems.get(0).getDescription()).isEqualTo("Two bottles of water");
    }


    private Response doGET(UUID ownerId) {
        return client.target(UriBuilder.fromUri(uri).queryParam("ownerId", ownerId.toString()).build()).request().get();
    }

    private Response doPOST(GroceryItem groceryItem) {
        return client.target(uri)
                .request()
                .post(Entity.json(groceryItem));
    }
}
