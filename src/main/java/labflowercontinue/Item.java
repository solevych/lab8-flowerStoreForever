package labflowercontinue;

import lombok.Getter;

public abstract class Item {
    @Getter
    private String description;

    protected void setDescription(String str) {
        description = str;
    }

    public abstract double price();
}