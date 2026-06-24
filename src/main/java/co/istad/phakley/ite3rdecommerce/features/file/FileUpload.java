package co.istad.phakley.ite3rdecommerce.features.file;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "files")
@Getter
@Service
@NoArgsConstructor
public class FileUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, unique = true)
    private String name;
    private String caption; // it is important when sco

    @Column(nullable = false)
    private Long size;
    @Column(nullable = false)

    private String mediaType;


}
