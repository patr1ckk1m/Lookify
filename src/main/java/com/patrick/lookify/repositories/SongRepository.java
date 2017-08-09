package com.patrick.lookify.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.patrick.lookify.models.*;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{

}