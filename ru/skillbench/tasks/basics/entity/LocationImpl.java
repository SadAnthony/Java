package ru.skillbench.tasks.basics.entity;

public class LocationImpl implements Location{
    private String name;
    private Type type;
    private Location parent;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void setParent(Location parent) {
        this.parent = parent;
    }

    @Override
    public String getParentName() {
        if (parent == null) {
            return "--";
        } else {
            return parent.getName();
        }
    }

    @Override
    public Location getTopLocation() {
        if (this.parent == null) {
            return this;
        } else {
            return this.parent.getTopLocation();
        }
    }

    //TODO fix the two methods below

    @Override
    public boolean isCorrect() {
        if (this.parent == null) {
            return true;
        } else if (this.getType().compareTo(this.parent.getType()) >= 0) {
            return false;
        } else {
            return parent.isCorrect();
        }
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public String toString(){
        return name + " (" + type.toString() + ")";
    }
}
