package swift.swift.model;

import java.util.List;



public class BankResponseDTO {
    private String address;
    private String bankName;
    private String countryISO2;
    private String countryName;
    private boolean isHeadquarter;
    private String swiftCode;
    private List<BranchDTO> branches;

    public BankResponseDTO(String address, String bankName, String countryISO2, 
                           String countryName, boolean isHeadquarter, String swiftCode, 
                           List<BranchDTO> branches) {
        this.address = address;
        this.bankName = bankName;
        this.countryISO2 = countryISO2;
        this.countryName = countryName;
        this.isHeadquarter = isHeadquarter;
        this.swiftCode = swiftCode;
        this.branches = branches;
    }
}
