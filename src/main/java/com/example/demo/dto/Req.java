package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Req<T> {

	private Header header;
	private T responseBody;
	
	@Data
	public static class Header{
		private String resCode;
	}
}
