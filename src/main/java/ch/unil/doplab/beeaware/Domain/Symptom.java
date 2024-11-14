package ch.unil.doplab.beeaware.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Symptom {
    private Long id;
    private Reaction reaction;
    private boolean antihistamine;
    private Date date;
    private Long beezzerId;

    public Symptom(Long beezzerId, Reaction reaction, boolean antihistamine, Date date) {
        this.beezzerId = beezzerId;
        this.reaction = reaction;
        this.antihistamine = antihistamine;
        this.date = date;
    }

    public Symptom(Long beezzerId, Reaction reaction, boolean antihistamine) {
        this(beezzerId, reaction, antihistamine, new Date());
    }
}
