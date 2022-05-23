 package com.inadang.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inadang.domain.Cart;
import com.inadang.service.CartService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("cart/*")
public class CartController {
	
	private final CartService cartService;
	
	/**
	 * @author 김승종
	 * @param principal
	 * @param cart
	 * @return
	 * 장바구니 추가
	 */
	@PostMapping("add")
	@ResponseBody
	public Long addCart(@AuthenticationPrincipal Principal principal, @RequestBody Cart cart){ // 장바구니 담기
		log.info(cart);
		if(cartService.checkCart(principal.getName(), cart.getMno()) == 0){
			cartService.addCart(cart.getMno(), cart.getCount(), principal.getName());
			Cart result = cartService.getLastCno(principal.getName());	
			log.info(result);
			return result.getCno();			
		} else {
			return null;
		}
	}
	
	/**
	 * @author 김승종
	 * @param principal
	 * @return
	 * 장바구니 화면 출력
	 */
	@GetMapping("id")
	@ResponseBody
	public List<Cart> getCart(@AuthenticationPrincipal Principal principal){
		List<Cart> cart = new ArrayList<>();
		if(principal != null){
			cart = cartService.list(principal.getName());
			log.info(cart);
		}
		return cart;
	}
	
	/**
	 * @author 김승종
	 * @param cno
	 * @return
	 * 장바구니 화면 출력(비동기)
	 */
	@GetMapping("get/{cno}")
	@ResponseBody
	public Cart get(@PathVariable Long cno) {
		return cartService.get(cno);
	}
	
	/**
	 * @author 김승종
	 * @param principal
	 * @param cno
	 * @return
	 * 장바구니 삭제
	 */
	@DeleteMapping("remove/{cno}")	
	@ResponseBody
	public String removerCart(@AuthenticationPrincipal Principal principal, @PathVariable Long cno){ // 장바구니 삭제
		return cartService.deleteCart(cno, principal.getName()) > 0 ? "success" : null;
	}
	
	/**
	 * @author 김승종
	 * @param cno
	 * @return
	 * 장바구니 수량 추가
	 */
	@PostMapping("plus/{cno}")
	@ResponseBody
	public String plucCart(@PathVariable Long cno){
		 return cartService.plusCart(cno) > 0 ? "success" : null;
	}

	/**
	 * @author 김승종
	 * @param cno
	 * @return
	 * 장바구니 수량 삭제
	 */
	@PostMapping("minus/{cno}")
	@ResponseBody
	public String minusCart(@PathVariable Long cno){
		return cartService.minusCart(cno) > 0 ? "success" : null;
	}
}
