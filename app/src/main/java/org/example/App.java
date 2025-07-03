package org.example;

public class App {

    public static void main(String[] args)
    {
//        new TestDb().connect();


        AppService service = new AppService();
        CardDb db = new CardDb();
        TextUI ui = new TextUI(service, db);
        ui.start();

    }
}
