package com.example.pedalboardDesigner.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.pedalboardDesigner.model.SignupForm;
import com.example.pedalboardDesigner.model.User;
import com.example.pedalboardDesigner.model.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository urepo;
	
	@RequestMapping(value = "signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	@RequestMapping(value="saveuser", method=RequestMethod.POST)
	public String save(@ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()) {
			if(signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
				String password = signupForm.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPassword = bc.encode(password);
				
				User newUser = new User();
				newUser.setPasswordHash(hashPassword);
				newUser.setUsername(signupForm.getUsername());
				// Define ONE user profile with admin credentials
//				if(signupForm.getUsername().equals("AaroAdmin")) {
//					newUser.setRole("ADMIN");
//				} else {
//					newUser.setRole("USER");
//				}
				newUser.setEmail(signupForm.getEmail());
//				newUser.setRole("USER");
				if(urepo.findByUsername(signupForm.getUsername()) == null) {
					urepo.save(newUser);
				} else {
					bindingResult.rejectValue("username", "err.username", "That username is already in use");
					return "signup";
				}
			} else {
				bindingResult.rejectValue("passwordCheck", "err.passwordCheck", "Passwords did not match, try again");
				return "signup";
			}
		}
		else {
			return "signup";
		}
		return "redirect:/login";
		}
	}


