package com.alexyamaoka.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexyamaoka.lc.api.BillDTO;
import com.alexyamaoka.lc.api.Billing;


@Controller
public class PaymentController {
	
	@RequestMapping("/payment")
	public String showPaymentPage(@ModelAttribute("billDTO") BillDTO billDTO) {
		
		return "payment-page";
	}
	
	
	@RequestMapping("/process-payment")
	public String processPayment(@ModelAttribute("billDTO") BillDTO billDTO) {
		
		return "process-payment";
	}
}
