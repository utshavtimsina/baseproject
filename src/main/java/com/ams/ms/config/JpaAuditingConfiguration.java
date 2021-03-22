//package com.ams.ms.config;
//
//mport org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//
//
//import java.util.Map;
//import java.util.Optional;
//
//@Configuration
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
//public class JpaAuditingConfiguration {
//
//    private final TokenStore tokenStore;
//
//    public JpaAuditingConfiguration(TokenStore tokenStore){
//        this.tokenStore = tokenStore;
//    }
//
//    @Bean
//    public AuditorAware<Integer> auditorProvider() {
//        return new AuditorAware<Integer>() {
//            @Override
//            public Optional<Integer> getCurrentAuditor() {
//                try {
//                    if (SecurityContextHolder.getContext().getAuthentication() != null) {
//                        OAuth2AuthenticationDetails auth2AuthenticationDetails = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
//                        Map<String, Object> details = tokenStore.readAccessToken(auth2AuthenticationDetails.getTokenValue()).getAdditionalInformation();
//
//                        return Optional.of(Integer.valueOf(String.valueOf(details.get("userId"))));
//                    } else {
//                        return Optional.of(Integer.valueOf(0));
//                    }
//                }catch (Exception e){
//                    return Optional.of(Integer.valueOf(0));
//                }
//            }
//        };
//    }
//
//}
