package com.biz.socket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.biz.socket.domain.MessageVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ChatController extends TextWebSocketHandler{

	List<WebSocketSession> sessionList ;
	Map<String,MessageVO> messageMap ;
	
	public ChatController() {
		sessionList = new ArrayList<WebSocketSession>();
		messageMap = new HashMap<String,MessageVO>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
		sessionList.add(session);
		
		MessageVO mVO = MessageVO.builder()
						.build();
		messageMap.put(session.getId(),mVO);

	}
	
	

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		sessionList.remove(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
		
		// jackson Bind의 클래스인 ObjectMapper를 사용하여
		// VO 클래스를 Json형 문자열로 바로 변환시키기
		ObjectMapper objMapper = new ObjectMapper();
		Map<String,String> map = new HashMap<String,String>();
		
		String user[] = message.getPayload().split(":");
		if(user.length > 1) {
			if(user[0].equalsIgnoreCase("USERNAME")) {
				MessageVO mVO = messageMap.get(session.getId());
				mVO.setUserName(user[1]);
				
				map.put("msg", "userName");
				map.put("userName", mVO.getUserName());
				
				/*
				 session.sendMessage(
						new TextMessage(
							String.format("{\"msg\":\"userName\",\"userName\":\"%s\"}",
							mVO.getUserName())));
				*/
				session.sendMessage(new TextMessage(objMapper.writeValueAsString(map)));
				return;
			}
		}

		if(message.getPayload().equalsIgnoreCase("GETUSERLIST")) {
			log.debug("GETUSERLIST");
			String userList = objMapper.writeValueAsString(messageMap);
			map.put("msg","userList");
			map.put("userList",userList);
			
			String userListMap = objMapper.writeValueAsString(map);
			log.debug(userListMap);
			this.sendMessage(session, userListMap);
			return;
			
		}

		Gson gson = new Gson();
		/*
		 * Gson을 사용하여 문자열형 JSON 데이터를 VO로 변환
		 */
		MessageVO messageVO = gson.fromJson(message.getPayload(), 
							MessageVO.class); 
		
		String sendMessage = String.format("%s 로부터 : %s",
						messageVO.getUserName(),
						messageVO.getMessage());
		
		// TextMessage sendTextMessage = new TextMessage(sendMessage);
		
		String jSonTextMessage = objMapper.writeValueAsString(messageVO);
		this.sendMessage(session, jSonTextMessage);

		
	}
	
	private void sendMessage(WebSocketSession session,
						String textMessage) throws IOException {
		
		TextMessage sendMessage = new TextMessage(textMessage);
		for(WebSocketSession ws : sessionList) {
			// 자신이 보낸 메시지는 다시 자신에게 보낼필요는 없기 때문에
			// 자신이 본낸 메시지를 제외하고 전송
			if( !ws.getId().equals(session.getId()) ) {
				ws.sendMessage(sendMessage);	
				
			}
		}
	}
	
}

















