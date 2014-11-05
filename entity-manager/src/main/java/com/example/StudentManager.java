package com.example;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class StudentManager {

    @PersistenceContext(unitName = "student-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    public void removeStudent(Student student) {
        entityManager.remove(student);
    }

    public List<Student> getStudents() {
        Query query = entityManager.createQuery("SELECT s from student as s");
        return query.getResultList();
    }
}
