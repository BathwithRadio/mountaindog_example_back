package md.example.mountaindog_example_back;

import md.example.mountaindog_example_back.logic.Example_Logic;
import md.example.mountaindog_example_back.rest.Example_Entity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MountaindogExampleBackApplicationTests {
    //
    @Autowired
    Example_Logic example_logic;

    @Test
    void saveTest() {
        //
        Example_Entity example_entity = new Example_Entity();
        example_entity.setName("민기6");
        example_entity.setAge(123);
        example_entity.setShowAge(false);

        System.out.println(example_logic.save(example_entity));
    }

    @Test
    void findByNameTest() {
        //
        Example_Entity example_entity = example_logic.findByName("민기");
    }

    @Test
    void findAllTest() {
        //
        List<Example_Entity> example_entities = example_logic.findAll();
        for (Example_Entity example_entity :example_entities){
            System.out.println(example_entity.getId());
            System.out.println(example_entity.getName());
            System.out.println(example_entity.getAge());
        }
    }

    @Test
    void updateTest() {
        //
        Example_Entity example_entity = example_logic.findByName("민기");
        example_entity.setAge(11);
        example_logic.save(example_entity);
    }

    @Test
    void deleteTest() {
        //
        Example_Entity example_entity = example_logic.findByName("민기4");
        example_logic.delete(example_entity);
        System.out.println("Delete complete");
    }

}
