package is.nord.repository;

import is.nord.model.Registration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/** Authors:
 *      Kári Snær Kárason (ksk12@hi.is),
 */

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository{

    private final List<Registration> registrationRepo; // a list of all registrations

    public RegistrationRepositoryImpl() {
        this.registrationRepo = new ArrayList<Registration>();
    }

    /**
     *
     * @return all the registration items
     */
    @Override
    public List<Registration> getAll() {
        return registrationRepo;
    }

    /**
     * Adds registration to the registrationRepo
     * @param registration the registration item to be added to the storage
     */
    @Override
    public void add(Registration registration) {
        registrationRepo.add(0, registration);
    }

    public void remove(String username, String event){
        for(int i=0; i < registrationRepo.size(); i++){
            System.out.println(registrationRepo.get(i).getUsername());
            System.out.println(registrationRepo.get(i).getEvent());
            if((registrationRepo.get(i).getUsername().equals(username)) && registrationRepo.get(i).getEvent().equals(event)){
                registrationRepo.remove(i);
                System.out.println("farið");
            }
        }
    }
}
