package ch.unil.doplab.beeaware.Domain;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {
    private Long id;
    private Level level;
    private boolean antihistamine;
    private Date date;
    private Long beezzerId;

    public Symptom(Long beezzerId, Level lvl, boolean antihistamine) {
        this.beezzerId = beezzerId;
        this.level = lvl;
        this.antihistamine = antihistamine;
    }

    public void updateLevel(Level lvl) {
        this.level = lvl;
    }

    public int getLevelValue() {
        return level.getValue();
    }
}
