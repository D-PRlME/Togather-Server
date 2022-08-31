package com.project.draw.domain.image.service;

import com.project.draw.domain.image.presentation.dto.response.ImagesUrlResponse;
import com.project.draw.global.image.s3.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImagesUploadService {

    private final S3Facade s3Facade;

    public ImagesUrlResponse execute(List<MultipartFile> images) {

        List<String> imagesUrl = images
                .stream()
                .map(s3Facade::uploadImage)
                .collect(Collectors.toList());

        return new ImagesUrlResponse(imagesUrl);
    }
}