package co.istad.phakley.ite3rdecommerce.features.file;

import co.istad.phakley.ite3rdecommerce.features.file.dto.FileUploadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @PostMapping("single")
    @ResponseStatus(HttpStatus.CREATED)
    public FileUploadResponse uploadSingle(@RequestPart MultipartFile file) {
        return fileUploadService.upload(file);
    }

    @PostMapping("/zmultiple")
    @ResponseStatus(HttpStatus.CREATED)
    public List<FileUploadResponse> uploadMultiple(@RequestPart("files") MultipartFile[] files) {
        return fileUploadService.uploadMultiple(files);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByName(@PathVariable String name) {
        fileUploadService.deleteByName(name);
    }
}

