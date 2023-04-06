package com.soccer1.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.soccer1.authority.repository.AuthorityRepository;
import com.soccer1.resources.repository.ResourcesRepository;
import com.soccer1.spring.CustomAccessDeniedHandler;
import com.soccer1.spring.CustomFilterInvocationSecurityMetadataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private ResourcesRepository resourcesRepository;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
    public void configure(WebSecurity web) {
        web.ignoring().mvcMatchers(
                "/assets",
                "/favicon.ico",
                "/swagger-ui.html",
                "/swagger/**",
                "/swagger-resources/**",
                "/webjars/**",
                "/v2/api-docs"
        );
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
	      .disable()
	      .httpBasic();

		http
			.authorizeRequests()
//			.antMatchers("/admin/**").hasRole("ADMIN")
//			.antMatchers("/user/**").hasRole("USER")
//			.antMatchers("/swagger-ui.html").hasRole("ADMIN")
			.antMatchers("/**").permitAll()
		.and()
			.formLogin()
			.loginPage("/login.html")
			.loginProcessingUrl("/admin/login")
			.usernameParameter("userId")
			.passwordParameter("password")
			.successHandler(authenticationSuccessHandler)
			.failureHandler(authenticationFailureHandler)
		.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login.html")
			.invalidateHttpSession(true)
		.and()
			.exceptionHandling().accessDeniedHandler(accessDeniedHandler())
		.and()
			.addFilterBefore(customFilterSecurityInterceptor(), FilterSecurityInterceptor.class)
		;	
	}
	
	@Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
	
	@Bean
	public CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource() {
		return new CustomFilterInvocationSecurityMetadataSource(authorityRepository, resourcesRepository);
	}
	
	@Bean
    public FilterSecurityInterceptor customFilterSecurityInterceptor() throws Exception {
        
        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
        filterSecurityInterceptor.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource());
        filterSecurityInterceptor.setAccessDecisionManager(affirmativeBased());
      
        // 권한체크 필터는 현재 사용자가 인증된 사용자인지 검사하기 때문에 인증 매니저가 필요하다.
        filterSecurityInterceptor.setAuthenticationManager(authenticationManagerBean());
        return filterSecurityInterceptor;
    }
	
	private AccessDecisionManager affirmativeBased() {
        AffirmativeBased affirmativeBased = new AffirmativeBased(getAccessDecistionVoters());
        return affirmativeBased;
    }
	
	private List<AccessDecisionVoter<?>> getAccessDecistionVoters() {
		return Arrays.asList(new RoleVoter());
	}
}