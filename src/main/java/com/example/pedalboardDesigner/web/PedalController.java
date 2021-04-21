package com.example.pedalboardDesigner.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pedalboardDesigner.model.Pedal;
import com.example.pedalboardDesigner.model.PedalRepository;
import com.example.pedalboardDesigner.model.TypeRepository;

@Controller
public class PedalController {
	
	@Autowired
	private TypeRepository trepo;
	@Autowired
	private PedalRepository prepo;
	
	
	// Controller methods
	
	// Login page

	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	// Fetch all pedals
	@RequestMapping(value = {"/", "pedallist"}, method = RequestMethod.GET)
	public String getPedals(Model model){
		model.addAttribute("pedals", prepo.findAll());
		return "pedallist";	
	}

	// Add a new pedal GET
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNewPedal(Model model) {
		model.addAttribute("pedal", new Pedal());
		model.addAttribute("types", trepo.findAll());
		return "add-pedal";
	}
	
	// Save new pedal
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savePedal(Pedal pedal) {
		prepo.save(pedal);
		return "redirect:pedallist";
	}
	
	// Edit existing pedal information
	
	@RequestMapping(value="/edit/{id}")
	public String editPedal(@PathVariable("id") Long id, Model model) {
		model.addAttribute("pedal", prepo.findById(id));
		model.addAttribute("types", trepo.findAll());
		return "edit-pedal";
	}
	
	// Delete Existing Pedal
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deletePedal(@PathVariable("id")Long id, Model model) {
		prepo.deleteById(id);
		return "redirect:../pedallist";
	}
	
	// Compile your pedalboard
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String compilepPedalboard(Model model) {
		model.addAttribute("pedals", prepo.findAll());
		model.addAttribute("types", trepo.findAll());
		return "pedalboard";
	}
	
	
	
	
}
