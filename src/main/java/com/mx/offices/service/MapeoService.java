package com.mx.offices.service;

import java.util.List;

public interface MapeoService {
    <S, D> D mapea(S sourceObject, Class<D> destinationClass);

    <S, D> List<D> mapeaLista(Iterable<S> sourceList, Class<D> destinationClass);

}
