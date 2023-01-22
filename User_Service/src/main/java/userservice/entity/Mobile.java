package userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mobile {

    private String mobileId;
    private String name;
    private String brand;
    private Long price;
}
