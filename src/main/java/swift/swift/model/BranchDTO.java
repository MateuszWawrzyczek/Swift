package swift.swift.model;

public class BranchDTO {
    private String address;
    private String bankName;
    private String countryISO2;
    private boolean isHeadquarter;
    private String swiftCode;

    public BranchDTO(String address, String bankName, String countryISO2, 
                     boolean isHeadquarter, String swiftCode) {
        this.address = address;
        this.bankName = bankName;
        this.countryISO2 = countryISO2;
        this.isHeadquarter = isHeadquarter;
        this.swiftCode = swiftCode;
    }

    public String getSwiftCode() {return swiftCode;}

    public String getAddress() { return address; }
    public String getBankName() { return bankName; }
    public String getCountryISO2() { return countryISO2; }
    public boolean isHeadquarter() { return isHeadquarter; }
    

}
