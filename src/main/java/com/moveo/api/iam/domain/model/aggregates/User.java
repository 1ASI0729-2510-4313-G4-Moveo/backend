package com.moveo.api.iam.domain.model.aggregates;

import com.moveo.api.iam.domain.model.entities.Type;
import com.moveo.api.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User aggregate root
 * This class represents the aggregate root for the User entity.
 *
 * @see AuditableAbstractAggregateRoot
 */
@Getter
@Setter
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {

    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @Size(max = 100)
    private String name;

    @Size(max = 20)
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(	name = "user_types",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<Type> types;

    public User() {
        this.types = new HashSet<>();
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.types = new HashSet<>();
    }

    public User(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.types = new HashSet<>();
    }

    public User(String email, String password, List<Type> types) {
        this(email, password);
        addTypes(types);
    }

    public User(String email, String password, String name, String phone, List<Type> types) {
        this(email, password, name, phone);
        addTypes(types);
    }

    /**
     * Add a type to the user
     * @param type the type to add
     * @return the user with the added type
     */
    public User addType(Type type) {
        this.types.add(type);
        return this;
    }

    /**
     * Add a list of types to the user
     * @param types the list of types to add
     * @return the user with the added types
     */
    public User addTypes(List<Type> types) {
        var validatedTypeSet = Type.validateTypeSet(types);
        this.types.addAll(validatedTypeSet);
        return this;
    }

}
