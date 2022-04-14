package io.github.bartoszpop.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class BinaryFileVersion extends FileVersion {

    @Lob
    @Column(nullable = false)
    private byte[] bytes;

    public BinaryFileVersion(byte[] bytes) {
        this.bytes = bytes;
    }

    public BinaryFileVersion() {
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
