package com.hc.cn.controller;

/**
 * Created by Charlie on 2017-07-12.
 */

import com.hc.cn.PdfReader;
import com.hc.cn.storage.StorageException;
import com.hc.cn.storage.StorageFileNotFoundException;
import com.hc.cn.storage.StorageProperties;
import com.hc.cn.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {
    private Logger log = LoggerFactory.getLogger(FileUploadController.class);
    private final StorageService storageService;
    private final Path rootLocation;


    @Autowired
    public FileUploadController(StorageService storageService, StorageProperties properties) {
        this.storageService = storageService;
        this.rootLocation = Paths.get(properties.getLocation());

    }

    @GetMapping("/upload")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message",
                    "Your  file is empty!");
            return "redirect:/";
        }
        Path path = rootLocation.resolve(file.getOriginalFilename());
        String absoluFilePath = path.toAbsolutePath().toString();
        String name = file.getOriginalFilename();
        if (!name.endsWith(".pdf")) {
            redirectAttributes.addFlashAttribute("message",
                    "file is not a pdf");
            return "redirect:/";
        }
        File file2 = new File(absoluFilePath);
        if (file2.exists()) {
            redirectAttributes.addFlashAttribute("message",
                    "Your  uploaded is failed(exist same filename)" + file.getOriginalFilename() + "!");

        } else {
            storageService.store(file);
            PdfReader pdfReader = new PdfReader();
            String content = pdfReader.getFileContent(absoluFilePath);
            String handleFileName = absoluFilePath.substring(0, absoluFilePath.length() - 4);
            handleFileName = handleFileName + ".doc";
            pdfReader.writeDocument(content, handleFileName);
            String origenName = file.getOriginalFilename();
            String origenName2 = origenName.substring(0, origenName.length() - 3);
            origenName2 = origenName2 + "doc";
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + origenName2 + "!");
        }
        return "redirect:/upload";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}