package ch.unil.doplab.beeaware.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * The Symptom class represents the details of a symptom experienced by a user.
 * It includes information such as the type of reaction, whether antihistamines were used,
 * the date the symptom was entered, and the unique identifier of the user (beezzerId).
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Symptom {
    @Id
    @Column(name= "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "REACTION")
    private int reaction;
    @Column(name = "ANTIHISTAMINE")
    private boolean antihistamine;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "BEEZZER_ID", nullable = false)
    private Long beezzerId;

    /**
     * Constructs a new Symptom object with the specified parameters.
     *
     * @param beezzerId The unique identifier of the user experiencing the symptom.
     * @param reaction The level of reaction experienced by the user.
     * @param antihistamine Indicates whether antihistamines were used.
     * @param date The date the symptom was entered.
     */
    public Symptom(Long beezzerId, int reaction, boolean antihistamine, Date date) {
        this.beezzerId = beezzerId;
        this.reaction = reaction;
        this.antihistamine = antihistamine;
        this.date = date;
    }

    public Symptom(Long beezzerId, int reaction, boolean antihistamine) {
        this(beezzerId, reaction, antihistamine, new Date());
    }
}
