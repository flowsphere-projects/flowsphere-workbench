package com.flowsphere.server.business.controller;

import com.flowsphere.server.business.entity.Provider;
import com.flowsphere.server.business.entity.ProviderFunction;
import com.flowsphere.server.business.entity.ProviderInstant;
import com.flowsphere.server.business.request.ProviderFunctionRequest;
import com.flowsphere.server.business.request.ProviderInstantRequest;
import com.flowsphere.server.business.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping("/registerInstant")
    public ResponseEntity registerInstant(@RequestBody ProviderInstantRequest request) {
        providerService.registerInstant(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/registerInstantFunction")
    public ResponseEntity registerInstantFunction(@RequestBody List<ProviderFunctionRequest> list) {
        for (ProviderFunctionRequest request : list) {
            providerService.registerInstantFunction(request);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByName")
    public ResponseEntity<Page<Provider>> findByName(String providerName, @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(providerService.findByName(providerName, pageable));
    }


    @GetMapping("/findInstantByProviderId")
    public ResponseEntity<Page<ProviderInstant>> findInstantByProviderId(Integer providerId, @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(providerService.findInstantByProviderId(providerId, pageable));
    }

    @GetMapping("/findFunctionByProviderId")
    public ResponseEntity<Page<ProviderFunction>> findFunctionByProviderId(Integer providerId, @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(providerService.findFunctionByProviderId(providerId, pageable));
    }


}