package ru.hse._223.dal.entities;

public record User(String name, String hashedPassword, Boolean hasAdminPrivileges) {

}
