package com.rtumirea.autoservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserModel {
    private Long id;
    private String email;
    private String fullName;
    private String password;
    private Set<RoleModel> roleModels;
    private List<OrderModel> orderModels;
}
