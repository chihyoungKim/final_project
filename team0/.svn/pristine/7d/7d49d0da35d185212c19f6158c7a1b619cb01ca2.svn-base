package com.inadang.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inadang.domain.CriteriaReview;
import com.inadang.domain.CriteriaScroll;
import com.inadang.domain.Menu;
import com.inadang.domain.Order;
import com.inadang.domain.OrderMenu;
import com.inadang.domain.Payment;
import com.inadang.domain.Review;
import com.inadang.domain.Store;
import com.inadang.service.MemberService;
import com.inadang.service.MenuService;
import com.inadang.service.OrderMenuService;
import com.inadang.service.OrderService;
import com.inadang.service.ReviewService;
import com.inadang.service.StoreService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("store/*")
public class StoreController {
	private final StoreService storeService;
	private final MenuService menuService;
	private final ReviewService reviewService;
	private final MemberService memberService;
	private final OrderService orderService;
	private final OrderMenuService orderMenuService;
			
	/**
	 * @author 김치형
	 * @param model
	 * @param category
	 * @return
	 * 가게 리스트
	 */
	@GetMapping("list/{category}") 
	public String list(
			Model model, 
			@PathVariable Long category, 
			Optional<String> condition
		) {
		CriteriaScroll cri = new CriteriaScroll();
		List<Store> ad = storeService.listAd(category);
		
		String cdn = condition.orElse("");
		List<Store> list = storeService.list(category, cri, cdn);
		
		for(Store s : ad) {
			if(storeService.getLogo(s.getSno()) != null) {
				s.setAttach(storeService.getLogo(s.getSno()));
			}
		}
		for(Store s : list) {
			if(storeService.getLogo(s.getSno()) != null) {
				s.setAttach(storeService.getLogo(s.getSno()));
			}
		}
		model.addAttribute("ad", ad);
		model.addAttribute("stores", list);
		model.addAttribute("category", category);
		return "store/list";
		
	}
	
	/**
	 * @author 김치형
	 * @param sno
	 * @param model
	 * @return
	 * 가게 상세보기
	 */
	@GetMapping("detail/{sno}")
	@PreAuthorize("isAUthenticated()")
	public String detail(@PathVariable Long sno, Model model
			, @AuthenticationPrincipal Principal principal) {
		
		CriteriaReview cri = new CriteriaReview();
		
		if(principal == null) {
			model.addAttribute("msg", "로그인 후 이용가능한 서비스입니다.");
			model.addAttribute("href", "/member/login");
			return "common/msg";
		}
		
		Store store = storeService.get(sno);
		if(storeService.getLogo(sno) != null) {
			store.setAttach(storeService.getLogo(sno));
		}
		model.addAttribute("store", store);
		CriteriaScroll criMenu = new CriteriaScroll();
		List<Menu> list = menuService.list(sno, criMenu);
		for(Menu m : list) {
			m.setAttach(menuService.getAttach(m.getMno()));
		}
		model.addAttribute("menus", list);
		List<Review> reviews = reviewService.list(sno, cri);
		//log.info(reviews);
		for(Review r : reviews) {
			r.setAttachs(reviewService.getAttach(r.getRno()));
		}
		
		
		model.addAttribute("like", storeService.likes(principal.getName(), sno));
		model.addAttribute("reviews", reviews);
		
		return "store/detail";
	}
	
	
	/**
	 * @author 이나현
	 * @param sno
	 * @return "redirect:/order/payment?ono=" + orderService.get(ono);
	 * menu 주문하기
	 */
	@PostMapping("detail/{sno}")
	public String toOrder(@AuthenticationPrincipal Principal principal, Order order) {
		principal.getName();
		order.setId(principal.getName());
//		log.info(order);
		
		orderService.insert(order);
		return "redirect:/order/payment?ono=" + order.getOno();
	}
	
	
	/**
	 * @author 김치형
	 * @param sno
	 * @param lastNo
	 * @param amount
	 * @return
	 * menu 더보기
	 */
	@GetMapping({"menu/{sno}", "menu/{sno}/{lastNo}", "menu/{sno}/{lastNo}/{amount}"})
	@ResponseBody
	public List<Menu> getList(
			@PathVariable Long sno,
			@PathVariable(required=false) Optional<Long> lastNo,
			@PathVariable(required=false) Optional<Integer> amount
			) {
		CriteriaScroll cri = new CriteriaScroll();
		
		cri.setLastNo(lastNo.orElse(cri.getLastNo()));
		cri.setAmount(amount.orElse(cri.getAmount()));
		
		List<Menu> menus = menuService.list(sno, cri);
		
		for(Menu m : menus) {
			if(menuService.getAttach(m.getMno()) != null) {
				m.setAttach(menuService.getAttach(m.getMno()));
			}
		}
		return menus;
	}
	
