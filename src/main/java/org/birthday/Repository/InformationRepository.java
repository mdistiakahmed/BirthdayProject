package org.birthday.Repository;

import org.birthday.Model.Information;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InformationRepository extends MongoRepository<Information,Integer> {
}
