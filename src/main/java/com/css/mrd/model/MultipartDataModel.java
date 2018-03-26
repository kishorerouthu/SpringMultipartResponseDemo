package com.css.mrd.model;

import java.io.InputStream;

/**
 * @author Kishore Routhu on 27/6/17 3:04 PM.
 */
public class MultipartDataModel {

    private String fileName;
    private InputStream baseFile;
    private InputStream localFile;
    private InputStream remoteFile;

    public MultipartDataModel() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getBaseFile() {
        return baseFile;
    }

    public void setBaseFile(InputStream baseFile) {
        this.baseFile = baseFile;
    }

    public InputStream getLocalFile() {
        return localFile;
    }

    public void setLocalFile(InputStream localFile) {
        this.localFile = localFile;
    }

    public InputStream getRemoteFile() {
        return remoteFile;
    }

    public void setRemoteFile(InputStream remoteFile) {
        this.remoteFile = remoteFile;
    }
}
