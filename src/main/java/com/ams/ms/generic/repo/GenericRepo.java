package com.ams.ms.generic.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepo<T,ID> extends JpaRepository<T,ID> {
    @Query("update #{#entityname} e set status=0 where id?1")
    void softDeleteById(ID id);
}
