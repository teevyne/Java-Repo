package service;

import com.producerapi.producerapidemo.model.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${resource.tasks}")
    private String resource;

    @Value("${resource.tasks}/{id}")
    private String idResource;

    public List<TaskDTO> findAll() {
        return Arrays.stream(restTemplate.getForObject(resource, TaskDTO[].class)).collect(Collectors.toList());
    }

    public TaskDTO create(TaskDTO task) {
        return restTemplate.postForObject(resource, task, TaskDTO.class);
    }

    public TaskDTO update(Long id, TaskDTO task) {
        return restTemplate.exchange(idResource, HttpMethod.PUT, new HttpEntity<>(task), TaskDTO.class, id).getBody();
    }

    public void delete(Long id) {
        restTemplate.delete(idResource, id);
    }
}
