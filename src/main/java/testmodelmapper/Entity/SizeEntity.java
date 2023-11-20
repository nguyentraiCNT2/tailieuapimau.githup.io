package testmodelmapper.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Size")
@Data
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sizename")
    private String sizeName;
}
