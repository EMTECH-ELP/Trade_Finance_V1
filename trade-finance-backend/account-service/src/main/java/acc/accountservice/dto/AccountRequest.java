package acc.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder

public class AccountRequest  {
    private String nationalId;
    private String passportNumber;
    private boolean isBusiness;
    private String currency;
    private String firstName;
    private String middleName;
    private String lastName;
    private String businessName;
    private String address;
    private String city;
    private String postalCode;
    private String email;
    private String accountName;
    private String phoneNumber;
    private String gender;
    private String countryCode;
    private String country;
    private String kra;

}
