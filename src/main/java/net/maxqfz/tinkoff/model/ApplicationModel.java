package net.maxqfz.tinkoff.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ApplicationModel {
    private long ContactId;
    private long ApplicationId;
    private LocalDate DtCreated;
    private String ProductName;

    public ApplicationModel(long contactId, long applicationId, LocalDate dtCreated, String productName)
    {
        ContactId = contactId;
        ApplicationId = applicationId;
        DtCreated = dtCreated;
        ProductName = productName;
    }

    @JsonProperty("CONTACT_ID")
    public long getContactId()
    {
        return ContactId;
    }

    @JsonProperty("APPLICATION_ID")
    public long getApplicationId()
    {
        return ApplicationId;
    }

    @JsonProperty("DT_CREATED")
    public LocalDate getDtCreated()
    {
        return DtCreated;
    }

    @JsonProperty("PRODUCT_NAME")
    public String getProductName()
    {
        return ProductName;
    }

    public void setContactId(long contact_Id)
    {
        ContactId = contact_Id;
    }

    public void setApplicationId(long applicationId)
    {
        ApplicationId = applicationId;
    }

    public void setDtCreated(LocalDate dtCreated)
    {
        DtCreated = dtCreated;
    }

    public void setProductName(String productName)
    {
        ProductName = productName;
    }
}
