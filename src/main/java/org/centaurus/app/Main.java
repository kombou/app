package org.centaurus.app;

import org.apache.catalina.LifecycleException;
import org.centaurus.app.server.Server;

import javax.servlet.ServletException;

public class Main {
    public static void main(String argv[]) throws ServletException, LifecycleException {
        Server.start();
    }
}
