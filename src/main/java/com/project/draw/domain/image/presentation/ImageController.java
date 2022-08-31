package com.project.draw.domain.image.presentation;

import com.project.draw.domain.image.presentation.dto.response.ImagesUrlResponse;
import com.project.draw.domain.image.service.ImagesUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ImageController {

    private final ImagesUploadService imageUploadService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/images")
    public ImagesUrlResponse imageUpload(@RequestPart(value = "images") List<MultipartFile> images) {
        return imageUploadService.execute(images);
    }

}