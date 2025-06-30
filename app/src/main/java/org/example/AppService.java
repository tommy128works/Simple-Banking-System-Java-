package org.example;

import java.util.ArrayList;
import java.util.List;

public class AppService {
    private final String BIN;
//    private String accountIdentifier;
    private List<String> cards;
    private List<String> pins;

    public AppService() {
        this.BIN = "400000";
        this.cards = new ArrayList<String>();
        this.pins = new ArrayList<String>();
    }

    public String[] createCard() {
        String card = "4321";
        this.cards.add(card);
        String pin = "1234";
        this.pins.add(pin);
        return new String[] {card, pin};
    }

    public boolean verifyLogin(String cardInput, String pinInput) {
        for (String card : this.cards) {
            if (card.equals(cardInput)) {
                for (String pin : this.pins) {
                    if (pin.equals(pinInput)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
