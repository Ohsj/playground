package com.osj4532.playground.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BcryptEncoderTest {
    @InjectMocks
    BcryptEncoder encoder;

    @Test
    void encoderTest() {
        String password = "rkskek12";
        String result = encoder.encode(password);

        boolean isMatch = encoder.matches(password, result);

        assertThat(result).isNotEmpty();
        assertThat(isMatch).isTrue();

        System.out.println(result);

    }
}

