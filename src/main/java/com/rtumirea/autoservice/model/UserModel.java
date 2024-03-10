package com.rtumirea.autoservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@ToString(exclude = {"password"})
@Getter
@Setter
public class UserModel {
    private Long id;
    private String email;
    private String phone;
    private String fullName;
    private String password;
    private Set<RoleModel> roleModels;
    private List<OrderModel> orderModels;
}
