package userservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "user")
public class User {

    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String number;

    @Transient
    private List<Rating> rating;

}
