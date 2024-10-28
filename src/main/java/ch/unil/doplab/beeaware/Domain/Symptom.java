package ch.unil.doplab.beeaware.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {
    private Long id;
    private int level;
    private boolean antihistamine;
    private Date date;
    private Long userId;

    public Symptom(Long userId, int lvl, boolean antihistamine){
        this.userId = userId;
        this.level = lvl;
        this.antihistamine = antihistamine;
    }
}
