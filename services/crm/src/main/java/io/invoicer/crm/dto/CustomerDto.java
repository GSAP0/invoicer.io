package io.invoicer.crm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDto {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
}
