package com.model;

import javax.persistence.*;

/**
 * Created by davidheryanto on 1/18/15.
 */
@Entity
@Table(name = "course", schema = "", catalog = "collegepossible")
public class CourseEntity {
    private int courseId;
    private String courseName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY applies to MySQL
    @Column(name = "CourseId")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "CourseName")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (courseId != that.courseId) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        return result;
    }
}
