package acc.accountservice.countries;

import com.TradeFinance.accountservice.countries.Country;
import com.TradeFinance.accountservice.countries.CountryDto;
import com.TradeFinance.accountservice.util.ApiResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

public interface countryService {
    static void saveCountries(List<com.TradeFinance.accountservice.countries.Country> countries) {
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
        @Transactional
        ApiResponse<com.TradeFinance.accountservice.countries.CountryDto> createCountry(@Valid com.TradeFinance.accountservice.countries.CountryDto countryDto);

    void initializeCountries();

   // public ApiResponse<CountryDto> createCountry(CountryDto countryDto);

    ApiResponse<com.TradeFinance.accountservice.countries.Country> modifyCountry(String countryName, CountryDto countryDto);


    ApiResponse<com.TradeFinance.accountservice.countries.Country> getByCountryName(String countryName);

    ApiResponse<com.TradeFinance.accountservice.countries.Country> getByCountryCode(String countryCode);

    ApiResponse<com.TradeFinance.accountservice.countries.Country> getByCountryCity(String countryCity);

    ApiResponse<List<Country>> getAll();



    ApiResponse<String> deleteCountryByCountryName(String countryName);

    ApiResponse<String> deleteCountryByCountryCode(String countryCode);

    ApiResponse<String> deleteCountryByCountryCity(String countryCity);
}
