package swift.swift.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import swift.swift.model.Branch;
import swift.swift.service.BranchService;

@RestController
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/branches")
    public List<Branch> getAllBranches() {
        return branchService.getAllBranches();
    }
}
