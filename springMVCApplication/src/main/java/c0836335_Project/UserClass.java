package c0836335_Project;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserClass {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message="First Name is required")
	@Size(min = 1, max = 30)
	private String firstName;
	
	@NotBlank(message="Last Name is required")
	@Size(min = 1, max = 30)
	private String lastName;
	
	@Email
	@NotBlank(message="Email is Required")
	private String email;
	
	@NotNull(message="Age is required")
	@Positive
	@Digits(fraction = 0, integer = 10, message ="age must not be in decimal")
	private Integer age;

}
