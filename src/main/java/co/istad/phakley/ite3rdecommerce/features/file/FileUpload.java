package co.istad.phakley.ite3rdecommerce.features.file;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "files")
@Getter
@Setter
@Service
@NoArgsConstructor
public class FileUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, length = 15)
    private String extension;
    private String caption; // it is important when sco

    @Column(nullable = false)
    private Long size;
    @Column(nullable = false)

    private String mediaType;


}
