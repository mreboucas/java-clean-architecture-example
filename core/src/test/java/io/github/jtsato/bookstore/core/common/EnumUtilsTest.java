package io.github.jtsato.bookstore.core.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.jtsato.bookstore.core.enumerator.EnumeratorUtils;
import io.github.jtsato.bookstore.core.exception.InvalidParameterException;

/**
 * @author Jorge Takeshi Sato
 */

class EnumeratorUtilsTest {

    enum Semaphore {
            GREEN, YELLOW, RED
    }

    @DisplayName("Fail to get value if not found")
    @Test
    void failToGetValueIfNotFound() {

        final Exception exception = Assertions.assertThrows(Exception.class, () -> EnumeratorUtils.valueOf("BLUE", Semaphore.class));

        assertThat(exception).isInstanceOf(InvalidParameterException.class);

        assertThat(exception.getMessage()).isNotNull();
        assertThat(exception.getMessage()).isEqualTo("The value BLUE is invalid for Semaphore. Valid values are: GREEN, YELLOW, RED.");
    }
}
