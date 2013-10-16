package org.nhnnext.repository;

import org.nhnnext.web.BoardData;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardData, Long> {

}