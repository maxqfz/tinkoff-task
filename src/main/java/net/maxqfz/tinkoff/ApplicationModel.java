package net.maxqfz.tinkoff;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class ApplicationModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty("APPLICATION_ID")
    @Getter private long applicationId;

    @JsonProperty("CONTACT_ID")
    @Getter @Setter private long contactId;

    @JsonProperty("DT_CREATED")
    @Getter @Setter private LocalDate dtCreated;

    @JsonProperty("PRODUCT_NAME")
    @Getter @Setter private String productName;

    protected ApplicationModel(){}

    ApplicationModel(long contactId, LocalDate dtCreated, String productName)
    {
        this.contactId = contactId;
        this.dtCreated = dtCreated;
        this.productName = productName;
    }
}
