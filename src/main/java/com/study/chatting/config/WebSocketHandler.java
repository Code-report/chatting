package com.study.chatting.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
//        TODO 대용량 요청 일 경우, sessions 는 ArrayList<>()보다 Map 이 효율적이지 않는가 ?
//        TimeMeter timeMeter = new TimeMeter();
//        timeMeter.setStartTime(System.currentTimeMillis());

        sessions.add(webSocketSession);
        log.info("접속 : {}", webSocketSession);

//        timeMeter.setEndTime(System.currentTimeMillis());
//        log.info("diff = {}", timeMeter.getDiff());
    }

//    @Override
//    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> message) throws Exception {
//        log.info("메세지 : {}", message);
//    }

    @Override
    protected void handleTextMessage(WebSocketSession webSocketSession, TextMessage textMessage) throws Exception {
        log.info("메세지 : {}", textMessage);
        for(WebSocketSession socketSession: sessions){
            TextMessage  message = new TextMessage(textMessage.getPayload());
            socketSession.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus status) throws Exception {
        sessions.remove(webSocketSession);
        log.info("종료 : {}", webSocketSession);
        /**
         *
         * TODO CloseStatus 에 따른 세션 유지 / 종료 코드
         *
         */
    }
}
