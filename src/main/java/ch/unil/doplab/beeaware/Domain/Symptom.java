package ch.unil.doplab.beeaware.Domain;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
