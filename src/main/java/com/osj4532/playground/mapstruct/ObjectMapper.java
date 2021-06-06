package com.osj4532.playground.mapstruct;

/**
 * 20606 | osj4532 | created
 */

public interface ObjectMapper<D, E> {
    D toDto(E e);
    E toEntity(D d);
}
