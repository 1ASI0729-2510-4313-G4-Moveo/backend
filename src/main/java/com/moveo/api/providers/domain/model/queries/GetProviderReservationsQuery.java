package com.moveo.api.providers.domain.model.queries;

public record GetProviderReservationsQuery(Long providerId) {
    public GetProviderReservationsQuery {
        if (providerId == null || providerId <= 0) {
            throw new IllegalArgumentException("Provider ID cannot be null or negative");
        }
    }
}
