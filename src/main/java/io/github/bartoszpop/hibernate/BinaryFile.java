package io.github.bartoszpop.hibernate;

import javax.persistence.Entity;

@Entity
public class BinaryFile extends File<BinaryFileVersion> {

    public BinaryFile(String name) {
        super(name);
    }

    public BinaryFile() {
    }
}
