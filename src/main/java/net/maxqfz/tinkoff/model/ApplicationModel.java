package net.maxqfz.tinkoff.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ApplicationModel {
    private long Contact_Id;
    private long Application_Id;
    private LocalDate Dt_Created;
    private String Product_Name;

    public ApplicationModel(long contact_Id, long application_Id, LocalDate dt_Created, String product_Name)
    {
        Contact_Id = contact_Id;
        Application_Id = application_Id;
        Dt_Created = dt_Created;
        Product_Name = product_Name;
    }

    @JsonProperty("CONTACT_ID")
    public long getContact_Id()
    {
        return Contact_Id;
    }

    @JsonProperty("APPLICATION_ID")
    public long getApplication_Id()
    {
        return Application_Id;
    }

    @JsonProperty("DT_CREATED")
    public LocalDate getDt_Created()
    {
        return Dt_Created;
    }

    @JsonProperty("PRODUCT_NAME")
    public String getProduct_Name()
    {
        return Product_Name;
    }

    public void setContact_Id(long contact_Id)
    {
        Contact_Id = contact_Id;
    }

    public void setApplication_Id(long application_Id)
    {
        Application_Id = application_Id;
    }

    public void setDt_Created(LocalDate dt_Created)
    {
        Dt_Created = dt_Created;
    }

    public void setProduct_Name(String product_Name)
    {
        Product_Name = product_Name;
    }
}
