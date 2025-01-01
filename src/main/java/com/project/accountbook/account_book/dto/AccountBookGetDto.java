package com.project.accountbook.account_book.dto;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class AccountBookGetDto {
	private String userId;
	private int years;
}