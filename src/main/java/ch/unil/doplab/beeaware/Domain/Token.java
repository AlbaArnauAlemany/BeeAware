package ch.unil.doplab.beeaware.Domain;

import ch.unil.doplab.beeaware.Domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    String key;
    Date expiration;
    Long beezzerId;
    Role role;
}
