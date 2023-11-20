package testmodelmapper.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Color")
@Data
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "colorname")
    private String colorName;
}
