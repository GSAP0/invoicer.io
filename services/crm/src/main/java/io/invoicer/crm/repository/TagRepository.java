package io.invoicer.crm.repository;

import io.invoicer.crm.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findTagByLabelIs(String value);
}
