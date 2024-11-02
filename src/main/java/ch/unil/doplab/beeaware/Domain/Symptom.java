package ch.unil.doplab.beeaware.Domain;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {
    private Long id;
    private int level;
    private boolean antihistamine;
    private Date date;
    private Long beezzerId;

    public Symptom(Long beezzerId, int lvl, boolean antihistamine) {
        this.beezzerId = beezzerId;
        this.level = lvl;
        this.antihistamine = antihistamine;
    }
}
