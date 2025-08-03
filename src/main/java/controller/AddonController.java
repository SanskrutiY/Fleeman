package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enums.AddonType;

@RestController
@RequestMapping("/api/addon")
public class AddonController {

	@GetMapping("/available-addons")
	private List<String> getAllAvailableAddons() {
		return List.of(AddonType.values()).stream()
				.map(val -> val.stringValue()).toList();
	}
}
