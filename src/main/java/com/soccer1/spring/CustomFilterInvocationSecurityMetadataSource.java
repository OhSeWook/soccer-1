package com.soccer1.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.soccer1.authority.entity.Authority;
import com.soccer1.authority.repository.AuthorityRepository;
import com.soccer1.resources.entity.Resource;
import com.soccer1.resources.repository.ResourcesRepository;

public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
    private final LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap;

    @Autowired
    public CustomFilterInvocationSecurityMetadataSource(AuthorityRepository authorityRepository, ResourcesRepository resourcesRepository) {
    	
        List<Resource> resources = resourcesRepository.findAll();
        List<Authority> roles = authorityRepository.findAll();

        this.requestMap = new LinkedHashMap<>();

        for (Resource resource : resources) {
            AntPathRequestMatcher urlMatcher = new AntPathRequestMatcher(resource.getResourcesName());
            List<ConfigAttribute> configAttributes = new ArrayList<>();

            for (Authority authority : roles) {
                if (authority.getId().equals(resource.getId())) {
                	String roleCode = authority.getRoleType().name();
                    configAttributes.add(new SecurityConfig(roleCode));
                }
            }

            this.requestMap.put(urlMatcher, configAttributes);
        }
        
        System.out.println(this.requestMap.toString());
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) {
        HttpServletRequest request = ((FilterInvocation) object).getRequest();

        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            RequestMatcher matcher = entry.getKey();

            if (matcher.matches(request)) {
                return entry.getValue();
            }
        }

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<>();

        for (Collection<ConfigAttribute> attributes : requestMap.values()) {
            allAttributes.addAll(attributes);
        }

        return allAttributes;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

}