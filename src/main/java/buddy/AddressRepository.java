package buddy;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository <AddressBook, Long> {

    public AddressBook findById (Integer id);
}
