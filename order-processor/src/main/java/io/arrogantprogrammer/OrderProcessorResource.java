package io.arrogantprogrammer;

import org.slf4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.slf4j.LoggerFactory.getLogger;

@Path("")
public class OrderProcessorResource {

    private static final Logger LOGGER = getLogger(OrderProcessorResource.class);

    @GET
    @Path("/dapr/subscribe")
    @Produces(MediaType.APPLICATION_JSON)
    public DaprSubscription[] getSubscription(){

        DaprSubscription daprSubscription = new DaprSubscription("orderpubsub", "orders", "orders");
        LOGGER.info("configured: {}", daprSubscription);
        LOGGER.info("Subscribed to Pubsubname {} and topic {}", "orderpubsub", "orders");
        DaprSubscription[] arr = new DaprSubscription[]{daprSubscription};
        return arr;
    }

    @POST
    @Path("/orders")
    @Consumes(MediaType.WILDCARD)
    public Response processOrders(final SubscriptionData<Order> body) {

        LOGGER.info("Subscriber received: {}", body.getData().getOrderId());
        return Response.ok().build();
    }

}