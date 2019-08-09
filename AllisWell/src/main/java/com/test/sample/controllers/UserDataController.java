package com.test.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.sample.model.UserData;
import com.test.sample.repository.UserDataMongoRepository;
import com.test.sample.repository.UserDataSearchRepository;

@Controller
public class UserDataController {

	@Autowired
	UserDataMongoRepository userDataRepository;
	
	@Autowired
	UserDataSearchRepository userDataSearchRepository;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("userDataList", userDataRepository.findAll());
		return "home";
	}
	
	@RequestMapping(value = "/addUserData", method = RequestMethod.POST)
	public String addUserData(@ModelAttribute UserData userData) {
		userDataRepository.save(userData);
		return "redirect:home";
	}
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("userDataList", userDataSearchRepository.searchUserDatas(search));
		model.addAttribute("search", search);
		return "home";
	}
	
}
