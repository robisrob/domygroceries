package com.helpingoldies.resources;

import com.helpingoldies.dao.GroceryListDOA;
import com.helpingoldies.domain.groceries.GroceryItem;
import io.dropwizard.auth.Auth;
import org.skife.jdbi.v2.DBI;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Path("/groceryItems")
@Produces(MediaType.APPLICATION_JSON)
public class GroceryItemResource {

    private final GroceryListDOA groceryListDOA;

    public GroceryItemResource(DBI jdbi) {
        this.groceryListDOA = jdbi.onDemand(GroceryListDOA.class);
    }

    @POST
    public Response createGroceryItem(@Valid GroceryItem groceryItem) throws URISyntaxException {
        GroceryItem createdGroceryItem = GroceryItem.buildGrocertyItem(groceryItem.getDescription(), groceryItem.getOwnerId());
        groceryListDOA.createGroceryItem(createdGroceryItem.getId().toString(), createdGroceryItem.getDescription(), createdGroceryItem.getOwnerId().toString(), new Date(createdGroceryItem.getCreatieDatum().getTime()));
        return Response.created(new URI("groceryList/"+String.valueOf(createdGroceryItem.getId().toString()))).build();
    }

    @GET
    public Response getGroceryItems(@QueryParam("ownerId") String ownerId) {
        List<GroceryItem> groceries = groceryListDOA.findGroceries(ownerId);
        return groceries.isEmpty() ? Response.noContent().build(): Response.ok(groceries).build();
    }


}
