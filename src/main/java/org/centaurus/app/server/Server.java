package org.centaurus.app.server;

public class Server {

    public static void start() {

        AppServer appServer = new TomcatServer();
        appServer.create();
        appServer.configure();
        appServer.start();

    }
}
