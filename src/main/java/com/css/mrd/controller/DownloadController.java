package com.css.mrd.controller;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.css.mrd.model.MultipartDataModel;

/**
 * @author Kishore Routhu on 27/6/17 2:58 PM.
 */
@RestController
@RequestMapping(value = "/download")
public class DownloadController {

    @RequestMapping(value = "/multipart", method = RequestMethod.GET, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MultipartDataModel> downloadMultipartFile(HttpServletRequest request, HttpServletResponse response) {
        ClassLoader classLoader = this.getClass().getClassLoader();

        InputStream baseFileStream = classLoader.getResourceAsStream("v1/README.md");
        InputStream localFileStream = classLoader.getResourceAsStream("v1/README_Local.md");
        InputStream remoteFileStream = classLoader.getResourceAsStream("v1/README_Remote.md");

        MultipartDataModel multipartDataModel = new MultipartDataModel();
        multipartDataModel.setFileName("README.md");
        multipartDataModel.setBaseFile(baseFileStream);
        multipartDataModel.setLocalFile(localFileStream);
        multipartDataModel.setRemoteFile(remoteFileStream);


        HttpHeaders headers = new HttpHeaders();
        headers.add("ContentType", MediaType.MULTIPART_FORM_DATA_VALUE);
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("baseFile", baseFileStream);
        parts.add("localFile", localFileStream);
        parts.add("remoteFile", remoteFileStream);
        parts.add("fileName", multipartDataModel.getFileName());

        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(parts);

        return new ResponseEntity<> (multipartDataModel,HttpStatus.OK);
    }
}
