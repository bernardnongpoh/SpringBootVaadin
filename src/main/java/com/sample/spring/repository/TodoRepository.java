package com.sample.spring.repository;

import com.sample.spring.model.Todo;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bernard-w on 10/3/19.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
