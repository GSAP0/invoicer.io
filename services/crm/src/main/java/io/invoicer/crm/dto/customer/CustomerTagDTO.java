package io.invoicer.crm.dto.customer;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerTagDTO {
    public Long id;
    public String label;
}