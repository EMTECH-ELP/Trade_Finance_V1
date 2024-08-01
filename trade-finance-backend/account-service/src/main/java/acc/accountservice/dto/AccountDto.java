package acc.accountservice.dto;

import lombok.Data;

@Data
public class AccountDto {
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
    private String cifId;
    private String nationalId;
    private String accountName;
    private String address;
    private String postalCode;
    private String city;
    private String formattedAddress;
    private String currency;
    private String email;
    private String phoneNumber;
    private String countryCode;
    private String country;
}
