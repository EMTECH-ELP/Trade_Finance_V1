package acc.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDto {
    private String accountName;
    private String cifId;
    private String currency;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String postalCode;
    private String countryCode;
    private String country;

//    private String nationalId;
    private String accountNumber;
//    private String formattedAddress;
//    private String alternativePhoneNumber;
//    private String Name;
//    private String gender;
//    private String kra;



}

