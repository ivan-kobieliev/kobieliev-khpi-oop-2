package ua.khpi.oop.lab09.model;

public class ProfileEntry<TEntity, TMeta> {

    private final TEntity entity;
    private final TMeta metadata;

    public ProfileEntry(TEntity entity, TMeta metadata) {
        this.entity = entity;
        this.metadata = metadata;
    }

    public TEntity getEntity() {
        return entity;
    }

    public TMeta getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "ProfileEntry{" +
                "entity=" + entity +
                ", metadata=" + metadata +
                '}';
    }
}