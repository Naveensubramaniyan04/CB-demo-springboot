package org.springframework.samples.petclinic.controller;

import org.springframework.samples.petclinic.PetClinicApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FontColorController {

	@GetMapping("/fontColor")
	@ResponseBody
	public String getFontColor() {
		return PetClinicApplication.flags.titleColors.getValue();
	}

	@GetMapping("/fontSize")
	@ResponseBody
	public int getFontSize() {
		return PetClinicApplication.flags.titleSize.getValue();
	}

}
