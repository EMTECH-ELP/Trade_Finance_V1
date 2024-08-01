package acc.accountservice.countries.Impl;

import com.TradeFinance.accountservice.countries.Country;
import com.TradeFinance.accountservice.countries.CountryDto;
import com.TradeFinance.accountservice.countries.countryRepository;
import com.TradeFinance.accountservice.countries.countryService;
import com.TradeFinance.accountservice.util.ApiResponse;
import com.neovisionaries.i18n.CountryCode;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.TradeFinance.accountservice.countries.CountryUtil.getCapitalCity;

//import static com.TradeFinance.accountservice.countries.CountryUtil.getCapitalCity;

@Service
public class countryServiceImpl implements countryService {
    private final countryRepository countryRepository;
    private final Validator validator;

    // Constructor-based dependency injection
    @Autowired
    public countryServiceImpl(countryRepository countryRepository, Validator validator) {
        this.countryRepository = countryRepository;
        this.validator = validator;
    }

//    private static final List<String> VALID_COUNTRY_NAMES = Arrays.asList(
//            "Afghanistan", "Albania", "Algeria",
//            "Andorra", "Angola", "Antigua and Barbuda",
//            "Argentina", "Armenia", "Australia",
//            "Austria", "Azerbaijan", "Bahamas",
//            "Bahrain", "Bangladesh", "Barbados",
//            "Belarus", "Belgium", "Belize",
//            "Benin", "Bhutan", "Bolivia",
//            "Bosnia and Herzegovina", "Botswana", "Brazil",
//            "Brunei", "Bulgaria", "Burkina Faso",
//            "Burundi", "Cabo Verde", "Cambodia",
//            "Cameroon", "Canada", "Central African Republic",
//            "Chad", "Chile", "China",
//            "Colombia", "Comoros", "Congo, Democratic Republic of the",
//            "Congo, Republic of the", "Costa Rica",
//            "Côte d'Ivoire", "Croatia", "Cuba",
//            "Cyprus", "Czech Republic", "Denmark",
//            "Djibouti", "Dominica", "Dominican Republic",
//            "East Timor (Timor-Leste)", "Ecuador", "Egypt",
//            "El Salvador", "Equatorial Guinea", "Eritrea",
//            "Estonia", "Eswatini", "Ethiopia",
//            "Fiji", "Finland", "France",
//            "Gabon", "Gambia", "Georgia",
//            "Germany", "Ghana", "Greece",
//            "Grenada", "Guatemala", "Guinea",
//            "Guinea-Bissau", "Guyana", "Haiti",
//            "Holy See", "Honduras", "Hungary",
//            "Iceland", "India", "Indonesia",
//            "Iran", "Iraq", "Ireland",
//            "Israel", "Italy", "Jamaica",
//            "Japan", "Jordan", "Kazakhstan",
//            "Kenya", "Kiribati", "Korea, North",
//            "Korea, South", "Kosovo", "Kuwait",
//            "Kyrgyzstan", "Laos", "Latvia",
//            "Lebanon", "Lesotho", "Liberia",
//            "Libya", "Liechtenstein", "Lithuania",
//            "Luxembourg", "Madagascar", "Malawi",
//            "Malaysia", "Maldives", "Mali",
//            "Malta", "Marshall Islands", "Mauritania",
//            "Mauritius", "Mexico", "Micronesia, Federated States of",
//            "Moldova", "Monaco", "Mongolia",
//            "Montenegro", "Morocco", "Mozambique",
//            "Myanmar (Burma)", "Namibia", "Nauru",
//            "Nepal", "Netherlands", "New Zealand",
//            "Nicaragua", "Niger", "Nigeria",
//            "North Macedonia", "Norway", "Oman",
//            "Pakistan", "Palau", "Panama",
//            "Papua New Guinea", "Paraguay", "Peru",
//            "Philippines", "Poland", "Portugal",
//            "Qatar", "Romania", "Russia",
//            "Rwanda", "Saint Kitts and Nevis", "Saint Lucia",
//            "Saint Vincent and the Grenadines", "Samoa", "San Marino",
//            "Sao Tome and Principe", "Saudi Arabia", "Senegal",
//            "Serbia", "Seychelles", "Sierra Leone",
//            "Singapore", "Slovakia", "Slovenia",
//            "Solomon Islands", "Somalia", "South Africa",
//            "South Sudan", "Spain", "Sri Lanka",
//            "Sudan", "Suriname", "Sweden",
//            "Switzerland", "Syria", "Taiwan",
//            "Tajikistan", "Tanzania", "Thailand",
//            "Togo", "Tonga", "Trinidad and Tobago",
//            "Tunisia", "Turkey", "Turkmenistan",
//            "Tuvalu", "Uganda", "Ukraine",
//            "United Arab Emirates", "United Kingdom", "Uruguay",
//            "Uzbekistan", "Vanuatu", "Vatican City",
//            "Venezuela", "Vietnam", "Yemen",
//            "Zambia", "Zimbabwe", "Ziman"
//    );
//    private static final String[] VALID_COUNTRY_CODES = {"AF", "AL", "DZ", "AD", "AO", "AG", "AR", "AM", "AU", "AT", "AZ", "BS", "BH", "BD", "BB", "BY", "BE", "BZ", "BJ", "BT", "BO", "BA", "BW", "BR", "BN", "BG", "BF", "BI", "KH", "CM", "CA", "CF", "TD", "CL", "CN", "CO", "KM", "CG", "CD", "CI", "HR", "CU", "CY", "CZ", "DK", "DJ", "DM", "DO", "EC", "EG", "SV", "GQ", "ER", "EE", "SZ", "ET", "FK", "FO", "GF", "TF", "GA", "GM", "GE", "GH", "GI", "GR", "GL", "GD", "GP", "GU", "GT", "GY", "HT", "HM", "VA", "HN", "HU", "IS", "IN", "ID", "IR", "IQ", "IE", "IL", "IT", "JM", "JP", "JO", "KZ", "KE", "KI", "KP", "KR", "KW", "KG", "LA", "LV", "LB", "LS", "LR", "LY", "LI", "LT", "LU", "MO", "MK", "MG", "MW", "YT", "MY", "MV", "ML", "MT", "MH", "MQ", "MR", "MU", "MX", "FM", "MD", "MC", "MN", "MS", "MA", "MZ", "MM", "NA", "NR", "NP", "NL", "NZ", "NI", "NE", "NG", "NU", "NF", "MP", "NO", "OM", "PK", "PW", "PA", "PG", "PY", "PE", "PH", "PN", "PL", "PT", "PR", "QA", "RO", "RU", "RW", "BL", "SH", "KN", "LC", "MF", "PM", "VC", "WS", "SM", "ST", "SA", "SN", "RS", "SC", "SL", "SG", "SK", "SI", "SB", "SO", "ZA", "GS", "SS", "ES", "LK", "SD", "SR", "SJ", "SE", "CH", "SY", "TW", "TJ", "TZ", "TH", "TL", "TG", "TK", "TO", "TT", "TN", "TR", "TM", "TC", "TV", "UG", "UA", "AE", "GB", "US", "UM", "UY", "UZ", "VU", "VE", "VN", "VG", "VI", "WF", "EH", "YE", "ZM", "ZW","ZXL"};
    @Override
    @Transactional
    public ApiResponse<CountryDto> createCountry(@Valid CountryDto countryDto){
        if (validator == null) {
            throw new IllegalStateException("Validator is not initialized");
        }

        Set<ConstraintViolation<CountryDto>> violations = validator.validate(countryDto);

        if (!violations.isEmpty()) {
            // Handle validation errors
            // You can return a custom error response or throw an exception
            return new ApiResponse<>("Validation failed", null, HttpStatus.BAD_REQUEST.value());
        }
//        if (!Arrays.asList(VALID_COUNTRY_CODES).contains(countryDto.getCountryCode().toUpperCase())) {
//            return new ApiResponse<>("Invalid country code", null, HttpStatus.BAD_REQUEST.value());
//        }
//        String upperCaseCountryName = countryDto.getCountryName().toUpperCase();
//        if (!VALID_COUNTRY_NAMES.contains(countryDto.getCountryName())) {
//            return new ApiResponse<>("Invalid country name", null, HttpStatus.BAD_REQUEST.value());
//        }



        // Check if a country with the same name already exists
        Optional<Country> existingCountry = countryRepository.findByName(countryDto.getCountryName());

        if (existingCountry.isPresent()) {
            // Return an error response if the country already exists
            return new ApiResponse<>("Country already exists", null, HttpStatus.CONFLICT.value());
        }

        Country country = Country.builder()
                .countryCity(countryDto.getCountryCity())
                .countryCode(countryDto.getCountryCode())
                .countryName(countryDto.getCountryName())
                .build();
        countryRepository.save(country);
        return new ApiResponse<>("Country created successfully", countryDto, HttpStatus.CREATED.value());
    }
@Transactional
public void initializeCountries() {
    List<Country> countries = new ArrayList<>();

    try {
        for (CountryCode countryCode : CountryCode.values()) {
            String isoAlpha2 = countryCode.getAlpha2();
            String countryName = countryCode.getName();
            String capitalCity = getCapitalCity(isoAlpha2); // Assuming this method is implemented
            //String countryPort= = getCountryPort(isoAlpha2); // Assuming this method

            Country country = Country.builder()
                    .countryName(countryName)
                    .countryCode(isoAlpha2)
                    .countryCity(capitalCity)
                    .build();

            countries.add(country);
        }

        countryRepository.saveAll(countries);

        System.out.println("Successfully saved " + countries.size() + " countries to the database.");
    } catch (Exception e) {
        // Log the exception details for debugging
        System.err.println("Failed to save countries: " + e.getMessage());
        e.printStackTrace(); // Or use a logger instead of System.err
    }
}

