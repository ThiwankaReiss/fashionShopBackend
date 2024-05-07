package org.example.controller.custom.impl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class ProxyController {
    @GetMapping("/proxy/{url}")
    public byte[] proxy(@PathVariable String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://drive.google.com/thumbnail?id="+url, byte[].class);
    }
}
