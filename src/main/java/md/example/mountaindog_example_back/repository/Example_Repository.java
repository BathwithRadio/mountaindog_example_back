package md.example.mountaindog_example_back.repository;

import md.example.mountaindog_example_back.aggregate.Example_Jpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Example_Repository extends JpaRepository<Example_Jpo, String> {
    //
    Example_Jpo findByName(String name);

    Example_Jpo deleteByName(String name);
}
