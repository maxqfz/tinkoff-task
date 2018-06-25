package net.maxqfz.tinkoff;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.*;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationRepository repository;

    @GetMapping(value = "/")
    @Transactional
    public List<ApplicationEntity> getAllApplications() {
        return repository.findAll();
    }

    @GetMapping(value = "/{contactId}")
    @Transactional
    public Optional<ApplicationEntity> getLastApplication(@PathVariable @NotNull @DecimalMin("0") Long contactId) {
        Page<ApplicationEntity> applications = repository.findByContactId(
                contactId,
                PageRequest.of(0, 1, Sort.Direction.DESC, "dtCreated")
        );
        return applications.stream().findFirst();
    }
}
