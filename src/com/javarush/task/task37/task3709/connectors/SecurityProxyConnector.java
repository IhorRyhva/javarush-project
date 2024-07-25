package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    SimpleConnector simpleConnector;
    SecurityChecker performSecurityCheck = new SecurityCheckerImpl();

    public SecurityProxyConnector(String resource){
        simpleConnector = new SimpleConnector(resource);
    }

    @Override
    public void connect() {
        if(performSecurityCheck.performSecurityCheck())
            simpleConnector.connect();
    }
}
