package com.example.fileuploadservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;


@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(List.of(
                "http://localhost:3000", // next.js 로컬
                "https://flow-assignment-frontend.vercel.app/" // vercel next.js
        ));
        // 허용 메서드
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        // 허용 헤더
        config.setAllowedHeaders(List.of("Authorization", "Content-Type", "Accept", "X-Requested-With"));
        // 응답에서 노출할 헤더(필요 시)
        config.setExposedHeaders(List.of("Location", "Content-Disposition"));
        // 쿠키/세션/인증정보를 보낼 필요가 있으면 true (axios withCredentials와 세트)
        config.setAllowCredentials(false);
        // preflight 캐시(초)
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 모든 경로에 CORS 정책 적용
        source.registerCorsConfiguration("/**", config);
        return source;
    }

}
