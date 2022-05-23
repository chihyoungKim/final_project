package com.inadang.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inadang.domain.CriteriaReview;
import com.inadang.domain.Review;
import com.inadang.service.ReviewService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
@RequestMapping("reviews/*")
public class ReviewController {
	
	private ReviewService service;
	/**
	 * @author 김치형
	 * @param sno
	 * @param lastRno
	 * @param amount
	 * @return
	 */
	@ResponseBody
	@GetMapping({"pages/{sno}", "pages/{sno}/{lastRno}", "pages/{sno}/{lastRno}/{amount}"})
	public List<Review> getList(
			@PathVariable Long sno,
			@PathVariable(required=false) Optional<Long> lastRno,
			@PathVariable(required=false) Optional<Integer> amount
			) {
		CriteriaReview cri = new CriteriaReview();
		
		cri.setLastRno(lastRno.orElse(cri.getLastRno()));
		cri.setAmount(amount.orElse(cri.getAmount()));
		List<Review> reviews = service.list(sno, cri);
		for(Review r : reviews) {
			r.setAttachs(service.getAttach(r.getRno()));
		}
		
		return reviews;
	}

	
	/**
	 * @author 김치형
	 * @param principal
	 * @param model
	 * @param review
	 * @return
	 */
	@PostMapping("register")
	@PreAuthorize("isAUthenticated()")
	public String registerReview(Principal principal, Model model, Review review) {
		log.info(review);
		review.setId(principal.getName());
		service.register(review);
		
		return "redirect:/member/orderHistory";
	}
}
