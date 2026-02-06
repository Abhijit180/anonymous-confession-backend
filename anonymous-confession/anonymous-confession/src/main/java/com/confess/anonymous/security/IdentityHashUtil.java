package com.confess.anonymous.security;


import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;


public class IdentityHashUtil {
    public static String generate(HttpServletRequest request){
        String raw = request.getRemoteAddr()
                + request.getHeader("User-Agent");
        return DigestUtils.sha256Hex(raw);
    }
}
