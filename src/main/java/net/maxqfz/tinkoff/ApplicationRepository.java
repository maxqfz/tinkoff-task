package net.maxqfz.tinkoff;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<ApplicationModel, Long> {
    List<ApplicationModel> findByContactId(long contactId);
}