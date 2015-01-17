package com.model;

import javax.persistence.*;

/**
 * Created by davidheryanto on 1/18/15.
 */
@Entity
@Table(name = "exam", schema = "", catalog = "collegepossible")
public class ExamEntity {
    private int examId;
    private String examName;
    private String examType;
    private String state;

    @Id
    @Column(name = "ExamId")
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    @Basic
    @Column(name = "ExamName")
    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    @Basic
    @Column(name = "ExamType")
    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamEntity that = (ExamEntity) o;

        if (examId != that.examId) return false;
        if (examName != null ? !examName.equals(that.examName) : that.examName != null) return false;
        if (examType != null ? !examType.equals(that.examType) : that.examType != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = examId;
        result = 31 * result + (examName != null ? examName.hashCode() : 0);
        result = 31 * result + (examType != null ? examType.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
