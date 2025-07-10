package com.moveo.api.iam.domain.model.queries;

import com.moveo.api.iam.domain.model.valueobjects.Types;

/**
 * Get type by name query
 * <p>
 *     This class represents the query to get a type by its name.
 * </p>
 * @param name the name of the type
 * @see Types
 */
public record GetTypeByNameQuery(Types name) {
} 