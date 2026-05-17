package PlatformQA.MemoryLeak;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

public class StaticListExample {

    private static final int MAX_LOG_SIZE = 1000;
    // Supposed to be like this
    private static final Deque<String> uploadedFiles = new LinkedList<>();

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (uploadedFiles.size() >= MAX_LOG_SIZE) {
            uploadedFiles.removeFirst();
        }
        uploadedFiles.addLast(file.getOriginalFilename());
        // ... process file ...
        return "Uploaded: " + file.getOriginalFilename();
    }

    @RestController
    public class FileUploadController {
        // BAD: Static list grows forever!
        private final List<String> uploadedFiles = new ArrayList<>();

        @PostMapping("/upload")
        public String uploadFile(@RequestParam("file") MultipartFile file) {
            uploadedFiles.add(file.getOriginalFilename());
            // ... process file ...
            return "Uploaded: " + file.getOriginalFilename();
        }
    }
}
