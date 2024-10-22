package com.devBA.devBATool.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "browse_info")
public class BrowseModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int browseId;
    private String fileName;
    public int getBrowseId() {
        return browseId;
    }

    public void setBrowseId(int browseId) {
        this.browseId = browseId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
