package api.responses;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.*;

@Builder
@JsonAutoDetect
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartCreatedResponse {

        private String type;
        private String cartType;
        private String code;
        private ArrayList<Object> entries;
        private String guid;
        private int payWithPoints;
        private int pointTotalAfterOrder;
        private int redeemLoyaltyPoints;
        private int rewardLoyaltyPoints;
        private int totalItems;
        private TotalPrice totalPrice;
        private TotalPriceWithTax totalPriceWithTax;
        private boolean adultCustomer;
        private boolean checkoutBlocked;
        private boolean consistentAddress;
        private boolean containsOtcProducts;
        private boolean guestCheckoutAllowed;
        private boolean homeDeliveryOnly;
        private boolean paymentBlocked;
        private boolean placeOrderBlocked;
        private boolean showFastlaneNotification;

        @JsonAutoDetect
        @Getter
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class TotalPrice {
                private String currencyIso;
                private double value;
        }

        @JsonAutoDetect
        @Getter
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class TotalPriceWithTax {
                private String currencyIso;
                private double value;
        }
}

