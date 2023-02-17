package io.arrogantprogrammer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import io.quarkus.runtime.annotations.QuarkusMain;

@Path("/checkout")
public class CheckoutServiceApplication{

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutServiceApplication.class);

    @Inject @RestClient
    OrdersClient ordersClient;

    @GET
    public Response placeOrder() {

        ArrayList<Order> orders = new ArrayList<>();

		for (int i = 0; i <= 10; i++) {
			int orderId = i;
            Order order = new Order(orderId);
            orders.add(order);
            try {
                LOGGER.info("sending {}", order);
                ordersClient.publishOrder(order);
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                LOGGER.error(e.getMessage());
            }

		}
        return Response.ok(orders).build();
    }

}