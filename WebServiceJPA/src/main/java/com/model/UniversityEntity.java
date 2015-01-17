package com.model;

import javax.persistence.*;

/**
 * Created by davidheryanto on 1/18/15.
 */
@Entity
@Table(name = "university", schema = "", catalog = "collegepossible")
public class UniversityEntity {
    private int universityId;
    private String universityName;
    private String universityType;
    private String universitySpecialization;
    private int universityEstablishedYear;
    private String state;
    private String location;

    @Id
    @Column(name = "UniversityId")
    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    @Basic
    @Column(name = "UniversityName")
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Basic
    @Column(name = "UniversityType")
    public String getUniversityType() {
        return universityType;
    }

    public void setUniversityType(String universityType) {
        this.universityType = universityType;
    }

    @Basic
    @Column(name = "UniversitySpecialization")
    public String getUniversitySpecialization() {
        return universitySpecialization;
    }

    public void setUniversitySpecialization(String universitySpecialization) {
        this.universitySpecialization = universitySpecialization;
    }

    @Basic
    @Column(name = "UniversityEstablishedYear")
    public int getUniversityEstablishedYear() {
        return universityEstablishedYear;
    }

    public void setUniversityEstablishedYear(int universityEstablishedYear) {
        this.universityEstablishedYear = universityEstablishedYear;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UniversityEntity that = (UniversityEntity) o;

        if (universityEstablishedYear != that.universityEstablishedYear) return false;
        if (universityId != that.universityId) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (universityName != null ? !universityName.equals(that.universityName) : that.universityName != null)
            return false;
        if (universitySpecialization != null ? !universitySpecialization.equals(that.universitySpecialization) : that.universitySpecialization != null)
            return false;
        if (universityType != null ? !universityType.equals(that.universityType) : that.universityType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = universityId;
        result = 31 * result + (universityName != null ? universityName.hashCode() : 0);
        result = 31 * result + (universityType != null ? universityType.hashCode() : 0);
        result = 31 * result + (universitySpecialization != null ? universitySpecialization.hashCode() : 0);
        result = 31 * result + universityEstablishedYear;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
