package com.ttulka.ecommerce.sales.category;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CategoryIdTest {

    private static final String STR_64_CHARS = "0123456789012345678901234567890123456789012345678901234567890123";

    @Test
    void string_id_value() {
        CategoryId categoryId = new CategoryId(123L);
        assertThat(categoryId.value()).isEqualTo("123");
    }

    @Test
    void fails_for_null() {
        assertThrows(IllegalArgumentException.class, () -> new CategoryId(null));
    }

    @Test
    void has_max_64_characters() {
        CategoryId categoryId = new CategoryId(STR_64_CHARS);
        assertAll(
                () -> assertThat(categoryId.value()).isEqualTo(STR_64_CHARS),
                () -> assertThrows(IllegalArgumentException.class, () -> new CategoryId(STR_64_CHARS + "X"))
        );
    }
}