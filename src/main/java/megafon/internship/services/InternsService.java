package megafon.internship.services;

import megafon.internship.dao.InternDAO;
import megafon.internship.entity.Interns;
import megafon.internship.repository.InternsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InternsService {

    @Autowired
    private InternsRepo internsRepo;

    public List<Interns> getAllInterns() {
        return internsRepo.findAll();
    }

    public List<InternDAO> getAllInternsDAO() {
        List<Interns> internsList = internsRepo.findAll();

        List<InternDAO> internDAOList = internsList.stream()
                .map(Interns::entityToDAO)
                .collect(Collectors.toList());
        return internDAOList;
    }

    public void addIntern(String name, String surname, int age, String hobby) {
        Interns interns = new Interns(name, surname, age, hobby);
        internsRepo.save(interns);
    }

    public Interns getInternById(long internId) {
        Optional<Interns> interns = internsRepo.findById(internId);
        return interns.get();
    }

    public void deleteIntern(long internId) {
        internsRepo.delete(getInternById(internId));
    }

    public void updateIntern(long internId, String name, String surname, String hobby) {
        Interns intern = getInternById(internId);
        intern.setName(name);
        intern.setSurname(surname);
        intern.setHobby(hobby);
        internsRepo.save(intern);
    }

}
