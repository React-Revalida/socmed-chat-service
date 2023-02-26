package org.ssglobal.revalida.codes.service;

import java.util.Set;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.ssglobal.revalida.codes.dto.AppUserDTO;

@FeignClient(name = "social-media-app", url = "${social-media-app.uri}")
public interface MutualFollowsService {
    @PostMapping("/mutually-followed")
    Set<AppUserDTO> mutualFollows(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token);
}
