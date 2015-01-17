package com.example;

import com.model.CourseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Collection;

/**
 * Created by davidheryanto on 1/18/15.
 */
@Path("/")
public class Resource {
    @Path("/hello")
    @GET
    @Produces("application/json")
    public Collection<CourseEntity> sayHello() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
//        Start transaction
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseName("My New Course 2");
        em.persist(courseEntity);
        Query query = em.createQuery("SELECT c FROM CourseEntity c WHERE c.courseId > 14");
        Collection<CourseEntity> courseEntities = query.getResultList();
//        End transaction
        em.getTransaction().commit();

        em.close();
        return courseEntities;
    }
}
