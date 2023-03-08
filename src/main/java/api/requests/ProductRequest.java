package api.requests;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@JsonAutoDetect
public class ProductRequest {
    private Product product;
    private Integer quantity;

    @AllArgsConstructor
    @Getter
    @JsonAutoDetect
    public static class Product {
        private String code;
    }
}
