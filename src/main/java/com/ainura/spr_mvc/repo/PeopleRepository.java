package com.ainura.spr_mvc.repo;

import com.ainura.spr_mvc.models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.ainura.spr_mvc.models.People;
import java.util.List;

public interface PeopleRepository extends JpaRepository<People,Long> {


}
