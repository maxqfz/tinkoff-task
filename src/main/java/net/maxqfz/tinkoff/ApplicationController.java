package net.maxqfz.tinkoff;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {
    @Autowired
    ApplicationRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<ApplicationModel> getAllApplications()
    {
        //Finding and returning all applications
        return repository.findAll();
    }

    @RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
    public ApplicationModel getLastApplication(@PathVariable @NotNull @DecimalMin("0") Long contactId)
    {
        //Finding all applications by contact
        List<ApplicationModel> applications = repository.findByContactId(contactId);
        //Returning null if there's none
        if(applications.isEmpty())
            return null;
        //Finding and returning last application if there's some
        ApplicationModel last = applications.get(0);
        for(int i = 1; i < applications.size(); ++i)
            if(applications.get(i).getDtCreated().isAfter(last.getDtCreated()))
                last = applications.get(i);
        return last;
    }
}