	/**
	 * @author 김치형
	 * @param category
	 * @param lastNo
	 * @param amount
	 * @return
	 * 가게 더보기
	 */
	@GetMapping({
		"pages/{category}", 
		"pages/{category}/{lastNo}", 
		"pages/{category}/{lastNo}/{amount}", 
		"pages/{category}/{lastNo}/{amount}/{condition}",
		"pages/{category}/{lastNo}/{amount}/{condition}/{search}"
	})
	@ResponseBody
	public List<Store> getStoreList(
			@PathVariable Long category,
			@PathVariable(required=false) Optional<Long> lastNo,
			@PathVariable(required=false) Optional<Integer> amount,
			@PathVariable(required=false) Optional<String> condition,
			@PathVariable(required=false) Optional<String> search
			) {
		CriteriaScroll cri = new CriteriaScroll();
		
		cri.setLastNo(lastNo.orElse(cri.getLastNo()));
		cri.setAmount(amount.orElse(cri.getAmount()));
		List<Store> stores = new ArrayList<>();
		
		String cdn = condition.orElse(" ");
		String a = search.orElse(" ");
		if(cdn.equals("F")) {
			stores = storeService.listBySearch(category, cri, a);
		}
		else {
			stores = storeService.list(category, cri, cdn);
		}
		
		
		for(Store s : stores) {
			if(storeService.getLogo(s.getSno()) != null) {
				s.setAttach(storeService.getLogo(s.getSno()));
			}
		}
		return stores;
	}
	
	/**
	 * @author 김치형
	 * @param principal
	 * @param sno
	 * @return
	 */
	@GetMapping("like/{sno}")
	@PreAuthorize("isAUthenticated()")
	public String like(@AuthenticationPrincipal Principal principal, @PathVariable Long sno) {
		storeService.changeLike(principal.getName(), sno);
		return "success";
	}

	
	/**
	 * @author 김승종
	 * 사장페이지 공지사항
	 */
	@GetMapping("notice")
	public void notice(){}
	
	/**
	 * @author 김승종
	 * @param principal
	 * @param model
	 * 사장페이지 가게등록
	 */
	@GetMapping("register")
	public void register(@AuthenticationPrincipal Principal principal, Model model){
		model.addAttribute("member", memberService.get(principal.getName()));
	}
	
	/**
	 * @author 김승종
	 * @param principal
	 * @param store
	 * @return
	 * 사장페이지 가게등록
	 */
	@PostMapping("register")
	public String register(@AuthenticationPrincipal Principal principal, Store store) {
		storeService.register(store);		
		memberService.updateSno(principal.getName(), store.getSno());
		
		return "/store/notice";
	}
	
	/**
	 * @author 김승종
	 * @param principal
	 * @param model
	 * 사장페이지 가게정보, 가게수정
	 */
	@GetMapping({"get", "modify"})
	public void get(@AuthenticationPrincipal Principal principal, Model model){
		model.addAttribute("member", memberService.get(principal.getName()));
		if(memberService.get(principal.getName()).getSno() != null){
			model.addAttribute("store", storeService.getStoreById(principal.getName()));			
		}
	}

