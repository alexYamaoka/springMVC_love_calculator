package com.alexyamaoka.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexyamaoka.lc.api.Billing;
import com.alexyamaoka.lc.api.CreditCard;

@Controller
public class PaymentController {
	
	@RequestMapping("/payment")
	public String showPaymentPage(@ModelAttribute("billing") Billing billing) {
		
		return "payment-page";
	}
	
	
	@RequestMapping("/process-payment")
	public String processPayment(@ModelAttribute("billing") Billing billing) {
		
		return "process-payment";
	}
}
