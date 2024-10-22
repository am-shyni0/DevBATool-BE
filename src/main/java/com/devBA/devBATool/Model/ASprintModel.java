package com.devBA.devBATool.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sprint_info")
public class ASprintModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aSprintId;
    private String projectName;
    private  String issueType;
    private  String status;
    private String epicName;


    public int getaSprintId() {
        return aSprintId;
    }

    public void setaSprintId(int aSprintId) {
        this.aSprintId = aSprintId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEpicName() {
        return epicName;
    }

    public void setEpicName(String epicName) {
        this.epicName = epicName;
    }


}
