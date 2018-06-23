package net.maxqfz.tinkoff.controller;

import net.maxqfz.tinkoff.DatabaseService;
import net.maxqfz.tinkoff.TinkoffApplication;
import net.maxqfz.tinkoff.model.ApplicationModel;

import java.sql.SQLException;

import javax.validation.constraints.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {

    @RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
    public ApplicationModel getLastApplication(@PathVariable @NotNull @DecimalMin("0") Long contactId) throws SQLException
    {
        TinkoffApplication.log("Getting last application for CONTACT_ID=" + contactId);
        return DatabaseService.getLastApplicationByContact_Id(contactId);
    }
}
