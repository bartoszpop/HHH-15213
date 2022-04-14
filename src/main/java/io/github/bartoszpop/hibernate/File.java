package io.github.bartoszpop.hibernate;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class File<T extends FileVersion> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "id.fileId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<T> versions = new ArrayList<>();

    @Column(nullable = false)
    private Integer nextVersionIndex = 1;

    public File(String name) {
        this.name = name;
    }

    public File() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getVersions() {
        return versions;
    }

    public final void addVersion(T version) {
        version.setFile(this);
        version.setId(new FileVersion.Id(id, nextVersionIndex++));
        versions.add(version);
    }
}
