package io.invoicer.crm.repository;

import io.invoicer.crm.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
