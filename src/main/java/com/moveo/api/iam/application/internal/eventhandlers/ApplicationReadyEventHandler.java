package com.moveo.api.iam.application.internal.eventhandlers;

import com.moveo.api.iam.domain.model.commands.SeedTypesCommand;
import com.moveo.api.iam.domain.services.TypeCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * ApplicationReadyEventHandler class
 * This class is used to handle the ApplicationReadyEvent
 */
@Service
public class ApplicationReadyEventHandler {
    private final TypeCommandService typeCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(TypeCommandService typeCommandService) {
        this.typeCommandService = typeCommandService;
    }

    /**
     * Handle the ApplicationReadyEvent
     * This method is used to seed the types
     * @param event the ApplicationReadyEvent the event to handle
     */
    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if types seeding is needed for {} at {}", applicationName, currentTimestamp());
        var seedTypesCommand = new SeedTypesCommand();
        typeCommandService.handle(seedTypesCommand);
        LOGGER.info("Types seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
