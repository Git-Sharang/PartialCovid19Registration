/*
 * Students:
 * Sharang Verma - 300981587
 * Harkirat Grewal - 300987512
 * Rojina Akter - 300756946
 * 
 * Submission Date: April 2, 2021
 * */
package com.spring.web;

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
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;

	@RequestMapping("/")
	public String home() {
		return "patienthome";
	}

	// for getting the patients summary
	@GetMapping(value = "/allpatients")
	public String showPatients(Model model) {
		model.addAttribute("patientList", patientRepository.findAll());
		return "patientsummary";
	}

	// For adding patients
	@GetMapping(value = "/register")
	public String showPatient(Patient patient) {
		return "addpatient";
	}

	// for saving a patient
	@PostMapping("/registerpatient")
	public String savePatient(@Valid Patient patient, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addpatient";
		}
		patientRepository.save(patient);
		return "redirect:/";
	}

	// for getting the patients based on the patientId
	@GetMapping("/patient/{patientId}")
	public String editPatient(@PathVariable("patientId") int patientId, Model model) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid patient id: " + patientId));
		model.addAttribute("patient", patient);
		return "editpatient";
	}

	// for updating a patient
	@RequestMapping(value = "/patientUpdate/{patientId}", method = RequestMethod.POST)
	public String updatePatient(@PathVariable("patientId") int patientId, @Valid Patient patient, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			patient.setPatientId(patientId);
			return "editPatient";
		}
		patientRepository.save(patient);
		return "redirect:/allpatients";
	}

	// for deleting a patient
	@GetMapping("/patientdelete/{patientId}")
	public String deletePatient(@PathVariable("patientId") int patientId) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid patient id: " + patientId));
		patientRepository.delete(patient);
		return "redirect:/allpatients";
	}

	// For Searching a patient
	@GetMapping(value = "/searchpatient")
	public String showSearch() {
		return "searchpatient";
	}

	// for looking a specific patient
	@GetMapping(value = "/patientsearch")
	public String searchPatient(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			Model model) {
		Patient patientOne = patientRepository.findByFirstname(firstname);
		Patient patientTwo = patientRepository.findByLastname(lastname);

		if(patientOne == null || patientTwo == null) {
			model.addAttribute("error", "The patient not found");
			return "patientdetails";
		}else {
			if(patientOne.getFirstname().equals(patientTwo.getFirstname()) && 
					patientOne.getLastname().equals(patientTwo.getLastname())) {
				model.addAttribute("patientInfo", patientOne);
				return "patientdetails";
			}else {
				model.addAttribute("error", "The patient not found");
				return "patientdetails";
			}
		}
	}
}
