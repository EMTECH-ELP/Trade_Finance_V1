package acc.accountservice.beneficiary;

import com.TradeFinance.accountservice.beneficiary.Beneficiary;
import com.TradeFinance.accountservice.beneficiary.BeneficiaryDto;
import com.TradeFinance.accountservice.beneficiary.BeneficiaryRepository;
import com.TradeFinance.accountservice.lookUp.BankBicLookUpService;
import com.TradeFinance.accountservice.lookUp.CountryLookUpService;
import com.TradeFinance.accountservice.util.ApiResponse;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BeneficiaryService {
    private final BeneficiaryRepository beneficiaryRepository;
    private final CountryLookUpService countryLookupService;
    private final BankBicLookUpService bankBicLookupService;



    public ApiResponse<?> enterBeneficiaryDetails(com.TradeFinance.accountservice.beneficiary.BeneficiaryDto beneficiaryDto) {

        // Populate country and bank details
       // String countryName = countryLookupService.getCountryNameCountryCode(beneficiaryDto.getCountry());
      //  String advisingBank = bankBicLookupService.getBankNameByBic(beneficiaryDto.getAdvisingBankBic());
        // Populate country and advisingBank details
        if (beneficiaryDto.getBeneficiaryCountryCode() != null) {
            String countryName = countryLookupService.getCountryNameByCountryCode(beneficiaryDto.getBeneficiaryCountryCode());
            beneficiaryDto.setBeneficiaryCountry(countryName);
        }

        // Populate country and bank details
        if (beneficiaryDto.getAdvisingBankBic() != null) {
            String advisingBankInfo = bankBicLookupService.getBankNameAndCountryByBic(beneficiaryDto.getAdvisingBankBic());
            String[] parts = advisingBankInfo.split(" - ");
            if (parts.length == 2) {
                beneficiaryDto.setAdvisingBankName(parts[0]);
                beneficiaryDto.setAdvisingBankCountry(parts[1]);
            } else {
                beneficiaryDto.setAdvisingBankName("Unknown Bank");
                beneficiaryDto.setAdvisingBankCountry("Unknown Country");
            }
        }
// Format the address block
        if (StringUtils.isNotBlank(beneficiaryDto.getBeneficiaryAddressLine1())&& StringUtils.isNotBlank(beneficiaryDto.getBeneficiaryAddressLine1())) {
            String formattedAddressBlock = formatAddressBlock(beneficiaryDto.getBeneficiaryAddressLine1(),
                    beneficiaryDto.getBeneficiaryBankAddressLine2(),
                    beneficiaryDto.getBeneficiaryCity(),
                    beneficiaryDto.getBeneficiaryPostalCode(),
                    beneficiaryDto.getBeneficiaryCountry());
            beneficiaryDto.setFormattedAddress(formattedAddressBlock);
        }

        com.TradeFinance.accountservice.beneficiary.Beneficiary beneficiary= com.TradeFinance.accountservice.beneficiary.Beneficiary.builder()
                .beneficiaryFirstName(beneficiaryDto.getBeneficiaryFirstName())
                .beneficiaryMiddleName(beneficiaryDto.getBeneficiaryMiddleName())
                .beneficiaryLastName(beneficiaryDto.getBeneficiaryLastName())
                .beneficiaryAccountNumber(beneficiaryDto.getBeneficiaryAccountNumber())
                .beneficiaryEmail(beneficiaryDto.getBeneficiaryEmail())
                .beneficiaryAccountName(beneficiaryDto.getBeneficiaryAccountName())
                .beneficiaryIban(beneficiaryDto.getBeneficiaryIban())
                .beneficiaryAddressLine1(beneficiaryDto.getBeneficiaryAddressLine1())
                .BankAddressLine2(beneficiaryDto.getBeneficiaryBankAddressLine2())
                .beneficiaryCity(beneficiaryDto.getBeneficiaryCity())
                .beneficiaryPostalCode(beneficiaryDto.getBeneficiaryPostalCode())
                .formattedAddress(beneficiaryDto.getFormattedAddress())
                .beneficiaryCountry(beneficiaryDto.getBeneficiaryCountry())
                .beneficiaryCountryCode(beneficiaryDto.getBeneficiaryCountryCode())
                .advisingBankName(beneficiaryDto.getAdvisingBankName())
                .advisingBankCountry(beneficiaryDto.getAdvisingBankCountry())
                .advisingBankBic(beneficiaryDto.getAdvisingBankBic())
                .build();
        // Map BeneficiaryDto to Beneficiary entity
       // Beneficiary beneficiary = mapToEntity(updatedBeneficiaryDto);

        // Save beneficiary entity
        beneficiaryRepository.save(beneficiary);
        return new ApiResponse<>("Beneficiary details entered successfully",null, HttpStatus.CREATED.value());


    }

    private String formatAddressBlock(String addressLine1, String addressLine2, String city, String postalCode, String country) {
        if (addressLine1 == null) {
            return ""; // Or throw an exception, depending on your requirements
        }
        StringBuilder formattedAddress = new StringBuilder();
        formattedAddress.append(":".repeat(35)).append("\n");
        formattedAddress.append(":10B::ADDRESS::").append(addressLine1).append("\n");

        if (addressLine2 != null) {
            formattedAddress.append(":".repeat(13)).append(addressLine2).append("\n");
        }
        formattedAddress.append(":".repeat(13)).append(city).append("\n");
        if (postalCode != null) {
            formattedAddress.append(":".repeat(13)).append(postalCode).append("\n");
        }
        formattedAddress.append(":".repeat(13)).append(country).append("\n");
        formattedAddress.append(":".repeat(35));
        return formattedAddress.toString();

    }

    public ApiResponse<?> modifyBeneficiaryDetails(Long beneficiaryId, BeneficiaryDto beneficiaryDto) {
        Optional<com.TradeFinance.accountservice.beneficiary.Beneficiary> beneficiaryOptional = beneficiaryRepository.findById(beneficiaryId);
        if (beneficiaryOptional.isPresent()) {
            Beneficiary beneficiary = beneficiaryOptional.get();

            beneficiary.setBeneficiaryFirstName(beneficiaryDto.getBeneficiaryFirstName());
            beneficiary.setBeneficiaryMiddleName(beneficiaryDto.getBeneficiaryMiddleName());
            beneficiary.setBeneficiaryLastName(beneficiaryDto.getBeneficiaryLastName());
            beneficiary.setBeneficiaryAccountNumber(beneficiaryDto.getBeneficiaryAccountNumber());
            beneficiary.setBeneficiaryAccountName(beneficiaryDto.getBeneficiaryAccountName());
            beneficiary.setBeneficiaryEmail(beneficiaryDto.getBeneficiaryEmail());
            beneficiary.setIban(beneficiaryDto.getBeneficiaryIban());
            beneficiary.setBeneficiaryAddressLine1(beneficiaryDto.getBeneficiaryAddressLine1());
            beneficiary.setBankAddressLine2(beneficiaryDto.getBeneficiaryBankAddressLine2());
            beneficiary.setBeneficiaryCity(beneficiaryDto.getBeneficiaryCity());
            beneficiary.setFormattedAddress(beneficiaryDto.getFormattedAddress());
            beneficiary.setBeneficiaryPostalCode(beneficiaryDto.getBeneficiaryPostalCode());
            beneficiary.setBeneficiaryCountry(beneficiaryDto.getBeneficiaryCountry());
            beneficiary.setBeneficiaryCountryCode(beneficiaryDto.getBeneficiaryCountryCode());
            beneficiary.setAdvisingBankName(beneficiaryDto.getAdvisingBankName());
            beneficiary.setAdvisingBankCountry(beneficiaryDto.getAdvisingBankCountry());
            beneficiary.setAdvisingBankBic(beneficiaryDto.getAdvisingBankBic());

            beneficiaryRepository.save(beneficiary);
            return new ApiResponse<>("Beneficiary details modified successfully", null, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("Beneficiary not found", null, HttpStatus.NOT_FOUND.value());
        }
    }


}
