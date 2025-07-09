package com.moveo.api.iam.interfaces.rest.resources;

import java.util.List;

public record SignUpResource(String email, String password, String name, String phone, List<String> types) {
}
