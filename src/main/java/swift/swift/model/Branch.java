package swift.swift.model;

import jakarta.persistence.*;



@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bankName;
    private String address;
    private String countryISO2;
    private String countryName;
    private boolean isHeadquarter;
    private String swiftCode;
    
    @ManyToOne
    @JoinColumn(name = "headquarter_id")
    private Headquarter headquarter;

    public String getSwiftCode() {return swiftCode;}
    public String getCountryName() {return countryName;}
    public String getAddress() { return address; }
    public String getBankName() { return bankName; }
    public String getCountryISO2() { return countryISO2; }
    public boolean isHeadquarter() { return isHeadquarter; }

    public void setSwiftCode(String swiftCode) {this.swiftCode = swiftCode;}
    public void setCountryName(String countryName) {this.countryName = countryName;}
    public void setAddress(String address) { this.address = address; }
    public void setBankName(String bankName) { this.bankName = bankName; }
    public void setCountryISO2(String countryISO2) { this.countryISO2 = countryISO2; }
    public void setHeadquarter(boolean isHeadquarter) { this.isHeadquarter = isHeadquarter; }
    public void setHeadquarter(Headquarter headquarter) { this.headquarter = headquarter; }
}
