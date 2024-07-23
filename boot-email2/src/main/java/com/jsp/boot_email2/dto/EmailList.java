package com.jsp.boot_email2.dto;

import lombok.Data;

@Data
public class EmailList {

	String[] to;
	String subject;
	String body;
}
