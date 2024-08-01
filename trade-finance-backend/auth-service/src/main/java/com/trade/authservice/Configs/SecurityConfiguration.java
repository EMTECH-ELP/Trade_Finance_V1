package com.trade.authservice.Configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static com.trade.authservice.User.Permission.*;
import static com.trade.authservice.User.Role.*;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)

                .authorizeRequests(auth -> auth
                        // Specify URL patterns and their access permissions
                        .requestMatchers(
                                "/api/v1/auth/**",
                                "/auth/**",
                                "/inventory/**",
                                "/api/branch/code/**",
                                "/policies/**",
                                "/swagger-ui/**",
                                "/swagger-ui/",
                                "/v3/api-docs/**",
                                "/v2/api-docs",
                                "/v3/api-docs",
                                "/configuration/ui",
                                "/swagger=resources",
                                "/swagger-resources/**",
                                "/configuration/security",
                                "/swagger-ui.html",
                                "/swagger-ui/index.html",
                                "/swagger/**")
                        .permitAll()
                        .requestMatchers("/api/v1/msme/**").hasAnyRole(SUPER_ADMIN.name(), ADMIN.name())
                        .requestMatchers(HttpMethod.GET, "/api/v1/msme/**").hasAnyAuthority(SUPER_ADMIN_READ.name(), ADMIN_READ.name())
                        .requestMatchers(HttpMethod.POST, "/api/v1/msme/**").hasAnyAuthority(SUPER_ADMIN_CREATE.name(), ADMIN_CREATE.name())
                        .requestMatchers(HttpMethod.PUT, "/api/v1/msme/**").hasAnyAuthority(SUPER_ADMIN_UPDATE.name(), ADMIN_UPDATE.name())
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/msme/**").hasAnyAuthority(SUPER_ADMIN_DELETE.name(), ADMIN_DELETE.name())
                        .requestMatchers("/api/v1/accountant/**").hasAnyRole(CHECKER.name(), ADMIN.name())
                        .requestMatchers(HttpMethod.GET, "/api/v1/accountant/**").hasAnyAuthority(CHECKER.name(), ADMIN_READ.name())
                        .requestMatchers(HttpMethod.POST, "/api/v1/accountant/**").hasAnyAuthority(CHECKER.name(), ADMIN_CREATE.name())
                        .requestMatchers(HttpMethod.PUT, "/api/v1/accountant/**").hasAnyAuthority(CHECKER.name(), ADMIN_UPDATE.name())
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/accountant/**").hasAnyAuthority(CHECKER.name(), ADMIN_DELETE.name())
                        .requestMatchers("/api/v1/maker/**").hasAnyRole(MAKER.name(), ADMIN.name())
                        .requestMatchers(HttpMethod.GET, "/api/v1/maker/**").hasAnyAuthority(MAKER.name(), ADMIN_READ.name())
                        .requestMatchers(HttpMethod.POST, "/api/v1/maker/**").hasAnyAuthority(MAKER.name(), ADMIN_CREATE.name())
                        .requestMatchers(HttpMethod.PUT, "/api/v1/maker/**").hasAnyAuthority(MAKER.name(), ADMIN_UPDATE.name())
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/maker/**").hasAnyAuthority(MAKER.name(), ADMIN_DELETE.name())
                        .requestMatchers("/api/v1/admin/**").hasRole(SUPER_ADMIN.name())
                        // Any other request should be authenticated
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .invalidSessionUrl("/login?expired")
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)

                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(false);

//        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        configuration.addAllowedOrigin("*");
        configuration.addAllowedOrigin("""
                http://localhost:4200""");
        configuration.setAllowedMethods(List.of("GET","POST","DELETE","HEAD","PUT","PATCH","OPTIONS"));
        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**",configuration);

        return source;
    }

}
