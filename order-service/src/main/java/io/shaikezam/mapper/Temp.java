package io.shaikezam.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Named;

@ApplicationScoped
public class Temp {
    @Named("lol")
    public String lol(Long productId) {
        return "Hello World";
    }
}
