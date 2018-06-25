package net.maxqfz.tinkoff;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {
    Page<ApplicationEntity> findByContactId(long contactId, Pageable pageRequest);
}