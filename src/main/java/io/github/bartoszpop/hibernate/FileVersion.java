package io.github.bartoszpop.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class FileVersion implements Serializable {

    @EmbeddedId
    private Id id;

    @MapsId("fileId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fileId", insertable = false, updatable = false)
    private File<?> file;

    public FileVersion() {
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public File<?> getFile() {
        return file;
    }

    public void setFile(File<?> file) {
        this.file = file;
    }

    @Embeddable
    public static final class Id implements Serializable {

        @Column
        private Long fileId;

        @Column
        private Integer versionIndex;

        public Id(Long fileId, Integer versionIndex) {
            this.fileId = fileId;
            this.versionIndex = versionIndex;
        }

        public Id() {
        }

        public Long getFileId() {
            return fileId;
        }

        public void setFileId(Long fileId) {
            this.fileId = fileId;
        }

        public Integer getVersionIndex() {
            return versionIndex;
        }

        public void setVersionIndex(Integer versionIndex) {
            this.versionIndex = versionIndex;
        }
    }
}
