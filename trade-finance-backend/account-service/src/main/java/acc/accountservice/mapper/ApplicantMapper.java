package acc.accountservice.mapper;

import com.TradeFinance.accountservice.applicant.Applicant;
import com.TradeFinance.accountservice.dto.ApplicantDto;

public class ApplicantMapper {

        public static ApplicantDto mapToApplicantDto(Applicant applicant, ApplicantDto applicantDto) {
            applicantDto.setAccountName(applicantDto.getAccountName());
            applicantDto.setEmail(applicant.getEmail());
//            applicantDto.setNationalId(applicant.getNationalId());
            return applicantDto;
        }

        public static Applicant mapToApplicant(ApplicantDto applicantDto, Applicant applicant) {
            applicant.setAccountName(applicantDto.getAccountName());
            applicant.setEmail(applicantDto.getEmail());
//            applicant.setNationalId (applicantDto.getNationalId());
            return applicant;
        }

    }

