package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.models.Post;
import com.example.onepractice1.repository.ClientRepository;
import com.example.onepractice1.service.AddressService;
import com.example.onepractice1.service.ClientService;
import com.example.onepractice1.service.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private PostService postService;
    private AddressService addressService;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, PostService postService, AddressService addressService) {
        this.clientRepository = clientRepository;
        this.postService = postService;
        this.addressService = addressService;
    }


    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot find client with %s id", id)));
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Client addClientToPost(Long clientId, Long postId) {
        Client client = getClientById(clientId);
        Post post = postService.getPostById(postId);
        client.addPost(post);
        return client;
    }

    @Transactional
    @Override
    public Client addClientToAddress(Long clientId, Long addressId) {
        Client client = getClientById(clientId);
        Address address = addressService.getAddressById(addressId);
        client.setAddress(address);
        return client;
    }
}
