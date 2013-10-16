package org.nhnnext.repository;

import org.nhnnext.web.CommentData;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentData, Long>{
}