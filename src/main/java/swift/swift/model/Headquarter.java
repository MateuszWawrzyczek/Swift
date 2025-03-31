package swift.swift.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;



@Entity
@Table(name = "headquarter")
public class Headquarter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankName;
    private String address;
    private String countryISO2;
    private String countryName;
    private boolean isHeadquarter;
    private String swiftCode;

    @OneToMany(mappedBy = "headquarter")
    private List<Branch> branches;

    public String getSwiftCode() {return swiftCode;}
    public String getCountryName() {return countryName;}
    public String getAddress() { return address; }
    public String getBankName() { return bankName; }
    public String getCountryISO2() { return countryISO2; }
    public boolean isHeadquarter() { return isHeadquarter; }
    public List<Branch> getBranches() { return branches; }

    public void setSwiftCode(String swiftCode) { this.swiftCode = swiftCode;}
    public void setBankName(String bankName) { this.bankName = bankName; }
    public void setAddress(String address) { this.address = address; }
    public void setCountryISO2(String countryISO2) { this.countryISO2 = countryISO2; }
    public void setCountryName(String countryName) { this.countryName = countryName; }
    public void setHeadquarter(boolean isHeadquarter) { this.isHeadquarter = isHeadquarter; }
    
}
