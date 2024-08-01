package acc.accountservice.countries;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryDto {
    private String countryName;
    private String countryCode;
    private String countryCity;
}
