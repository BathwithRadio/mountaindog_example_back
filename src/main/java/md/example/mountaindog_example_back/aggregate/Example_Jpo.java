package md.example.mountaindog_example_back.aggregate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import md.example.mountaindog_example_back.rest.Example_Entity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
@Table(name = "EXAMPLE_TABLE")
public class Example_Jpo{
    //
    @Id
    @GeneratedValue(generator = "EXAMPLE_GENERATOR")
    @GenericGenerator(name = "EXAMPLE_GENERATOR", strategy = "uuid")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "SHOW_AGE")
    private boolean showAge;

    public Example_Jpo(Example_Entity exampleEntity) {
        //
        BeanUtils.copyProperties(exampleEntity, this);
    }

    public Example_Entity toDomain(){
        //
        Example_Entity example_entity = new Example_Entity();
        BeanUtils.copyProperties(this, example_entity);
        return example_entity;
    }

    public static List<Example_Entity> toDomains(List<Example_Jpo> example_jpos){
        return example_jpos.stream().map(Example_Jpo::toDomain).collect(Collectors.toList());
    }
}
