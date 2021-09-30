package entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Team {
    private Integer id;
    private String name;
    private String stadium;
    private String country;
}