    @Override
    public ApiResponse<Country> modifyCountry(String countryName, CountryDto countryDto) {
        Optional<Country> originalCountryOptional = countryRepository.findByName(countryName);
        if (originalCountryOptional.isPresent()) {
            Country originalCountry = originalCountryOptional.get();

            originalCountry.setCountryCode(countryDto.getCountryCode());
            originalCountry.setCountryCity(countryDto.getCountryCity());
            originalCountry.setCountryName(countryDto.getCountryName());

            return new ApiResponse<>("Country modified successfully", countryRepository.save(originalCountry), 200);
        } else {
            throw new IllegalArgumentException("Country with ID " + countryName + " not found.");
        }
    }
    @Override
    public ApiResponse<Country> getByCountryName(String countryName) {
        Optional<Country> letterOfCreditOptional = countryRepository.findByName(countryName);
        if (letterOfCreditOptional.isPresent()) {
            Country letterOfCredit = letterOfCreditOptional.get();
            return new ApiResponse<>("success", letterOfCredit, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }
    @Override
    public ApiResponse<Country> getByCountryCode(String countryCode) {
        Optional<Country> letterOfCreditOptional = countryRepository.findByCountryCode(countryCode);
        if (letterOfCreditOptional.isPresent()) {
            Country letterOfCredit = letterOfCreditOptional.get();
            return new ApiResponse<>("success", letterOfCredit, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }
    @Override
    public ApiResponse<Country> getByCountryCity(String countryCity) {
        Optional<Country> letterOfCreditOptional = countryRepository.findByCountryCity(countryCity);
        if (letterOfCreditOptional.isPresent()) {
            Country letterOfCredit = letterOfCreditOptional.get();
            return new ApiResponse<>("success", letterOfCredit, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<List<Country>> getAll() {
        List<Country> letterOfCredits = countryRepository.findAll();
        if (!letterOfCredits.isEmpty()) {
            return new ApiResponse<>("success", letterOfCredits, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<String> deleteCountryByCountryName(String countryName) {
        Optional<Country> letterOfCreditOptional = countryRepository.findByName(countryName);

        if (letterOfCreditOptional.isPresent()) {
            Country letterOfCredit = letterOfCreditOptional.get();

            countryRepository.delete(letterOfCredit);

            return new ApiResponse<>("success", "Letter of Credit with LC number " + countryName + " has been deleted", HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", "Letter of Credit with LC number " + countryName + " not found", HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<String> deleteCountryByCountryCode(String countryCode) {
        Optional<Country> letterOfCreditOptional = countryRepository.findByCountryCode(countryCode);

        if (letterOfCreditOptional.isPresent()) {
            Country letterOfCredit = letterOfCreditOptional.get();

            countryRepository.delete(letterOfCredit);

            return new ApiResponse<>("success", "Letter of Credit with LC number " + countryCode + " has been deleted", HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", "Letter of Credit with LC number " + countryCode + " not found", HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<String> deleteCountryByCountryCity(String countryCity) {
        Optional<Country> letterOfCreditOptional = countryRepository.findByCountryCity(countryCity);

        if (letterOfCreditOptional.isPresent()) {
            Country letterOfCredit = letterOfCreditOptional.get();

            countryRepository.delete(letterOfCredit);

            return new ApiResponse<>("success", "Letter of Credit with LC number " + countryCity + " has been deleted", HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", "Letter of Credit with LC number " + countryCity + " not found", HttpStatus.NOT_FOUND.value());
        }
    }


}