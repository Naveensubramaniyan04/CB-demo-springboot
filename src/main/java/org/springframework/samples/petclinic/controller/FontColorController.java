package org.springframework.samples.petclinic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FontColorController {

	@GetMapping("/fontColor")
	@ResponseBody
	public String getFontColor() {
		return flags.titleColors.getValue();
	}

}