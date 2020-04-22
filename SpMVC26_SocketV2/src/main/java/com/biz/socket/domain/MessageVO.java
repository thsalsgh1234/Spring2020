package com.biz.socket.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userName;
	private String message;
	private String sendUser;
	private String toUser;
	
}


