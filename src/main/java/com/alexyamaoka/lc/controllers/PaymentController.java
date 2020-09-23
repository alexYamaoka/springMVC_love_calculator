package com.alexyamaoka.lc.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexyamaoka.lc.api.BillDTO;



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
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		System.out.println("inside init binder of payment controller");
		
		// property editor
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm-dd-yyyy");
		CustomDateEditor customDateEditor = new CustomDateEditor(simpleDateFormat, true);
		webDataBinder.registerCustomEditor(Date.class, "date", customDateEditor);
		
		
	}
}
