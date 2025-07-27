package io.invoicer.crm.repository;

import io.invoicer.crm.model.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long> {
}
