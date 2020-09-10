package cloud.itsu.springbootdemo.controller;


import cloud.itsu.springbootdemo.service.FileHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/tv-series/")
public class FileController {

    @Autowired
    FileHandlingService fileHandlingService;

    @PostMapping("/file/create")
    public String createFile() {
        return fileHandlingService.createNewFile();
    }

    @PostMapping("/file/byte-stream")
    public void byteStream() throws IOException {
        fileHandlingService.playWithByteStreams();
    }

    @PostMapping("/file/char-stream")
    public void charStream() throws IOException {
        fileHandlingService.playWithCharStreams();
    }

    @PostMapping("/file/manual-stream")
    public void manualStream() throws IOException {
        fileHandlingService.playWithManualStreams();
    }

    @PostMapping("/file/manual-byte-stream")
    public void manualByteStream() throws IOException {
        fileHandlingService.playWithManualByteArrayStreams();
    }

    @PostMapping("/file/scanner")
    public void playWithScanner() throws IOException {
        fileHandlingService.playWithScanner();
    }

    @PostMapping("/file/upload")
    public ResponseEntity<String> uploadFile (@RequestBody MultipartFile file) throws IOException {

        return new ResponseEntity<>(fileHandlingService.uploadFile(file), HttpStatus.OK);
    }

    @GetMapping(value="/file/download", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> downloadFile (@RequestParam String name) throws IOException {

        return new ResponseEntity<>(fileHandlingService.downloadFile(name), HttpStatus.OK);
    }

}
