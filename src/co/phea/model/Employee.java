package co.phea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    // field
    private Integer id;
    private String name;
    private String gender;
    private String dob;
    private Integer phone;

}
