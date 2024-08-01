package com.TradeFinance.collectionservice.BillCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BillService {
    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Optional<Bill> getBillById(Long id) {
        return billRepository.findById(id);
    }

    public Bill createBill(Bill bill) {
        try {
            String randomBillNumber = BillNumberGenerator.generateRandomBillNumber();
            bill.setBillNumber(randomBillNumber);
            return billRepository.save(bill);
        } catch (Exception e) {
            e.printStackTrace();
            bill.setBillNumber("DEFAULT_BILL_NUMBER");
            return billRepository.save(bill);
        }
    }

    public Bill updateBill(Long id, Bill bill) {
        bill.setBillId(id);
        return billRepository.save(bill);
    }

    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }
    public Bill discountBill(Long id, double discountAmount) {
        Optional<Bill> optionalBill = billRepository.findById(id);
        if (optionalBill.isPresent()) {
            Bill bill = optionalBill.get();
            BigDecimal currentAmount = bill.getAmount();
            BigDecimal discount = BigDecimal.valueOf(discountAmount);
            BigDecimal discountedAmount = currentAmount.subtract(discount);
            if (discountedAmount.compareTo(BigDecimal.ZERO) < 0) {
                discountedAmount = BigDecimal.ZERO; // Ensure discounted amount doesn't go negative
            }
            bill.setAmount(discountedAmount);
            return billRepository.save(bill);
        } else {
            throw new IllegalArgumentException("Bill not found with id: " + id);
        }
    }
    public class BillNumberGenerator {

        public static String generateRandomBillNumber() throws Exception {
            Random random = new Random();
            int randomNumber = random.nextInt(1000000);
            if (randomNumber < 0) {
                throw new Exception("Invalid random number generated");
            }
            String billNumber = "BILL-" + String.format("%06d", randomNumber);
            return billNumber;
        }

        public static void main(String[] args) {
            try {
                String billNumber = generateRandomBillNumber();
                System.out.println("Generated Bill Number: " + billNumber);
            } catch (Exception e) {
                System.out.println("Failed to generate a random bill number. Error: " + e.getMessage());
            }
        }

    }
    public Bill approveBill(Long billId) {
        Optional<Bill> optionalBill = billRepository.findById(billId);

        if (optionalBill.isPresent()) {
            Bill bill = optionalBill.get();
            if (!bill.isApproved()) {
                bill.setApproved(true);
                return billRepository.save(bill);
            } else {
                throw new IllegalStateException("Bill with ID " + billId + " has already been approved.");
            }
        } else {
            throw new IllegalArgumentException("Bill with ID " + billId + " not found.");
        }
    }
    public Bill requestAvalisation(Long billId, String guarantor, Date expiryDate) {
        Bill bill = getBillById(billId).orElseThrow(() -> new IllegalArgumentException("Bill not found with id: " + billId));
        if (!bill.isAvalised()) {
            bill.setAvalised(true);
            bill.setAvalisationExpiryDate(expiryDate);
            bill.setGuarantor(guarantor);
            return billRepository.save(bill);
        } else {
            throw new IllegalStateException("Bill with ID " + billId + " is already avalised.");
        }
    }

    public Bill cancelAvalisation(Long billId) {
        Bill bill = getBillById(billId).orElseThrow(() -> new IllegalArgumentException("Bill not found with id: " + billId));
        if (bill.isAvalised()) {
            bill.setAvalised(false);
            bill.setAvalisationExpiryDate(null);
            bill.setGuarantor(null);
            return billRepository.save(bill);
        } else {
            throw new IllegalStateException("Bill with ID " + billId + " is not avalised.");
        }
    }

}
