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

    public Symptom(Long beezzerId, Reaction reaction, boolean antihistamine) {
        this.beezzerId = beezzerId;
        this.reaction = reaction;
        this.antihistamine = antihistamine;
        this.date = new Date();
    }

    public Symptom(Long beezzerId, Reaction reaction, boolean antihistamine, Date date) {
        this.beezzerId = beezzerId;
        this.reaction = reaction;
        this.antihistamine = antihistamine;
        this.date = date;
    }

    public void updateLevel(Reaction reaction) {
        this.reaction = reaction;
    }

    public int getLevelValue() {
        return reaction.getValue();
    }
}
