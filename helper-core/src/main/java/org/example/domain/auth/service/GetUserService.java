package org.example.domain.auth.service;

import org.example.domain.auth.model.User;

public interface GetUserService {

    User getUserById(String id);
}
