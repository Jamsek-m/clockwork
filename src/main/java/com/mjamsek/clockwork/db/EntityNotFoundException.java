package com.mjamsek.clockwork.db;

public class EntityNotFoundException extends RuntimeException {
    
    public EntityNotFoundException(Class entityType, long entityId) {
        super(String.format("Entity of type %s with id: %d does not exist!", entityType.getName(), entityId));
    }
}
