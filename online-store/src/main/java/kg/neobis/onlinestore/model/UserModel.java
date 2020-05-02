package kg.neobis.onlinestore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String login;
    private String email;
    private String password;
    private String phoneNumber;
    private Long addressId;
    private Integer isActive; //0-inactive, 1-active...
}
