package web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Timeouts {
    TIMEOUT_5_SECONDS(5),
    TIMEOUT_10_SECONDS(10),
    TIMEOUT_30_SECONDS(30),
    TIMEOUT_60_SECONDS(60);

    private final int seconds;
}

