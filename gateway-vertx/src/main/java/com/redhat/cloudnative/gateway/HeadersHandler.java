package com.redhat.cloudnative.gateway;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.ext.web.RoutingContext;
import io.vertx.reactivex.ext.web.client.HttpRequest;

public class HeadersHandler {
    private static final List<String> FORWARDED_HEADER_NAMES = Arrays.asList(
        "x-request-id",
        "x-b3-traceid",
        "x-b3-spanid",
        "x-b3-parentspanid",
        "x-b3-sampled",
        "x-b3-flags",
        "x-ot-span-context",
        "ike-session-id"
    );

    static final String X_TRACING_HEADERS = "X-Tracing-Headers";

    private HeadersHandler() {
        // Avoid direct instantiation.
    }

    public static void capture(RoutingContext ctx) {
        Set<String> names = ctx.request().headers().names();
        Map<String, String> headers = names.stream()
            .map(String::toLowerCase)
            .filter(FORWARDED_HEADER_NAMES::contains)
            .collect(Collectors.toMap(
                Function.identity(),
                h -> ctx.request().getHeader(h)
            ));
        ctx.put(X_TRACING_HEADERS, headers);
        ctx.next();
    }

    public static HttpRequest<Buffer> populateHeaders(HttpRequest<Buffer> request, RoutingContext ctx) {
        final Map<String, String> populateHeaders = ctx.get(X_TRACING_HEADERS);
        if (populateHeaders != null) {
            request.headers().addAll(populateHeaders);
        }
        return request;
    }


}
