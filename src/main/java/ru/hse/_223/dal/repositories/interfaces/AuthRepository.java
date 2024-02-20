package ru.hse._223.dal.repositories.interfaces;

import ru.hse._223.dal.exceptions.*;
import ru.hse._223.dal.entities.UserEntity;

import java.util.ArrayList;

public interface AuthRepository {
    ArrayList<UserEntity> getUsers() throws CannotAccessDataFileException, BadDataFileException;
    void writeUsers(ArrayList<UserEntity> users) throws CannotAccessDataFileException, BadDataFileException;
}
