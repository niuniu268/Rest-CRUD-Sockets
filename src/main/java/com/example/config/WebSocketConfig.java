package com.example.config;

import com.example.controller.BroadcastServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.awt.image.RasterFormatException;
@EnableWebSocket
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private BroadcastServer broadcastServer;
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

    @Override
    public void registerWebSocketHandlers (WebSocketHandlerRegistry registry) {

        registry.addHandler( broadcastServer,"/broadcast" );

    }
}
