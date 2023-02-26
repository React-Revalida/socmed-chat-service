package org.ssglobal.revalida.codes.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssglobal.revalida.codes.dto.AppUserDTO;
import org.ssglobal.revalida.codes.service.MutualFollowsService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MutalFollowsController {

    @Autowired
    private MutualFollowsService followsService;

    @PostMapping("/mutual-followed")
    public Set<AppUserDTO> getMutalFollows(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token) {
        return followsService.mutualFollows(token);
    }

}
