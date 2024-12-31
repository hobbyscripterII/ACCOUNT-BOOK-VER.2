package com.project.accountbook.account_book;

import org.springframework.stereotype.Service;

@Service
public class AccountBookService {
	private final AccountBookMapper accountBookMapper;
	
	public AccountBookService(AccountBookMapper accountBookMapper) {
		this.accountBookMapper = accountBookMapper;
	}
}