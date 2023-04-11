package web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Errors {
    DIFFERENCE_MESSAGE("Las temperaturas son diferentes. La diferencia es de: ");

    private final String errorMessage;

}
