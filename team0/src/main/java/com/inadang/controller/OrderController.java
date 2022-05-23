package com.inadang.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inadang.domain.OrderMenu;
import com.inadang.domain.Payment;
import com.inadang.service.OrderMenuService;
import com.inadang.service.OrderService;
import com.inadang.service.PaymentService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@RequestMapping("order/*")
@Log4j
public class OrderController {
	private final PaymentService paymentService; 
	private final OrderService orderService;
	private final OrderMenuService orderMenuService;

	/**
	 * @author 이나현
	 * @param principal
	 * @param ono
	 * @param model
	 * 주문결제화면
	 */
	@GetMapping ("payment")
	public void order(@AuthenticationPrincipal Principal principal, String ono, Model model){
		model.addAttribute("orderMenu", orderMenuService.findBy(ono));
		model.addAttribute("order", orderService.get(ono));
		log.info(ono);
	}
	
	/**
	 * @author 이나현
	 * @param payment
	 * @return "redirect:/order/history?ono=" + payment.getOno()
	 * 주문결제화면
	 */
	@PostMapping("payment")  
	public String payment(Payment payment){
		paymentService.insert(payment);
		log.info("payment" + payment);
		
		return "redirect:/order/history?ono=" + payment.getOno();
	}
		
	/**
	 * @author 이나현
	 * @param payment
	 * @param model
	 * @return
	 * 결제완료, 주문내용확인화면
	 */
	@GetMapping("history")
	public void history(Payment payment, Model model, OrderMenu om){
		model.addAttribute("history", paymentService.select(payment.getOno()));
		
	}
	
	
	/**
	 * @author 김치형
	 * @param 
	 * @return
	 * 
	 */
	@GetMapping("findorder/{ono}")
	@ResponseBody
	public List<OrderMenu> getOrder(@PathVariable String ono) {
		log.info(orderMenuService.findBy(ono));
		return orderMenuService.findBy(ono);
	}
	

	
	/**
	 * @author 이나현
	 * @param model
	 * @param imp_uid
	 * @return api.paymentByImpUid(imp_uid);
	 * IAMPORT API, 유효성검증
	 */
	@ResponseBody
	@RequestMapping(value="payment/{imp_uid}")
	public IamportResponse<com.siot.IamportRestClient.response.Payment> paymentByImpUid(
			 Model model
			, @PathVariable(value= "imp_uid") String imp_uid) throws IamportResponseException, IOException
	{	
													// REST API,와 REST API secret.
		IamportClient api = new IamportClient("3036721238050964","ab08095efeceb5826011a8f75016182bc8065fa2093e2435ccebfd05083238ae3f34017a42ff1fa0");
		api.paymentByImpUid(imp_uid);
		log.info("imp_uid" + imp_uid);
		return api.paymentByImpUid(imp_uid);
	}	
	
	
}
