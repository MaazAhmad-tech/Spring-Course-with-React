package com.springcourse.learnjpaandhibernate.course.jpa;

import com.springcourse.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CourseJpaRepository {

    @Autowired
    private EntityManager entityManager;

    public void insert(Course course)
    {
        entityManager.merge(course);
    }

    public Course selectById(long id)
    {
        return entityManager.find(Course.class, id);
    }

    @Transactional
    public void deleteById(long id)
    {
        Course course = selectById(id);
        entityManager.remove(course);
    }


}
