package api.responses;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@JsonAutoDetect
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductAddedResponse {
    private Entry entry;
    private int quantity;
    private int quantityAdded;
    private String statusCode;


    @JsonAutoDetect
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class BaseOption {
        private Selected selected;
        private String variantType;
    }

    @JsonAutoDetect
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Category {
        private String code;
        private String name;
    }

    @JsonAutoDetect
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Entry {
        private ArrayList<Object> configurationInfos;
        private int displayOrder;
        private int entryNumber;
        private Product product;
        private int quantity;
        private int redeemLoyaltyPoints;
        private int redeemLoyaltyPointsForProduct;
        private int rewardLoyaltyPoints;
        private TotalPrice totalPrice;
    }

    @JsonAutoDetect
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Price {
        private String currencyIso;
        private String formattedValue;
        private String oldValueLabel;
        private String priceType;
        private double value;
    }

    @JsonAutoDetect
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PriceData {
        private String currencyIso;
        private double value;
    }

    @JsonAutoDetect
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Product {
        private boolean availableForPickup;
        private ArrayList<BaseOption> baseOptions;
        private String baseProduct;
        private ArrayList<Category> categories;
        private String code;
        private boolean configurable;
        private boolean digitalProduct;
        private boolean displayOnly;
        private boolean fastlane;
        private boolean homeDeliveryOnly;
        private boolean isLoyaltyProduct;
        private boolean isOfflineProduct;
        private int maxOrderQuantity;
        private boolean modifaceEnabled;
        private boolean multibuy;
        private String name;
        private boolean pharmacy;
        private Price price;
        private int productLoyaltyPoints;
        private boolean purchasable;
        private Stock stock;
        private boolean subscription;
        private String url;
        private boolean whiteLabelShopProduct;
    }

    @JsonAutoDetect
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Selected {
        private String code;
        private PriceData priceData;
        private Stock stock;
        private String url;
        private ArrayList<Object> variantOptionQualifiers;
    }

    @JsonAutoDetect
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Stock {
        private int stockLevel;
        private String stockLevelStatus;
    }

    @JsonAutoDetect
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TotalPrice {
        private String currencyIso;
        private double value;
    }
}
