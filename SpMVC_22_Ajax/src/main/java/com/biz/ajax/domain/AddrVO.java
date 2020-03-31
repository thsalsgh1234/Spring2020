package com.biz.ajax.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddrVO {

	private String ad_name;
	private String ad_addr;
	private String ad_tel;
	private int ad_age;
	
}
