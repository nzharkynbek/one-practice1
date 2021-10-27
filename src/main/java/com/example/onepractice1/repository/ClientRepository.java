package com.example.onepractice1.repository;

import com.example.onepractice1.models.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> findAll();
    Client findClientById(Long id);
    void saveClient(Client client);
    boolean deleteClientById(Long id);
}
