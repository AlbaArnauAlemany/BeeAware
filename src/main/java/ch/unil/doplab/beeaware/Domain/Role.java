package ch.unil.doplab.beeaware.Domain;

/**
 * Represent a specific role within the beezzers that gives you certain accesses for our API.
 * ADMIN is a role that grants access to every resource, BEEZZER is restricted to call for
 * only for your unique identifier.
 *
 */

public enum Role {
    ADMIN,
    BEEZZER;
}