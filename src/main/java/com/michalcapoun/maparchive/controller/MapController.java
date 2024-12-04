package com.michalcapoun.maparchive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michalcapoun.maparchive.service.MapService;

@Controller
public class MapController {
private final MapService mapService;

@Autowired
public MapController(MapService mapService) {
    this.mapService = mapService;
}

@GetMapping("/")
public String home() {
    return "home";
}

@PostMapping("/add-trip")
public String addTrip(@RequestParam String mapLink, @RequestParam String tripName, Model model) {
    String tripLength = mapService.getTripLength(mapLink);
    model.addAttribute("tripName", tripName);
    model.addAttribute("tripLength", tripLength);

    return "result";
}
}
