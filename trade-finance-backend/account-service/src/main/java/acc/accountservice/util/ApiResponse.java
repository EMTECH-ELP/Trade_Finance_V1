package acc.accountservice.util;

//import com.TradeFinance.accountservice.BankAccount.Dto.AccountResponse;
import com.TradeFinance.accountservice.dto.BankResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApiResponse<T> {
    private String message;
    private T data;
    private Integer statusCode;

//     Add this constructor to match the arguments you are passing
    public ApiResponse(String message, List<BankResponse> entity, Integer statusCode) {
        this.message = message;
        this.data = (T) data;
        this.statusCode = statusCode;

    }
}