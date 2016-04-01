package com.ensode.websocket;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/defaultdataendpoint")
public class DefaultDataEndpoint {

    @OnMessage
    public String onMessage(String message) {
        String retVal;

        if (message.equals("get_defaults")) {
            retVal = new StringBuilder("{").
                    append("\"firstName\":\"Auto\",").
                    append("\"lastName\":\"Generated\"").
                    append("}").toString();
        } else {
            retVal = "";
        }

        return retVal;
    }

}
