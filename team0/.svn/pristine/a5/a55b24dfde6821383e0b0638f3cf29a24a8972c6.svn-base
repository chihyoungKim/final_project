package com.inadang.controller;


import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inadang.domain.Criteria;
import com.inadang.domain.MemberVO;
import com.inadang.domain.Payment;
import com.inadang.domain.Store;
import com.inadang.service.MemberService;
import com.inadang.service.OrderMenuService;
import com.inadang.service.OrderService;
import com.inadang.service.PaymentService;
import com.inadang.service.ReviewService;
import com.inadang.service.StoreService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("member/*")
@AllArgsConstructor
@Log4j
public class MemberController {
	private MemberService memberService;
	private StoreService storeService;
	private PaymentService paymentService;
	private OrderService orderService;
	private OrderMenuService orderMenuService;
	private ReviewService reviewService;
	
	/**
	 * @author 황규웅
	 * @param error
	 * @param logout
	 */
	@GetMapping("login")
	public void login(@ModelAttribute String error,@ModelAttribute String logout) {
		
	}
	
	/**
	 * @author 황규웅
	 * return /redirect:/index
	 */
	@PostMapping("login")
	public String login() {
		return "/redirect:/index";
	}
	
	/**
	 * @author 황규웅
	 */
	@GetMapping("contract")
	public void contract() {
		
	}
	
	/**
	 * @author 황규웅
	 */
	@GetMapping("memberJoin")
	public void memberJoin() {
		
	}
	
	/**
	 * @author 황규웅
	 * @param vo
	 * return redirect:/member/login
	 */
	@PostMapping("memberJoin")
	public String memberJoin(MemberVO vo) {
		memberService.joinMember(vo);
		log.info(vo.getId());
		log.info(vo);
		return "redirect:/member/login";
	}
	
	/**
	 * @author 황규웅
	 */
	@GetMapping("managerJoin")
	public void managerJoin() {
		
	}
	
	/**
	 * @author 황규웅
	 * @param vo
	 * return redirect:/member/login
	 */
	@PostMapping("managerJoin")
	public String managerJoin(MemberVO vo) {
		memberService.joinManager(vo);
		log.info(vo.getId());
		log.info(vo);
		return "redirect:/member/login";
	}
	
	/**
	 * @author 황규웅
	 * @param principal
	 * @param model
	 */
	@GetMapping("notice")
	public void notice(Principal principal, Model model) {
		model.addAttribute("member", memberService.get(principal.getName()));
	}
	
	/**
	 * @author 황규웅
	 * @param principal
	 * @param model
	 */
	@GetMapping("modify")
	@PreAuthorize("isAuthenticated()")
	public void modify(Principal principal, Model model) {
		model.addAttribute("member", memberService.get(principal.getName()));
	}
	
	/**
	 * @author 김치형
	 * @param model
	 * @param principal
	 */
	@GetMapping("like")
	@PreAuthorize("isAUthenticated()")
	public void like(Model model, Principal principal) {
		List<Long> snos = storeService.listLike(principal.getName());
		List<Store> stores = new ArrayList<Store>();
		
		snos.forEach(sno->stores.add(storeService.get(sno)));
		stores.forEach(store->{
			if(storeService.getLogo(store.getSno()) != null) {
				store.setAttach(storeService.getLogo(store.getSno()));
			}
		});
		model.addAttribute("stores", stores);
	}
	
	/**
	 * @author 황규웅
	 * @param memberVO
	 * @param rttr
	 * return redirect:/member/notice
	 */
	@PostMapping("modify")
	@PreAuthorize("isAuthenticated() and principal.username == #memberVO.id")
	public String modify(MemberVO memberVO, RedirectAttributes rttr) {
		log.info("과연 : " + memberVO);
		if(memberService.updateMember(memberVO)) {
			rttr.addFlashAttribute("result", "수정");
		}
		return "redirect:/member/notice";
	}
	
	/**
	 * @author 황규웅
	 * @param id
	 * @param email
	 * return success
	 */
	@GetMapping("memberAuth") @ResponseBody 
	public String memberAuth(String id, String email) throws UnsupportedEncodingException, IllegalArgumentException {
		log.info(email);
		log.info(id);
		memberService.emailAuth(id, email);
		return "success";
	}
	
	/**
	 * @author 황규웅
	 * @param id
	 * @param rttr
	 * @param authToken
	 * return redirect:/member/notice
	 */
	@GetMapping("procAuth") 
	public String procAuth(String id, RedirectAttributes rttr, String authToken ) {
		log.info("진짜 " +id);
		rttr.addFlashAttribute("result", memberService.emailAuthToken(id, authToken));
		log.info("어렵다... " +authToken);
		return "redirect:/member/notice";
	}
	
	@PostMapping("notice")
	@PreAuthorize("isAuthenticated() and principal.username == #memberVO.id")
	public void remove(String id, RedirectAttributes rttr) {
		rttr.addFlashAttribute("result", "삭제");
		
	}
	
	
	
	
	/**
	 * @author 이나현,김치형
	 * @param principal
	 * @param model
	 * @param cri
	 * 주문내역히스토리
	 */
	@GetMapping("orderHistory")
	public void orderHistory(Principal principal, Model model, Criteria cri) {
		List<Payment> payments = paymentService.get(principal.getName());
		for(Payment p : payments) {
			p.setOrd(orderService.get(p.getOno()));
			p.setOrderMenus(orderMenuService.findBy(p.getOno()));
			p.setExistReview(reviewService.existReview(p.getOno()));
		}
		
		model.addAttribute("history", payments);
//		model.addAttribute("page", new PageDTO(, cri))
	}
	
	
}
