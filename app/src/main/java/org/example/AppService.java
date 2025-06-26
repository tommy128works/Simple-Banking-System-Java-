package org.example;

import java.util.ArrayList;
import java.util.List;

public class AppService {
    private final String BIN;
//    private String accountIdentifier;
    private List<String> cards;

    public AppService() {
        this.BIN = "400000";
        this.cards = new ArrayList<String>();

    }
}
