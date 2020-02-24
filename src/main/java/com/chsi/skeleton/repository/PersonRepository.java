package com.chsi.skeleton.repository;

import com.chsi.skeleton.entity.*;
import java.util.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.rest.core.annotation.*;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    List<Person> findByFirstName(@Param("firstName") String firstName);
}
