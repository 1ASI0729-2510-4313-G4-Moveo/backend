package com.moveo.api.iam.interfaces.rest.transform;

import com.moveo.api.iam.domain.model.entities.Type;
import com.moveo.api.iam.interfaces.rest.resources.TypeResource;

public class TypeResourceFromEntityAssembler {
    public static TypeResource toResourceFromEntity(Type type) {
        return new TypeResource(type.getId(), type.getStringName());
    }
} 