package com.example.onepractice1.service.impl;

import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import com.example.onepractice1.models.Post;
import com.example.onepractice1.repository.ClientRepository;
import com.example.onepractice1.service.AddressService;
import com.example.onepractice1.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ClientServiceImplTest {
    @Mock
    ClientRepository clientRepository;
    @Mock
    PostService postService;
    @Mock
    AddressService addressService;
    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllClients() {
        List<Client> result = clientServiceImpl.getAllClients();
        Assertions.assertEquals(Arrays.<Client>asList(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus")))), result);
    }

    @Test
    void testGetClientById() {
        Client result = clientServiceImpl.getClientById(Long.valueOf(1));
        Assertions.assertEquals(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))), result);
    }

    @Test
    void testSaveClient() {
        Client result = clientServiceImpl.saveClient(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))));
        Assertions.assertEquals(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))), result);
    }

    @Test
    void testDeleteClientById() {
        clientServiceImpl.deleteClientById(Long.valueOf(1));
    }

    @Test
    void testAddClientToPost() {
        when(postService.getPostById(anyLong())).thenReturn(new Post(Long.valueOf(1), "name", "description", "postStatus"));

        Client result = clientServiceImpl.addClientToPost(Long.valueOf(1), Long.valueOf(1));
        Assertions.assertEquals(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))), result);
    }

    @Test
    void testAddClientToAddress() {
        when(addressService.getAddressById(anyLong())).thenReturn(new Address(Long.valueOf(1), "landmark", "city", 0));

        Client result = clientServiceImpl.addClientToAddress(Long.valueOf(1), Long.valueOf(1));
        Assertions.assertEquals(new Client(Long.valueOf(1), "email", new Address(Long.valueOf(1), "landmark", "city", 0), Arrays.<Post>asList(new Post(Long.valueOf(1), "name", "description", "postStatus"))), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme