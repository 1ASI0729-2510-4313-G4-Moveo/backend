package com.moveo.api.iam.domain.services;

import com.moveo.api.iam.domain.model.commands.SeedTypesCommand;

/**
 * Type command service
 * <p>
 *     This interface represents the service to handle type commands.
 * </p>
 */
public interface TypeCommandService {
    /**
     * Handle seed types command
     * @param command the {@link SeedTypesCommand} command
     *
     */
    void handle(SeedTypesCommand command);
} 