package com.springcourse.learnjpaandhibernate.course.jdbc;

import com.springcourse.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_HARDCODED_QUERY =
            """
                INSERT INTO course  VALUES
                (2, 'Learn Azure', 'in28minutes');
            """;
    private static final String INSERT_PARAMETERIZED_QUERY =
            """
                INSERT INTO course  VALUES
                (?, ?, ?);
            """;

    private static final String DELETE_BY_ID_QUERY =
            """
                DELETE FROM course  WHERE id = ?;
            """;

    private static final String SELECT_BY_ID_QUERY =
            """
                SELECT * FROM course  WHERE id = ?;
            """;


    public void insert(Course course)
    {
        jdbcTemplate.update(INSERT_PARAMETERIZED_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    @Transactional
    public void deleteById(long id)
    {
        jdbcTemplate.update(DELETE_BY_ID_QUERY, id);
    }

    public Course selectById(int id)
    {

        return jdbcTemplate.queryForObject
                (SELECT_BY_ID_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
