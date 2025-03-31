package swift.swift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import swift.swift.model.Branch;
import swift.swift.model.Headquarter;
import swift.swift.repository.BranchRepository;
import swift.swift.repository.HeadquarterRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class SwiftDataParserService {

    @Autowired
    private HeadquarterRepository headquarterRepository;

    @Autowired
    private BranchRepository branchRepository;

    public void loadSwiftData() {
        String csvFile = "swift_data.csv"; 
        Map<String, Headquarter> headquartersMap = new HashMap<>(); 

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new ClassPathResource(csvFile).getInputStream(), StandardCharsets.UTF_8))) {

            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) { 
                    firstLine = false;
                    continue;
                }

                String[] values = line.split(",", -1); 
                if (values.length < 7) continue; 

                String countryISO2 = values[0].trim().toUpperCase();
                String swiftCode = values[1].trim();
                String codeType = values[2].trim(); 
                String bankName = values[3].trim();
                String address = values[4].trim();
                String townName = values[5].trim();
                String countryName = values[6].trim().toUpperCase();

                String fullAddress = address + ", " + townName;

                boolean isHeadquarter = swiftCode.endsWith("XXX");

                if (isHeadquarter) {
                    
                    Headquarter hq = new Headquarter();
                    hq.setSwiftCode(swiftCode);
                    hq.setBankName(bankName);
                    hq.setAddress(fullAddress);
                    hq.setCountryISO2(countryISO2);
                    hq.setCountryName(countryName);
                    hq.setHeadquarter(true);
                    headquarterRepository.save(hq);

                    headquartersMap.put(swiftCode.substring(0, 8), hq); 
                } else {
                    String hqKey = swiftCode.substring(0, 8); 
                    Headquarter hq = headquartersMap.get(hqKey);

                    Branch branch = new Branch();
                    branch.setSwiftCode(swiftCode);
                    branch.setBankName(bankName);
                    branch.setAddress(fullAddress);
                    branch.setCountryISO2(countryISO2);
                    branch.setCountryName(countryName);
                    branch.setHeadquarter(false);
                    branch.setHeadquarter(hq);

                    branchRepository.save(branch);
                }
            }
            System.out.println("SWIFT Codes loaded successfully!");

        } catch (Exception e) {
            System.err.println("Error loading SWIFT codes: " + e.getMessage());
        }
    }
}
