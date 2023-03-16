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

import com.soccer1.resources.dao.ResourcesRepository;
import com.soccer1.resources.entity.Resource;
import com.soccer1.role.dao.RoleRepository;
import com.soccer1.role.entity.Role;

public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
    private final LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap;

    @Autowired
    public CustomFilterInvocationSecurityMetadataSource(RoleRepository roleRepository, ResourcesRepository resourcesRepository) {
    	
        List<Resource> resources = resourcesRepository.findAllResources();
        List<Role> roles = roleRepository.findAllRoles();

        this.requestMap = new LinkedHashMap<>();

        for (Resource resource : resources) {
            AntPathRequestMatcher urlMatcher = new AntPathRequestMatcher(resource.getResourcesName());
            List<ConfigAttribute> configAttributes = new ArrayList<>();

            for (Role authority : roles) {
                if (authority.getResourcesId().equals(resource.getResourcesId())) {
                	String roldeCode = authority.getRoleCode();
                    configAttributes.add(new SecurityConfig(roldeCode));
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