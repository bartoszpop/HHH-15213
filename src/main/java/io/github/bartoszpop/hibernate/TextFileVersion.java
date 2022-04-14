package io.github.bartoszpop.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class TextFileVersion extends FileVersion {

    @Lob
    @Column(nullable = false)
    private char[] characters;

    public TextFileVersion(char[] characters) {
        this.characters = characters;
    }

    public TextFileVersion() {
    }

    public char[] getCharacters() {
        return characters;
    }

    public void setCharacters(char[] characters) {
        this.characters = characters;
    }
}
