package org.example;

public class App {

    public static void main(String[] args)
    {
//        new TestDb().connect();


        CardDb db = new CardDb();
        AppService service = new AppService(db);
        TextUI ui = new TextUI(service);
        ui.start();

    }
}
