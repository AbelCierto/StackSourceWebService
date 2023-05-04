package com.example.stacksourcewebservices.service.impl;

import com.example.stacksourcewebservices.entities.User;
import com.example.stacksourcewebservices.repository.IUserRepository;
import com.example.stacksourcewebservices.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) throws Exception {
        return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) throws Exception {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findByFirstName(String firstName) throws Exception {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> findDeveloperByFrameworkAndProgrammingLanguageAndDatabase(String framework, String programmingLanguage, String database) throws Exception {
        return userRepository.findDeveloperByFrameworkAndProgrammingLanguageAndDatabase(framework, programmingLanguage, database);
    }
}
