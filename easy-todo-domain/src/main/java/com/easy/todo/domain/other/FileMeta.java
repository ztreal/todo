package com.easy.todo.domain.other;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 文件相关信息.
 * User: zhangtan
 * Date: 13-9-3
 * Time: 上午10:31
 */
public class FileMeta {
    private String fileName;
    private String fileSize;
    private String fileType;

    private String filePath;
    /*
    序列化的上传文件内容
     */
    @JSONField(serialize = false)
    private byte[] bytes;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
