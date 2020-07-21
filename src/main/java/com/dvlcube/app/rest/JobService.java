package com.dvlcube.app.rest;

import com.dvlcube.app.interfaces.MenuItem;
import com.dvlcube.app.jpa.repo.JobRepository;
import com.dvlcube.app.manager.data.JobBean;
import static com.dvlcube.app.manager.data.e.Menu.CONFIGURATION;
import com.dvlcube.app.manager.data.vo.MxRestResponse;
import com.dvlcube.utils.interfaces.MxService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MenuItem(value = CONFIGURATION)
@RequestMapping("${dvl.rest.prefix}/jobs")
public class JobService implements MxService {

    @Autowired
    private JobRepository repository;

    @GetMapping
    public List<JobBean> get() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<JobBean> get(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public MxRestResponse post(@Valid @RequestBody JobBean body) {
        JobBean persistedJob = repository.save(body);
        return GenericRestResponse.ok(persistedJob.getId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
