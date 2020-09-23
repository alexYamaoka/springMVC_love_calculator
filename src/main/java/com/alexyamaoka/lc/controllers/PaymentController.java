package com.alexyamaoka.lc.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexyamaoka.lc.api.BillDTO;
import com.alexyamaoka.lc.propertyEditor.MyCurrencyEditor;



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
		
		// editor for the date field
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
		CustomDateEditor customDateEditor = new CustomDateEditor(simpleDateFormat, true);
		webDataBinder.registerCustomEditor(Date.class, "date", customDateEditor);
		
		
		// register a custom editor for the amount field
		NumberFormat numberFormat = new DecimalFormat("##,###.00");
		CustomNumberEditor customNumberEditor = new CustomNumberEditor(BigDecimal.class, numberFormat, true);
		webDataBinder.registerCustomEditor(BigDecimal.class, "amount", customNumberEditor);
		
		
		// register a custom editor for currency 
		MyCurrencyEditor myCurrencyEditor = new MyCurrencyEditor();
		webDataBinder.registerCustomEditor(Currency.class, "currency", myCurrencyEditor);
	}
}








