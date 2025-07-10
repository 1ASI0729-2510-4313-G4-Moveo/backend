package com.moveo.api.iam.domain.model.entities;

import com.moveo.api.iam.domain.model.valueobjects.Types;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

/**
 * Type entity
 * <p>
 *     This entity represents the type of a user in the system.
 *     It is used to define the permissions of a user.
 * </p>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Types name;

    public Type(Types name) {
        this.name = name;
    }

    /**
     * Get the name of the type as a string
     * @return the name of the type as a string
     */
    public String getStringName() {
        return name.name();
    }

    /**
     * Get the default type
     * @return the default type
     */
    public static Type getDefaultType() {
        return new Type(Types.USER);
    }

    /**
     * Get the type from its name
     * @param name the name of the type
     * @return the type
     */
    public static Type toTypeFromName(String name) {
        return new Type(Types.valueOf(name));
    }

    /**
     * Validate the type set
     * <p>
     *     This method validates the type set and returns the default type if the set is empty.
     * </p>
     * @param types the type set
     * @return the type set
     */
    public static List<Type> validateTypeSet(List<Type> types) {
        if (types == null || types.isEmpty()) {
            return List.of(getDefaultType());
        }
        return types;
    }

} 