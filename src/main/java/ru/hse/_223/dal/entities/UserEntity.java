package ru.hse._223.dal.entities;

public record UserEntity(String name, String hashedPassword, Boolean hasAdminPrivileges) {

}
