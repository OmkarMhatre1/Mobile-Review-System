package mobileService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Mobile")
public class Mobile {

    @Id
    private String mobileId;
    private String name;
    private String brand;
    private Long price;
}
