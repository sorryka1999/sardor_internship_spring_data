package megafon.internship.services;

import megafon.internship.entity.Interns;
import megafon.internship.repository.InternsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternsService {

    @Autowired
    private InternsRepo internsRepo;

    public List<Interns> getAllInterns() {
        return internsRepo.findAll();
    }
}
