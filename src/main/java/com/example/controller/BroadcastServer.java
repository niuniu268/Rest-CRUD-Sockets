package com.example.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class BroadcastServer extends TextWebSocketHandler {

    private ArrayList <WebSocketSession> sessions = new ArrayList <>( );


    @Override
    public void afterConnectionEstablished (WebSocketSession session) throws Exception {
        sessions.add( session );
        System.out.println( session );
    }

    @Override
    public void afterConnectionClosed (WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println( session );
        sessions.remove( session );

    }

    public void broadcast(String message){

        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage( new TextMessage( message ) );
            } catch (IOException e) {
                throw new RuntimeException( e );
            }
        }


    }
}
