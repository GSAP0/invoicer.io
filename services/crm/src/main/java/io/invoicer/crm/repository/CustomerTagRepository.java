package io.invoicer.crm.repository;

import io.invoicer.crm.model.CustomerTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTagRepository extends JpaRepository<CustomerTag, Long> {
}
