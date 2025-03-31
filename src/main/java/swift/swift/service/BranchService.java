package swift.swift.service; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swift.swift.model.Branch;
import swift.swift.repository.BranchRepository;

import java.util.List;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }
}
