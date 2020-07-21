
package com.dvlcube.app.jpa.repo;

import com.dvlcube.app.jpa.DvlRepository;
import com.dvlcube.app.manager.data.JobBean;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends DvlRepository<JobBean, Long>{
    
}
