package com.rtumirea.autoservice.config.properties;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "app.config.non-register.stub")
public class NonRegisterStubProperties {
    @NotNull
    private String phone;
    @NotNull
    private String fullName;
}
