package ru.tlcfr.chess.helper;

import lombok.experimental.UtilityClass;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.UUID;

import static java.util.Optional.ofNullable;

@UtilityClass
public class SessionHelper {

    public static UUID getSessionId() {
        return ofNullable(RequestContextHolder.getRequestAttributes())
                .map(RequestAttributes::getSessionId)
                .map(UUID::fromString)
                .orElse(null);
    }
}
