package io.github.bartoszpop.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TextFile extends File<TextFileVersion> {

    @Column(nullable = false)
    private String encoding;

    public TextFile(String name, String encoding) {
        super(name);
        this.encoding = encoding;
    }

    public TextFile() {
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
