package ru.hse._223.dal.repositories.interfaces;

import ru.hse._223.dal.exceptions.*;
import ru.hse._223.dal.entities.User;

import java.util.ArrayList;

public interface AuthRepository {
    ArrayList<User> getUsers() throws CannotAccessDataFileException, BadDataFileException;
    void writeUsers(ArrayList<User> users) throws CannotAccessDataFileException, BadDataFileException;
}
