package ch.unil.doplab.beeaware.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDescription {
    private String type;
    private String message;

    public ExceptionDescription() {}

    public ExceptionDescription(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
