package ru.hse._223.dal.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.hse._223.dal.entities.User;
import ru.hse._223.dal.exceptions.BadDataFileException;
import ru.hse._223.dal.exceptions.CannotAccessDataFileException;
import ru.hse._223.dal.repositories.interfaces.AuthRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DefaultAuthRepository implements AuthRepository {
    private final Path filePath;
    private final ObjectMapper objectMapper;
    private final TypeReference<ArrayList<User>> typeReference;
    public DefaultAuthRepository(String filePath) {
        this.filePath = Paths.get(filePath);
        objectMapper = new ObjectMapper();
        typeReference = new TypeReference<ArrayList<User>>() {};
    }
    @Override
    public ArrayList<User> getUsers() throws CannotAccessDataFileException, BadDataFileException {
        ArrayList<User> userList;
        try {
            String data = Files.readString(filePath);
            userList = objectMapper.readValue(data, typeReference);
        } catch (IOException e) {
            throw new CannotAccessDataFileException("Cannot read from " + filePath);
        } catch (Exception e) {
            throw new BadDataFileException("File " + filePath + " was corrupted");
        }
        return userList;
    }

    @Override
    public void writeUsers(ArrayList<User> users) throws CannotAccessDataFileException, BadDataFileException {
        try {
            String json = objectMapper.writeValueAsString(users);
            Files.writeString(filePath, json);
        } catch (IOException e) {
            throw new CannotAccessDataFileException("Cannot write to " + filePath);
        } catch (Exception e) {
            throw new BadDataFileException("File " + filePath + " was corrupted");
        }
    }
}
