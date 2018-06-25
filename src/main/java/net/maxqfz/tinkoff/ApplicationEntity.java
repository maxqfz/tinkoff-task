package net.maxqfz.tinkoff;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
class ApplicationEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty("APPLICATION_ID")
    private long applicationId;

    @JsonProperty("CONTACT_ID")
    private long contactId;

    @JsonProperty("DT_CREATED")
    private LocalDate dtCreated;

    @JsonProperty("PRODUCT_NAME")
    private String productName;

    ApplicationEntity(long contactId, LocalDate dtCreated, String productName)
    {
        this.contactId = contactId;
        this.dtCreated = dtCreated;
        this.productName = productName;
    }
}
