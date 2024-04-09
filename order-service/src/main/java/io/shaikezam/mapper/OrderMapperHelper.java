package io.shaikezam.mapper;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.shaikezam.rest.HttpClientWrapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.mapstruct.Named;

import java.net.http.HttpResponse;
import java.time.Duration;

@ApplicationScoped
public class OrderMapperHelper {

    private final HttpClientWrapper httpClientWrapper;
    private final Cache<Long, String> productNameCache;

    @Inject
    public OrderMapperHelper(HttpClientWrapper httpClientWrapper) {
        this.httpClientWrapper = httpClientWrapper;
        this.productNameCache = Caffeine.newBuilder()
                .expireAfterWrite(Duration.ofMinutes(1)) // Evict entries after 1 minute
                .build();
    }

    @Named("fetchProductName")
    public String fetchProductName(Long productId) {
        return productNameCache.get(productId, key ->
                httpClientWrapper.executeGetRequest(String.format("http://product-service:8080/web/api/products/%d/name", key),
                        HttpResponse.BodyHandlers.ofString()));
    }
}
