package com.atibusinessgroup.bukutamu.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ExpenseDocumentLodgeClaimForm {
	private String claimId;
    private List<Document> documents = new ArrayList<ExpenseDocumentLodgeClaimForm.Document>();

    public static class Document{
        private String filename;
        private String type;

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Document{" +
                "filename='" + filename + '\'' +
                ", type='" + type + '\'' +
                '}';
        }
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "ExpenseDocumentLodgeClaimForm{" +
            "claimId='" + claimId + '\'' +
            ", documents=" + documents +
            '}';
    }
}