	/**
	 * @author 김승종
	 * @param principal
	 * @param store
	 * @return
	 * 사장페이지 가게수정
	 */
	@PostMapping("modify")
	public String modify(@AuthenticationPrincipal Principal principal, Store store){
		log.info(store);
		storeService.modify(store, principal.getName());
		
		return "/store/modify";
	}

	/**
	 * @author 김승종
	 * @param principal
	 * @return
	 * 사장페이지 가게삭제
	 */
	@PostMapping("get")
	public String removeStore(@AuthenticationPrincipal Principal principal, Model model) {
		storeService.removeStore(Long.parseLong(memberService.get(principal.getName()).getSno()));
		
		return "redirect:/store/notice";
	}

	/**
	 * @author 김승종
	 * 사장페이지 가게광고
	 */
	@GetMapping("ad")
	public void ad(){
		log.info("storeManagement ad get");
	}

	/**
	 * @author 김승종
	 * 사장페이지 수정이력
	 */
	@GetMapping("history")
	public void history(){
		log.info("storeManagement history get");
	}
	
	
	/**
	 * @author 이나현
	 * @param principal
	 * @param model
	 * @param order
	 * 주문내역확인
	 */
	@GetMapping("storeHistory")
	public String storeHistory(@AuthenticationPrincipal Principal principal, Model model, Long sno, Order order){
		if(principal == null) {
			model.addAttribute("msg", "로그인 후 이용가능한 서비스입니다.");
			model.addAttribute("href", "/member/login");
			return "common/msg";
		}
		model.addAttribute("member", memberService.get(principal.getName()));
		if(memberService.get(principal.getName()).getSno() != null){
			model.addAttribute("store", storeService.get(memberService.getSno(principal.getName())));
			List<Order> list = orderService.showList(memberService.getSno(principal.getName()));
			for(Order o : list) {
				o.setOrderMenus(orderMenuService.findBy(o.getOno()));
			}
			model.addAttribute("history", list);
			//log.info(storeService.get(memberService.getSno(principal.getName())));
		}
		
		return "/store/storeHistory";
	}
	
	
	/**
	 * @author 김치형
	 * @param model
	 * @param principal
	 */
	@GetMapping("menu")
	@PreAuthorize("isAUthenticated()")
	public void menu(Model model, Principal principal) {
		model.addAttribute("member", memberService.get(principal.getName()));
		if(memberService.get(principal.getName()).getSno() != null){
			Store store = storeService.getStoreById(principal.getName());
			List<Menu> menus = menuService.list(store.getSno(), new CriteriaScroll());
			for(Menu m : menus) {
				if(menuService.getAttach(m.getMno()) != null) {
					m.setAttach(menuService.getAttach(m.getMno()));
				}
			}
			model.addAttribute("store", store);
			model.addAttribute("menus", menus);
		}
	}
	
	/**
	 * @author 김치형
	 * @param menu
	 * @param principal
	 */
	@PostMapping("menu")
	public String menu(Menu menu) {
		menuService.register(menu);
		return "redirect:/store/menu";
	}
	
	/**
	 * @author 김치형
	 * @param mno
	 * @return
	 */
	@GetMapping("menuState/{mno}")
	public String menuState(@PathVariable Long mno) {
		menuService.changeState(mno);
		return "redirect:/store/menu";
	}
	
	/**
	 * @author 김치형
	 * @param principal
	 * @param model
	 */
	@GetMapping("reply")
	@PreAuthorize("isAUthenticated()")
	public void reply(Principal principal, Model model) {
		Store store = storeService.getStoreById(principal.getName());
		List<Menu> menus = menuService.list(store.getSno(), new CriteriaScroll());
		for(Menu m : menus) {
			if(menuService.getAttach(m.getMno()) != null) {
				m.setAttach(menuService.getAttach(m.getMno()));
			}
		}
		model.addAttribute("store", store);
	}
	
	/**
	 * @author 김치형
	 * @param principal
	 * @param review
	 * @return
	 */
	@PostMapping("reply")
	public String replyRegister(Principal principal, Review review) {
		review.setId(principal.getName());
		reviewService.replyRegister(review);
		return "redirect:/store/reply";
	}
}
