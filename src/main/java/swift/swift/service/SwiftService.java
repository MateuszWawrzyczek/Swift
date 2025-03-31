package swift.swift.service;

import org.springframework.stereotype.Service;
import swift.swift.model.Branch;
import swift.swift.model.Headquarter;
import swift.swift.repository.BranchRepository;
import swift.swift.repository.HeadquarterRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SwiftService {

    private final HeadquarterRepository headquarterRepository;
    private final BranchRepository branchRepository;

    public SwiftService(HeadquarterRepository headquarterRepository, BranchRepository branchRepository) {
        this.headquarterRepository = headquarterRepository;
        this.branchRepository = branchRepository;
    }

    public Optional<Headquarter> getHeadquarterBySwiftCode(String swiftCode) {
        return headquarterRepository.findBySwiftCode(swiftCode);
    }

    public Optional<Branch> getBranchBySwiftCode(String swiftCode) {
        return branchRepository.findBySwiftCode(swiftCode);
    }

    public List<String> getSwiftCodesByCountry(String countryISO2) {
        List<Branch> branches = branchRepository.findAllByCountryISO2(countryISO2);
        return branches.stream()
                .map(Branch::getSwiftCode)
                .collect(Collectors.toList());
    }

    public void addBranch(Branch branch) {
        branchRepository.save(branch);
    }

    public void deleteSwiftCode(String swiftCode) {
        branchRepository.deleteBySwiftCode(swiftCode);
    }
}
