package md.example.mountaindog_example_back.logic;

import lombok.RequiredArgsConstructor;
import md.example.mountaindog_example_back.aggregate.Example_Jpo;
import md.example.mountaindog_example_back.repository.Example_Repository;
import md.example.mountaindog_example_back.rest.Example_Entity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Example_Logic {
    //
    private final Example_Repository example_repository;

    public String save(Example_Entity exampleEntity) {
        //
        Example_Jpo example_jpo = new Example_Jpo(exampleEntity);
        
        return example_repository.save(example_jpo).getName();
    }



    public Example_Entity findByName(String name) {
        //
        return example_repository.findByName(name).toDomain();
    }



    public List<Example_Entity> findAll() {
        //
        return Example_Jpo.toDomains(example_repository.findAll());
    }



    public void delete(Example_Entity exampleEntity) {
        //
        Example_Jpo example_jpo = new Example_Jpo(exampleEntity);
        example_repository.delete(example_jpo);
    }

    public void find() {
        //
        
    }


}
