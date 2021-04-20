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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@Autowired
	private TestRepository testRepository;

	@RequestMapping("/")
	public String home() {
		return "testhome";
	}

	// for getting the tests summary
	@GetMapping(value = "/alltests")
	public String showTests(Model model) {
		model.addAttribute("testList", testRepository.findAll());
		return "testsummary";
	}

	// For adding tests
	@GetMapping(value = "/test")
	public String showTest(Test test) {
		return "addtest";
	}

	// for adding a test
	@PostMapping("/addtest")
	public String saveTest(@Valid Test test, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addtest";
		}
		testRepository.save(test);
		return "redirect:/";
	}

	// for getting the tests based on the testId
	@GetMapping("/test/{testId}")
	public String editTest(@PathVariable("testId") int testId, Model model) {
		Test test = testRepository.findById(testId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid test id: " + testId));
		model.addAttribute("test", test);
		return "edittest";
	}

	// for updating a test
	@RequestMapping(value = "/testUpdate/{testId}", method = RequestMethod.POST)
	public String updateTest(@PathVariable("testId") int testId, @Valid Test test, BindingResult result, Model model) {
		if (result.hasErrors()) {
			test.setTestId(testId);
			return "edittest";
		}
		testRepository.save(test);
		return "redirect:/alltests";
	}

	// for deleting a test
	@GetMapping("/testDelete/{testId}")
	public String deleteTest(@PathVariable("testId") int testId) {
		Test test = testRepository.findById(testId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid test id: " + testId));
		testRepository.delete(test);
		return "redirect:/alltests";
	}

	// For Searching a test by Date
	@GetMapping(value = "/searchtest")
	public String showTestSearch() {
		return "searchtest";
	}

	// for looking a specific tests based on the testDate
	@GetMapping(value = "/testsearch")
	public String searchTest(@RequestParam("testDate") String testDate, Model model) {
		List<Test> specificTestsByDate = testRepository.findByTestDate(testDate);
		if (specificTestsByDate == null || specificTestsByDate.isEmpty()) {
			model.addAttribute("error", "The test not found");
			return "testdetails";
		} else {
			model.addAttribute("testList", specificTestsByDate);
			return "testdetails";
		}
	}
}
