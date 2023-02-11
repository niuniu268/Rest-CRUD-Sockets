package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@ServerEndpoint( "/sub/{user}" )
@Component
public class WebSocketServer {



    private static final Map< String, Session> sessionMap = new ConcurrentHashMap <>(  );



    @OnOpen
    public void onOpen ( @PathParam( "user" ) String user, Session session){


        sessionMap.put( user, session );



        JSONObject jsonObject = new JSONObject( );
        JSONArray array = new JSONArray( );

        jsonObject.put( "users", array );

        for (String s : sessionMap.keySet( )) {

             JSONObject jo = new JSONObject(  );
             jo.put("userid", s);
             array.add( jo );

            System.out.println( sessionMap.get(s).getRequestURI());



        }

        broadcast( JSON.toJSONString( jsonObject ) );

    }

    private void broadcast (String message) {

        for (Session value : sessionMap.values( )) {
            try {
                value.getBasicRemote().sendText( message );
            } catch (IOException e) {
                throw new RuntimeException( e );
            }
        }

    }


    @OnClose
    public void onClose (@PathParam( "user" ) String user, Session session) throws IOException {

        sessionMap.remove( user );



    }
@OnMessage
    public void onMessage(@PathParam( "user" ) String user, Session session, String message)  {

    JSONObject object = JSONArray.parseObject( message );
    String toUser = object.getString( "to" );
    String text = object.getString( "text" );
    Session toUserSession = sessionMap.get( toUser );

    if(toUserSession != null){
        JSONObject showObject = new JSONObject( );
        showObject.put("from", user);
        showObject.put( "text", text );
        this.sendMessage(showObject.toJSONString(), toUserSession);
    }
    

    
}

    private void sendMessage (String message, Session toUserSession)  {

        try {
            toUserSession.getBasicRemote().sendText( message );
        } catch (IOException e) {
            throw new RuntimeException( e );
        }


    }


}
