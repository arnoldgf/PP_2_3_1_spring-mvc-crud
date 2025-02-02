package app.dao;


import app.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements UserDaoInt {

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> getUsers(){
      return entityManager.createQuery("from User").getResultList();
    }

    public void saveUser (User user){
        entityManager.persist(user);
    }

    public void updateUser (User user){
        entityManager.merge(user);
    }

    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }

    public void deleteUser (Integer id){
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

}
