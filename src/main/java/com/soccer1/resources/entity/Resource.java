package com.soccer1.resources.entity;

import lombok.Data;

@Data
public class Resource {

    private Long resourcesId;
    
    private String resourcesName;
    
    private String httpMethod;
    
    private int orderNum;
    
    private String resourceType;
    
    private Long roleId;
}
