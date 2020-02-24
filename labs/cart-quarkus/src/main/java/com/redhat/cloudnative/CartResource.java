package com.redhat.cloudnative;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.cloudnative.model.ShoppingCart;
import com.redhat.cloudnative.service.ShoppingCartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api/cart")
public class CartResource {
    private static final Logger LOG = LoggerFactory.getLogger(CartResource.class);
    
    @Inject
    private ShoppingCartService shoppingCartService;

    @GET
    @Path("/{cartId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShoppingCart getCart(@PathParam("cartId") String cartId) {

        return shoppingCartService.getShoppingCart(cartId);
    }


    @POST
    @Path("/{cartId}/{itemId}/{quantity}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShoppingCart add(@PathParam("cartId") String cartId,
                            @PathParam("itemId") String itemId,
                            @PathParam("quantity") int quantity) throws Exception {
        return shoppingCartService.addItem(cartId, itemId, quantity);
    }

    @POST
    @Path("/{cartId}/{tmpId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShoppingCart set(@PathParam("cartId") String cartId,
                            @PathParam("tmpId") String tmpId) throws Exception {

        return shoppingCartService.set(cartId, tmpId);
    }

    @DELETE
    @Path("/{cartId}/{itemId}/{quantity}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShoppingCart delete(@PathParam("cartId") String cartId,
                               @PathParam("itemId") String itemId,
                               @PathParam("quantity") int quantity) throws Exception {

        return shoppingCartService.deleteItem(cartId, itemId, quantity);
    }

    @POST
    @Path("/checkout/{cartId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ShoppingCart checkout(@PathParam("cartId") String cartId) {
        // TODO: register purchase of shoppingCart items by specific user in session
        return shoppingCartService.checkout(cartId);
    }
}