package com.redhat.cloudnative.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.redhat.cloudnative.model.Product;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface CatalogService {
    @GET
    @Path("/api/catalog")
    @Produces("application/json")
    List<Product> products();
}
