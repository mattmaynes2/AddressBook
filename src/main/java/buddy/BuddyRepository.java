package buddy;

import org.springframework.data.repository.CrudRepository;

public interface BuddyRepository extends CrudRepository <BuddyInfo, Long> {

    public BuddyInfo findById (Integer id);
    public void removeById (Integer id);
}
