package kg.easyit.onlineshop.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String firstName;
    String lastName;
    String username;
    String email;
    String phoneNumber;
    Long BasketId;
    Long AccountIds;
}
