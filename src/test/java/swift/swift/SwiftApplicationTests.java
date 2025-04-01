package swift.swift;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import swift.swift.model.Branch;
import swift.swift.repository.BranchRepository;
import swift.swift.service.BranchService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class SwiftApplicationTests {

    @Mock
    private BranchRepository branchRepository;

    @InjectMocks
    private BranchService branchService;

    @Test
    void testGetAllBranches() {
        Branch branch1 = new Branch();
        branch1.setSwiftCode("ABCDUS33");
        branch1.setBankName("Test Bank");
        branch1.setAddress("123 Test St");
        branch1.setCountryISO2("US");
        branch1.setHeadquarter(false);

        Branch branch2 = new Branch();
        branch2.setSwiftCode("EFGHUS34");
        branch2.setBankName("Another Bank");
        branch2.setAddress("456 Another St");
        branch2.setCountryISO2("US");
        branch2.setHeadquarter(false);

        when(branchRepository.findAll()).thenReturn(Arrays.asList(branch1, branch2));

        List<Branch> branches = branchService.getAllBranches();

        assertNotNull(branches);
        assertEquals(2, branches.size());
        assertEquals("ABCDUS33", branches.get(0).getSwiftCode());
        assertEquals("EFGHUS34", branches.get(1).getSwiftCode());

        verify(branchRepository).findAll();
    }
}
