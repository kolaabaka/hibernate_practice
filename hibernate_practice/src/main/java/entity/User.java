package entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import converter.BirthDayConverter;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor //important initialize noArgs constructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Table(name = "users", schema = "public")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class User {
    @Id
    private String userName;

    private String firstName;

    private String lastName;

//    @Convert(converter = BirthDayConverter.class)
    @Column(name = "birth_date")//, columnDefinition = "date")
    private Birthday birthDate;

//    private Integer age;
    @Type(type = "jsonb")
    private String info;

    @Enumerated(EnumType.STRING)
    private Role role;
}
