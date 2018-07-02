package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

/**
 * Created by Павлуша on 25.04.2018.
 */
public class SecurityProxyConnector implements Connector {
    private SimpleConnector connector;
    private SecurityChecker checker = new SecurityCheckerImpl();

    public SecurityProxyConnector(String resourceString) {
        connector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {

        if(checker.performSecurityCheck()) connector.connect();
    }
}
