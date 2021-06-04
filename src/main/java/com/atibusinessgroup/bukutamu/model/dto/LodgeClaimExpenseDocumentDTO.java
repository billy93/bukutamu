package com.atibusinessgroup.bukutamu.model.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class LodgeClaimExpenseDocumentDTO {

    private String id;

    private List<DocumentDTO> documents = new ArrayList<>();
    private Instant timestamp;
    private Instant lastUpdated;

    public static class DocumentDTO{
        private String filename;
        private String fileurl;
        private DocumentTypeDTO type;

        public DocumentDTO(){

        }
        public DocumentDTO(String filename, String fileurl, DocumentTypeDTO type) {
            this.filename = filename;
            this.fileurl = fileurl;
            this.type = type;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public DocumentTypeDTO getType() {
            return type;
        }

        public void setType(DocumentTypeDTO type) {
            this.type = type;
        }

        public String getFileurl() {
            return fileurl;
        }

        public void setFileurl(String fileurl) {
            this.fileurl = fileurl;
        }

        @Override
        public String toString() {
            return "DocumentDTO{" +
                "filename='" + filename + '\'' +
                ", fileurl='" + fileurl + '\'' +
                ", type='" + type + '\'' +
                '}';
        }
    }

    public LodgeClaimExpenseDocumentDTO() {
    }

    public LodgeClaimExpenseDocumentDTO(String id, List<DocumentDTO> documents, Instant timestamp, Instant lastUpdated) {
        this.id = id;
        this.documents = documents;
        this.timestamp = timestamp;
        this.lastUpdated = lastUpdated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DocumentDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentDTO> documents) {
        this.documents = documents;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Instant getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Instant lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "LodgeClaimExpenseDocumentDTO{" +
            "id='" + id + '\'' +
            ", documents=" + documents +
            ", timestamp=" + timestamp +
            ", lastUpdated=" + lastUpdated +
            '}';
    }
}
