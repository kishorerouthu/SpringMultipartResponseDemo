package com.css.mrd.converter;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServletServerHttpResponse;

import com.css.mrd.model.MultipartDataModel;

/**
 * @author Kishore Routhu on 27/6/17 3:11 PM.
 */
public class MultipartDownloadConverter extends AbstractHttpMessageConverter<MultipartDataModel> {

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return super.canWrite(clazz, mediaType);
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return MultipartDataModel.class == aClass;
    }

    @Override
    protected MultipartDataModel readInternal(Class<? extends MultipartDataModel> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        throw new RuntimeException("Does not suuport de-serialization");
    }

    @Override
    protected void writeInternal(MultipartDataModel multipartDataModel, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        ServletServerHttpResponse servletServerHttpResponse = (ServletServerHttpResponse)httpOutputMessage;
        InputStream baseFileStream = multipartDataModel.getBaseFile();
        InputStream localFileStream = multipartDataModel.getLocalFile();
        InputStream remoteFileStream = multipartDataModel.getRemoteFile();

        servletServerHttpResponse.getServletResponse().setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);
    }
}
