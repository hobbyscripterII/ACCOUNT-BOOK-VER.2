package com.project.accountbook.account_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account_book")
public class AccountBookController {
	private final AccountBookService accountbookService;
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	public AccountBookController(AccountBookService accountbookService) {
		this.accountbookService = accountbookService;
	}
	
	@GetMapping("/main")
	public String main(Model model) {
		return "account_book/main";
	}
}
