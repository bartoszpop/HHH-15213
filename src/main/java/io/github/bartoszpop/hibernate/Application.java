package io.github.bartoszpop.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    public void bug(FileRepository fileRepository) {
        var textFile = new TextFile("textFile.txt", "UTF-8");
        textFile.addVersion(new TextFileVersion(new char[] {'a'}));
        /*
        If BinaryFile is annotated with @Entity, FileRepository#save throws
        org.hibernate.AnnotationException: Property io.github.bartoszpop.hibernate.File.versions has an unbound type and no explicit target entity.
        Resolve this Generic usage issue or set an explicit target attribute (eg @OneToMany(target=) or use an explicit @Type
        Otherwise, it throws
        java.lang.IllegalArgumentException: Can not set [B field io.github.bartoszpop.hibernate.BinaryFileVersion.bytes to io.github.bartoszpop.hibernate.TextFileVersion
         */
        fileRepository.save(textFile);
    }
}
