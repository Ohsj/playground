package com.osj4532.playground.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class HomeServiceTest extends BaseTestService{
    @InjectMocks
    private HomeService service;

    @Test
    void playground() {
        String playground = service.playground();
        assertThat(playground)
                .isEqualTo("This is PlayGround");
    }
}
