/*
 * Students:
 * Sharang Verma - 300981587
 * Harkirat Grewal - 300987512
 * Rojina Akter - 300756946
 * 
 * Submission Date: April 2, 2021
 * */
package com.spring.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CentreController {

	@Autowired
	private CentreRepository centreRepository;

	@RequestMapping("/")
	public String home() {
		return "centrehome";
	}

	// for getting the centres summary
	@GetMapping(value = "/allcentres")
	public String showCentres(Model model) {
		model.addAttribute("centreList", centreRepository.findAll());
		return "centresummary";
	}

	// For adding centres
	@GetMapping(value = "/centre")
	public String showCentre(Centre centre) {
		return "addcentre";
	}

	@PostMapping("/addcentre")
	public String saveCentre(@Valid Centre centre, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addcentre";
		}
		centreRepository.save(centre);
		return "redirect:/";
	}

	// for getting the centres based on the centreId
	@GetMapping("/centre/{centreId}")
	public String editCentre(@PathVariable("centreId") int centreId, Model model) {
		Centre centre = centreRepository.findById(centreId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid centre id: " + centreId));
		model.addAttribute("centre", centre);
		return "editcentre";
	}

	// for updating a centre
	@RequestMapping(value = "/centreUpdate/{centreId}", method = RequestMethod.POST)
	public String updatePatient(@PathVariable("centreId") int centreId, @Valid Centre centre, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			centre.setCentreId(centreId);
			return "editCentre";
		}
		centreRepository.save(centre);
		return "redirect:/allcentres";
	}

	// for deleting the centre
	@GetMapping("/centreDelete/{centreId}")
	public String deleteCentre(@PathVariable("centreId") int centreId) {
		Centre centre = centreRepository.findById(centreId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid centre id: " + centreId));
		centreRepository.delete(centre);
		return "redirect:/allcentres";
	}

	// For Searching a centre
	@GetMapping(value = "/searchcentre")
	public String showCentreSearch() {
		return "searchcentre";
	}

	// for looking a specific centres
	@GetMapping(value = "/centresearch")
	public String searchCentre(@RequestParam("centreName") String centreName, Model model) {
		List<Centre> centreList = centreRepository.findByCentreName(centreName);
		if (centreList == null || centreList.isEmpty()) {
			model.addAttribute("error", "The centre not found");
			return "centredetails";
		} else {
			model.addAttribute("centreList", centreList);
			return "centredetails";
		}
	}
}