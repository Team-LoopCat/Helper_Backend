package org.example.persistence;

import java.util.Optional;

public interface GenericMapper<D, E> {

    public Optional<D> toDomain(Optional<E> entity);

    public E toEntity(D entity);
}
