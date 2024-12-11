package ch.unil.doplab.beeaware.Domain;

import ch.unil.doplab.beeaware.Domain.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Token {
    @Id
    @Column(name = "ID", nullable = false, unique = true)
    String key;
    @Column(name = "EXPIRATION")
    Date expiration;
    @Column(name = "BEEZZERID", nullable = false)
    Long beezzerId;
    @Column(name="ROLE")
    Role role;
}
