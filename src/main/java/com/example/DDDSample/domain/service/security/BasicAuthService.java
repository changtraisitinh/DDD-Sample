package com.example.DDDSample.domain.service.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import com.example.DDDSample.application.configuration.ApplicationConfig;
//import vn.hdbank.ebankapi.mbank.application.configuration.keyManage.KeyManager;
//import vn.hdbank.ebankapi.mbank.application.configuration.keyManage.PartnerKey;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class BasicAuthService {
    static final String TOKEN_PREFIX = "Basic ";
    static final String HEADER_STRING = "Authorization";

    @Autowired
    ApplicationConfig applicationConfig;

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            token = token.replace(TOKEN_PREFIX, "");
            byte[] credDecoded = Base64.getDecoder().decode(token);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            final String[] userInfo = credentials.split(":", 2);
            if (userInfo != null && userInfo.length == 2) {

//                final PartnerKey partnerKey = KeyManager.GetInstance(applicationConfig).getPartnerKey(userInfo[0]);
//                //final PartnerKey partnerKey = applicationConfig.getSignature().getPartnerKey(applicationConfig, userInfo[0]);
//                if (!userInfo[0].equals(partnerKey.getPartnerPassword())) {
//                    List<GrantedAuthority> authorities = new ArrayList<>();
//                    authorities.add(new SimpleGrantedAuthority("PARTNER"));
//                    return new UsernamePasswordAuthenticationToken(partnerKey, null, authorities);
//                }
            }

        }
        return null;
    }
}
