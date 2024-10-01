
package com.senac.filmeWeb.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository<AnaliseEntity, Long> {
    AnaliseEntity findByFilmeId(Long filmeId);
   
}
